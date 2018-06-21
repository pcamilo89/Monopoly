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
public class BoardPlain extends Board{

    public BoardPlain(String name) {
        super(name);
    }

    @Override
    public void execute(Player player) {
        //esta casilla no tiene funcionalidades que implementar
    }
    
}
