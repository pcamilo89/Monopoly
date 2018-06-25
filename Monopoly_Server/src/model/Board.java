/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

/**
 *
 * @author Camilo
 */
public abstract class Board {
    private String name;
    
    public Board(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public abstract void execute(Player player);

    @Override
    public String toString() {
        return "Board{" + "name=" + name + '}';
    }   
    
}
