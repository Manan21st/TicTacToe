package org.projects_nj.models;


import java.util.List;

public class Bot extends Player{
    private BotDifficulty botDifficulty;

    public Bot(String name, Symbol symbol, BotDifficulty botDifficulty){
        super(name, symbol, PlayerType.Bot);
        this.botDifficulty = botDifficulty;
    }

    public BotDifficulty getBotDifficulty() {
        return botDifficulty;
    }

    public void setBotDifficulty(BotDifficulty botDifficulty) {
        this.botDifficulty = botDifficulty;
    }

    public Move makeMove(Board board){
        for(List<Cell> row : board.getBoard()){
            for(Cell cell: row){
                if(cell.getState().equals(CellState.EMPTY)){
                    return new Move(cell, this);
                }
            }
        }
        return null;
    }
}
