/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import model.Utils.GroupColor;

/**
 *
 * @author Camilo
 */
public class BoardProperty extends BoardOwnable{
    private GroupColor group;
    private int numHouses;
    private int priceHouse;
    private int priceHotel;
    private int rentSimple;
    private int rentH1;
    private int rentH2;
    private int rentH3;
    private int rentH4;
    private int rentHotel;

    public BoardProperty(GroupColor group, int priceHouse, int priceHotel, int rentSimple, int rentH1, int rentH2, int rentH3, int rentH4, int rentHotel, String name, int price, int mortage) {
        super(name, price, mortage);
        this.group = group;
        this.numHouses = 0;
        this.priceHouse = priceHouse;
        this.priceHotel = priceHotel;
        this.rentSimple = rentSimple;
        this.rentH1 = rentH1;
        this.rentH2 = rentH2;
        this.rentH3 = rentH3;
        this.rentH4 = rentH4;
        this.rentHotel = rentHotel;
    }  
 
    public int getNumHouses() {
        return numHouses;
    }

    public void setNumHouses(int numHouses) {
        this.numHouses = numHouses;
    }
    
    public GroupColor getGroup() {
        return group;
    }

    public int getPriceHouse() {
        return priceHouse;
    }

    public int getPriceHotel() {
        return priceHotel;
    }

    public int getRentSimple() {
        return rentSimple;
    }

    public int getRentH1() {
        return rentH1;
    }

    public int getRentH2() {
        return rentH2;
    }

    public int getRentH3() {
        return rentH3;
    }

    public int getRentH4() {
        return rentH4;
    }

    public int getRentHotel() {
        return rentHotel;
    }
    
    public boolean checkGroupColor(){
        if (this.getOwner() != null ) {
            //se chequean todas las casillas
            for(Board board :Core.boardList){
                //si la casilla es de clase BoardProperty
                if(board.getClass().equals(this.getClass())){
                    BoardProperty temp = (BoardProperty) board;
                    //se chequea si es del mismo grupo color y el dueño es distinto
                    if(temp.group.equals(this.group) &&  !temp.getOwner().equals(this.getOwner()) ){
                        //se retorna falso
                        return false;
                    }
                }
            }
            //si pasa por todas las propiedades del mismo grupo color y no hay dueños distintos retorna true
            return true;
        }
        else{
            //si no tiene dueño return false
            return false;
        }        
    }

    @Override
    public void rent(Player player) {
        int amount =  getRentSimple();
        
        if(checkGroupColor()){
            if (getNumHouses() == 0){
                amount *= 2;
            }
            else if(getNumHouses() == 1){
                amount = getRentH1();
            }
            else if(getNumHouses() == 2){
                amount = getRentH2();
            }
            else if(getNumHouses() == 3){
                amount = getRentH3();
            }
            else if(getNumHouses() == 4){
                amount = getRentH4();
            }
            else if(getNumHouses() == 5){
                amount = getRentHotel();
            }
        }
        
        if (isMortaged()){
            amount = 0;
        }
        
        if(player.getBalance() > amount){
            player.setBalance(player.getBalance() - amount);
            getOwner().setBalance(getOwner().getBalance() + amount);
        }else{
            Core.playerBankruptcy(player);
        }
    }

    @Override
    public void execute(Player player) {
        if (this.getOwner() == null) {                       
            if( player.getBalance() > getPrice() ){
                buy(player);
            }
            else{
                Core.playerBankruptcy(player);
            }
        }
        else{
            rent(player);
        }
    }
    
}
