package org.uob.a2.commands;

import org.uob.a2.gameobjects.*;

/**
 * Represents the search command, allowing the player to search for an equipment in the container.
 * 
 * <p>
 * The search command checks if the specified container exists and is not hidden in the current room.
 * If a matching container is found, the player will be able to see the hidden equipment in the current room.
 * Otherwise, if there is no such feature in the room, or if there is no equipment in the container,it will display the error messages, respectively.
 * </p>
 */

public class Search extends Command{
    //Constructor, requesting the container name:
    public Search(String containerName){
        super.commandType = CommandType.valueOf("SEARCH");
        super.value = containerName;
    }

    
    public String execute(GameState gameState){
        Room currentRoom = gameState.getMap().getCurrentRoom();
        String result = "";

        //Checking if the specified container exists and is not hidden in the current room:
        if((currentRoom.getFeatureByName(super.value)!=null) && (!currentRoom.getFeatureByName(super.value).getHidden())){
            //Checking if the equipment (player is searching for) exists and is hidden in the current room:
            if(super.value.equals("shoes") && currentRoom.getEquipment("s0")!=null && currentRoom.getEquipment("s0").getHidden()){
                //Enabling the player to see the searched equipment in the current room:
                currentRoom.getEquipment("s0").setHidden(false);
                result = "You feel two things made of wood...";
            }
            else if(super.value.equals("firewood") && currentRoom.getEquipment("k3")!=null && currentRoom.getEquipment("k3").getHidden()){
                //Enabling the player to see the searched equipment in the current room:
                currentRoom.getEquipment("k3").setHidden(false);
                result = "You feel something metal...";
            }
            else{
                result = "There is nothing.";
            }
        }
        else{
            result = "You are in the wrong room! There is no "+ super.value +" to search!";
        }
        
        return result;
    }
}