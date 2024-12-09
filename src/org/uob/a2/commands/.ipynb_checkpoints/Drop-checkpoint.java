package org.uob.a2.commands;

import org.uob.a2.gameobjects.*;

/**
 * Represents the drop command, allowing the player to drop an item from their inventory into the current room.
 * 
 * <p>
 * This command checks if the player possesses the specified item and, if so, removes it from their inventory
 * and adds it to the current room. If the player does not have the item, an error message is returned.
 * </p>
 */
public class Drop extends Command {
    
    public Drop(String item){
        super.commandType = CommandType.valueOf("DROP");
        super.value = item;
    }

    @Override
    public String toString(){
        return super.value + " "+ super.commandType.name();
    }

    public String execute(GameState gameState){
        Room currentRoom=gameState.getMap().getCurrentRoom();
        Player player = gameState.getPlayer();
        String result;
        if (player.hasItem(super.value)){
            //Removing the item from the player's inventory:
            Item searchedItem = player.getItem(super.value);
            int indexOfSearchedItem = player.getInventory().indexOf(searchedItem);
            player.getInventory().remove(indexOfSearchedItem);
            
            //Adding the item to the current room:
            currentRoom.addItem(searchedItem);

            result = "You drop: "+super.value;
        }
        else if(player.hasEquipment(super.value)){
            //Removing the item from the player's inventory:
            Equipment searchedEquipment = player.getEquipment(super.value);
            int indexOfSearchedEquipment = player.getEquipment().indexOf(searchedEquipment);
            player.getEquipment().remove(indexOfSearchedEquipment);
            
            //Adding the item to the current room:
            currentRoom.addEquipment(searchedEquipment);

            result = "You drop: "+super.value;
        }
        else{
            result = "You cannot drop "+super.value;
        }

        return result;
    }
   
}
