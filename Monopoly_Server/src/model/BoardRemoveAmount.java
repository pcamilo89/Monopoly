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
public class BoardRemoveAmount extends Board{
    private int amount;

    public BoardRemoveAmount(String name, int amount) {
        super(name);
        this.amount = amount;
    }

    @Override
    public void execute(Player player) {
        //si el jugador tiene balance mayor a la cantidad.
        if (player.getBalance() > amount) {
            player.setBalance(player.getBalance() - amount);
        }
        else {
            //caso en que el jugador cae en bancarrota
        }
    }
    
}