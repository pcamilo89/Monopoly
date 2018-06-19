package model;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import controller.ServerViewController;

public class Server extends Thread{
    private ServerSocket  serverSocket = null;
    private Socket conectionSocket = null;
    public ArrayList<Connection> list = new ArrayList();
    
    private boolean working = true;
    

    public Server(int port) {
        try {
            this.serverSocket = new ServerSocket(port,10);
            this.serverSocket.setSoTimeout(5000);
            //print ip and address information
            ServerViewController.addServerText(InetAddress.getLocalHost()+":"+port);
            
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
    @Override
    public void run(){
        ServerViewController.addServerText(Utils.SERVER_STARTUP_MSG);
        
        while(working) {

            try {
                conectionSocket = serverSocket.accept();
                if (conectionSocket != null) {
                    Connection connection = new Connection(conectionSocket);
                    list.add(connection);
                    connection.start();  
                }
            } catch (IOException ex) {
                //Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                //System.out.println("timeout");
            }

        }         
        ServerViewController.addServerText(Utils.SERVER_STOPPED_MSG);
    }
    
    /**
     *
     */
    public void Close(){
        try {
            this.working = false;
            this.serverSocket.close();
            
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void removeConnection(Connection e){
        list.remove(e);
    }
    
    public void msgAll(String msg){
        for (Connection conn : this.list) {
            conn.sendMsg(msg);
        }
    }
    
    public void msgAuthUsers(String msg){
        for (Connection conn : this.list) {
            if (conn.getUser() != null){
                conn.sendMsg(msg);
            }
        }
    }
        
    public boolean isUserConnected(String username){
        for (Connection conn : this.list) {
            if (conn.getUser() != null){
                if( conn.getUser().getUsername().equals(username) ) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public int countAuthUsers(){
        int count = 0;
        for (Connection conn : this.list) {
            if (conn.getUser() != null){
                count++;
            }
        }
        return count;
    }
    
    public int countConnected(){
        return this.list.size();
    }
    
    public String statusString(){
        //shows how many connected and loged in
        return "Connected:"+countConnected()+" "+"Logged in:"+countAuthUsers();
    }
    
    public void disconectNonAuth(){
        for (Connection conn : this.list) {
            if (conn.getUser() == null){
                conn.sendMsg("disconnect");
            }
        }
    }
}
