/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import model.Card;
import model.Core;

/**
 *
 * @author ryu_a
 */
public class TestCommunityAndChanceList
{
    public static void main(String[] args)
    {
        Core.initCore();
        System.out.println("Chance:");
        System.out.println("Tamaño: " + Core.chanceList.size());
        for(Card card: Core.chanceList){
            System.out.println(card.toString());
        }
        
        System.out.println("Community:");
        System.out.println("Tamaño: " + Core.communityList.size());
        for(Card card: Core.communityList){
            System.out.println(card.toString());
        }

    }
}
