/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Martin
 */
public class EndWinNet extends JFrame {
    boolean A;
    int D;
    JLabel L;
    JButton B;
    JButton C;
    WindowNET l;
    public EndWinNet(boolean a,int b,WindowNET l) {
       // super("moje okno");
        this.A=a;
        this.D=b;
        this.l=l;
        this.setBounds(200,200,400,200);
        this.setTitle("Konec hry");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
        this.setLayout(null);
        if(A)L=new JLabel("hrac O vyhral"); 
        else L=new JLabel("hrac X vyhral");         
        L.setBounds(20,20,150,40);
        this.add(L);
        
        B=new JButton("hrat znovu");
        B.setBounds(0,100,100,32);
        this.add(B);        
        B.addActionListener(new EndOperNet(this,D,l));
        
        C=new JButton("konec");
        C.setBounds(120,100,100,32);
        this.add(C);        
        C.addActionListener(new EndOperNet(this,0,l));
    
    }     
  
    public void kill() {
                WindowEvent wev = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
                Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(wev);
        }
}
