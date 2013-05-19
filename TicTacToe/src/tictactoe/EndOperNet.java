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
public class EndOperNet implements ActionListener{
    EndWinNet E;
    int a;
    WindowNET l;

    public EndOperNet(EndWinNet e, int a,WindowNET l){
    this.E=e;
    this.a=a; 
    this.l=l;
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
       /* if(a!=0){    
            WindowNET s = new WindowNET(a);
            s.setVisible(true);
            l.dispose();
            E.dispose();
        }
        else{*/
       l.kill();
       E.kill();               
       // }
       
    }
}
