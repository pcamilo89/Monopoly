package model;

import controller.ChatPanelController;
import controller.ClientViewController;
import controller.TableroViewController;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.util.Scanner;
import view.TableroView;

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
                    //Hilo adicional para gestionar cierre del cliente por desconeccion del servidor.
                    new Thread(() -> {
                        Core.client.sendMsg("exit");
                        Core.stopClient();
                        ClientViewController.connectSetup();
                    }).start();
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
                if(Core.jugadorLocal != null){

                    //recepcion de mensajes chat
                    if ( valuesArray[0].equals("chat") ) {
                        chatMsg(valuesArray[1], valuesArray[2]);
                    }
                    //instrucciones para la partida
                    else if ( valuesArray[0].equals("startgame")){
                        //se inicia la partida con esta instruccion
                        startGame(valuesArray);
                    }                    
                    else if ( valuesArray[0].equals("lanzardado")){
                        resultDado(Integer.parseInt(valuesArray[1]),Integer.parseInt(valuesArray[2]));//Recibo el lanzamiento del dado para mostrarlo a la vista solamente
                    }

                }

            }
        }
    }
    
    public void resultDado(int dado1,int dado2){
        int sum = dado1 + dado2;
        TableroViewController.ResultDado(dado1,dado2);
        //temporal - esto se movera a actualizar tablero que sera siempre que se recibe algo durante la partida
        TableroViewController.MoveChess(sum,1);//"1" es el jugador que en este momento está cableado con el jugador 1
    }
    
    public void startGame(String values[]){
        Core.initPartida();
        //se cargan los jugadores en Core
        for(String act: values){
            if( !act.equals("null")  && !act.equals("startgame" )){
                if( act.equals( Core.jugadorLocal.getUsername() ) ){
                    Core.listaJugadores.add( Core.jugadorLocal );
                }
                else {
                    Core.listaJugadores.add( new Player(act) );
                }
            }
        }
        
        System.out.println("Partida Iniciada:"+Core.listaJugadores.size());
        
        ClientViewController.closeWindow();
        
        TableroView tablero = new TableroView();
        tablero.setVisible(true);
    }
    
    public void connect(String values[]){
        if(values[1].equals("true")){
            ClientViewController.disconnectSetup();
        }
    }
    
    public void login(String values[]){
        if ( values[1].equals("true") ){
            receivedMsg(Utils.CLIENT_LOGIN_SUCCESS);
            Core.jugadorLocal = new Player(values[2], values[3], values[4]);
            System.out.println(Core.jugadorLocal);
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
