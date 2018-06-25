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
public class BoardGrabCard extends Board{
    private CardType type;

    public BoardGrabCard(CardType type) {
        //nombre de la casilla
        super(type.toString());
        //tipo de carta
        this.type = type;
    }

    @Override
    public String toString() {
        return "BoardGrabCard{" + "type=" + type + '}';
    }
    
    @Override
    public void execute(Player player) {
        //se busca la carta aleatoria segun el tipo de la casilla
        Card  card = Core.getRandomCard(Core.getCardList(type));
        //se ejecuta el comando segun la carta seleccionada
        card.execute(player);
    }
    
}
