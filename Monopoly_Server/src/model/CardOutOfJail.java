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
public class CardOutOfJail extends Card{

    public CardOutOfJail(Utils.CardType type, int amount, String text) {
        super(type, amount, text);
    }

    @Override
    public void execute(Player player) {
        //se agrega a la lista de cartas del jugador.
        player.getCardList().add(this);
        //se retira de la lista momentaneamente
        if(super.getType() == CardType.COMMUNITY){
            Core.communityList.remove(this);
        }
        else if(super.getType() == CardType.CHANCE){
            Core.chanceList.remove(this);
        }
    }
    
}
