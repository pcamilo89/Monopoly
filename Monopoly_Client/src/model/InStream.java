package model;

import controller.ChatPanelController;
import controller.ClientViewController;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.util.Scanner;

public class InStream extends Thread{
    private InputStream in;
    private Scanner scanner;
    
    public InStream(InputStream from){
        in = from;
        scanner = new Scanner(new BufferedInputStream(this.in), "UTF-8");
    }
    
    @Override
    public void run(){
        String line = null;
        while (Client.working) {
            if(this.scanner.hasNext()){
                line = this.scanner.nextLine();
                
                this.protocol(line);
            }            
        }
        closeInStream();
    }
    
    public void closeInStream(){
        this.scanner.close();
        System.out.println("#"+Utils.CLIENT_STOPING_INSTREAM_MSG);
    }
    
    public void protocol(String line){       
        
        String valuesArray[] = null;
        
        if ( line != null ) {
            System.out.println("%"+line);
            
            valuesArray = line.split(";");
            
            if (valuesArray.length == 1){
                
                if( valuesArray[0].equals("disconnect") ){
                    //metodo para desconeccion
                    Core.client.sendMsg("disconnect;true");
                    Core.client.closeClient();
                }
                    
            }
            if (valuesArray.length > 1 ) {

                //metodo de validacion de login
                if( valuesArray[0].equals("connect") ) {
                    connect(valuesArray);
                }
                else if( valuesArray[0].equals("login") ) {
                    login(valuesArray);
                }
                else if ( valuesArray[0].equals("msg") ) {
                    receivedMsg(valuesArray[1]);
                }                
                else if ( valuesArray[0].equals("exit") ) {
                    receivedMsg(Utils.CLIENT_DISCONNECT_MSG);
                }

                //si pasa el proceso de login
                if(Core.username != null){

                    //recepcion de mensajes chat
                    if ( valuesArray[0].equals("chat") ) {
                        chatMsg(valuesArray[1], valuesArray[2]);
                    }

                }

            }
        }
    }
    
    public void connect(String values[]){
        if(values[1].equals("true")){
            ClientViewController.disconnectSetup();
        }
    }
    
    public void login(String values[]){
        if ( values[1].equals("true") ){
            receivedMsg(Utils.CLIENT_LOGIN_SUCCESS);
            ClientViewController.loginSuccess();
        }
        else {
            receivedMsg(values[2]);
        }
    }
    
    public void receivedMsg(String values){
        System.out.println("MSG:"+values);
        ClientViewController.setInfoLabel(values);
        ChatPanelController.addServerText(values);
    }
    
    public void chatMsg(String user, String text) {
        ChatPanelController.addUserText(user, text);
    }
}
