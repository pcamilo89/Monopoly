/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import java.awt.Dimension;
import java.awt.Insets;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Core;
import view.TableroView;

/**
 *
 * @author Ramiro
 */
public class TableroViewController {
    public static TableroView vista;
    
    public static void load(TableroView from){
        vista=from;
        setElm();
    }
    
    public static void setElm()
    {
        vista.setMinimumSize(new Dimension(700+400, 700));
        //Insets inset = vista.getPanel_Tablero().getInsets();
        //vista.getPanel_Tablero().setBounds(inset.left, inset.top, 650, 650);
        
        vista.GetButton_Throw().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TableroViewController.Throw_btn();
            }
        });
    }
    public static void Throw_btn(){
        if (Core.client != null){
            Core.client.sendMsg("lanzardado");
        }            
        
    }
    
    public static void ResultDado(int dado1,int dado2){//mostrar dados
        vista.GetDado1().setIcon(new javax.swing.ImageIcon(TableroViewController.class.getResource("/resources/dado"+String.valueOf(dado1)+".png")));
        vista.GetDado2().setIcon(new javax.swing.ImageIcon(TableroViewController.class.getResource("/resources/dado"+String.valueOf(dado2)+".png")));
    }
    
    public static void MoveChess(int casilla,int player){
        try {
            Thread.sleep(100);
        } catch (InterruptedException ex) {
            Logger.getLogger(TableroViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("casilla:"+casilla);
        int orig = 0;
        int axis = 0;
        //si la casilla es GO
        if(casilla==0){
            orig =vista.GetGox()+30;
            axis =vista.GetGoy();            
        }
        //si la casilla esta entre 0 y 9
        else if(casilla>0 && casilla<=9){
            orig =vista.GetJailx()+30;
            axis =vista.GetJaily()/7;
            casilla=casilla-1;
            
            for (int i=1;i<=casilla;i++)
            {
                    axis=axis+53;
            }
        }
        else if(casilla==10)
        {
            orig =vista.GetJailx()+30;
            axis =vista.GetJaily()+30;  
        }
        else if(casilla>10 && casilla<=19)
        {
            casilla=casilla-10;
            orig =vista.GetJailx()-50;
            axis =vista.GetFreey()+30;
            casilla=casilla-1;
            
            for (int i=1;i<=casilla;i++)
            {
                    orig=orig-53;
            }
            
        }
        else if(casilla==20)
        {
            orig =vista.GetFreex();
            axis =vista.GetFreey()+30;
        }
        else if(casilla>20 && casilla<=29)
        {
            casilla=casilla-20;
            orig =vista.GetFreex();
            axis =vista.GetFreey()-54;
            casilla=casilla-1;
            
            for (int i=1;i<=casilla;i++)
            {
                    axis=axis-53;
            }
        }
        else if(casilla==30)
        {
            orig =vista.GetGotox();
            axis =vista.GetGotoy();
        }
        else if(casilla>30 && casilla<=39)
        {
            casilla=casilla-30;
            orig =vista.GetGox()/7+5;
            axis =vista.GetGotoy();
            casilla=casilla-1;
            
            for (int i=1;i<=casilla;i++)
            {
                    orig=orig+53;
            }
            
        }
        
        if(player == 1)
            vista.SetP1(orig,axis);       
        else if(player == 2)
            vista.SetP2(orig+20,axis);
        else if(player == 3)
            vista.SetP3(orig,axis+30);
        else if(player == 4)
            vista.SetP4(orig+30,axis+20);

    }

    
}
