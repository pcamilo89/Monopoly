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
public class CardNearest extends Card{

    public CardNearest(Utils.CardType type, int amount, String text) {
        super(type, amount, text);
    }

    @Override
    public void execute(Player player) {
        int pos = player.getPosition();
        
        //si amount 0 nearest utility
        if ( this.getAmount() == 0 ) {
            //electricidad 12 y  agua 28
            
            if (pos >=29 || pos <= 11){
                //si la posicion es mayor a 29 o menor a 11 se mueve a la 12
                player.setPosition(12);
            }
            else if (pos >= 13 && pos <= 27) {
                //si la posicion esta entre 13 y 27 se mueve a la 28
                player.setPosition(28);
            }
            
            BoardOwnable temp = (BoardOwnable) Core.boardList.get( Core.getPlayerByUsername(Core.playerActual).getPosition());
            
            if (temp.getOwner() == null){
                if( temp.getPrice() < player.getBalance() ){
                    temp.buy(player);
                }else{
                    Core.playerBankruptcy(player);
                }
            }else{
                //lanzar dado para pagar cardNearest (nuevas instrucciones)
                //pagar al dueño 10 veces el valor de los dados
            }
        }
        //si amount 1 nearest railroad
        else if ( this.getAmount() == 1 ) {
            //5,15,25,35
            
            if(pos >= 36 || pos <= 4){
                player.setPosition(5);
            }
            else if (pos >= 6 && pos <= 14) {
                player.setPosition(15);
            }
            else if (pos >= 16 && pos <= 24){
                player.setPosition(25);
            }
            else if (pos >= 26 && pos <= 34 ) {
                player.setPosition(35);
            }
            
            BoardOwnable temp = (BoardOwnable) Core.boardList.get( Core.getPlayerByUsername(Core.playerActual).getPosition());
            
            if (temp.getOwner() == null){
                if( temp.getPrice() < player.getBalance() ){
                    temp.buy(player);
                }else{
                    Core.playerBankruptcy(player);
                }
            }else{
                //se paga el doble del alquiler
                temp.rent(player);
                temp.rent(player);
            }
        }

    }
    
}
