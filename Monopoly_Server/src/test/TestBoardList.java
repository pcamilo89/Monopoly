/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test;

import model.Board;
import model.Core;

/**
 *
 * @author Camilo
 */
public class TestBoardList {
    public static void main(String args[]){
        Core.initCore();
        for (Board board : Core.boardList){
            System.out.println(board);
        }
        System.out.println("Tamaño: " + Core.boardList.size());
    }
}
