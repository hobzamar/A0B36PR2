/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author Martin
 */
public class OperNET implements ActionListener{   
    Boolean over=false;
    int a,b,c;    
    int[][] x;
    int[]y;   
    WindowNET l;
    //private int citac;

       public OperNET(int a, int b, int[][]x,int[]y,WindowNET l,int c){
         this.a=a;
         this.b=b;
         this.x=x;
         this.y=y;
         this.l=l;
         this.c=c;
           }
    @Override
    public void actionPerformed(ActionEvent event)
    {if("".equals(((JButton) event.getSource()).getText())){
       if(y[0]%2==1){
           ((JButton) event.getSource()).setText("X");
           ((JButton) event.getSource()).setForeground(Color.red);           
       x[a][b]=1;}
       
       else{((JButton) event.getSource()).setText("O");
       ((JButton) event.getSource()).setForeground(Color.blue);       
       x[a][b]=2;}
       
       
       
       y[0]++;       
       konec(x,event);
        
    }}
    
    
    public void konec(int[][]derp,ActionEvent e){ //has anyone won?
    for (int i=0;i<derp.length-4;i++)
                {for (int j=0;j<derp[i].length;j++)
                    {if (   derp[i][j]==1&&
                            derp[i+1][j]==1&&
                            derp[i+2][j]==1&&
                            derp[i+3][j]==1&&
                            derp[i+4][j]==1||
                            derp[i][j]==2&&
                            derp[i+1][j]==2&&
                            derp[i+2][j]==2&&
                            derp[i+3][j]==2&&
                            derp[i+4][j]==2)
                    {l.setTitle("Nekdo vyhral");
                    over=true;
                    }}}
    for (int i=0;i<derp.length;i++)
                {for (int j=0;j<derp[i].length-4;j++)
                    {
                     if (   derp[i][j]==1&&
                            derp[i][j+1]==1&&
                            derp[i][j+2]==1&&
                            derp[i][j+3]==1&&
                            derp[i][j+4]==1||
                            derp[i][j]==2&&
                            derp[i][j+1]==2&&
                            derp[i][j+2]==2&&
                            derp[i][j+3]==2&&
                            derp[i][j+4]==2)  
                     {l.setTitle("Nekdo vyhral");
                     over=true;}
                    }}
    for (int i=0;i<derp.length-4;i++)
                {for (int j=0;j<derp[i].length-4;j++)
                    {
                     if (derp[i][j]==1&&
                            derp[i+1][j+1]==1&&
                            derp[i+2][j+2]==1&&
                            derp[i+3][j+3]==1&&
                            derp[i+4][j+4]==1||
                            derp[i][j]==2&&
                            derp[i+1][j+1]==2&&
                            derp[i+2][j+2]==2&&
                            derp[i+3][j+3]==2&&
                            derp[i+4][j+4]==2) 
                     {l.setTitle("Nekdo vyhral");
                     over=true;}
                    }}
    for (int i=0;i<derp.length-4;i++)
                {for (int j=4;j<derp[i].length;j++)
                    {if(derp[i][j]==1&&
                            derp[i+1][j-1]==1&&
                            derp[i+2][j-2]==1&&
                            derp[i+3][j-3]==1&&
                            derp[i+4][j-4]==1||
                            derp[i][j]==2&&
                            derp[i+1][j-1]==2&&
                            derp[i+2][j-2]==2&&
                            derp[i+3][j-3]==2&&
                            derp[i+4][j-4]==2)
                    { l.setTitle("Nekdo vyhral");
                    over=true;}
                    }}
    if(over){  EndWinNet konec = new EndWinNet(y[0],(derp.length),l);
        konec.setVisible(true);
        l.setEnabled(false);
    }
    
}
}