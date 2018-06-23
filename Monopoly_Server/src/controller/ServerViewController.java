/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.awt.Color;
import java.awt.Dimension;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import model.Core;
import model.Utils;
import view.ServerView;
import view.UserView;

/**
 *
 * @author Camilo
 */
public class ServerViewController {
    private static ServerView serverView;

    public static void load(ServerView from){
        ServerViewController.serverView = from;
        
        setElements();
        
        serverView.setMinimumSize(new Dimension(370, 385));
        serverView.setLocationRelativeTo(null);
        //serverView.setResizable(false);
    }
    
    private static void setElements(){
        serverView.getjTFInput().setText("");
        serverView.getjTFPort().setText(String.valueOf(Utils.SERVER_PORT));
        
        serverView.getjBSend().setText("Send");
        serverView.getjBSend().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ServerViewController.sendTextButton();
            }
        });
        
        serverView.getjBStartServer().setText("Start/Stop");
        serverView.getjBStartServer().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ServerViewController.startServerButton();
            }
        });
        
        serverView.getjBAdminUsers().setText("Usuarios");
        serverView.getjBAdminUsers().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UserView userView = new UserView();
                userView.setVisible(true);
            }
        });
        
        serverView.getjTPTerminal().setEditable(false);
        
        serverView.getjBStartGame().setText("Iniciar Juego");
        serverView.getjBStartGame().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //logica para empezar la partida
                Core.checkStartGameConditions();
            }
        });
        startGameButtonDisable();
    }
    
    public static void startGameButtonEnable(){
        serverView.getjBStartGame().setEnabled(true);
    }
    
    public static void startGameButtonDisable(){
        serverView.getjBStartGame().setEnabled(false);
    }
    
    public static void sendTextButton(){
        if(!serverView.getjTFInput().getText().equals("")){
            ServerViewController.addUserText( "Server", serverView.getjTFInput().getText());
            Core.server.msgAuthUsers("chat;Server;"+serverView.getjTFInput().getText());
            serverView.getjTFInput().setText("");
        }        
    }
    
    public static void startServerButton(){
        Utils.SERVER_PORT = Integer.parseInt(serverView.getjTFPort().getText());
        
        Core.startServer(Utils.SERVER_PORT);
    }
    
    public static void addUserText(String user, String text){
        try {
            Date date = new Date();
            DateFormat df = new SimpleDateFormat("hh:mm:ss");

            
            StyledDocument doc = serverView.getjTPTerminal().getStyledDocument();
            
            Style timeStyle = serverView.getjTPTerminal().addStyle("Time", null);
            StyleConstants.setForeground(timeStyle, Color.DARK_GRAY);
            StyleConstants.setBold(timeStyle, true);
            
            Style nameStyle = serverView.getjTPTerminal().addStyle("Name", null);
            StyleConstants.setForeground(nameStyle, Color.DARK_GRAY);
            StyleConstants.setBold(nameStyle, true);
            
            Style textStyle = serverView.getjTPTerminal().addStyle("Text", null);
            StyleConstants.setForeground(textStyle, Color.BLACK);
            StyleConstants.setBold(textStyle, false);
            
            
            doc.insertString(doc.getLength(), "<"+df.format(date)+"> ", timeStyle);
            doc.insertString(doc.getLength(), user+": ", nameStyle);
            doc.insertString(doc.getLength(), text+"\n", textStyle);
            
            //output a la consola
            System.out.println(user+">"+text);
            
        } catch (BadLocationException ex) {
            Logger.getLogger(ServerViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void addServerText(String text){
        try {
            Date date = new Date();
            DateFormat df = new SimpleDateFormat("hh:mm:ss");
            
            StyledDocument doc = serverView.getjTPTerminal().getStyledDocument();
            
            Style timeStyle = serverView.getjTPTerminal().addStyle("Time", null);
            StyleConstants.setForeground(timeStyle, Color.DARK_GRAY);
            StyleConstants.setBold(timeStyle, true);
            
            Style nameStyle = serverView.getjTPTerminal().addStyle("Name", null);
            StyleConstants.setForeground(nameStyle, Color.RED);
            StyleConstants.setBold(nameStyle, true);
            
            Style textStyle = serverView.getjTPTerminal().addStyle("Text", null);
            StyleConstants.setForeground(textStyle, Color.BLACK);
            StyleConstants.setBold(textStyle, false);
            
            
            doc.insertString(doc.getLength(), "<"+df.format(date)+"> ", timeStyle);
            doc.insertString(doc.getLength(), "Server: ", nameStyle);
            doc.insertString(doc.getLength(), text+"\n", textStyle);
            
            //output a la consola
            System.out.println("#"+text);
            
        } catch (BadLocationException ex) {
            Logger.getLogger(ServerViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
