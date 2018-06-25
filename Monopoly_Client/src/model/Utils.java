/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import javax.swing.JFrame;
import view.MyDialog;

/**
 *
 * @author Camilo
 */
public class Utils {
    public static final String CLIENT_ERROR_PORT = "Port Error.";
    
    public static final String CLIENT_STARTUP_MSG = "Client Started.";
    
    public static final String CLIENT_STOPING_INSTREAM_MSG = "Ended Input Thread.";
    public static final String CLIENT_STOPING_OUTSTREAM_MSG = "Ended Output Thread.";
    public static final String CLIENT_STOPING_MSG = "Client Stopped.";
    public static final String CLIENT_DISCONNECT_MSG = "Client Disconnected.";
    
    public static final String CLIENT_LOGIN_SUCCESS = "Login Successful.";
    public static final String CLIENT_LOGIN_FAILURE = "Login Failure.";
    
    public static final long SLEEP_TIME = 100;
    
    public static String CLIENT_SERVER_IP = "192.168.1.4";
    public static int CLIENT_SERVER_PORT = 6565;
    
    public static void textDialog(String text, JFrame father){
        MyDialog dialog = new MyDialog(father, "TITULO", text, false);
        dialog.setVisible(true);
    }
}
