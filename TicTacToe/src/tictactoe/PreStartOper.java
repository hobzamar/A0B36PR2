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
public class PreStartOper implements ActionListener{
    PreStart w;
    int a;
    
    public PreStartOper(PreStart w, int a){
    this.w=w;
    this.a=a;
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        StartWin o = new StartWin(a);
        o.setVisible(true);
        w.kill();
    }
}