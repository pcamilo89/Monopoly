/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import javax.swing.JList;
import model.Core;
import model.User;
import model.UserJson;
import view.UserFormView;
import view.UserListPanel;
import view.UserView;

/**
 *
 * @author Camilo
 */
public class UserViewController {
    private static UserView userView;
    
    public static void load(UserView from) {
        userView = from;
        setModel(userView.getjLUserList());
        
        UserJson.loadUserList();
        setElements();
    }
    
    public static void setElements(){
        userView.getjBAddUser().setText("Add");
        userView.getjBAddUser().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButton();
            }
        });
        
        userView.getjBEditUser().setText("Edit");
        userView.getjBEditUser().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editSelectedUser();
            }
        });
        
        userView.getjBDeleteUser().setText("Delete");
        userView.getjBDeleteUser().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UserViewController.deleteSelectedUser();
            }
        });
        
        userView.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                userView.setVisible(false);
                userView.dispose();
            }
        });
    }
    
    public static void setModel(JList userList){
        userList.setModel(Core.userList);
        userList.setCellRenderer(new UserListPanel());
    }
    
    public static User getSelectedUser(){
        return (User) userView.getjLUserList().getSelectedValue();
    }
    
    public static void deleteSelectedUser(){
        User user = getSelectedUser();
        if ( user != null ){
            UserJson.deleteUser(user);
            UserJson.loadUserList();
        }
        
    }
    
    public static void addButton(){
        UserFormViewController.setMode(0);
        UserFormView userForm = new UserFormView();
        userForm.setVisible(true);
    } 
    
    public static void editSelectedUser(){
        User user = getSelectedUser();

        if ( user != null ){
            UserFormView userForm = new UserFormView();
            
            UserFormViewController.loadUser(user);
            UserFormViewController.setMode(1);
            
            userForm.setVisible(true);
        }
            
    }
}
