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
public class CardRemoveAmount extends Card{

    public CardRemoveAmount(Utils.CardType type, int amount, String text) {
        super(type, amount, text);
    }

    @Override
    public void execute(Player player) {
        //si tiene mas de la cantidad se le descuenta
        if (player.getBalance() > this.getAmount() ){
            player.setBalance(player.getBalance()-super.getAmount());
        }
        else{
            //caso para bacarrota
        }
        
    }
    
}
