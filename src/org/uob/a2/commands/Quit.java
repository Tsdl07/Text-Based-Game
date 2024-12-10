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
public class Quit extends Command {
    public Quit(){
        super.commandType = CommandType.valueOf("QUIT");
    }

    public String execute(GameState gameState){
        Player player = gameState.getPlayer();
        String result = "Game over:\n";
        result += "Your current status is:\nPlayer name: "+player.getName()+"\nInventory:\n";
        for (Item item : player.getInventory()){
            result+=item.getDescription() + "\n";
        }
        result+="\nEquipment:\n";
        for (Equipment equipment : player.getEquipment()){
            result+=equipment.getDescription() + "\n";
        }

        result+="\nYour final score is: " + player.getScore().showScore();
        return result;
    }
}
