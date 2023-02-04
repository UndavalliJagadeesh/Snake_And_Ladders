package SnakeAndLadders;

public class Player {
    private String playerName;
    private int playerId;
    private int playerLoc=0;
    private int playerScore;

    //Constructur
    Player(String playerName, int playerId){
        this.playerName=playerName;
        this.playerId=playerId;
    }

    Player(String playerName){
        this.playerName=playerName;
    }

    //setters
    public void setLoc(int playerLoc){
        this.playerLoc=playerLoc;
    }

    public void setScore(int playerScore){
        this.playerScore=playerScore;
    }

    //getters
    public String getPlayerName(){
        return playerName;
    }
    
    public int getPlayerId(){
        return playerId;
    }
    
    public int getPlayerLoation(){
        return playerLoc;
    }
    
    public int getPlayerScore(){
        return playerScore;
    }
}
