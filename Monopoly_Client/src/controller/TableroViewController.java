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
import model.Player;
import view.ChatPanel;
import view.TableroView;

/**
 *
 * @author Ramiro
 */
public class TableroViewController {
    public static TableroView vista;
    
    public static int dado1 = 1;
    public static int dado2 = 1;
    
    public static void load(TableroView from){
        vista=from;
        setElm();
    }
    
    public static void setElm()
    {
        vista.setMinimumSize(new Dimension(700+500, 700));
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
        
        vista.getPanel_ChatContainer().add(new ChatPanel());
    }
    
    public static void closeWindow(){
        vista.setVisible(false);
        vista.dispose();
    }
    
    public static void Button_Throw(){
        if (Core.client != null){
            Core.client.sendMsg("lanzardado");
            Button_ThrowDisable();
        }
    }
    
    public static void enableInterface(){
        Button_ThrowEnable();
    }
    
    public static void disableInterface(){
        
    }
    
    public static void setTurno(){
        
    }
    
    public static void updateTurno(String turno){
        
        vista.GetTurno().setText("El turno es de:"+turno);
    }
    
    public static void updateInterface(){
        DadosUpdate();
        
        try {      
            Thread.sleep(50);
        } catch (InterruptedException ex) {
            Logger.getLogger(TableroViewController.class.getName()).log(Level.SEVERE, null, ex);
        }  
        TableroViewController.MovePiece(Core.listaJugadores.get(0).getPosition(),1);
        TableroViewController.MovePiece(Core.listaJugadores.get(1).getPosition(),2);
        TableroViewController.MovePiece(Core.listaJugadores.get(2).getPosition(),3);
        TableroViewController.MovePiece(Core.listaJugadores.get(3).getPosition(),4);
        vista.GetPlayer().setText(Core.jugadorLocal.getName());
        vista.setTitle(Core.jugadorLocal.getName());
        vista.getNameC().setText(Core.getCasilla());
    }
    
    public static void FillInfoPlayer(Player player,int index)
    {
        if(index==1){
            vista.getNamePlayer(1).setText(player.getName()+" "+player.getLastname());
            vista.getLastPLayer(1).setText("Estado:"+String.valueOf(player.isInJail()));
            vista.getBalPlayer(1).setText("Balance:"+player.getBalance());
        }
        if(index==2){
            vista.getNamePlayer(2).setText(player.getName()+" "+player.getLastname());
            vista.getLastPLayer(2).setText("Estado:"+String.valueOf(player.isInJail()));
            vista.getBalPlayer(2).setText("Balance:"+player.getBalance());
        }
        if(index==3){
            vista.getNamePlayer(3).setText(player.getName()+" "+player.getLastname());
            vista.getLastPLayer(3).setText("Estado:"+String.valueOf(player.isInJail()));
            vista.getBalPlayer(3).setText("Balance:"+player.getBalance());
        }
        if(index==4){
            vista.getNamePlayer(4).setText(player.getName()+" "+player.getLastname());
            vista.getLastPLayer(4).setText("Estado:"+String.valueOf(player.isInJail()));
            vista.getBalPlayer(4).setText("Balance:"+player.getBalance());
        }
    }
    
    public static void Button_ThrowEnable(){
        vista.GetButton_Throw().setEnabled(true);
    }
    
    public static void Button_ThrowDisable(){
        vista.GetButton_Throw().setEnabled(false);
    }
    
    public static void HidePlayer(int i)
    {
        vista.getPanelPlayer(i).setVisible(false);
    }
    
    public static void DadosSet(int dado1,int dado2){//mostrar dados
        TableroViewController.dado1 = dado1;
        TableroViewController.dado2 = dado2;
    }
    
    public static void DadosUpdate(){
        vista.GetDado1().setIcon(new javax.swing.ImageIcon(TableroViewController.class.getResource("/resources/dado"+String.valueOf(dado1)+".png")));
        vista.GetDado2().setIcon(new javax.swing.ImageIcon(TableroViewController.class.getResource("/resources/dado"+String.valueOf(dado2)+".png")));
    }
    
    public static void MovePiece(int casilla,int player){

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
            orig =vista.GetJailx();
            axis =vista.GetJaily();  
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
        if(player == 1 && casilla==10 && Core.listaJugadores.get(1).isInJail()==true)
            vista.SetP1Location(orig,axis);
        else if(player == 1 && casilla==10)
            vista.SetP1Location(orig+60,axis);       
        else if(player == 1)
            vista.SetP1Location(orig,axis); 
        else if(player == 2 && casilla==10 && Core.listaJugadores.get(2).isInJail()==true)
            vista.SetP2Location(orig+25,axis);
        else if(player == 2 && casilla==10)
            vista.SetP2Location(orig+60,axis+30);
        else if(player==2)
            vista.SetP2Location(orig+20,axis);
        else if(player == 3 && casilla==10 && Core.listaJugadores.get(3).isInJail()==true)
            vista.SetP3Location(orig,axis+30);
        else if(player == 3 && casilla==10)
            vista.SetP3Location(orig,axis+60);
        else if(player==3)
            vista.SetP3Location(orig,axis+30);
        else if(player == 4 && casilla==10 && Core.listaJugadores.get(4).isInJail()==true)
            vista.SetP4Location(orig+25,axis+30);
        else if(player == 4 && casilla==10)
            vista.SetP4Location(orig+50,axis+55);
        else if(player==4)
            vista.SetP4Location(orig+25,axis+20);
    }

    public static void setActivePlayers(){
        int result[] = Core.jugadoresActivos();
        
        int i;
        for(i=0;i<result.length;i++){
            if(vista.getPlayerByIndex(i+1) != null ){
                if(result[i]==1){
                    vista.getPlayerByIndex(i+1).setVisible(true);
                    vista.getPanelPlayer(i+1).setVisible(true);
                }
                else
                {
                    vista.getPlayerByIndex(i+1).setVisible(false);
                    vista.getPanelPlayer(i+1).setVisible(false);
                }
            }    
        }                  
    }
}
