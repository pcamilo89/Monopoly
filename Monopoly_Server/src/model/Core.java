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
    public static Server server;
    public static UserList userList;
    
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
    
}
