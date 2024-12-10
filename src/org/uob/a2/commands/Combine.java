package org.uob.a2.commands;

import org.uob.a2.gameobjects.*;

/**
 * NEW FEATURE
 * Represents the combine command, allowing the player to combine two items into a new item or equipment.
 * 
 * <p>
 * This command checks if the player possesses the specified items and, if so, removes them from their inventory
 * and combines them into a new item or equipment. That new item or equipment is added to the player's inventory.
 * If the player does not have the required items for combining, an error message is returned.
 * Each time the player combines two items, his score is increased by 5 points.
 * 
 * </p>
 */

public class Combine extends Command{
    private String itemName2;

    //Constructor, requiring two items for combining:
    public Combine(String itemName, String itemName2){
        super.commandType = CommandType.valueOf("COMBINE");
        super.value = itemName;
        this.itemName2 = itemName2;
    }

    
    public String execute(GameState gameState){
        Player player = gameState.getPlayer();
        String result = "";

        if(player.hasItem(super.value) && player.hasItem(itemName2)){ //Checking if the player has required items.
            if((super.value.equals("blade") && itemName2.equals("handle"))||(super.value.equals("handle") && itemName2.equals("blade"))){
                //Removing the 2 items used for combination from the player's inventory (based on index):
                Item searchedItem = player.getItem(super.value);
                int indexOfSearchedItem = player.getInventory().indexOf(searchedItem);
                player.getInventory().remove(indexOfSearchedItem);

                Item searchedItem2 = player.getItem(itemName2);
                int indexOfSearchedItem2 = player.getInventory().indexOf(searchedItem2);
                player.getInventory().remove(indexOfSearchedItem2);

                //Creating the result of combination (in this case equipment):
                Equipment axe = new Equipment("a1", "axe", "A metal axe", false, new UseInformation(false, "open", "cl2", "m2", "You destroyed the closet. Something falls to the floor..."));
                //Adding the new equipment to the player's inventory.
                player.addEquipment(axe);

                result = "You have successfully combined "+super.value+" and "+itemName2+" into "+axe.getName();
            }
            else if((super.value.equals("tube") && itemName2.equals("screen"))||(super.value.equals("screen") && itemName2.equals("tube"))){
                //Removing the 2 items used for combination from the player's inventory (based on index):
                Item searchedItem = player.getItem(super.value);
                int indexOfSearchedItem = player.getInventory().indexOf(searchedItem);
                player.getInventory().remove(indexOfSearchedItem);

                Item searchedItem2 = player.getItem(itemName2);
                int indexOfSearchedItem2 = player.getInventory().indexOf(searchedItem2);
                player.getInventory().remove(indexOfSearchedItem2);

                //Creating the result of combination (in this case equipment):
                Equipment goggles = new Equipment("g2", "goggles", "A night vision goggles", false, new UseInformation(false, "reveal", "r6", "e11", "You are wearing the night vision goggles. Now you can see everything!"));
                //Adding the new equipment to the player's inventory.
                player.addEquipment(goggles);

                result = "You have successfully combined "+super.value+" and "+itemName2+" into "+goggles.getName();
            }

            else if((super.value.equals("stick") && itemName2.equals("rope"))||(super.value.equals("rope") && itemName2.equals("stick"))){
                //Removing the 2 items used for combination from the player's inventory (based on index):
                Item searchedItem = player.getItem(super.value);
                int indexOfSearchedItem = player.getInventory().indexOf(searchedItem);
                player.getInventory().remove(indexOfSearchedItem);

                Item searchedItem2 = player.getItem(itemName2);
                int indexOfSearchedItem2 = player.getInventory().indexOf(searchedItem2);
                player.getInventory().remove(indexOfSearchedItem2);

                //Creating the result of combination (in this case item):
                Item handle = new Item("h3", "handle", "A wooden handle", false);
                //Adding the new item to the player's inventory.
                player.addItem(handle);

                result = "You have successfully combined "+super.value+" and "+itemName2+" into "+handle.getName();
            }
            else if((super.value.equals("head") && itemName2.equals("handle"))||(super.value.equals("handle") && itemName2.equals("head"))){
                //Removing the 2 items used for combination from the player's inventory (based on index):
                Item searchedItem = player.getItem(super.value);
                int indexOfSearchedItem = player.getInventory().indexOf(searchedItem);
                player.getInventory().remove(indexOfSearchedItem);

                Item searchedItem2 = player.getItem(itemName2);
                int indexOfSearchedItem2 = player.getInventory().indexOf(searchedItem2);
                player.getInventory().remove(indexOfSearchedItem2);

                //Creating the result of combination (in this case equipment):
                Equipment hammer = new Equipment("hm4", "hammer", "A metal hammer", false, new UseInformation(false, "open", "bn6", "ph7", "You destroyed the bin. Something green falls to the floor..."));
                //Adding the new equipment to the player's inventory.
                player.addEquipment(hammer);

                result = "You have successfully combined "+super.value+" and "+itemName2+" into "+hammer.getName();
            }

            //Increasing the score of the player by 5 points.
            player.getScore().addScore(5);

        }
        else{
            result = "You do not have the necessary items for combining items!";
        }

        return result;
    }
}