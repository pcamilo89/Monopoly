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
public class BoardRailroad extends BoardOwnable{

    public BoardRailroad(String name, int price, int mortage) {
        super(name, price, mortage);
    }

    @Override
    public void rent(Player player) {
        int count = 0;
        //se busca las otras BoardRailroad en la lista
        for(Board board: Core.boardList){
            if(board.getClass().equals(this.getClass())){
                BoardRailroad temp = (BoardRailroad) board;
                if( temp.getOwner().equals(this.getOwner()) ){
                    count ++;
                }
            }
        }
        
        int amount;
        if(count == 1){
            amount = 25;
        }
        else if(count == 2){
            amount = 50;
        }
        else if(count == 3){
            amount = 100;
        }
        else {
            amount = 200;
        }
        
        if (player.getBalance() > amount){
            //se paga alquiler
            player.setBalance(player.getBalance() - amount);
            getOwner().setBalance(getOwner().getBalance() + amount);
        }
        else{
            Core.playerBankruptcy(player);
        }
    }

    @Override
    public void execute(Player player) {
        if (this.getOwner() != null){
            rent(player);
        }
        else{
            if(player.getBalance() > getPrice()){
                buy(player);
            }
            else{
                Core.playerBankruptcy(player);
            }
        }
    }
    
}
