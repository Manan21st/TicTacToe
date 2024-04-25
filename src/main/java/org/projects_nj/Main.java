package org.projects_nj;

import org.projects_nj.controllers.GameController;
import org.projects_nj.exceptions.InvalidMoveException;
import org.projects_nj.models.*;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InvalidMoveException {
        Scanner scanner = new Scanner(System.in);
        GameController gameController = new GameController();

        int size=3;

        List<Player> players = List.of(new Player("Player1", new Symbol('X'), PlayerType.Human)
                , new Bot("Player2",new Symbol('O'), BotDifficulty.EASY));

        Game game = gameController.startGame(size, players);
        while(game.getGameState() == GameState.IN_PROGRESS){
            gameController.printBoard(game);
            gameController.makeMove(game);
        }

        gameController.printBoard(game);
        System.out.println();
        if(!gameController.checkState(game).equals(GameState.IN_PROGRESS)){
            System.out.println("The winner is: "+gameController.getWinner(game).getName());
        }
        else{
            game.setGameState(GameState.DRAW);
            System.out.println("The game is a draw");
        }
        System.out.println("Game Over");
    }
}