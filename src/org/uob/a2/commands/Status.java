package org.uob.a2.commands;

import org.uob.a2.gameobjects.*;

/**
 * Represents the status command, allowing the player to retrieve information
 * about their inventory, specific items, or their overall status.
 * 
 * <p>
 * The status command can display a list of items in the player's inventory, 
 * provide details about a specific item, or show the player's general status.
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


            
        else if(super.value.equals("score")){
            result = "Your score is: " +player.getScore().showScore();
        }


        else if(super.value.equals("map")){
            result = "The rooms you have visited:\n";
            for(Room room : map.getRooms()){
                if(!room.getHidden()){
                    String exitString = "";
                    for(Exit exit : room.getExits()){
                        if(!exit.getHidden()){
                            exitString+=exit.getDescription()+"\n      ";
                        }
                    }
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
            result = ""; //Test requires empty result;
        }
        return result;
    }
  
}
