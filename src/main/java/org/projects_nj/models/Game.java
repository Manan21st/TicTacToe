package org.projects_nj.models;


import java.util.ArrayList;
import java.util.List;

public class Game {
    private Board board;
    private List<Player> players;
    private int nextPlayerMoveIndex;
    private Player Winner;
    private List<Move> moves;
    private GameState gameState;

    public Game(int size, List<Player> players){
        this.board = new Board(size);
        this.players = players;
        this.nextPlayerMoveIndex = 0;
        this.Winner = null;
        this.moves = new ArrayList<>();
        this.gameState = GameState.IN_PROGRESS;
    }
}
