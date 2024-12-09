package org.uob.a2.commands;

import org.uob.a2.gameobjects.*;

public class Search extends Command{

    public Search(String containerName){
        super.commandType = CommandType.valueOf("SEARCH");
        super.value = containerName;
    }

    
    public String execute(GameState gameState){
        Room currentRoom = gameState.getMap().getCurrentRoom();
        String result = "";

        if((currentRoom.getFeatureByName(super.value)!=null) && (!currentRoom.getFeatureByName(super.value).getHidden())){
            
            if(super.value.equals("shoes") && currentRoom.getEquipment("s0")!=null && currentRoom.getEquipment("s0").getHidden()){
                currentRoom.getEquipment("s0").setHidden(false);
                result = "You feel two things made of wood...";
            }
            else if(super.value.equals("firewood") && currentRoom.getEquipment("k3")!=null && currentRoom.getEquipment("k3").getHidden()){
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