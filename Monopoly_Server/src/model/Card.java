/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import model.Utils.CardType;

/**
 *
 * @author Camilo
 */
public abstract class Card {
    private CardType type;
    private int amount;
    private String text;

    public CardType getType() {
        return type;
    }

    public void setType(CardType type) {
        this.type = type;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    
    public Card(CardType type, int amount, String text){
        this.type = type;
        this.amount = amount;
        this.text = text;
    }
    
    public abstract void execute(Player player);        
}
