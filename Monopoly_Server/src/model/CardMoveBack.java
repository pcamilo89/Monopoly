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
public class CardMoveBack extends Card{

    public CardMoveBack(Utils.CardType type, int amount, String text) {
        super(type, amount, text);
    }

    @Override
    public void execute(Player player) {
        player.setPosition(player.getPosition() - this.getAmount());
        
        if(player.getPosition() < 0 ){
            player.setPosition(player.getPosition() + 39);
        }
        
        //falta implementar como continuar turno evaluando la siguiente posicion en tablero.
        //llamar a la lista tablero en la posicion amount y su metodo excecute para siguiente paso
    }
    
}
