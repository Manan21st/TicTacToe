package org.projects_nj.controllers;

import org.projects_nj.exceptions.InvalidMoveException;
import org.projects_nj.models.Game;
import org.projects_nj.models.GameState;
import org.projects_nj.models.Player;

import java.util.List;

public class GameController {
    public Game startGame(int size, List<Player> players){
        return new Game(size, players);
    }

    public void makeMove(Game game) throws InvalidMoveException {
        game.makeMove();
    }

    public GameState checkState(Game game){
        return game.getGameState();
    }

    public Player getWinner(Game game){
        return game.getWinner();
    }

    public void printBoard(Game game){
        game.printBoard();
    }
}
