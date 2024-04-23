package org.projects_nj.models;



public class Cell {
    private int row;
    private int col;
    private Player player;
    private CellState state;

    public Cell(int row, int col){
        this.row = row;
        this.col = col;
        this.state = CellState.EMPTY;
    }
}
