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
public abstract class BoardOwnable extends Board{
    private Player owner;
    private int price;
    private int mortageVal;
    private boolean mortaged;
    
    public BoardOwnable(String name,int price, int mortage) {
        super(name);
        this.owner = null;
        this.price = price;
        this.mortageVal = mortage;
        this.mortaged = false;
    }

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    public boolean isMortaged() {
        return mortaged;
    }

    public void setMortaged(boolean mortaged) {
        this.mortaged = mortaged;
    }
    
    public void buy(Player player){
        if( owner == null ){
            if (player.getBalance() > price) {
                player.setBalance(player.getBalance() - price);
                this.owner = player;
            }
        }
    }
    
    public void sell(){
        if( owner != null ){            
            owner.setBalance(owner.getBalance() + ( price/2 ));
            this.owner = null;

        }
    }
    
    public void auction(){
        if( owner != null ){
            //subasta a los otros jugadores va aqui
            //se puede transferir hipoteca a otro jugador
            //subasta a uno o a todos (trade o intercambio)
        }
    }
    
    public void mortageOwnable(){
        if( owner != null ){
            owner.setBalance(owner.getBalance() + mortageVal);
            setMortaged(true);
        }
    }
    
    public void mortageLift(){
        int temp = (int) (mortageVal * 1.10);
        if( owner != null ){
            //solo se puede levantar si tiene un balance mayor al valor de hipoteca + 10%
            if(owner.getBalance() > temp) {
                owner.setBalance(owner.getBalance() - temp);
                setMortaged(false);
            }
        }
    }
    
    public abstract void rent(Player player);
}