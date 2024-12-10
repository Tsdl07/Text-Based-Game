package org.uob.a2.commands;

import org.uob.a2.gameobjects.*;

/**
 * Represents the restart command, allowing the player to restart the game.
 * 
 * <p>
 * The restart command allows the player to restart the game. 
 * The player can restart the game in the middle of the game or may choose the restart option after finishing the game. 
 * </p>
 */

public class Restart extends Command {
    //Constructor:
    public Restart(){
        super.commandType = CommandType.valueOf("RESTART");
    }

    public String execute(GameState gameState){

        //Displaying message for the user:
        String result = "You are restarting the game!\n\n";

        //Restarting the game (the introduction to the game):
        result+=".........\n";
        result+="......\n";
        result+="...\n";
        result+=".\n";
        result+="You woke up in a big creepy house. You are surrounded by the dark walls.\nYour first thought is to leave this house as soon as you can. But you find out it is not as easy as it seems....";
        
        return result;
    }
}