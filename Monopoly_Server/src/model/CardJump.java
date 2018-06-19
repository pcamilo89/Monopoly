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
public class CardJump extends Card{

    public CardJump(Utils.CardType type, int amount, String text) {
        super(type, amount, text);
    }

    @Override
    public void execute(Player player) {
        player.setPosition(super.getAmount());
        
        //falta implementar como continuar turno evaluando la siguiente posicion en tablero.
    }
    
}
