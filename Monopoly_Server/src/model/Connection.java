package model;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import controller.ServerViewController;

public class Connection extends Thread{
    private Socket conectionSocket = null;
    private InputStream in;
    private OutputStream out;
    private Scanner scanner;
    private PrintWriter outw;
    
    //specific user data.
    private boolean working = true;
    private User user =  null;

    public User getUser() {
        return user;
    }

    public boolean isWorking() {
        return working;
    }

    public void setWorking(boolean working) {
        this.working = working;
    }
        
    public Connection(Socket incoming){        
        try {
            conectionSocket = incoming;
            
            this.in = this.conectionSocket.getInputStream();
            this.out = this.conectionSocket.getOutputStream();
            
            this.scanner = new Scanner(new BufferedInputStream(this.in), "UTF-8");
            this.outw = new PrintWriter(this.out, true);
            
        } catch (IOException e) {
            closeConnection();
        }
        
        
    }
    
    @Override
    public void run(){
        
        String line = null;
        //print number of conected users
        ServerViewController.addServerText(Core.server.statusString());        
        
        //send success msg to client
        sendMsg("msg"+";"+Utils.SERVER_CONECTION_SUCCESS_MSG);
        sendMsg("connect;true");     
        
        while (working) {
            if(this.scanner.hasNext()){
                line = this.scanner.nextLine();
                        
                //se envia lo recibido al metodo que procesa el protocolo
                protocol(line);  
            }                      
        }
        
        //print number of conected
        ServerViewController.addServerText(Core.server.statusString());
    }
    
    public void closeConnection(){
        try {
            this.setWorking(false);
            this.scanner.close();
            this.conectionSocket.close();
            this.conectionSocket = null;
            Core.server.removeConnection(this);
            
        } catch (IOException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void sendMsg(String text){
        this.outw.println(text);
    }
    
    public void protocol(String text){
        String valuesArray[] = null;
        
        if (text != null){
            System.out.println("%"+text);
            
            valuesArray = text.split(";");

            //si solo hay un valor
            if(valuesArray.length == 1){
                if (valuesArray[0].equals("exit")){

                    //metodo para desconeccion
                    this.disconect();                    
                }
                else if(valuesArray[0].equals("lanzardado")) {
                    lanzarDados();
                }
            }   
            // si hay mas de un valor en el arreglo
            else if (valuesArray.length > 1 ) {

                //metodo de validacion de login
                if( valuesArray[0].equals("login") ) {
                    this.login(valuesArray);
                }

                //si pasa el proceso de login
                if(user != null){

                    //envio de mensajes chat
                    if ( valuesArray[0].equals("chat") ) {
                        String name = user.getName()+" "+user.getLastname();
                        this.chat(name, valuesArray[1]);
                    }

                }

            }
                
            }
    }
    
    public void lanzarDados(){
        Core.lanzarDados();
    }
    
    public void login(String values[]){

        //logica de validacion de usuario aqui.
        String tempUsername = values[1];
        String tempPassword = values[2];
        
        //si el usuario ya esta conectado
        if ( Core.server.isUserConnected(tempUsername) ) {
            sendMsg("login;false;"+Utils.ERR_USER_LOGED_IN);
        }
        else {
            user = UserJson.loginUser(tempUsername, tempPassword);
            //en caso que se encuentre en archivo
            if( user != null ) {
                sendMsg("login;true;"+user.getUsername()+";"+user.getName()+";"+user.getLastname()+";");
                ServerViewController.addServerText(Core.server.statusString());
            }
            else{
                sendMsg("login;false;"+Utils.ERR_USER_BAD_LOGIN_INFO);
            }
        }            
        
    }
    
    public void disconect(){
        sendMsg("exit"+";"+"true");
        closeConnection();
    }
    
    public void chat(String username, String text){
        //send msg to all conected
        Core.server.msgAuthUsers("chat"+";"+username+";"+text );

        //print user received msg on console
        ServerViewController.addUserText(username, text);
    }
}
