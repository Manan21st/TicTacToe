package org.projects_nj.strategies;

import org.projects_nj.models.Board;
import org.projects_nj.models.Move;

import java.util.HashMap;

public class WinningAlgorithm {
    HashMap<Integer, HashMap<Character,Integer>> rowMap= new HashMap<>();
    HashMap<Integer, HashMap<Character,Integer>> colMap= new HashMap<>();
    HashMap<Character,Integer> leftDiagMap= new HashMap<>();
    HashMap<Character,Integer> rightDiagMap= new HashMap<>();

    public boolean checkWinner(Board board, Move move){
        int row= move.getCell().getRow();
        int col= move.getCell().getCol();
        Character character= move.getPlayer().getSymbol().getaChar();

        if(!rowMap.containsKey(row)){
            rowMap.put(row, new HashMap<>());
        }
        HashMap<Character,Integer> currRowMap= rowMap.get(row);

        if(!currRowMap.containsKey(character)){
            currRowMap.put(character, 1);
        }else{
            currRowMap.put(character, currRowMap.get(character)+1);
        }

        if(currRowMap.get(character)==board.getSize()){
            return true;
        }

        if(!colMap.containsKey(col)){
            colMap.put(col, new HashMap<>());
        }
        HashMap<Character,Integer> currColMap= colMap.get(col);

        if(!currColMap.containsKey(character)){
            currColMap.put(character, 1);
        }else{
            currColMap.put(character, currColMap.get(character)+1);
        }

        if(currColMap.get(character)==board.getSize()){
            return true;
        }

        if(row==col){
            if(!leftDiagMap.containsKey(character)){
                leftDiagMap.put(character,1);
            }else{
                leftDiagMap.put(character, leftDiagMap.get(character)+1);
            }

            if(leftDiagMap.get(character)==board.getSize()){
                return true;
            }
        }

        if(row+col==board.getSize()-1){
            if(!rightDiagMap.containsKey(character)){
                rightDiagMap.put(character,1);
            }else{
                rightDiagMap.put(character, rightDiagMap.get(character)+1);
            }

            if(rightDiagMap.get(character)==board.getSize()){
                return true;
            }
        }

        return false;
    }

}
