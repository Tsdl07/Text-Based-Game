package org.uob.a2.commands;

import org.uob.a2.gameobjects.*;

/**
 * Represents the look command, allowing the player to examine various elements of the game world.
 * 
 * <p>
 * The look command can provide details about the current room, its exits, features, or specific items and equipment.
 * Hidden objects are not included in the output unless explicitly revealed.
 * </p>
 */
public class Look extends Command {

    public Look(String target){
        super.commandType = CommandType.valueOf("LOOK");
        super.value = target;
    }

    @Override
    public String toString(){
        return super.commandType.name() + " " + super.value;
    }

    public String execute(GameState gameState){
        Room currentRoom = gameState.getMap().getCurrentRoom();
        String result = "";
        if (super.value.equals("room")){
            result = currentRoom.getDescription() +"\nYou see:\n";
            for (GameObject object : currentRoom.getAll()){
                if(!object.getHidden()){
                    result+=object.getDescription() + "\n";
                }
            }
        }
            
        else if(super.value.equals("exits")){
            result = "The available exits are:\n";
            for (Exit exit : currentRoom.getExits()){
                if(!exit.getHidden()){
                result+=exit.getDescription() + "\n";
                }
            }
        }
            
        else if(super.value.equals("features")){
            result = "You also see:\n";
            for (Feature feature : currentRoom.getFeatures()){
                if(!feature.getHidden()){
                result+=feature.getDescription() + "\n";
                }
            }
        }

        else if(currentRoom.hasItem(super.value) && (!currentRoom.getItemByName(super.value).getHidden())){
            result = currentRoom.getItemByName(super.value).getDescription();
        }

        else if(currentRoom.hasEquipment(super.value) && (!currentRoom.getEquipmentByName(super.value).getHidden())){
            result = currentRoom.getEquipmentByName(super.value).getDescription();
        }

        else if(currentRoom.getFeatureByName(super.value)!=null){
            result = currentRoom.getFeatureByName(super.value).getDescription();
        }
            
        else{
            result = ""; //Test requires empty result;
        }
        
        return result;
    }
   
}
