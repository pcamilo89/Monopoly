/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
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
        vista.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        
        WindowListener exitListener = new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                
                int confirm = JOptionPane.showOptionDialog(
                    null, "Are You Sure to Close Application?", 
                    "Exit Confirmation", JOptionPane.YES_NO_OPTION, 
                    JOptionPane.QUESTION_MESSAGE, null, null, null);
                if (confirm == 0) {
                    System.out.println("Cerrando Tablero");
                    if(Core.client != null){
                        Core.client.sendMsg("exit");
                        Core.stopClient();
                    }
                    vista.setVisible(false);
                    vista.dispose();
                }
                
            }
        };
        vista.addWindowListener(exitListener);
        
        vista.GetButton_Throw().setText("Lanzar Dados");
        vista.GetButton_Throw().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TableroViewController.Button_Throw();
            }
        });
        Button_ThrowDisable();
    }
    
    public static void closeWindow(){
        vista.setVisible(false);
        vista.dispose();
    }
    
    public static void Button_Throw(){
        if (Core.client != null){
            Core.client.sendMsg("lanzardado");
        }            
        
    }
    
    public static void Button_ThrowEnable(){
        vista.GetButton_Throw().setEnabled(true);
    }
    
    public static void Button_ThrowDisable(){
        vista.GetButton_Throw().setEnabled(false);
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
            vista.SetP1Location(orig,axis);       
        else if(player == 2)
            vista.SetP2Location(orig+20,axis);
        else if(player == 3)
            vista.SetP3Location(orig,axis+30);
        else if(player == 4)
            vista.SetP4Location(orig+30,axis+20);

    }

    
}
