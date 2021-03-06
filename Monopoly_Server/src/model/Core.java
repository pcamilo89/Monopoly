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
import model.Utils.GroupColor;

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
        
        //llenar lista tablero
        fillBoard();
        //llenar listas de cartas
        fillChanceCardList();
        fillCommunityCardList();
    }
    
    public static void fillBoard(){
        boardList.add(new BoardPlain("GO") );
        boardList.add(new BoardProperty(GroupColor.DARK_PURPLE, 50, 2, 10, 30, 90, 160, 250, "Av. Mediterraneo", 60, 30));
        boardList.add(new BoardGrabCard(CardType.COMMUNITY));
        boardList.add(new BoardProperty(GroupColor.DARK_PURPLE, 50, 4, 20, 60, 180, 320, 450, "Av. Baltica", 60, 30));
        boardList.add(new BoardRemoveAmount("Impuesto", 200));
        boardList.add(new BoardRailroad("Ferrocarril Reading", 200, 100));
        boardList.add(new BoardProperty(GroupColor.LIGHT_BLUE, 50, 6, 30, 90, 270, 400, 550, "Av. Oriental", 100, 50));
        boardList.add(new BoardGrabCard(CardType.CHANCE));
        boardList.add(new BoardProperty(GroupColor.LIGHT_BLUE, 50, 6, 30, 90, 270, 400, 550, "Av. Vermont", 100, 50));
        boardList.add(new BoardProperty(GroupColor.LIGHT_BLUE, 50, 8, 40, 100, 300, 450, 600, "Av. Connecticut", 120, 60));
        boardList.add(new BoardPlain("Carcel"));
        boardList.add(new BoardProperty(GroupColor.LIGHT_PURPLE, 100, 10, 50, 150, 450, 625, 750, "Plaza San Carlos", 140, 70));
        boardList.add(new BoardUtility("Compañia Electriciad", 150, 75));
        boardList.add(new BoardProperty(GroupColor.LIGHT_PURPLE, 100, 10, 50, 150, 450, 625, 750, "Av. de los Estadios", 140, 70));
        boardList.add(new BoardProperty(GroupColor.LIGHT_PURPLE, 100, 12, 60, 180, 500, 700, 900, "Av. Virginia", 160, 80));
        boardList.add(new BoardRailroad("Ferrocarril Pensilvania", 200, 100));
        boardList.add(new BoardProperty(GroupColor.ORANGE, 100, 14, 70, 200, 550, 750, 950, "Plaza Santiago", 180, 90));
        boardList.add(new BoardGrabCard(CardType.COMMUNITY));
        boardList.add(new BoardProperty(GroupColor.ORANGE, 100, 14, 70, 200, 550, 750, 950, "Av. Tennessee", 180, 90));
        boardList.add(new BoardProperty(GroupColor.ORANGE, 100, 16, 80, 220, 600, 800, 1000, "Av. Nueva York", 200, 100));
        boardList.add(new BoardPlain("Parada Libre"));
        boardList.add(new BoardProperty(GroupColor.RED, 150, 18, 90, 250, 700, 875, 1050, "Av. Kentuky", 220, 110));
        boardList.add(new BoardGrabCard(CardType.CHANCE));
        boardList.add(new BoardProperty(GroupColor.RED, 150, 18, 90, 250, 700, 875, 1050, "Av. Indiana", 220, 110));
        boardList.add(new BoardProperty(GroupColor.RED, 150, 20, 100, 300, 750, 925, 1100, "Av. Illinois", 240, 120));
        boardList.add(new BoardRailroad("Ferrocarril B & O", 200, 100));
        boardList.add(new BoardProperty(GroupColor.YELLOW, 150, 22, 110, 330, 800, 975, 1150, "Av. Atlantico", 260, 130));
        boardList.add(new BoardProperty(GroupColor.YELLOW, 150, 22, 110, 330, 800, 975, 1150, "Av. Ventnor", 260, 130));
        boardList.add(new BoardUtility("Obras de Agua Potable", 150, 75));
        boardList.add(new BoardProperty(GroupColor.YELLOW, 150, 24, 120, 360, 850, 1025, 1200, "Jardines Marvin", 280, 140));
        boardList.add(new BoardGoToJail("Vayase a la Carcel!"));
        boardList.add(new BoardProperty(GroupColor.GREEN, 200, 26, 130, 390, 900, 1100, 1275, "Av. Pacifico", 300, 150));
        boardList.add(new BoardProperty(GroupColor.GREEN, 200, 26, 130, 390, 900, 1100, 1275, "Av. Carolina del Norte", 300, 150));
        boardList.add(new BoardGrabCard(CardType.COMMUNITY));
        boardList.add(new BoardProperty(GroupColor.GREEN, 200, 28, 150, 450, 1000, 1200, 1400, "Av. Pensilvania", 320, 160));
        boardList.add(new BoardRailroad("Ferrocarril Short Line", 200, 100));
        boardList.add(new BoardGrabCard(CardType.CHANCE));
        boardList.add(new BoardProperty(GroupColor.DARK_BLUE, 200, 35, 175, 500, 1100, 1300, 1500, "Plaza del Parque", 350, 175));
        boardList.add(new BoardRemoveAmount("Impuesto al Lujo", 100));
        boardList.add(new BoardProperty(GroupColor.DARK_BLUE, 200, 50, 200, 600, 1400, 1700, 2000, "Paseo Tablado", 400, 200));
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
        
        Core.msgServerAllPlayers(msg);
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
            
            msgServerAllPlayers(msg);
        }
    }
    
    public static void sendPlayerInfo(Player player){        
            String msg = "updateuser;"+player.getUser().getUsername()+";"+player.getUser().getName()+";"+player.getUser().getLastname();
            msg += ";"+player.getPosition()+";"+player.getBalance()+";"+player.isInJail();
            
            msgServerAllPlayers(msg);
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
        if(Core.playerList.size()>1){
            String username = playerList.get(turn).getUser().getUsername();
            playerActual = username;
            msgServerAllPlayers("actualturn;"+username);
            Player player = getPlayerByUsername(username);
            player.setContJail(player.getContJail()+1);            
        }else{
            juegoEnCurso = false;
            String username = playerList.get(turn).getUser().getUsername();
            playerActual = username;
            String msg = "VICTORIA, "+ playerActual +  " eres el ultimo en la partida.";
            alertAllPlayers(msg);
        }            
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
        System.out.println("turn:"+turn+" cant:"+cant);
    }
    
    /**
     * metodo que se llama al recibir instruccion de lanzar dados
     */
    public static void lanzarDados(){
        Player act = getPlayerByUsername(playerActual);
        
        Core.dados = Utils.lanzarDados();
        Core.msgServerAllPlayers("lanzardado;"+Core.dados[0]+";"+Core.dados[1]);
        
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
                //se ejecuta accion del tablero
                Core.boardList.get(act.getPosition()).execute(act);
                
                sendPlayerInfo(act);
                //enviar mensaje de turno al mismo jugador
                sendPlayerInTurn();
            }
            //dados iguales y cuenta igual a 3
            else if(dados[0]==dados[1] && act.getContJail() == 3){
                act.setInJail(true);
                act.setContJail(0);
                act.setPosition(10);                
                
                alertAllPlayers(playerActual+ " ha sacado 3 dobles seguidos, por penalizacion va a la Carcel.");
                playerHasCardOutOfJail(act);
                
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
                
                //se ejecuta accion del tablero
                Core.boardList.get(act.getPosition()).execute(act);
                
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
                
                //se ejecuta accion del tablero
                Core.boardList.get(act.getPosition()).execute(act);
                
                sendPlayerInfo(act);

                alertAllPlayers(playerActual+ " ha sacado dobles, puede salir de la carcel.");
                //enviar mensaje de turno al siguiente jugador
                nextPlayerTurn();
                sendPlayerInTurn();
            }
            else if(dados[0]!=dados[1] && act.getContJail() < 3){
                //enviar mensaje de turno al siguiente jugador
                
                alertAllPlayers(playerActual+ " no ha sacado dobles, se queda en la Carcel.");
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
                    alertAllPlayers(playerActual+ " al tercer turno, ha pagado "+fine+" para salir de la Carcel.");
                    act.setBalance(act.getBalance() - fine);
                }
                else{
                    Core.playerBankruptcy(act);
                }
                
                act.setPosition(pos);
                
                //se ejecuta accion del tablero
                Core.boardList.get(act.getPosition()).execute(act);
                
                sendPlayerInfo(act);                
                
                //enviar mensaje de turno al siguiente jugador
                nextPlayerTurn();
                sendPlayerInTurn();
            }
        }
    }
    
    /**
     * se utiliza para mandar protocolo a todos los jugadores
     * @param msg 
     */
    public static void msgServerAllPlayers(String msg){
        for(Player act : Core.playerList){
            msgPlayer(act.getUser().getUsername(), msg);
        }
    }
    
    public static void msgAllPlayers(String msg){
        for(Player act : Core.playerList){
            msgPlayer(act.getUser().getUsername(), "msg;"+msg);
        }
    }
    
    public static void alertAllPlayers(String msg){
        for(Player act : Core.playerList){
            alertPlayer(act.getUser().getUsername(), msg);
        }
    }
    
    public static void msgPlayer(String username, String msg){
        Core.server.getConnByUsername(username).sendMsg(msg);
    }
    
    public static void alertPlayer(String username, String msg){
        Core.server.getConnByUsername(username).sendMsg("alert;"+msg);
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
        
        Core.alertAllPlayers( playerActual + " ha caido en bancarrota.");
        //se elimina de la lista de jugadores
        Core.playerList.remove(player);
        player.setBalance(0);
        
        //se envia a todos los clientes el player con balance 0;
        Core.sendPlayerInfo(player);
        
        //se le retiran todas las propiedades
        for(Board board :Core.boardList){
            //si la casilla es de clase BoardProperty
            if(board.getClass().getSuperclass().equals(BoardOwnable.class)){
                BoardOwnable temp = (BoardOwnable) board;
                //se chequea que el dueño sea el username recibido
                if(temp.getOwner() != null && temp.getOwner().getUser().getUsername().equals(player.getUser().getUsername())){
                    temp.setOwner(null);
                    temp.setMortaged(false);
                    
                    System.out.println("LIMPIANDO PROPIEDAD: "+temp.getName());
                    
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
        }
        turn--;
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
                if( temp.getOwner() != null && temp.getOwner().getUser().getUsername().equals(username) ){
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
    
    public static void fillChanceCardList()
    {
        chanceList.add(new CardJumpTo(CardType.CHANCE, 0, "Avanza a GO. Colecta 200"));
        chanceList.add(new CardJumpTo(CardType.CHANCE,24,"Avanza a Av. Illinoise. Si pasas por GO colectas $200"));
        chanceList.add(new CardJumpTo(CardType.CHANCE,11,"Avanza a Plaza San Carlos. Si pasas por GO colectas $200"));
        chanceList.add(new CardNearest(CardType.CHANCE, 0, "Ve a la Utilidad mas cercana. Si no esta comprada, se la puede comprar al banco. Si esta comprada, arroje los dados y paguese al propietario 10 veces el numero obtenido"));
        chanceList.add(new CardNearest(CardType.CHANCE, 1, "Ve al Ferrocarril mas cercano. Si esta comprada, paguese al propietario el doble de la renta que tenga. Si no esta comprada, se la puede comprar al banco"));
        chanceList.add(new CardAddAmount(CardType.CHANCE,50,"El banco te paga $50"));
        chanceList.add(new CardOutOfJail(CardType.CHANCE, 0, "Sal de la carcel gratis"));
        chanceList.add(new CardMoveBack(CardType.CHANCE,3,"Retrocede 3 pasos"));
        chanceList.add(new CardGoToJail(CardType.CHANCE, 0, "Ve directamente a la carcel. No pasas por GO. No colectas $200"));
        chanceList.add(new CardTax(25,100,CardType.CHANCE, 0, "Haz reparaciones generales a tus propiedades, $25 por casa, $100 por hotel"));
        chanceList.add(new CardRemoveAmount(CardType.CHANCE, 15, "Paga tus impuestos, $15"));
        chanceList.add(new CardJumpTo(CardType.CHANCE,5, "Ve a Ferrocarril Reading. Si pasas por GO colectas $200"));
        chanceList.add(new CardJumpTo(CardType.CHANCE,39, "Ve a caminar al Paseo Tablado. Si pasas por GO colectas $200"));
        chanceList.add(new CardAmountToPlayers(CardType.CHANCE, 50, "Has sido elegido Presidente de la partida. Paga a cada jugador $50"));
        chanceList.add(new CardAddAmount(CardType.CHANCE, 150, "Tus edificios y prestamos han madurado. Colecta $150"));
        chanceList.add(new CardAddAmount(CardType.CHANCE, 100, "Has ganado una competencia de crucigramas, Colecta $100"));        
    }
    
    public static void fillCommunityCardList()
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
        communityList.add(new CardTax(40,115,CardType.COMMUNITY, 0, "Haz sido juzgado para reparaciones de calle, $40 por casa, $115 por hotel"));
        communityList.add(new CardAddAmount(CardType.COMMUNITY, 10, "Haz quedado en segundo lugar en un concurso de belleza. Colecta $10"));
        communityList.add(new CardAddAmount(CardType.COMMUNITY, 100, "Haz heredado $100"));
    }
    
    public static void playerHasCardOutOfJail(Player player){
        //se chequea si el jugador tiene carta de salir de la carcel y se le retira y se coloca como visitante de carcel
        if( player.getCardList().size() > 0){
            Card card = player.getCardList().get(0);
            if(card != null){
                player.getCardList().remove(card);
            
                if(card.getType() == Utils.CardType.COMMUNITY){
                    Core.communityList.add(card);
                }
                else if(card.getType() == Utils.CardType.CHANCE){
                    Core.chanceList.add(card);
                }

                player.setInJail(false);
                Core.alertAllPlayers(player.getUser().getUsername()+ " ha utilizado carta de salid de la carcel.");
            }
            
        }
    }
}
