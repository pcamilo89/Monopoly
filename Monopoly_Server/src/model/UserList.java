/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.util.ArrayList;
import javax.swing.AbstractListModel;

/**
 *
 * @author Camilo
 */
public class UserList extends AbstractListModel{
    private ArrayList<User> userList;
    
    public UserList(){
        this.userList = new ArrayList<User>();
    }
    
    public void addUser(User user) {
        if(this.userList.add(user)){
            fireContentsChanged(this, 0, getSize());
        }else{
            System.out.println("Error Add.");
        }
    }
    
    public void clear() {
        this.userList.clear();
        fireContentsChanged(this, 0, getSize());
    }
    
    public User getById(int id) {
        for (User user : this.userList) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }
    @Override
    public int getSize() {
        return this.userList.size();
    }

    @Override
    public Object getElementAt(int index) {
        return this.userList.get(index);
    }
    
}
