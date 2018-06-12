/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.User;
import model.UserJson;
import view.UserFormView;

/**
 *
 * @author Camilo
 */
public class UserFormViewController {
    private static UserFormView userForm;
    //mode 0=guardar 1=editar
    private static int mode = -1;
    
    private static int userID = -1;
    
    public static void load(UserFormView from) {
        userForm = from;
        setElements();
        userForm.setResizable(false);
        userForm.setLocationRelativeTo(null);
    }
    
    public static void setElements(){
        setLabels();
        clearFields();
        setButtons();
    }
    
    public static void setLabels(){
        userForm.getjLName().setText("Nombre:");
        userForm.getjLLastname().setText("Apellido");
        userForm.getjLUsername().setText("Username");
        userForm.getjLPassword().setText("Password");
        
        userForm.getjBSave().setText("Guardar");
        userForm.getjBCancel().setText("Cancelar");
    }
    
    public static void clearFields(){
        userForm.getjTFName().setText("");
        userForm.getjTFLastname().setText("");
        userForm.getjTFUsername().setText("");
        userForm.getjPFPassword().setText("");
    }
    
    public static void setButtons(){
        userForm.getjBSave().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                saveButton();
            }
        });
        
        userForm.getjBCancel().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                cancelButton();
            }
        });
    }
    
    public static void setMode(int num){
        mode = num;
    }
    
    public static int getMode(int num){
        return mode;
    }
    
    public static void loadUser(User user){
        if ( user != null ) {
            userID =  user.getId();
            userForm.getjTFName().setText(user.getName());
            userForm.getjTFLastname().setText(user.getLastname());
            userForm.getjTFUsername().setText(user.getUsername());
            userForm.getjPFPassword().setText(user.getPassword());
        }
        
    }
    
    public static void saveButton(){
        User user = null;
        //caso agregar
        if(mode == 0){
            user = new User(
                userForm.getjTFName().getText(),
                userForm.getjTFLastname().getText(),
                userForm.getjTFUsername().getText(),
                String.valueOf(userForm.getjPFPassword().getPassword())
            );
            UserJson.addUser(user);
        }
        //caso modificar
        else if(mode == 1){
            user = new User(
                userID,
                userForm.getjTFName().getText(),
                userForm.getjTFLastname().getText(),
                userForm.getjTFUsername().getText(),
                String.valueOf(userForm.getjPFPassword().getPassword())
            );
            userID = -1;
            UserJson.editUser(user);
        }
        UserJson.loadUserList();
        cancelButton();
    }
    
    public static void cancelButton(){
        userForm.setVisible(false);
        userForm.dispose();
    }
}
