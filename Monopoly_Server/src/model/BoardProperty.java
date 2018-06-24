/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import model.Utils.GroupColor;

/**
 *
 * @author Camilo
 */
public class BoardProperty extends BoardOwnable{
    private GroupColor group;
    private int priceHouse;
    private int priceHotel;
    private int rentSimple;
    private int rentH1;
    private int rentH2;
    private int rentH3;
    private int rentH4;
    private int rentHotel;

    public BoardProperty(GroupColor group, int priceHouse, int priceHotel, int rentSimple, int rentH1, int rentH2, int rentH3, int rentH4, int rentHotel, String name, int price, int mortage) {
        super(name, price, mortage);
        this.group = group;
        this.priceHouse = priceHouse;
        this.priceHotel = priceHotel;
        this.rentSimple = rentSimple;
        this.rentH1 = rentH1;
        this.rentH2 = rentH2;
        this.rentH3 = rentH3;
        this.rentH4 = rentH4;
        this.rentHotel = rentHotel;
    }    

    public GroupColor getGroup() {
        return group;
    }

    public int getPriceHouse() {
        return priceHouse;
    }

    public int getPriceHotel() {
        return priceHotel;
    }

    public int getRentSimple() {
        return rentSimple;
    }

    public int getRentH1() {
        return rentH1;
    }

    public int getRentH2() {
        return rentH2;
    }

    public int getRentH3() {
        return rentH3;
    }

    public int getRentH4() {
        return rentH4;
    }

    public int getRentHotel() {
        return rentHotel;
    }

    @Override
    public void rent(Player player) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void execute(Player player) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
