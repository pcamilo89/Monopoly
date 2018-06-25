/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import controller.ServerViewController;
import java.util.ArrayList;
import java.util.Random;
import model.Utils.CardType;

/**
 *
 * @author Camilo
 */
public class Core {
    public static Server server;
    public static UserList userList;
    
    //listas necesarias para la logica de juego
    public static ArrayList<Card> chanceList;
    public static ArrayList<Card> communityList;
    public static ArrayList<Board> boardList;
    public static ArrayList<Player> playerList;
    
    //variable para saber si el juego esta en curso
    public static boolean juegoEnCurso = false;
    
    //username del jugador actual
    public static String playerActual =  null;
    
    //variable para saber el indice del jugador en turno
    public static int turn = 0;
    
    //variable para guardar valor de dados recibido por jugador actual
    public static int dados[] = new int[2];
    
    //variable para el modo de partida 0=normal, 1=cardNearest, 2=boardUtility
    public static int mode = 0;
    
    //variables para el numero de casas y hoteles disponibles para compra
    public static int houses = 32;
    public static int hotels = 12;
    
    public static void initCore(){
        Core.userList = new UserList();
        Core.playerList = new ArrayList<>();
        Core.boardList =  new ArrayList<>();
        Core.chanceList = new ArrayList<>();
        Core.communityList = new ArrayList<>();
        
        //setear dados inicialmente en cero;
        dados[0]=0;
        dados[1]=0;
        //falta llenar listas de cartas y la listatablero
        chanceList = getCardList(CardType.CHANCE);
        communityList = getCardList(CardType.COMMUNITY);
    }
    
    public static void startServer(int port){
        //print startup msg
        
        if( server == null ){            
            server = new Server(port);
            server.start();
            
            //en caso que se quiera iniciar partidas consecutivas
            juegoEnCurso = false;
            ServerViewController.startGameButtonEnable();
        }else{
            server.Close();
            server = null;
            //ServerViewController.addServerText(Utils.SERVER_STOPPED_MSG);
        }
        
    }
    
    public static void checkStartGameConditions(){
        if(!juegoEnCurso){
            if(server.countAuthUsers() >= 2 && server.countAuthUsers() <= 4){
                //si hay entre 2 y 4 jugadores logueados
                gameStart();
            }
            else if(server.countAuthUsers() > 4){
                //si hay mas de 4 usuarios logueados
                //se deberia desconectar el exceso
                server.disconectNonAuth();
                server.disconectExcess();
                //y volver a llamar a startgame
                checkStartGameConditions();
            }
            else{
                //si hay menos de dos usuarios logueados
                ServerViewController.addServerText(Utils.SERVER_GAME_NOT_ENOUGH);
            }
        }
    }
    
    public static void gameStart(){
        ServerViewController.addServerText(Utils.SERVER_GAME_ENOUGH);

        initPlayers();
        printPlayers();

        //se desconectan los usuarios que no iniciaron sesion.
        server.disconectNonAuth();

        //desabilitar el boton de iniciar partida
        ServerViewController.startGameButtonDisable();
        //enviar mensaje a clientes en lista jugador para habilitar interfaz de juego
        int cant = Core.playerList.size();

        String msg = "startgame";

        //se envian los username para listas locales
        for(Player act : Core.playerList){
            msg += ";"+act.getUser().getUsername();
        }

        //si no son 4 se envian null por jugadores faltantes
        if (cant < 4 ){
            cant = 4 - cant;
            for(int i=0;i<cant;i++){
                msg += ";null";
            }
        }
        
        Core.msgAllPlayers(msg);
        //se envia informacion de todos los jugadores
        sendPlayerInfo();
        //se envia jugador actual
        sendPlayerInTurn();
        juegoEnCurso = true;
    }
    
    public static void sendPlayerInfo(){
        
        for(Player act : Core.playerList){
            String msg = "updateuser;"+act.getUser().getUsername()+";"+act.getUser().getName()+";"+act.getUser().getLastname();
            msg += ";"+act.getPosition()+";"+act.getBalance()+";"+act.isInJail();
            
            msgAllPlayers(msg);
        }
    }
    
