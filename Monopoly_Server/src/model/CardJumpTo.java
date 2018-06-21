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
public class CardJumpTo extends Card{

    public CardJumpTo(Utils.CardType type, int amount, String text) {
        super(type, amount, text);
    }

    @Override
    public void execute(Player player) {
        if(player.getPosition() > this.getAmount()){
            player.setBalance(player.getBalance()+200);
        }
        player.setPosition(super.getAmount());
        
        //ultimo paso, ejecutar comando de casilla destino
        Core.boardList.get(player.getPosition()).execute(player);
    }
    
}
