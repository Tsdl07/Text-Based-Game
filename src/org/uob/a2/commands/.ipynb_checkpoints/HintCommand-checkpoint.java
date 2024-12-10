package org.uob.a2.commands;

import org.uob.a2.gameobjects.*;

/**
 * Represents the hint command, allowing the player to access a hint message during the game.
 * 
 * <p>
 * The hint command displays a hint message for the player based on his current room.
 * If the hint is available in the current room, it will display the hint message. Otherwise, an error message will be shown.
 * (For this game, I provide hint for the player in every room)
 * </p>
 */
public class HintCommand extends Command {
    //Constructor:
    public HintCommand(){
        super.commandType = CommandType.valueOf("HINTCOMMAND");
    }

    public String execute(GameState gameState){
        Room currentRoom = gameState.getMap().getCurrentRoom();
        String result;

        if(currentRoom.getHint()!=null){ //Checking if there is a hint in the current room.
            //Displaying the hint message for the player:
            result = currentRoom.getHint().getDescription();
        }
        else{
            result ="There is no hint for this room!";
        }
        return result;
    }
}