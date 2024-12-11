package org.uob.a2.commands;

import org.uob.a2.gameobjects.*;

/**
 * Represents the help command, providing the player with instructions or information
 * about various topics related to the game.
 * 
 * <p>
 * The help command displays information on how to play the game, including details about 
 * available commands, their syntax, and their purpose.
 * </p>
 */
public class Help extends Command {

    public Help(String topic){
        super.commandType = CommandType.valueOf("HELP");
        super.value = topic;
    }

    @Override
    public String toString(){
        return super.commandType.name() + " " + super.value;
    }

    public String execute(GameState gameState){
        String result = "";
        if(super.value==null){
            result = "Welcome to the game! Here is the list of useful commands throughout the game:\n";
            result+="-- MOVE: Move to a different location (e.g., ’move north’, ’move south’, ’move up’, or ’move down’).\n";
            result+="-- LOOK: Look around the current room or inspect an object.\n";
            result+="-- GET: Pick up an item or equipment from the current room (e.g., ’get sticks’).\n";
            result+="-- DROP: Drop an item or equipment from your inventory (e.g., ’drop sticks’).\n";
            result+="-- USE: Use an item in your inventory (e.g., ’use ruby’ or  ’use medallion on pillar’).\n";
            result+="-- COMBINE: Combine two items into a new equipment (e.g., ’combine stick and rope’).\n";
            result+="-- SEARCH: Search container for an item or equipment (e.g., ’search chest’).\n";
            result+="-- STATUS: Check your current status, including inventory, your map, or your score.(e.g. ’status player’, ’status inventory’, ’status map’, or ’status score’).\n";
            result+="-- HELP: Display this help information or get help on a specific topic (e.g., ’help look’).\n";
            result+="-- HINT: Get a hint if you are stuck in a particular room.\n";
            result+="-- RESTART: Restart the game.\n";
            result+="-- QUIT: Exit the game.\n";
            result+="Enjoy the game!";
        }
        else if(super.value.equals("move")){
            result+="MOVE Command:\n";
            result+="Use the 'move' command to move in a particular direction (e.g., ’move north’, or ’move up’).";
        }
        else if(super.value.equals("look")){
            result+="LOOK Command:\n";
            result+="Use the 'look' command to look around the current room, at its exits, at its features, or, at a specific item, equipment or feature of the room.";
        }
        else if(super.value.equals("get")){
            result+="GET Command:\n";
            result+="Use the 'get' command to pick up an item or equipment from the current room (e.g., ’get sticks’).";
        }
        else if(super.value.equals("drop")){
            result+="DROP Command:\n";
            result+="Use the 'drop' command to drop an item or equipment from your inventory (e.g., ’drop sticks’).";
        }
        else if(super.value.equals("use")){
            result+="USE Command:\n";
            result+="Use the 'use' command to use an item in your inventory on its own, or on a feature or item (e.g., ’use ruby’ or  ’use medallion on pillar’).";
        }
        else if(super.value.equals("combine")){
            result+="COMBINE Command:\n";
            result+="Use the 'combine' command to combine two items into a new equipment (e.g., ’combine stick and rope’).";
        }
        else if(super.value.equals("search")){
            result+="SEARCH Command:\n";
            result+="Use the 'search' command to search container for an item or equipment (e.g., ’search chest’).";
        }
        else if(super.value.equals("status")){
            result+="STATUS Command:\n";
            result+="Use the 'status' command to check your current status, including inventory, your map, or your score.(e.g. ’status player’, ’status inventory’, or ’status map’).";
        }
        else if(super.value.equals("help")){
            result+="HELP Command:\n";
            result+="Use the 'display' command to display this help information or get help on a specific topic (e.g., ’help look’).";
        }
        else if(super.value.equals("hint")){
            result+="HINT Command:\n";
            result+="Use the 'hint' command to get a hint if you are stuck in a particular room.";
        }
        else if(super.value.equals("restart")){
            result+="RESTART Command:\n";
            result+="Use the 'restart' command to restart the game.";
        }
        else if(super.value.equals("quit")){
            result+="QUIT Command:\n";
            result+="Use the 'quit' command to quit the game.";
        }
        else{
            result="No help available for the topic: "+super.value;
        }
        return result;
    }
}
