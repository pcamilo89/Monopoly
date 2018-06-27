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
public class BoardGoToJail extends Board{

    public BoardGoToJail(String name) {
        super(name);
    }

    @Override
    public void execute(Player player) {
        //se mueve al jugador a la carcel y se setea el boolean como true
        player.setPosition(10);
        player.setInJail(true);
        
        String msg = player.getUser().getName()+" "+this.getName();
        Core.msgAllPlayers(msg);
        Core.alertAllPlayers(msg);
        
        //metodo verifica tarjetas de salir de la carcel
        Core.playerHasCardOutOfJail(player);
        
    }
    
}
