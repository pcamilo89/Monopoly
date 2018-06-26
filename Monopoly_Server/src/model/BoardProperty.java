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
    private int numHouses;
    private int priceHouse;
    private int rentSimple;
    private int rentH1;
    private int rentH2;
    private int rentH3;
    private int rentH4;
    private int rentHotel;

    /**
     * 
     * @param group grupoColor
     * @param priceHouse precio casa/hotel
     * @param rentSimple renta simple
     * @param rentH1 renta 1 casa   
     * @param rentH2 renta 2 casas
     * @param rentH3 renta 3 casas
     * @param rentH4 renta 4 casas
     * @param rentHotel renta hotel
     * @param name nombre propiedad
     * @param price precio
     * @param mortage hipoteca
     */
    public BoardProperty(GroupColor group, int priceHouse, int rentSimple, int rentH1, int rentH2, int rentH3, int rentH4, int rentHotel, String name, int price, int mortage) {
        super(name, price, mortage);
        this.group = group;
        this.numHouses = 0;
        this.priceHouse = priceHouse;
        this.rentSimple = rentSimple;
        this.rentH1 = rentH1;
        this.rentH2 = rentH2;
        this.rentH3 = rentH3;
        this.rentH4 = rentH4;
        this.rentHotel = rentHotel;
    }  
 
    public int getNumHouses() {
        return numHouses;
    }

    public void setNumHouses(int numHouses) {
        this.numHouses = numHouses;
    }
    
    public GroupColor getGroup() {
        return group;
    }

    public int getPriceHouse() {
        return priceHouse;
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
    public String toString() {
        return "BoardProperty{" + super.toString() + ", group=" + group + ", numHouses=" + numHouses + ", priceHouse=" + priceHouse + ", rentSimple=" + rentSimple + ", rentH1=" + rentH1 + ", rentH2=" + rentH2 + ", rentH3=" + rentH3 + ", rentH4=" + rentH4 + ", rentHotel=" + rentHotel + '}';
    }
    
    @Override
    public void sell(){
        if( this.numHouses == 0 ){
            super.sell();
        }
    }
    
    @Override
    public void auction(){
        if( this.numHouses == 0 ){
            super.auction();
        }
    }
    
    @Override
    public void mortageOwnable(){
        if( this.numHouses == 0 ){
            super.mortageOwnable();
        }
    }
    
    public boolean buyAddOn(){
        //si se es dueño del grupo color
        if(checkOwnerGroupColor() && checkNumHousesGroupColor()){
            //si tengo menos de 4, es decir solo casas
            if(numHouses < 4){
                //si hay casas disponibles para comprar
                if(Core.houses > 0){
                    if(getOwner().getBalance() > priceHouse){
                        Core.houses -= 1;
                        numHouses += 1;
                        getOwner().setBalance(getOwner().getBalance() - priceHouse);
                        return true;
                    }
                }
            }else if (numHouses == 4){
                //si el numHouses es 4 y hay hoteles en core
                if(Core.hotels > 0){
                    if(getOwner().getBalance() > priceHouse){
                        Core.houses += numHouses;
                        Core.hotels -=1;
                        numHouses += 1;
                        getOwner().setBalance(getOwner().getBalance() - priceHouse);
                        return true;
                    }
                }
            }
        }
        return false;
    }    

    public boolean sellAddon(){
        //si hay casas o hotel
        if(numHouses > 0 ){
            //se chequea que se es el dueño del grupoColor y que los numeros del grupo sean iguales
            if(checkOwnerGroupColor() && checkNumHousesGroupColor()){
                //si se tienen casas
                if ( numHouses < 5 ){
                    Core.houses += 1;
                    numHouses -= 1;
                    getOwner().setBalance(getOwner().getBalance() + (priceHouse/2) );
                    return true;
                }
                //si se tiene hotel
                else if(numHouses == 5){
                    //solo si en core hay 4 casas o mas
                    if( Core.houses >= 4 ) {
                        //se obtienen las casas
                        Core.houses -= 4;
                        //se disminuye en uno el contador
                        numHouses -=1;
                        //se devuelve el hotel
                        Core.hotels +=1;
                        getOwner().setBalance(getOwner().getBalance() + (priceHouse/2) );
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    /**
     * metodo que chequea que todas las las propiedades del grupoColor tengan el mismo numero de casas +/- 1;
     * @return 
     */
    public boolean checkNumHousesGroupColor(){
        boolean answer = true;
        if (this.getOwner() != null && checkOwnerGroupColor()) {
            //se chequean todas las casillas
            for(Board board :Core.boardList){
                //si la casilla es de clase BoardProperty
                if(board.getClass().equals(this.getClass())){
                    BoardProperty temp = (BoardProperty) board;
                    //se chequea si es del mismo grupo color
                    if(temp.getGroup().equals(this.getGroup())){
                        if ( !(
                                this.getNumHouses() == temp.getNumHouses() ||
                                this.getNumHouses() == temp.getNumHouses() + 1 ||
                                this.getNumHouses() == temp.getNumHouses() - 1 
                              ) ){
                            answer = false;
                        }
                    }
                }
            }
        }
        return answer;
    }
    
    public boolean checkOwnerGroupColor(){
        if (this.getOwner() != null ) {
            //se chequean todas las casillas
            for(Board board :Core.boardList){
                //si la casilla es de clase BoardProperty
                if(board.getClass().equals(this.getClass())){
                    BoardProperty temp = (BoardProperty) board;
                    //se chequea si es del mismo grupo color y el dueño es distinto
                    if(temp.getGroup().equals(this.getGroup()) &&  !temp.getOwner().equals(this.getOwner()) ){
                        //se retorna falso
                        return false;
                    }
                }
            }
            //si pasa por todas las propiedades del mismo grupo color y no hay dueños distintos retorna true
            return true;
        }
        else{
            //si no tiene dueño return false
            return false;
        }        
    }

    @Override
    public void rent(Player player) {
        int amount =  getRentSimple();
        
        if(checkOwnerGroupColor()){
            if (getNumHouses() == 0){
                amount *= 2;
            }
            else if(getNumHouses() == 1){
                amount = getRentH1();
            }
            else if(getNumHouses() == 2){
                amount = getRentH2();
            }
            else if(getNumHouses() == 3){
                amount = getRentH3();
            }
            else if(getNumHouses() == 4){
                amount = getRentH4();
            }
            else if(getNumHouses() == 5){
                amount = getRentHotel();
            }
        }
        
        if (isMortaged()){
            amount = 0;
        }
        
        if(amount > 0){
            Core.msgAllPlayers(player.getUser().getName()+" ha pagado a "+this.getOwner().getUser().getName()+ "la renta de "+ amount + " por visitar "+ this.getName());
        }
        
        if(player.getBalance() > amount){
            player.setBalance(player.getBalance() - amount);
            getOwner().setBalance(getOwner().getBalance() + amount);
        }else{
            Core.playerBankruptcy(player);
        }
    }

    @Override
    public void execute(Player player) {
        if (this.getOwner() == null) {                       
            if( player.getBalance() > getPrice() ){
                buy(player);
                Core.msgAllPlayers(player.getUser().getName()+" ha comprado "+this.getName()+ " por "+ this.getPrice());
            }
            else{
                Core.playerBankruptcy(player);
            }
        }
        else{
            rent(player);
        }
    }
    
}
