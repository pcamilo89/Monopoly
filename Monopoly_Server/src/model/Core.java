/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import controller.ServerViewController;
import java.util.ArrayList;

/**
 *
 * @author Camilo
 */
public class Core {
    public static Server server;
    public static UserList userList;
    
    public static ArrayList<Jugador> playerList;
    
    public static boolean juegoEnCurso = false;
    
    public static void initCore(){
        Core.userList = new UserList();
        Core.playerList = new ArrayList<>();
    }
    
    public static void startServer(int port){
        //print startup msg
        
        if( server == null ){            
            server = new Server(port);
            server.start();
            //ServerViewController.addServerText(Utils.SERVER_STARTUP_MSG);
        }else{
            server.Close();
            server = null;
            //ServerViewController.addServerText(Utils.SERVER_STOPPED_MSG);
        }
        
    }
    
    public static void startGame(){
        if(!juegoEnCurso){
            if(server.countAuthUsers() >= 2 && server.countAuthUsers() <= 4){
                ServerViewController.addServerText(Utils.SERVER_GAME_ENOUGH);


                initPlayers();
                printPlayers();
                
                //se desconectan los usuarios que no iniciaron sesion.
                server.disconectNonAuth();

                //falta desabilitar el boton de iniciar partida
                
                //enviar mensaje a clientes en lista jugador para habilitar interfaz de juego
                
                juegoEnCurso = true;
            }
            else{
                ServerViewController.addServerText(Utils.SERVER_GAME_NOT_ENOUGH);
            }
        }
            
        
        
    }
    
    public static void initPlayers(){
        playerList.clear();
        for (Connection conn : server.list) {
            if (conn.getUser() != null){
                playerList.add(new Jugador(conn.getUser(), Utils.GAME_INITIAL_MONEY));
            }
        }
        
        
    }
    
    public static void printPlayers(){
        for(Jugador act : playerList){
            System.out.println(act.toString());
        }
    }
    
}
