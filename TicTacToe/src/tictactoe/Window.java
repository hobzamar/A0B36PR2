/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

/**
 *
 * @author Martin
 */
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import javax.swing.*;

public class Window extends JFrame /*implements ActionListener*/{
    JPanel buttonPanel;
    int A;
    int[] citac=new int[1];
    Font f;
    int [][]field;
    int x,z;
   
     public Window(int a) {        
        super("TicTacToe");
        this.citac[0]=1;
        this.A=a;
        
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
            addButton(buttonPanel,i,j,field,citac,this);
        }}
       
           
        this.setVisible(true);  
    }
      private void addButton(Container parent, int x,int y, int[][] z,int[]k, Window l)
    {
        JButton but = new JButton();
        but.addActionListener(new Oper(x,y,z,k,l));
        but.setFont(f);
        //but.setActionCommand(name);
        parent.add(but);
    }
  public void kill() {
                WindowEvent wev = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
                Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(wev);
        }
/*@Override
    public void actionPerformed(ActionEvent event)
    { if("".equals(((JButton) event.getSource()).getText())){
       if(citac%2==1){
           ((JButton) event.getSource()).setText("X");
       ((JButton)event.getSource()).setName("X");}
       else{((JButton) event.getSource()).setText("O");((JButton)event.getSource()).setName("O");}
       citac++;
       this.EndeSchlus();
       
    }
    }*/


}
