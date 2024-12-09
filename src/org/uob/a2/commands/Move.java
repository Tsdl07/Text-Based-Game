package org.uob.a2.commands;

import org.uob.a2.gameobjects.*;

/**
 * Represents the move command, allowing the player to navigate to a different room in the game world.
 * 
 * <p>
 * The move command checks if the specified direction corresponds to an available exit in the current room.
 * If a matching exit is found, the player's location is updated to the connected room.
 * </p>
 */
public class Move extends Command {
    private String direction;

    public Move(String direction){
        super.commandType = CommandType.valueOf("MOVE");
        super.value = direction;
    }

    @Override
    public String toString(){
        return super.commandType.name() + " " + super.value;
    }

    public String execute(GameState gameState){
        Room currentRoom = gameState.getMap().getCurrentRoom();
        String result = "";
        
        String idExit = ""; //???
        
        for(Exit exit : currentRoom.getExits()){
            if(exit.getName().equals(super.value)){
                idExit = exit.getId();
            }
        }
        

        if(!idExit.isEmpty()){
            if(!currentRoom.getExit(idExit).getHidden()){
                gameState.getMap().setCurrentRoom(currentRoom.getExit(idExit).getNextRoom());
                result = "Moving towards "+ currentRoom.getExit(idExit).getName()+"\n";

                gameState.getMap().getCurrentRoom().setHidden(false);
                
            }
            else{
                result = "No exit found in that direction.";
            }
        }
        else{
            result = "No exit found in that direction.";
        }
        return result;
    }
  
}
