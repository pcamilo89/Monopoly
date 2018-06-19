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
        
        //se chequea si el jugador tiene carta de salir de la carcel y se le retira y se coloca como visitante de carcel
        if( player.getCardList().size() > 0){
            Card card = player.getCardList().get(0);
            if(card != null){
                player.getCardList().remove(card);
            
                if(card.getType() == Utils.CardType.COMMUNITY){
                    Core.communityList.add(card);
                }
                else if(card.getType() == Utils.CardType.CHANCE){
                    Core.chanceList.add(card);
                }

                player.setInJail(false);
            }
            
        }
        
    }
    
}
