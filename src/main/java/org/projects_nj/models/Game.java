package org.projects_nj.models;


import org.projects_nj.exceptions.InvalidMoveException;
import org.projects_nj.strategies.WinningAlgorithm;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Board board;
    private List<Player> players;
    private int nextPlayerMoveIndex;
    private Player Winner;
    private List<Move> moves;
    private GameState gameState;
    WinningAlgorithm winningAlgorithm;

    public Game(int size, List<Player> players){
        this.board = new Board(size);
        this.players = players;
        this.nextPlayerMoveIndex = 0;
        this.Winner = null;
        this.moves = new ArrayList<>();
        this.gameState = GameState.IN_PROGRESS;
        this.winningAlgorithm = new WinningAlgorithm();
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public int getNextPlayerMoveIndex() {
        return nextPlayerMoveIndex;
    }

    public void setNextPlayerMoveIndex(int nextPlayerMoveIndex) {
        this.nextPlayerMoveIndex = nextPlayerMoveIndex;
    }

    public Player getWinner() {
        return Winner;
    }

    public void setWinner(Player winner) {
        Winner = winner;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public void printBoard(){
        this.board.printBoard();
    }

    public boolean validateMove(Move move){
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();
        if(row < 0 || row >= this.board.getSize() || col < 0 || col >= this.board.getSize()){
            return false;
        }
        return board.getBoard().get(row).get(col).getState().equals(CellState.EMPTY);
    }

    public void makeMove() throws InvalidMoveException{
        Player currentPlayer = this.players.get(this.nextPlayerMoveIndex);
        System.out.println("It is " + currentPlayer.getName() + "'s turn.");

        Move move = currentPlayer.makeMove(this.board);

        if(!validateMove(move)) {
            throw new InvalidMoveException("Invalid Move made by " + currentPlayer.getName());
        }

        int row = move.getCell().getRow();
        int col = move.getCell().getCol();
        Cell cellToChange = this.board.getBoard().get(row).get(col);
        cellToChange.setPlayer(currentPlayer);
        cellToChange.setState(CellState.FILLED);

        Move finalMove = new Move(cellToChange, currentPlayer);
        this.moves.add(finalMove);
        nextPlayerMoveIndex= (nextPlayerMoveIndex + 1) % this.players.size();

        if(winningAlgorithm.checkWinner(board, finalMove)){
            this.gameState = GameState.ENDED;
            this.Winner = currentPlayer;
        }
    }
}
