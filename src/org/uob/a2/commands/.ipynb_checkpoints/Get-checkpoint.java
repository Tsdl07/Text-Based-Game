package org.uob.a2.commands;

import org.uob.a2.gameobjects.*;

/**
 * Represents the get command, allowing the player to pick up an item from the current room and add it to their inventory.
 * 
 * <p>
 * This command checks if the specified item is present in the current room. If the item exists and the player
 * does not already have it, the item is added to the player's inventory and removed from the room. Otherwise,
 * an appropriate message is returned.
 * </p>
 */
public class Get extends Command {

    public Get(String item){
        super.commandType = CommandType.valueOf("GET");
        super.value = item;
    }

    @Override
    public String toString(){
        return super.commandType.name() + " " + super.value;
    }

    public String execute(GameState gameState){
        Room currentRoom=gameState.getMap().getCurrentRoom();
        Player player = gameState.getPlayer();
        String result;
        
        if (currentRoom.hasItem(super.value) && !player.hasItem(super.value) && !currentRoom.getItemByName(super.value).getHidden()){
            currentRoom = gameState.getMap().getCurrentRoom();
            
            //Removing the item from the current room:
            Item searchedItem = currentRoom.getItemByName(super.value);
            
            int indexOfSearchedItem = currentRoom.getItems().indexOf(searchedItem);
            currentRoom.getItems().remove(indexOfSearchedItem);
            
            int indexOfSearchedItemAll = currentRoom.getAll().indexOf(searchedItem);
            currentRoom.getAll().remove(indexOfSearchedItemAll);
            
            //Adding the item to player's inventory:
            player.addItem(searchedItem);

            result = "You pick up: "+super.value;
            
        }
        else if(currentRoom.hasEquipment(super.value) && !player.hasEquipment(super.value) && !currentRoom.getEquipmentByName(super.value).getHidden()){
            currentRoom = gameState.getMap().getCurrentRoom();
            
            //Removing the equipment from the current room:
            Equipment searchedEquipment = currentRoom.getEquipmentByName(super.value);
            
            int indexOfSearchedEquipment = currentRoom.getEquipments().indexOf(searchedEquipment);
            currentRoom.getEquipments().remove(indexOfSearchedEquipment);
            
            int indexOfSearchedEquipmentAll = currentRoom.getAll().indexOf(searchedEquipment);
            currentRoom.getAll().remove(indexOfSearchedEquipmentAll);
            
            //Adding the equipment to player's inventory:
            player.addEquipment(searchedEquipment);

            result = "You pick up: "+super.value;
            
        }
            
        else if(player.hasItem(super.value)|| player.hasEquipment(super.value)){
            result = "You already have "+super.value;
            
        }
            
        else{
            result = "No "+super.value+" to get.";
        }

        return result;
    }
}
