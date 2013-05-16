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
public class PreStart extends JFrame{
    JButton A;
    JButton B;
    JButton C;
    
    public PreStart(){    
        super("TicTacToeStart");    
        this.setBounds(100,100,500,300);
        this.setTitle("start window");     
        this.setLayout(null);
        
        A=new JButton("Host Game");
        A.setBounds(50,60,100,32);
        this.add(A);        
        A.addActionListener(new PreStartOper(this,0));
        
        B=new JButton("Join Game");
        B.setBounds(150,60,100,32);
        this.add(B);        
        B.addActionListener(new PreStartOper(this,1));
        
        C=new JButton("Play Offline");
        C.setBounds(250,60,100,32);
        this.add(C);        
        C.addActionListener(new PreStartOper(this,2));
        
        
    }
    public void kill() {
                WindowEvent wev = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
                Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(wev);
        }

    
}
