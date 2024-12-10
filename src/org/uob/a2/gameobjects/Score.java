package org.uob.a2.gameobjects;

/**
 * Represents the score of the player.
 * 
 * <p>
 * Score can be increased while the game is running. 
 * Each time the player combines two items into new item or equipment, player's score increases by 5 points.
 * Each time the player uses an equipment, player's score increases by 10 points.
 * </p>
 */

public class Score{
    private int score;

    //Constructor, with initial starting score (in this game, it will be 0):
    public Score(int startingScore){
        score = startingScore;
    }

    //Increasing the score by some points during the game (in this game either 5 or 10):
    public void addScore(int points){
        score+=points;
    }

    //Displaying score of the player.
    public int showScore(){
        return score;
    }
  
}