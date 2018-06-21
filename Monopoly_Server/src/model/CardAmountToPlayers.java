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
public class CardAmountToPlayers extends Card{

    public CardAmountToPlayers(Utils.CardType type, int amount, String text) {
        super(type, amount, text);
    }

    @Override
    public void execute(Player player) {
        int cant = Core.playerList.size() - 1;
        cant *= super.getAmount();
        //si el jugador tiene mas en su balance de lo que tiene que pagarle a otros jugadores
        if(player.getBalance() > cant) {
            //recorre cada jugador.
            for(Player act: Core.playerList){
                //si no es el jugador actual le pasa la cantidad especificada
                if(act != player){
                    act.setBalance(act.getBalance()+super.getAmount());
                    player.setBalance(player.getBalance()-super.getAmount());
                }
            }
        }
        else{
            //en caso que el balance sea menor entra en bancarrota
        }
    }
    
}
