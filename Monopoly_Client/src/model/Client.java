package model;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Client extends Thread{
    private Socket conectionSocket = null;
    private InputStream in;
    private OutputStream out;
    //private Scanner scanner;
    
    //envio de mensajes
    private PrintWriter outw;
    
    //private int localPort=5007;
    
    //hilo con mensajes entrantes
    InStream instream = null;
    
    
    public static boolean working=true;
    
    public Client(String ip,int port){
        try {
            //conectionSocket = new Socket(ip, port, null, localPort);
            conectionSocket = new Socket(ip, port);
            in = conectionSocket.getInputStream();
            out = conectionSocket.getOutputStream();
            out.flush();
            
        } catch (IOException ex) {
            //mensaje con error en puerto
            System.out.println("#"+Utils.CLIENT_ERROR_PORT);
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.outw = new PrintWriter(this.out, true);
    }
    @Override
    public void run(){
        Client.working = true;
        
        instream = new InStream(in);
        instream.start();
        
        PrintWriter outw = new PrintWriter(this.out, true);
        
        System.out.println("#"+Utils.CLIENT_STARTUP_MSG);
        System.out.println(conectionSocket.getLocalAddress()+":"+conectionSocket.getLocalPort());
        //scanner = new Scanner(System.in);
        
        
        
        while(Client.working){
            try {
                Thread.sleep(Utils.SLEEP_TIME);
            } catch (InterruptedException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void closeClient(){
        try {
            Client.working=false;
            //this.scanner.close();
            System.out.println("#"+Utils.CLIENT_STOPING_OUTSTREAM_MSG);
            
            //Espera del hilo de mensajes entrantes
            instream.join();
            
            conectionSocket.close();
            System.out.println("#"+Utils.CLIENT_STOPING_MSG);
            
        } catch (InterruptedException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void sendMsg(String text){
        this.outw.println(text);
    } 
}