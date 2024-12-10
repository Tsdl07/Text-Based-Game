package org.uob.a2.commands;

import org.uob.a2.gameobjects.*;

/**
 * Represents the status command, allowing the player to retrieve information
 * about their inventory, specific items, or their overall status.
 * 
 * <p>
 * The status command can display a list of items in the player's inventory, display the map and player's score, 
 * provide details about a specific item or equipment, or show the player's general status.
 * </p>
 */
public class Status extends Command {

    public Status(String topic){
        super.commandType = CommandType.valueOf("STATUS");
        super.value = topic;
    }

    @Override
    public String toString(){
        return super.commandType.name() + " " + super.value;
    }

    public String execute(GameState gameState){
        Player player = gameState.getPlayer();
        Map map = gameState.getMap();
        String result ="";
        
        if (super.value.equals("inventory")){
            result = "You have:\n";
            for (Item item : player.getInventory()){
                result+=item.getName() + "\n";
            }
            
            for (Equipment equipment : player.getEquipment()){
                result+=equipment.getName() + "\n";
            }
        }

        /////// FOR DISPLAYING PLAYER'S SCORE (New Feature):
        else if(super.value.equals("score")){
            result = "Your score is: " +player.getScore().showScore();
        }

        /////// FOR DISPLAYING THE MAP (New Feature):
        else if(super.value.equals("map")){
            String exitString="";
            result = "The rooms you have visited:\n";
            for(Room room : map.getRooms()){
                if(!room.getHidden()){ //Checking if the rooms are not hidden, that is the player has visited those rooms.
                    for(Exit exit : room.getExits()){
                        if(!exit.getHidden()){ //Checking the visible exits of the room.
                            exitString+=exit.getDescription()+"\n      ";
                        }
                    }
                    /////DISPLAYING THE MAP (THE VISITED ROOMS, ALONG WITH VISIBLE EXITS):
                    result+="   "+room.getName()+":\n      "+room.getDescription()+"\n      "+exitString +"\n";
                }
            }
        }
        

        else if(player.hasItem(super.value)){
            result = "You have: " +player.getItem(super.value).getDescription();
        }

        else if(player.hasEquipment(super.value)){
            result = "You have: " +player.getEquipment(super.value).getDescription();
        }
            
        else if(super.value.equals("player")){
            result = "Your current status is:\nPlayer name: "+player.getName()+"\nInventory:\n";
            for (Item item : player.getInventory()){
                result+=item.getDescription() + "\n";
            }
            result+="\nEquipment:\n";
            for (Equipment equipment : player.getEquipment()){
                result+=equipment.getDescription() + "\n";
            }
        }

        else{
            result = "";
        }
        return result;
    }
  
}
