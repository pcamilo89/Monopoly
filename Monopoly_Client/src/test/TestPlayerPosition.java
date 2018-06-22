/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test;

import controller.TableroViewController;
import java.util.logging.Level;
import java.util.logging.Logger;
import view.MainClient;
import view.TableroView;

/**
 *
 * @author Camilo
 */
public class TestPlayerPosition {
    public static void main(String args[]){
        MainClient.setLookAndFeel();
        TableroView tablero = new TableroView();
        tablero.setVisible(true);
        

        for (int i = 0; i <= 40; i++) {
            if(i == 40)
                i=0;
            try {
                Thread.sleep(1*1000);
                TableroViewController.MoveChess(i, 1);
                System.out.println("i:"+i);
            } catch (InterruptedException ex) {
                Logger.getLogger(TestPlayerPosition.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
}
