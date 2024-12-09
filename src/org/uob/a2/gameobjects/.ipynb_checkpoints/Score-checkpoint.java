package org.uob.a2.gameobjects;

/**
 * Represents the score of the player.
 * 
 * <p>
 * Score can be increased while game is running. 
 * Each time the player combines two item into new item or equipment, player's score increases by 5 points.
 * Each time the player uses an equipment, player's score increases by 10 points.
 * </p>
 */

public class Score{
    private int score;

    public Score(int startingScore){
        score = startingScore;
    }

    
    public void addScore(int points){
        score+=points;
    }

    public int showScore(){
        return score;
    }
  
}