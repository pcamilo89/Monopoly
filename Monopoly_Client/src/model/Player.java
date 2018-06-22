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
public class Player {
    private String username;
    private String name;
    private String lastname;
    private int position;
    private int balance;
    private boolean inJail;
    private boolean activo;
    
    public Player(){
        this.username = "";
        this.name = "";
        this.lastname = "";
        this.position = 0;
        this.balance = 1500;
        this.inJail = false;
        this.activo =  false;        
    }
    
    public Player(String username){
        this.username = username;
        this.name = "";
        this.lastname = "";
        this.position = 0;
        this.balance = 1500;
        this.inJail = false;
        this.activo =  false;
    }
    
    public Player(String username, String name, String lastname){
        this.username = username;
        this.name = name;
        this.lastname = lastname;
        this.position = 0;
        this.balance = 1500;
        this.inJail = false;
        this.activo =  false;

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public boolean isInJail() {
        return inJail;
    }

    public void setInJail(boolean inJail) {
        this.inJail = inJail;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "Jugador{" + "username=" + username + ", name=" + name + ", lastname=" + lastname + ", position=" + position + ", balance=" + balance + ", inJail=" + inJail + ", activo=" + activo + '}';
    }
    
}
