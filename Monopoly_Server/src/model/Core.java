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
    
    public static void initCore(){
        Core.userList = new UserList();
        Core.playerList = new ArrayList<>();
        Core.boardList =  new ArrayList<>();
        
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
    
    public static void startGame(){
        if(!juegoEnCurso){
            if(server.countAuthUsers() >= 2 && server.countAuthUsers() <= 4){
                //si hay entre 2 y 4 jugadores logueados
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
                
                
                
                juegoEnCurso = true;
            }
            else if(server.countAuthUsers() > 4){
                //si hay mas de 4 usuarios logueados
                //se deberia desconectar el exceso
                server.disconectNonAuth();
                server.disconectExcess();
                //y volver a llamar a startgame
                startGame();
            }
            else{
                //si hay menos de dos usuarios logueados
                ServerViewController.addServerText(Utils.SERVER_GAME_NOT_ENOUGH);
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
}