    public static void sendPlayerInfo(Player act){        
            String msg = "updateuser;"+act.getUser().getUsername()+";"+act.getUser().getName()+";"+act.getUser().getLastname();
            msg += ";"+act.getPosition()+";"+act.getBalance()+";"+act.isInJail();
            
            msgAllPlayers(msg);
    }
    
    public static Player getPlayerByUsername(String username){
        for(Player player: playerList){
            if ( player.getUser().getUsername().equals(username)) {
                return player;
            }
        }
        return null;
    }
    
    /**
     * 
     */
    public static void sendPlayerInTurn(){
        String username = playerList.get(turn).getUser().getUsername();
        playerActual = username;
        msgAllPlayers("actualturn;"+username);
        Player player = getPlayerByUsername(username);
        player.setContJail(player.getContJail()+1);
    }    
    
    public static Player getJugadorActual(){
        return getPlayerByUsername(playerActual);
    }

    public static void nextPlayerTurn(){
        turn++;
        int cant = Core.playerList.size()-1;
        if (turn > cant){
            turn = 0;
        }
    }
    
    /**
     * metodo que se llama al recibir instruccion de lanzar dados
     */
    public static void lanzarDados(){
        Player act = getPlayerByUsername(playerActual);
        
        Core.dados = Utils.lanzarDados();
        Core.msgAllPlayers("lanzardado;"+Core.dados[0]+";"+Core.dados[1]);
        
        boolean passGo = false;
        
        //se saca la suma de los dados
        int sum = dados[0]+dados[1];
        
        int pos = act.getPosition()+sum;
        //si el numero es mayor a 39 se devuelve el conteo
        //suma 200 por pasar por go con boolean passGo
        if(pos > 39){
            passGo = true;
            pos -= 40;
        }
        
        //si no esta en la carcel
        if(!act.isInJail()){
            //dados iguales y cuenta de dobles menor a 3
            if (dados[0]==dados[1] && act.getContJail() < 3){
                //notificar a todos posicion nueva
                if(passGo){
                    act.setBalance(act.getBalance() + 200);
                }
                act.setPosition(pos);
                sendPlayerInfo(act);
                //enviar mensaje de turno al mismo jugador
                sendPlayerInTurn();
            }
            //dados iguales y cuenta igual a 3
            else if(dados[0]==dados[1] && act.getContJail() == 3){
                act.setInJail(true);
                act.setContJail(0);
                act.setPosition(10);
                
                sendPlayerInfo(act);
                nextPlayerTurn();
                sendPlayerInTurn();
            }
            //si se saca cualquier otro valor de dados
            else{
                //notificar a todos posicion nueva
                if(passGo){
                    act.setBalance(act.getBalance() + 200);
                }
                act.setPosition(pos);
                sendPlayerInfo(act);
                //resetear contador de dobles
                act.setContJail(0);
                //enviar mensaje de turno al siguiente jugador
                nextPlayerTurn();
                sendPlayerInTurn();
            }
        }
        //si esta en la carcel
        else{
            //si lanza iguales y el contador no llega a 3
            if(dados[0]==dados[1] && act.getContJail() < 3){
                //sacar de estado carcel
                act.setInJail(false);
                act.setContJail(0);

                act.setPosition(pos);
                sendPlayerInfo(act);

                //enviar mensaje de turno al siguiente jugador
                nextPlayerTurn();
                sendPlayerInTurn();
            }
            else if(dados[0]!=dados[1] && act.getContJail() < 3){
                //enviar mensaje de turno al siguiente jugador
                nextPlayerTurn();
                sendPlayerInTurn();
            }
            else if(dados[0]!=dados[1] && act.getContJail() == 3){
                //sacar de estado carcel
                act.setInJail(false);
                act.setContJail(0);                
                
                //multa del tercer turno
                int fine = 50;
                
                if ( act.getBalance() > fine ) {
                    act.setBalance(act.getBalance() - fine);
                }
                else{
                    Core.playerBankruptcy(act);
                }
                
                act.setPosition(pos);
                sendPlayerInfo(act);                
                
                //enviar mensaje de turno al siguiente jugador
                nextPlayerTurn();
                sendPlayerInTurn();
            }
        }
    }
    
