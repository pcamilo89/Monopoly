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
    
    public static ArrayList<Card> chanceList;
    public static ArrayList<Card> communityList;
    
    public static ArrayList<Board> boardList;
    
    public static ArrayList<Player> playerList;
    
    public static boolean juegoEnCurso = false;
    
    public static String playerActual =  null;
    
    public static int turn = 0;
    public static int dados[] = new int[2];
    
    public static void initCore(){
        Core.userList = new UserList();
        Core.playerList = new ArrayList<>();
        Core.boardList =  new ArrayList<>();
        
        //setear dados inicialmente en cero;
        dados[0]=0;
        dados[1]=0;
        //falta llenar listas de cartas y la listatablero
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
        sendJugadorActual();
        juegoEnCurso = true;
    }
    
    public static void sendPlayerInfo(){
        
        for(Player act : Core.playerList){
            String msg = "updateuser;"+act.getUser().getUsername()+";"+act.getUser().getName()+";"+act.getUser().getLastname();
            msg += ";"+act.getPosition()+";"+act.getBalance()+";"+act.isInJail();
            
            msgAllPlayers(msg);
        }
    }
    
    public static Player getPlayerByUsername(String username){
        for(Player player: playerList){
            if ( player.getUser().getUsername().equals(username)) {
                return player;
            }
        }
        return null;
    }
    
    public static void sendJugadorActual(){
        String username = playerList.get(turn).getUser().getUsername();
        playerActual = username;
        msgAllPlayers("actualturn;"+username);
        Player player = getPlayerByUsername(username);
        player.setContJail(player.getContJail()+1);
    }    
    
    public static void newTurn(){
        Player player = getPlayerByUsername(playerActual);
        //logica de movimiento si player actual no esta en la carcel
        if (player.isInJail() == false){
            //si los dados son iguales y la cuenta de dobles es menor a 3
            if (dados[0]==dados[1] && player.getContJail() < 3){
                sendJugadorActual();
            }
            else if(dados[0]==dados[1] && player.getContJail() == 3){
                player.setInJail(true);
                player.setContJail(0);
                player.setPosition(10);            
            }
            else{
                player.setContJail(0);
                nextTurn();
            }
        }
            
    }
    
    public static void nextTurn(){
        turn++;
        int cant = Core.playerList.size()-1;
        if (turn > cant){
            turn = 0;
        }
        sendJugadorActual();
    }
    
    public static void lanzarDados(){
        Core.dados = Utils.lanzarDados();
        Core.msgAllPlayers("lanzardado;"+Core.dados[0]+";"+Core.dados[1]);
        
        //se saca la suma de los dados
        int sum = dados[0]+dados[1];
        //se busca al jugador actual
        Player act = getPlayerByUsername(playerActual);
        //se actualiza su posicion
        int pos = act.getPosition()+sum;
        //si el numero es mayor a 39 se devuelve el conteo
        //suma 200 por pasar por go
        if(pos > 39){
            act.setBalance(act.getBalance() + 200);
            pos -= 40;
        }
        
        act.setPosition(pos);
        
        //se envia a todos los clientes por msg
        String msg = "updateuser;"+act.getUser().getUsername()+";"+act.getUser().getName()+";"+act.getUser().getLastname();
        msg += ";"+act.getPosition()+";"+act.getBalance()+";"+act.isInJail();    
        msgAllPlayers(msg);
        
        //logica de posicion del tablero va aqui.
        
        //proximo turno
        newTurn();
        
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
        
    }
}
