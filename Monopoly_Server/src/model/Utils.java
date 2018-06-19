/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.util.Random;

/**
 *
 * @author Camilo
 */
public class Utils {
    public static final String SERVER_STARTUP_MSG = "Server Started.";
    public static final String SERVER_STOPPED_MSG = "Server Stopped.";
    
    public static final String SERVER_CONECTION_SUCCESS_MSG = "Conection to Server successful.";
    
    public static int SERVER_PORT = 6565;
    
    public static final String SERVER_USER_PATH = "user.json";
    
    public static final String ERR_USER_LOGED_IN = "User already loged in.";
    public static final String ERR_USER_BAD_LOGIN_INFO = "Wrong username or password.";
    
    public static final String SERVER_GAME_NOT_ENOUGH = "No hay usuarios suficientes para iniciar partida";
    public static final String SERVER_GAME_ENOUGH = "Hay usuarios suficientes, iniciando partida.";
    
    public static final int GAME_INITIAL_MONEY = 1500;
    
    /**
     * Metodo que retorna un numero pseudo random desde cero hasta tope -1, es decir sin incluir el valor tope.
     * @param tope
     * @return 
     */
    public static int getRandomint(int tope){
        Random randomGenerator = new Random();
        int index = randomGenerator.nextInt(tope);
        
        return index;
    }
    
    public static int[] lanzarDados(){
        int result[] = new int[2];
        
        result[0] = 1 + Utils.getRandomint(6);
        result[1] = 1 + Utils.getRandomint(6);
        return result;
    }
}
