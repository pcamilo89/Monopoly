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
public class CardTax extends Card{
    private int priceHouse;
    private int priceHotel;

    public CardTax(int priceHouse, int priceHotel, Utils.CardType type, int amount, String text) {
        super(type, amount, text);
        this.priceHouse = priceHouse;
        this.priceHotel = priceHotel;
    }

    public int getPriceHouse() {
        return priceHouse;
    }

    public void setPriceHouse(int priceHouse) {
        this.priceHouse = priceHouse;
    }

    public int getPriceHotel() {
        return priceHotel;
    }

    public void setPriceHotel(int priceHotel) {
        this.priceHotel = priceHotel;
    }
    
    @Override
    public void execute(Player player) {
        //se deben contar las casas y hoteles del jugador en todas sus propiedades
        int countHouse = 0;
        int countHotel = 0;
        int price = (countHouse * priceHouse) + (countHotel * priceHotel);
        
        //si el balance del jugador es mayor al precio
        if ( player.getBalance() > price ) {
            player.setBalance(player.getBalance() - price);
        }
        else {
            Core.playerBankruptcy(player);
        }
        
    }
    
}
