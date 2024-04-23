package org.projects_nj.models;



public class Bot extends Player{
    private BotDifficulty botDifficulty;

    public Bot(String name, Symbol symbol, BotDifficulty botDifficulty){
        super(name, symbol, PlayerType.Bot);
        this.botDifficulty = botDifficulty;
    }
}
