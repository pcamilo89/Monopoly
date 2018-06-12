/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test;

import model.Core;
import model.UserList;
import view.UserView;

/**
 *
 * @author Camilo
 */
public class TestUserList {
    public static void main(String args[]){
        Core.userList = new UserList();
        
        UserView userView =  new UserView();
        userView.setVisible(true);
    }
}
