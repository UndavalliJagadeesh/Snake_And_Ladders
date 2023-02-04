package SnakeAndLadders;

import java.util.Random;

public abstract class Dice {

    private int numDice;
    public int generate(){
        int diceSum=0;
        Random rd = new Random();
        for(int i=0; i<numDice; diceSum+=rd.nextInt(1,7), i++);
        if(diceSum==numDice*6) return 0;
        return diceSum;
    }
    public int generateWithOne(){
        Random rd = new Random();
        int diceSum = rd.nextInt(1, 7);
        if(diceSum==6) diceSum+=rd.nextInt(1, 7);
        if(diceSum==12) diceSum+=rd.nextInt(1, 7);
        if(diceSum==18){
            System.out.println("Sorry, triple 6");
            return 0;
        }
        return diceSum;
    }
    public void setDice(int numDice){
        this.numDice=numDice;
    }
    public int getDice(){
        return numDice;
    }

}