package SnakeAndLadders;

// import SnakeAndLadders.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//listening key strokes
// import java.awt.event.KeyAdapter;
// import java.awt.event.KeyEvent;
// import javax.swing.JFrame;

// import javax.xml.namespace.QName;

public class Game {
    
    public static void main(String[] args) {
        System.out.print("Hey there!! Let's start the game.\n Enter the number of dice to play with: ");
        Scanner in = new Scanner(System.in);

        //number of dice
        int diceNum = in.nextInt();

        //number of players
        System.out.print("\nEnter the number of players : ");
        int players=in.nextInt();

        Board board = new Board(diceNum);
        Queue<Player> playersQueue = new LinkedList<>();
        ArrayList<Player> winningList = new ArrayList<>();

        //registering
        System.out.println("Register: ");
        for(int i=0;i<players;i++){
            String playerName = in.next();
            Player player = new Player(playerName,i);
            playersQueue.add(player);
        }

        board.gameStart();

        int rank=1;
        boolean flag = false;
        while(playersQueue.size()!=1){
            Player currentPlayer = playersQueue.remove();
            System.out.println(currentPlayer.getPlayerName()+"'s turn: 0 - Roll Dice || Any other key - End Game ==> ");
            String entry = in.next();
            if(!entry.equals("0")){
                flag=true;
                break;
            }
            boolean isOver = board.move(currentPlayer);
            // System.out.print("\nPlayer "+currentPlayer.getPlayerName()+" is at "+currentPlayer.getPlayerLoation());
            System.out.println(currentPlayer.getPlayerName()+" is at "+currentPlayer.getPlayerLoation());
            if(isOver){
                currentPlayer.setScore(rank++);
                winningList.add(currentPlayer);
            }else{
                playersQueue.add(currentPlayer);
            }
        }
        if(!flag){
            Player lastPlayer = playersQueue.remove();
            lastPlayer.setScore(rank);
            winningList.add(lastPlayer);

            System.out.println("\nRank\t\tPlayer Name");
            for(Player player: winningList){
                System.out.println(player.getPlayerScore()+"\t\t"+player.getPlayerName());
            }
        }
        
        System.out.println("========================== Game Over   =====================");
        in.close();
    }
}
