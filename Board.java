package SnakeAndLadders;

import java.util.HashMap;

public class Board extends Dice{
    HashMap<Integer,Integer> snakes = new HashMap<>();
    HashMap<Integer,Integer> ladders = new HashMap<>();
    // Player player;
    Board(int num){
        this.setDice(num);
    }
    
    public void gameStart(){
        setSnakes();
        setLadders();
    }

    public void setSnakes(){
        snakes.put(32, 10);
        snakes.put(36, 6);
        snakes.put(48, 26);
        snakes.put(62, 18);
        snakes.put(88, 24);
        snakes.put(95, 56);
        snakes.put(99, 1);
    }

    public void setLadders(){
        ladders.put(2, 38);
        ladders.put(4, 14);
        ladders.put(8, 30);
        ladders.put(21, 42);
        ladders.put(28, 76);
        ladders.put(50, 67);
        ladders.put(71, 92);
        ladders.put(80, 98);
    }

    public boolean move(Player player){
        int pos = player.getPlayerLoation();
        int diceRoll=1;
        if(this.getDice()==1){
            diceRoll = this.generateWithOne();
        }else{
            diceRoll = this.generate();
        }
        int currentPosition = pos + diceRoll;
        if(currentPosition>100){
            System.out.println("Invalid roll");
            player.setLoc(pos);
        }else{
            if(snakes.containsKey(currentPosition)){
                System.out.println("Bite by snake!!! at "+currentPosition);
                player.setLoc(snakes.get(currentPosition));
            }else if(ladders.containsKey(currentPosition)){
                System.out.println("Hurray!!!! Got a ladder at "+currentPosition);
                player.setLoc(ladders.get(currentPosition));
                // System.out.println(player.getPlayerLoation());
            }else{
                player.setLoc(currentPosition);
            }
        }
        return currentPosition==100;
    }
}
