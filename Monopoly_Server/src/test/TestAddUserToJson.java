/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test;

import model.User;
import model.UserJson;

/**
 *
 * @author Camilo
 */
public class TestAddUserToJson {
    public static void main(String args[]){
        User tempUser =  new User("Camilo", "Perez", "pcamilo89", "1234");
        UserJson.addUser(tempUser);
    }
}
