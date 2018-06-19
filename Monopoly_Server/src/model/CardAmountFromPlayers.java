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
public class CardAmountFromPlayers extends Card{

    public CardAmountFromPlayers(Utils.CardType type, int amount, String text) {
        super(type, amount, text);
    }

    @Override
    public void execute(Player player) {
        for(Player act: Core.playerList){
            //si no es el jugador actual le pasa la cantidad especificada
            if(act != player){
                if(act.getBalance() > super.getAmount()) {
                    act.setBalance(act.getBalance()-super.getAmount());
                    player.setBalance(player.getBalance()+super.getAmount());
                }
                else{
                    //caso en el que el jugador act entra en bancarrota
                }
                
                
                
            }
        }
    }
    
}
