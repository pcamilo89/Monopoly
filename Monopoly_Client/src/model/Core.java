/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.util.ArrayList;
import javax.swing.JFrame;

/**
 *
 * @author Camilo
 */
public class Core {
    public static JFrame frameActual;
    
    public static Client client;
    
    public static ArrayList<Player> listaJugadores;
    public static ArrayList<Board> listaBoard;
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
        listaBoard = new ArrayList<>();
        FillBoard();
    }
    
    public static void FillBoard(){
        listaBoard.add(new Board("Go"));
        listaBoard.add(new Board("Avenida Mediterráneo"));
        listaBoard.add(new Board("Arca Comunal"));
        listaBoard.add(new Board("Avenida Báltica"));
        listaBoard.add(new Board("Impuesto"));
        listaBoard.add(new Board("Ferrocarril Reading"));
        listaBoard.add(new Board("Avenida Oriental"));
        listaBoard.add(new Board("Casualidad"));
        listaBoard.add(new Board("Avenida Vermont"));
        listaBoard.add(new Board("Avenida Conecticut"));
        listaBoard.add(new Board("Cárcel"));
        listaBoard.add(new Board("Plaza San Carlos"));
        listaBoard.add(new Board("Compañia Electrica"));
        listaBoard.add(new Board("Avenida de los Estados"));
        listaBoard.add(new Board("Avenida Virginia"));
        listaBoard.add(new Board("Ferrocarril Pensilvania"));
        listaBoard.add(new Board("Plaza Santiago"));
        listaBoard.add(new Board("Arca Comunal"));
        listaBoard.add(new Board("Avenida Tenesse"));
        listaBoard.add(new Board("Avenida Nueva York"));
        listaBoard.add(new Board("Parada Libre"));
        listaBoard.add(new Board("Avenida Kentucky"));
        listaBoard.add(new Board("Casualidad"));
        listaBoard.add(new Board("Avenida Indiana"));
        listaBoard.add(new Board("Avenida Illinois"));
        listaBoard.add(new Board("Ferrocarril B & O"));
        listaBoard.add(new Board("Avenida Atlántico"));
        listaBoard.add(new Board("Avenida Ventnor"));
        listaBoard.add(new Board("Obras de Agua Potable"));
        listaBoard.add(new Board("Jardines Marvin"));
        listaBoard.add(new Board("Ir a Carcel"));
        listaBoard.add(new Board("Avenida Pacífico"));
        listaBoard.add(new Board("Avenida Carolina del Norte"));
        listaBoard.add(new Board("Arca Comunal"));
        listaBoard.add(new Board("Avenida Pensilvania"));
        listaBoard.add(new Board("Ferrocarril Short Line"));//acomodar el nombre del ferrocarril
        listaBoard.add(new Board("Casualidad"));
        listaBoard.add(new Board("Plaza del Parque"));
        listaBoard.add(new Board("Impuesto de Alujo"));
        listaBoard.add(new Board("Paseo Tablado"));
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
    
    public static String getCasilla(){
        return ("Casilla actual: "+listaBoard.get(Core.jugadorLocal.getPosition()).getName());
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
    
    public static Player getPlayer(String username){
        for(Player act : listaJugadores){
            if(act.getUsername().equals(username)){
                return act;
            }
        }
        return null;
    }
}
