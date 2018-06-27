/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test;

import model.Card;
import model.Core;
import model.Utils;

/**
 *
 * @author Camilo
 */
public class TestGrabCard {
    public static void main(String args[]){
        Core.initCore();
        for(int i=0; i<10;i++){
            Card card = Core.getRandomCard(Core.getCardList(Utils.CardType.CHANCE));
            System.out.println(card.toString());
        }
    }
}
