/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test;

import model.Board;
import model.BoardOwnable;
import model.BoardProperty;
import model.BoardRailroad;
import model.BoardUtility;
import model.Core;

/**
 *
 * @author Camilo
 */
public class TestRemoveOwner {
    public static void main(String args[]){
        Core.initCore();
        System.out.println("Size:"+Core.boardList.size());
        
        for(Board board: Core.boardList){
//            System.out.println(board.getClass().getSuperclass().toString());
            
//            if(board.getClass().equals(BoardProperty.class) || board.getClass().equals(BoardRailroad.class) || board.getClass().equals(BoardUtility.class)){
//                System.out.println(board.getName());
//            }
            
            if(board.getClass().getSuperclass().equals(BoardOwnable.class)){
                System.out.println(board.getName());
            }

        }
        
    }
}
