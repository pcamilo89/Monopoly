/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.util.ArrayList;

/**
 *
 * @author Camilo
 */
public class Core {
    public static Client client;
    
    public static ArrayList<Player> listaJugadores;
    
    public static Player jugadorLocal;
    public static String jugadorActual;
    
    public static void startClient(String ip,int port){
        
        if( client == null ){            
            client = new Client(ip, port);
            client.start();
        }
        
    }
    
    public static void stopClient(){
        if (client != null) {
            
            client.closeClient();
            client = null;
            jugadorLocal = null;
        }
    }
    
    public static void initPartida(){
        listaJugadores = new ArrayList<>();
    }
    
    public static void printPlayerList(){
        for (Player act: listaJugadores) {
            System.out.println(act.toString());
        }
    }
    
    public static int contarJugadores(){
        int amount = 0;
        for (Player act: listaJugadores) {
            if ( act.isActivo() ) {
                amount++;
            }
        }
        return amount;
    }
    
    public static int[] jugadoresActivos(){
        int[] result =  new int[4];
        for(int i=0;i<listaJugadores.size();i++){
            if (listaJugadores.get(i).isActivo()){
                result[i]=1;
            }
            else {
                result[i]=0;
            }            
        }
        return result;
    }
}
