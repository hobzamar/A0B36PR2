/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

/**
 *
 * @author Martin
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.net.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class WindowNET extends JFrame implements Runnable{
    JPanel buttonPanel;
    int A;
    int B;
    boolean[] citac=new boolean[2];
    Font f;
    int [][]field;
    int x,z;
    Socket echoSocket = null;
    PrintWriter out = null;
    BufferedReader in = null;
    ServerSocket serverSocket = null;
     Socket clientSocket = null;
    public ObjectInputStream inputStream;
    public ObjectOutputStream outStream;
    public JButton[][] butref;
     public WindowNET(int a,int b) {        
        super("TicTacToe");
        this.citac[0]=true;
        this.A=a;
        this.B=b;
        this.butref=new JButton[A][A];
         System.out.println("pred podminkama site");
        if(b==0){            //server
            try {
            serverSocket = new ServerSocket(7777);
            
        } catch (IOException e) {
            System.err.println("Could not listen on port: 7777.");
            System.exit(1);
        }

        clientSocket = null;
        try {
            clientSocket = serverSocket.accept();
            outStream= new ObjectOutputStream(clientSocket.getOutputStream());
            inputStream= new ObjectInputStream(clientSocket.getInputStream());
            new Thread(this).start();
            
        } catch (IOException e) {
            System.err.println("Accept failed.");
            System.exit(1);
        }
        }
        
        
        else if(b==1) //klient
            {
                 try {
            echoSocket = new Socket("localhost",7777); //147.32.218.125   88.103.118.243 
            outStream= new ObjectOutputStream(echoSocket.getOutputStream());
            inputStream= new ObjectInputStream(echoSocket.getInputStream());
            new Thread(this).start();
            citac[0]=false;
            
            
        } catch (UnknownHostException e) {
            System.err.println("error occured");
            System.exit(1);
        } catch (IOException e) {
            System.err.println("no host found");
            System.exit(1);
        }
            }
        
         System.out.println("pred otevrenim okna");
        if(A<13)f = new Font("Dialog", Font.PLAIN, 24);
        else f = new Font("Dialog", Font.PLAIN, 12);
        
        this.field=new int[A][A];
        this.setSize(900,900);
        this.setTitle("TicTacToe");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
        this.setLocationRelativeTo(null);   
        
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(A,A));   
        this.add(buttonPanel, BorderLayout.CENTER);
        
       for (int i=0;i<A;i++)
        {for (int j=0;j<A;j++)
        {
            addButton(buttonPanel,i,j,field,citac,b,this);
            
        }}
       
           
        this.setVisible(true);  
    }
      private void addButton(Container parent, int x,int y, int[][] z,boolean[]k,int b, WindowNET l)
    {
        JButton but = new JButton();
        but.addActionListener(new OperNET(x,y,z,k,l,b));
        but.setFont(f);
        //but.setActionCommand(name);
        parent.add(but);
        butref[x][y]=but;
    } 
  public void kill() {
                WindowEvent wev = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
                Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(wev);
        }

    @Override
    public void run() {
       Point point;
        try {
            while((point=(Point)inputStream.readObject())!=null)
            {
               if(point.x==-1){EndWinNet konec = new EndWinNet(!citac[0],A,this);
                                this.setEnabled(false);
                                konec.setVisible(true);
                                System.out.println("nepritel vyhral");}
               else{
                System.out.println(point);
                if(citac[1]){
                    field[point.x][point.y]=1;
                    butref[point.x][point.y].setText("X");
                    butref[point.x][point.y].setForeground(Color.red);
                    buttonPanel.getComponentAt(point).setName("X");
                    buttonPanel.getComponentAt(point).setForeground(Color.red);
                    }
                else{                    
                    field[point.x][point.y]=2;
                    butref[point.x][point.y].setText("O");
                    butref[point.x][point.y].setForeground(Color.blue);
                    buttonPanel.getComponentAt(point).setName("O");
                    buttonPanel.getComponentAt(point).setForeground(Color.blue);}
                 citac[0]=!citac[0];
                 citac[1]=!citac[1];
            }}
        } catch (IOException ex) {
            Logger.getLogger(WindowNET.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(WindowNET.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }



}