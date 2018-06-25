/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Ramiro
 */
public class Board {
    private String nombre;
    public Board(){
        this.nombre="";
    }
    public Board(String name){
        this.nombre=name;
    }
    public String getName(){
        return(nombre);
    }
    public void setName(String name){
        this.nombre=name;
    }
}
