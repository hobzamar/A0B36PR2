/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;

/**
 *
 * @author Martin
 */
public class StartOper implements ActionListener{
    
    StartWin w;
    int a;
    int b;
    
    public StartOper(StartWin w, int a,int b){
    this.w=w;
    this.a=a;
    this.b=b;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(b==2){
        Window o = new Window(a);
        o.setVisible(true);}
        else if(b==1){
         //   Client C= new Client
        WindowNET o=new WindowNET(a);
        o.setVisible(true);}
        if (b==0){
        // Server S = new Server();
        WindowNET o=new WindowNET(a);
        o.setVisible(true);
        }
        w.kill();
    }
}
