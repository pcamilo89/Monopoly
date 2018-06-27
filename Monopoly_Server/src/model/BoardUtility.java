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
public class BoardUtility extends BoardOwnable{

    public BoardUtility(String name, int price, int mortage) {
        super(name, price, mortage);
    }

    @Override
    public String toString() {
        return "BoardUtility{" +super.toString()+ '}';
    }

    
    
    @Override
    public void rent(Player player) {
        int count = 0;
        //se busca las BoardUtility en la lista y se verifica si mismo dueño
        for(Board board: Core.boardList){
            if(board.getClass().equals(this.getClass())){
                BoardUtility temp = (BoardUtility) board;
                if( temp.getOwner() != null && temp.getOwner().getUser().getName().equals( this.getOwner().getUser().getName() ) ){
                    count ++;
                }
            }
        }
        int amount = 0;
        if(count == 1){
            amount = ( Core.dados[0]+Core.dados[1] ) * 4;
        }
        else {
            amount = ( Core.dados[0]+Core.dados[1] ) * 10;
        }
        
        if(amount > 0){
            Core.msgAllPlayers(player.getUser().getName()+" ha pagado a "+this.getOwner().getUser().getName()+ " la renta de "+ amount + " por visitar "+ this.getName());
        }        
        
        if (player.getBalance() > amount){
            //se paga alquiler
            getOwner().setBalance(getOwner().getBalance() + amount);
            player.setBalance(player.getBalance() - amount);
        }
        else{
            Core.playerBankruptcy(player);
        }
        
    }
    
    /**
     *
     * @param player
     */
    @Override
    public void execute(Player player) {
        //si la propiedad no tiene dueño 
        if (this.getOwner() == null) {                       
            if( player.getBalance() > getPrice() ){
                buy(player);
                String msg = player.getUser().getName()+" ha comprado "+this.getName()+ " por "+ this.getPrice();
                Core.msgAllPlayers(msg);
                Core.alertPlayer(player.getUser().getUsername(), msg);
            }
            else{
                Core.playerBankruptcy(player);
            }
        }
        else{
            if(!this.getOwner().getUser().getUsername().equals(player.getUser().getUsername())){
                /*  Si tiene dueño lanzar dados en interfaz (instruccion desde utility)
                    1. usar desde cliente lanzardado (para usar valores de dado en core)     
                    2. seguido de otra instruccion (nueva instruccion)
                    3. al recibir instruccion llamar al rent de la siguiente manera            
                        BoardUtility temp = (BoardUtility) Core.boardList.get( Core.getPlayerByUsername(Core.playerActual).getPosition() );
                        temp.rent(Core.getPlayerByUsername(Core.playerActual));
                */
            }
                
        }    
    }
    
}