    public static void initPlayers(){
        playerList.clear();
        for (Connection conn : server.list) {
            if (conn.getUser() != null){
                playerList.add(new Player(conn.getUser(), Utils.GAME_INITIAL_MONEY));
            }
        }
    }
    
    public static void printPlayers(){
        for(Player act : playerList){
            System.out.println(act.toString());
        }
    }
    
    public static void msgAllPlayers(String msg){
        for(Player act : playerList){
            String username = act.getUser().getUsername();
            
            Connection conn = server.getConnByUsername(username);
            conn.sendMsg(msg);
        }
    }
    
    public static void msgPlayer(String username, String msg){
        for(Player act : playerList){
            if(act.getUser().getUsername().equals(username)) {
                Connection conn = server.getConnByUsername(username);
                conn.sendMsg(msg);
            }
            break;
        }
    }
    
    /**
     * Metodo para obtener la lista de cartas segun su tipo
     * @param type tipo de la carta segun CardType
     * @return lista de cartas
     */
    public static ArrayList getCardList(CardType type ) {
        if( type.equals(CardType.CHANCE) ){
            //retorna la lista de chance
            return chanceList;
        }
        else if( type.equals(CardType.COMMUNITY) ){
            //retorna la lista de community
            return communityList;
        }
        else {
            //caso borde retorna null
            return null;
        }        
    }
    
    /**
     * obtener carta aleatoria de lista de cartas
     * @param list lista de cartas para buscar
     * @return la carta aleatoria
     */
    public static Card getRandomCard(ArrayList<Card> list){
        Random randomGenerator = new Random();
        Card card = null;
        if (list != null) {
            if(list.size()>0){
                int index = randomGenerator.nextInt(list.size());
                card = list.get(index);
            }
        }
        
        return card;
    }
    
    public static void playerBankruptcy(Player player){
        //se elimina de la lista de jugadores
        Core.playerList.remove(player);
        player.setBalance(0);
        
        //se le retiran todas las propiedades
        for(Board board :Core.boardList){
            //si la casilla es de clase BoardProperty
            if(board.getClass().equals(BoardOwnable.class)){
                BoardOwnable temp = (BoardOwnable) board;
                //se chequea que el dueño sea el username recibido
                temp.setOwner(null);
                temp.setMortaged(false);
                
                if ( temp.getClass().equals(BoardProperty.class) ){
                    BoardProperty tempPro = (BoardProperty) temp;
                    //si es tipo property se le retiran las casas y hoteles
                    
                    if(tempPro.getNumHouses() < 5){
                        Core.houses += tempPro.getNumHouses();
                        tempPro.setNumHouses(0);
                    }else if(tempPro.getNumHouses() == 5){
                        Core.hotels += 1;
                        tempPro.setNumHouses(0);
                    }                  
                }
                
            }
        }
        
        //se envia a todos los clientes el player con balance 0;
        Core.sendPlayerInfo(player);
    }
    
    public static int[] countPlayerHousesAndHotels(String username){
        //retorna array con 0=casas, 1=hoteles por defecto retornar 0 si no encuentra
        int data[] = new int[2];
        int contHouse = 0;
        int contHotel = 0;
        
        for(Board board :Core.boardList){
            //si la casilla es de clase BoardProperty
            if(board.getClass().equals(BoardProperty.class)){
                BoardProperty temp = (BoardProperty) board;
                //se chequea que el dueño sea el username recibido
                if(temp.getOwner().equals(username)){
                    //si la cuenta es 5 es un hotel
                    if(temp.getNumHouses() > 4 ){
                        contHotel++;
                    }
                    else{
                        //si es menor a cinco sumar la cuenta de casas
                        contHouse += temp.getNumHouses();
                    }
                   
                }
            }
        }
        
        data[0] = contHouse;
        data[1] = contHotel;
        return data;
    }
    
