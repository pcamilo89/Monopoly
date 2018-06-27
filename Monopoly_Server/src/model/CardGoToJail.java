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
public class CardGoToJail extends Card{

    public CardGoToJail(Utils.CardType type, int amount, String text) {
        super(type, amount, text);
    }

    @Override
    public void execute(Player player) {
        //se mueve al jugador a la carcel y se setea el boolean como true
        player.setPosition(10);
        player.setInJail(true);
        
        //metodo verifica tarjetas de salir de la carcel
        Core.playerHasCardOutOfJail(player);
        
    }
    
}
