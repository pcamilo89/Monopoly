/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test;

import model.Utils;

/**
 *
 * @author Camilo
 */
public class TestLanzamientoDados {
    public static void main(String args[]){
        int result[];
        int countDobles = 0;
        for(int i = 0; i < 500 ; i++){
            result = Utils.lanzarDados();
            if(result[0] == result [1]){
                countDobles++;
            }else{
                countDobles = 0;
            }
            
            if(countDobles > 2)
                System.out.println(i+":"+result[0]+":"+result[1]+":"+countDobles);
        }
        
    }
}