    public static void fillChanceCardList(ArrayList<Card> list)
    {
        chanceList.add(new CardGoToJail(CardType.CHANCE, 0, "Ve directamente a la carcel. No pasas por GO. No colectas $200"));
        chanceList.add(new CardJumpTo(CardType.CHANCE,0,"Avanza a Illinois Ave. Si pasas por GO colectas $200"));
        chanceList.add(new CardJumpTo(CardType.CHANCE,0,"Avanza a St Charles Place. Si pasas por GO colectas $200"));
        chanceList.add(new CardMoveBack(CardType.CHANCE,0,"Retrocede 3 pasos"));
        chanceList.add(new CardJumpTo(CardType.CHANCE,0,"Ve a GO. Colecta $200"));
        chanceList.add(new CardNearest(CardType.CHANCE, 0, "Ve a la utilidad mas cercana. Si no esta comprada, se la puede comprar al banco. Si esta comprada, arroje los dados y paguese al propietario 10 veces el numero obtenido"));
        chanceList.add(new CardNearest(CardType.CHANCE, 1, "Ve al Railroad mas cercano. Si esta comprada, paguese al propietario el doble de la renta que tenga. Si no esta comprada, se la puede comprar al banco"));
        chanceList.add(new CardAddAmount(CardType.CHANCE,50,"El banco te paga $50"));
        chanceList.add(new CardAddAmount(CardType.CHANCE, 150, "Tus edificios y prestamos han madurado. Colecta $150"));
        chanceList.add(new CardAddAmount(CardType.CHANCE, 100, "Has ganado una competencia de crucigramas, Colecta $100"));
        chanceList.add(new CardOutOfJail(CardType.CHANCE, 0, "Sal de la carcel gratis"));
        chanceList.add(new CardRemoveAmount(CardType.CHANCE, 15, "Paga tus impuestos, $15"));
        chanceList.add(new CardAmountToPlayers(CardType.CHANCE, 50, "Has sido elegido Chairman de la partida. Paga a cada jugador $50"));
        System.out.println("chanceList: "+new String(chanceList.toString()));
    }
    
    public static void fillCommunityCardList(ArrayList<Card> list)
    {
        communityList.add(new CardJumpTo(CardType.COMMUNITY,0, "Ve a GO. Colecta $200"));
        communityList.add(new CardAddAmount(CardType.COMMUNITY,200,"Error del banco a tu favor. Colecta $200"));
        communityList.add(new CardRemoveAmount(CardType.COMMUNITY, 50, "Factura medica. Paga $50"));
        communityList.add(new CardAddAmount(CardType.COMMUNITY, 50, "De las vetas de tus acciones obtienes $50"));
        communityList.add(new CardOutOfJail(CardType.COMMUNITY, 0, "Sales de la carcel gratis"));
        communityList.add(new CardGoToJail(CardType.COMMUNITY, 0, "Ve directamente a la carcel. No pasas por GO. No colectas $200"));
        communityList.add(new CardAmountFromPlayers(CardType.COMMUNITY, 50, "Gran noche de Opera. Colecta $50 decada jugador por asientos en noche de apertura"));
        communityList.add(new CardAddAmount(CardType.COMMUNITY, 100, "Ha madurado tu fondo de vacaciones. Colecta $100"));
        communityList.add(new CardAddAmount(CardType.COMMUNITY, 20, "Reembolso de impuestos. Colecta 20"));
        communityList.add(new CardAddAmount(CardType.COMMUNITY, 100, "Ha madurado tu seguro de vida. Colecta $100"));
        communityList.add(new CardRemoveAmount(CardType.COMMUNITY, 100, "Paga $100 en la factura del hospital"));
        communityList.add(new CardRemoveAmount(CardType.COMMUNITY, 150, "Paga $150 en la factura del colegio"));
        communityList.add(new CardAddAmount(CardType.COMMUNITY, 25, "Recibe $25 por trabajos de consultor"));
        communityList.add(new CardTax(40,150,CardType.COMMUNITY, 0, "Haz sido juzgado para reparaciones de calle, $40 por casa, $115 por hotel"));
        communityList.add(new CardAddAmount(CardType.COMMUNITY, 10, "Haz quedado en segundo lugar en un concurso de belleza. Colecta $10"));
        communityList.add(new CardAddAmount(CardType.COMMUNITY, 100, "Haz heredado $100"));
        System.out.println("communityList: "+new String(communityList.toString()));
    }
}
