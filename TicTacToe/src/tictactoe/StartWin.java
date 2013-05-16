/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author Martin
 */
public class StartWin extends JFrame{
    JButton A;
    JButton B;
    JButton C;
    int net;
    
    public StartWin(int a){    
        super("TicTacToeStart");   
        net=a;
        this.setBounds(100,100,500,300);
        this.setTitle("start window");            
        this.setLayout(null);
        
        A=new JButton("size 8x8");
        A.setBounds(50,60,100,32);
        this.add(A);        
        A.addActionListener(new StartOper(this,8,net));
        
        B=new JButton("size 12x12");
        B.setBounds(150,60,100,32);
        this.add(B);        
        B.addActionListener(new StartOper(this,12,net));
        
        C=new JButton("size 20x20");
        C.setBounds(250,60,100,32);
        this.add(C);        
        C.addActionListener(new StartOper(this,20,net));
        
        
    }
    public void kill() {
                WindowEvent wev = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
                Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(wev);
        }

    
}
