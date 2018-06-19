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
public class Core {
    public static Client client;
    
    public static String username;
    
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
            username = null;
        }
    }
}
