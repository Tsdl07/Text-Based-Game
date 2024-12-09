package org.uob.a2.commands;

import org.uob.a2.gameobjects.*;

public class Combine extends Command{
    private String itemName2;

    public Combine(String itemName, String itemName2){
        super.commandType = CommandType.valueOf("COMBINE");
        super.value = itemName;
        this.itemName2 = itemName2;
    }

    
    public String execute(GameState gameState){
        Player player = gameState.getPlayer();
        String result = "";

        if(player.hasItem(super.value) && player.hasItem(itemName2)){
            if((super.value.equals("diamond") && itemName2.equals("key"))||(super.value.equals("key") && itemName2.equals("diamond"))){
                Item searchedItem = player.getItem(super.value);
                int indexOfSearchedItem = player.getInventory().indexOf(searchedItem);
                player.getInventory().remove(indexOfSearchedItem);

                Item searchedItem2 = player.getItem(itemName2);
                int indexOfSearchedItem2 = player.getInventory().indexOf(searchedItem2);
                player.getInventory().remove(indexOfSearchedItem2);
                
                Equipment stick = new Equipment("s1", "stick", "A wooden stick.", false, new UseInformation(false, "open", "c1", "rb1", "You use stick"));
                player.addEquipment(stick);

                result = "You have successfully combined "+super.value+" and "+itemName2+" into "+stick.getName();
            }

            else if((super.value.equals("blade") && itemName2.equals("handle"))||(super.value.equals("handle") && itemName2.equals("blade"))){
                Item searchedItem = player.getItem(super.value);
                int indexOfSearchedItem = player.getInventory().indexOf(searchedItem);
                player.getInventory().remove(indexOfSearchedItem);

                Item searchedItem2 = player.getItem(itemName2);
                int indexOfSearchedItem2 = player.getInventory().indexOf(searchedItem2);
                player.getInventory().remove(indexOfSearchedItem2);
                
                Equipment axe = new Equipment("a1", "axe", "A metal axe", false, new UseInformation(false, "open", "cl2", "m2", "You destroyed the closet. Something falls to the floor..."));
                player.addEquipment(axe);

                result = "You have successfully combined "+super.value+" and "+itemName2+" into "+axe.getName();
            }
            else if((super.value.equals("tube") && itemName2.equals("screen"))||(super.value.equals("screen") && itemName2.equals("tube"))){
                Item searchedItem = player.getItem(super.value);
                int indexOfSearchedItem = player.getInventory().indexOf(searchedItem);
                player.getInventory().remove(indexOfSearchedItem);

                Item searchedItem2 = player.getItem(itemName2);
                int indexOfSearchedItem2 = player.getInventory().indexOf(searchedItem2);
                player.getInventory().remove(indexOfSearchedItem2);
                
                Equipment goggles = new Equipment("g2", "goggles", "A night vision goggles", false, new UseInformation(false, "reveal", "r6", "e11", "You are wearing the night vision goggles. Now you can see everything!"));
                player.addEquipment(goggles);

                result = "You have successfully combined "+super.value+" and "+itemName2+" into "+goggles.getName();
            }

            else if((super.value.equals("stick") && itemName2.equals("rope"))||(super.value.equals("rope") && itemName2.equals("stick"))){
                Item searchedItem = player.getItem(super.value);
                int indexOfSearchedItem = player.getInventory().indexOf(searchedItem);
                player.getInventory().remove(indexOfSearchedItem);

                Item searchedItem2 = player.getItem(itemName2);
                int indexOfSearchedItem2 = player.getInventory().indexOf(searchedItem2);
                player.getInventory().remove(indexOfSearchedItem2);
                
                Item handle = new Item("h3", "handle", "A wooden handle", false);
                player.addItem(handle);

                result = "You have successfully combined "+super.value+" and "+itemName2+" into "+handle.getName();
            }
            else if((super.value.equals("head") && itemName2.equals("handle"))||(super.value.equals("handle") && itemName2.equals("head"))){
                Item searchedItem = player.getItem(super.value);
                int indexOfSearchedItem = player.getInventory().indexOf(searchedItem);
                player.getInventory().remove(indexOfSearchedItem);

                Item searchedItem2 = player.getItem(itemName2);
                int indexOfSearchedItem2 = player.getInventory().indexOf(searchedItem2);
                player.getInventory().remove(indexOfSearchedItem2);
                
                Equipment hammer = new Equipment("hm4", "hammer", "A metal hammer", false, new UseInformation(false, "open", "bn6", "ph7", "You destroyed the bin. Something green falls to the floor..."));
                player.addEquipment(hammer);

                result = "You have successfully combined "+super.value+" and "+itemName2+" into "+hammer.getName();
            }

            player.getScore().addScore(5);

        }
        else{
            result = "You do not have the necessary items for combining items!";
        }

        return result;
    }






    
}