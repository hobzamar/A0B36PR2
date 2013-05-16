/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Martin
 */
public class EndOper implements ActionListener{
    EndWin E;
    int a;
    Window l;

    public EndOper(EndWin e, int a,Window l){
    this.E=e;
    this.a=a; 
    this.l=l;
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(a!=0){
        Window s = new Window(a);      
        s.setVisible(true);
        }        
        l.kill();
        E.kill();               
        
       
    }
}
