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
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.net.*;
import java.io.*;
import javax.swing.*;

public class WindowNET extends JFrame {
    JPanel buttonPanel;
    int A;
    int B;
    int[] citac=new int[1];
    Font f;
    int [][]field;
    int x,z;
    Socket echoSocket = null;
    PrintWriter out = null;
    BufferedReader in = null;
    ServerSocket serverSocket = null;
    
     public WindowNET(int a,int b) {        
        super("TicTacToe");
        this.citac[0]=1;
        this.A=a;
        this.B=b;
        
        
        if(b==0){
            try {
            serverSocket = new ServerSocket(7777);
        } catch (IOException e) {
            System.err.println("Could not listen on port: 7777.");
            System.exit(1);
        }

        Socket clientSocket = null;
        try {
            clientSocket = serverSocket.accept();
        } catch (IOException e) {
            System.err.println("Accept failed.");
            System.exit(1);
        }
        }
        
        
        else if(b==1)
            {
                 try {
            echoSocket = new Socket("localhost",7777); //147.32.218.125   88.103.118.243 
            out = new PrintWriter(echoSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(
                                        echoSocket.getInputStream()));
        } catch (UnknownHostException e) {
            System.err.println("error occured");
            System.exit(1);
        } catch (IOException e) {
            System.err.println("no host found");
            System.exit(1);
        }
            }
        
        
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
      private void addButton(Container parent, int x,int y, int[][] z,int[]k,int b, WindowNET l)
    {
        JButton but = new JButton();
        but.addActionListener(new OperNET(x,y,z,k,l,b));
        but.setFont(f);
        //but.setActionCommand(name);
        parent.add(but);
    } 
  public void kill() {
                WindowEvent wev = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
                Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(wev);
        }



}