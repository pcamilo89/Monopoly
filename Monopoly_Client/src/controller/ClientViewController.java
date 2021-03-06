/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import model.Core;
import model.Utils;
import view.ChatPanel;
import view.ClientView;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Camilo
 */
public class ClientViewController {
    private static ClientView clientView;
    
    public static void load(ClientView from){
        clientView = from;
        
        setElements();
        
        clientView.setMinimumSize(new Dimension(600, 385));
        clientView.setLocationRelativeTo(null);
    }
    
    public static void setElements(){
        clientView.getjLUsername().setText("Username:");
        clientView.getjLPassword().setText("Password:");
        clientView.getjBLogin().setText("Login");
        clientView.getjBLogout().setText("Logout");
        clearUserFields();
        
        clientView.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        
        WindowListener exitListener = new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                
                int confirm = JOptionPane.showOptionDialog(
                    null, "Are You Sure to Close Application?", 
                    "Exit Confirmation", JOptionPane.YES_NO_OPTION, 
                    JOptionPane.QUESTION_MESSAGE, null, null, null);
                if (confirm == 0) {
                    System.out.println("Cerrando ClientView");
                    if(Core.client != null){
                        Core.client.sendMsg("exit");
                        Core.stopClient();
                    }
                    clientView.setVisible(false);
                    clientView.dispose();
                }
                
            }
        };
        clientView.addWindowListener(exitListener);
        
        clientView.getjBLogin().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClientViewController.loginButton();
            }
        });
        
        clientView.getjBLogout().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClientViewController.logoutButton();
            }
        });
        
        clientView.getjLServerIP().setText("Server IP:");
        clientView.getjLServerPort().setText("Server Port:");
        clientView.getjBConnect().setText("Connect");
        clientView.getjBDisconnect().setText("Disconnect");
        clearServerFields();
        
        clientView.getjTFServerIP().setText(Utils.CLIENT_SERVER_IP);
        clientView.getjTFServerPort().setText(String.valueOf(Utils.CLIENT_SERVER_PORT));
        
        clientView.getjBConnect().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClientViewController.connectButton();
            }
        });
        
        clientView.getjBDisconnect().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClientViewController.disconnectButton();
            }
        });
        
        clearInfoLabel();
        connectSetup();
        clientView.getjPChat().add(new ChatPanel());
    }
    
    public static void closeWindow(){
        clientView.setVisible(false);
        clientView.dispose();
    }
    
    public static void clearUserFields(){
        clientView.getjTFUsername().setText("");
        clientView.getjPFPassword().setText(null);        
    }
    
    public static void enableUserFields(){
        clientView.getjTFUsername().setEnabled(true);
        clientView.getjPFPassword().setEnabled(true);
    }
    
    public static void disableUserFields(){
        clientView.getjTFUsername().setEnabled(false);
        clientView.getjPFPassword().setEnabled(false);
    }
    
    public static void clearServerFields(){
        clientView.getjTFServerIP().setText("");
        clientView.getjTFServerPort().setText("");
    }
    
    public static void enableServerFields(){
        clientView.getjTFServerIP().setEnabled(true);
        clientView.getjTFServerPort().setEnabled(true);
    }
    
    public static void disableServerFields(){
        clientView.getjTFServerIP().setEnabled(false);
        clientView.getjTFServerPort().setEnabled(false);
    }
    
    public static void clearInfoLabel(){
        clientView.getjLInfo().setText("");
    }
    
    public static void setInfoLabel(String text){
        clientView.getjLInfo().setText(text);
    }
    
    public static void connectSetup(){
        enableServerFields();
        clientView.getjBConnect().setEnabled(true);
        clientView.getjBDisconnect().setEnabled(false);
        
        disableUserFields();
        clientView.getjBLogin().setEnabled(false);
        clientView.getjBLogout().setEnabled(false);
    }
    
    public static void disconnectSetup(){
        disableServerFields();
        clientView.getjBConnect().setEnabled(false);
        clientView.getjBDisconnect().setEnabled(true);
        
        enableUserFields();
        clientView.getjBLogin().setEnabled(true);
        clientView.getjBLogout().setEnabled(false);
    }
    
    public static void loginSetup(){
        enableUserFields();
        
        clientView.getjBLogin().setEnabled(true);
        clientView.getjBLogout().setEnabled(false);
    }
    
    public static void logoutSetup(){
        disableUserFields();
        
        clientView.getjBLogin().setEnabled(false);
        clientView.getjBLogout().setEnabled(true);        
    }
    
    public static void loginButton(){
        String msg = "login;"+clientView.getjTFUsername().getText()+";"+String.valueOf(clientView.getjPFPassword().getPassword());
        Core.client.sendMsg(msg);
    }
    
    public static void logoutButton(){

    }
    
    public static void connectButton(){
        Core.startClient(clientView.getjTFServerIP().getText(), Integer.parseInt(clientView.getjTFServerPort().getText()));
    }
    
    public static void disconnectButton(){
        if(Core.client != null){
            Core.client.sendMsg("exit");
            Core.stopClient();
        }
        
        connectSetup();
    }
    
    public static void loginSuccess(){        
        clearUserFields();
        logoutSetup();
    }
}
