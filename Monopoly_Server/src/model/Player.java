/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.util.ArrayList;

/**
 *
 * @author Camilo
 */
public class Player {
    private User user;
    private int position;
    private int balance;
    private int contJail;
    private boolean inJail;
    private ArrayList<Card> cardList;
    
    
    public Player(){
        this.user = null;
        this.position = 0;
        this.balance = 0;
        this.contJail = 0;
        this.inJail = false;
        this.cardList = new ArrayList<>();
    }
    
    public Player(User user, int saldo){
        this.user = user;
        this.position = 0;
        this.balance = saldo;
        this.contJail = 0;
        this.inJail =  false;
        this.cardList = new ArrayList<>();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public int getContJail() {
        return contJail;
    }

    public void setContJail(int contJail) {
        this.contJail = contJail;
    }

    public boolean isInJail() {
        return inJail;
    }

    public void setInJail(boolean inJail) {
        this.inJail = inJail;
    }

    public ArrayList<Card> getCardList() {
        return cardList;
    }

    public void setCardList(ArrayList<Card> cardList) {
        this.cardList = cardList;
    }
    
    @Override
    public String toString() {
        return "Jugador{" + "user=" + user + ", posicion=" + position + ", saldo=" + balance + ", contCarcel=" + contJail + ", inJail=" + inJail + '}';
    }
    
}
