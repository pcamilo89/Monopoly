/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import model.Core;
import view.ChatPanel;
import java.awt.Color;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

/**
 *
 * @author Camilo
 */
public class ChatPanelController {
    public static ChatPanel panel;
    
    public static void load(ChatPanel from) {
        panel = from;
        
        setElements();
    }
    
    public static void setElements(){
        panel.getjTFInput().setText("");
        
        panel.getjBSend().setText("Send");
        panel.getjBSend().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChatPanelController.sendTextButton();
            }
        });
        
        panel.getjTPTerminal().setEditable(false);
    }
    
    public static void sendTextButton(){
        if(!panel.getjTFInput().getText().equals("")){
            Core.client.sendMsg("chat;"+panel.getjTFInput().getText());
            //Core.server.msgAll("chat;server;"+serverView.getjTFInput().getText());
            panel.getjTFInput().setText("");
        } 
    }
    
    public static void addUserText(String user, String text){
        try {
            Date date = new Date();
            DateFormat df = new SimpleDateFormat("hh:mm:ss");

            
            StyledDocument doc = panel.getjTPTerminal().getStyledDocument();
            
            Style timeStyle = panel.getjTPTerminal().addStyle("Time", null);
            StyleConstants.setForeground(timeStyle, Color.DARK_GRAY);
            StyleConstants.setBold(timeStyle, true);
            
            Style nameStyle = panel.getjTPTerminal().addStyle("Name", null);
            StyleConstants.setForeground(nameStyle, Color.DARK_GRAY);
            StyleConstants.setBold(nameStyle, true);
            
            Style textStyle = panel.getjTPTerminal().addStyle("Text", null);
            StyleConstants.setForeground(textStyle, Color.BLACK);
            StyleConstants.setBold(textStyle, false);
            
            
            doc.insertString(doc.getLength(), "<"+df.format(date)+"> ", timeStyle);
            doc.insertString(doc.getLength(), user+": ", nameStyle);
            doc.insertString(doc.getLength(), text+"\n", textStyle);
            
            //output a la consola
            System.out.println(user+">"+text);
            
        } catch (BadLocationException ex) {
            Logger.getLogger(ChatPanelController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void addServerText(String text){
        try {
            Date date = new Date();
            DateFormat df = new SimpleDateFormat("hh:mm:ss");
            
            StyledDocument doc = panel.getjTPTerminal().getStyledDocument();
            
            Style timeStyle = panel.getjTPTerminal().addStyle("Time", null);
            StyleConstants.setForeground(timeStyle, Color.DARK_GRAY);
            StyleConstants.setBold(timeStyle, true);
            
            Style nameStyle = panel.getjTPTerminal().addStyle("Name", null);
            StyleConstants.setForeground(nameStyle, Color.RED);
            StyleConstants.setBold(nameStyle, true);
            
            Style textStyle = panel.getjTPTerminal().addStyle("Text", null);
            StyleConstants.setForeground(textStyle, Color.BLACK);
            StyleConstants.setBold(textStyle, false);
            
            
            doc.insertString(doc.getLength(), "<"+df.format(date)+"> ", timeStyle);
            doc.insertString(doc.getLength(), "Server: ", nameStyle);
            doc.insertString(doc.getLength(), text+"\n", textStyle);
            
            //output a la consola
            System.out.println("#"+text);
            
        } catch (BadLocationException ex) {
            Logger.getLogger(ChatPanelController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
