/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import view.TableroView;
import model.Core;


/**
 *
 * @author Ramiro
 */
public class TableController {
    public static TableroView vista;
    public static void load(TableroView form){
        vista=form;
        setElm();
    }
    
    public static void setElm()
    {
        vista.GetThrowBtn().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TableController.Throw_btn();
            }
        });
    }
    public static void Throw_btn(){
        Core.client.sendMsg("lanzardado");
    }
    
    public static void ResultDado(int dado1,int dado2){//mostrar dados

    }
    public static void MoveChess(int casilla,int player){
        if(casilla==0){
            int orig =vista.GetGotox()+30;
            int axis =vista.GetGotoy();
            if(player==1)
            vista.SetP1(orig,axis);
            vista.SetP2(orig+20,axis);
            vista.SetP3(orig,axis+30);
            vista.SetP4(orig+30,axis+20);
        }
        if(casilla>0 && casilla<=9){
            int orig =vista.GetJailx()+30;
            int axis =vista.GetJaily()/7;
            casilla=casilla-1;
            for (int i=1;i<=casilla;i++)
            {
                    axis=axis+53;
            }
            vista.SetP1(orig,axis);
            vista.SetP2(orig+20,axis);
            vista.SetP3(orig,axis+30);
            vista.SetP4(orig+30,axis+20);
        }
        if(casilla==10)
        {
            int orig =vista.GetJailx()+30;
            int axis =vista.GetJaily()+30;
            vista.SetP1(orig,axis);
            vista.SetP2(orig+20,axis);
            vista.SetP3(orig,axis+30);
            vista.SetP4(orig+30,axis+20);   
        }
        if(casilla>10 && casilla<=19)
        {
            casilla=casilla-10;
            int orig =vista.GetJailx()-50;
            int axis =vista.GetFreey()+30;
            casilla=casilla-1;
            for (int i=1;i<=casilla;i++)
            {
                    orig=orig-53;
            }
            vista.SetP1(orig,axis);
            vista.SetP2(orig+20,axis);
            vista.SetP3(orig,axis+30);
            vista.SetP4(orig+30,axis+20);
            
        }
        if(casilla==20)
        {
            int orig =vista.GetFreex();
            int axis =vista.GetFreey()+30;
            vista.SetP1(orig,axis);
            vista.SetP2(orig+20,axis);
            vista.SetP3(orig,axis+30);
            vista.SetP4(orig+30,axis+20); 
        }
        if(casilla>20 && casilla<=29)
        {
            casilla=casilla-20;
            int orig =vista.GetFreex();
            int axis =vista.GetFreey()-54;
            casilla=casilla-1;
            for (int i=1;i<=casilla;i++)
            {
                    axis=axis-53;
            }
            vista.SetP1(orig,axis);
            vista.SetP2(orig+20,axis);
            vista.SetP3(orig,axis+30);
            vista.SetP4(orig+30,axis+20);
        }
        if(casilla==30)
        {
            int orig =vista.GetGotox();
            int axis =vista.GetGotoy();
            vista.SetP1(orig,axis);
            vista.SetP2(orig+20,axis);
            vista.SetP3(orig,axis+30);
            vista.SetP4(orig+30,axis+20);
        }
        if(casilla>30 && casilla<=39)
        {
            casilla=casilla-30;
            int orig =vista.GetGox()/7+5;
            int axis =vista.GetGotoy();
            casilla=casilla-1;
            for (int i=1;i<=casilla;i++)
            {
                    orig=orig+53;
            }
            vista.SetP1(orig,axis);
            vista.SetP2(orig+20,axis);
            vista.SetP3(orig,axis+30);
            vista.SetP4(orig+30,axis+20);
            
        }
    }

    
}
