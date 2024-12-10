package org.uob.a2.commands;

import org.uob.a2.gameobjects.*;

/**
 * Represents the quit command, allowing the player to exit the game.
 * 
 * <p>
 * The quit command signals the end of the game session and provides a summary of the player's
 * current status before termination.
 * </p>
 */
public class HintCommand extends Command {
    public HintCommand(){
        super.commandType = CommandType.valueOf("HINTCOMMAND");
        //super.value = hintName;
    }

    public String execute(GameState gameState){
        Room currentRoom = gameState.getMap().getCurrentRoom();
        String result;

        if(currentRoom.getHint()!=null){
            result = currentRoom.getHint().getDescription();
        }
        else{
            result ="There is no hint for this room!";
        }
        return result;

        // if(!currentRoom.getHints().isEmpty()){
        //     for(Hint hint : currentRoom.getHints()){
        //         if(hint.getName().equals(super.value)){
        //             result = hint.getDescription();
        //             return result;
        //         }
        //     }

        //     result = "Invalid hint input!";
        // }
        // else{
        //     result = "There are no hints for this room!";
        // }

        // return result;
    }
}