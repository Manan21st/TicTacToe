package org.projects_nj.models;


import java.util.ArrayList;
import java.util.List;

public class Board {
    private int size;
    private List<List<Cell>> board;

    public Board(int n){
        this.size=n;
        board = new ArrayList<>();
        for(int i =0;i<n;i++){
            List<Cell> row = new ArrayList<>();
            board.add(row);
            for(int j=0;j<n;j++){
                board.get(i).add(new Cell(i,j));
            }
        }
    }
}
