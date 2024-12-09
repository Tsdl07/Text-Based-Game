package org.uob.a2.commands;

import org.uob.a2.gameobjects.*;

/**
 * Represents the use command, allowing the player to use equipment on a specific target in the game.
 * 
 * <p>
 * The use command checks if the player has the specified equipment and whether it can interact with
 * the target. The target can be a feature, item, or the current room, depending on the game context.
 * </p>
 */
public class Use extends Command {
    private String equipmentName;

    public Use(String equipmentName, String target){
        super.commandType = CommandType.valueOf("USE");
        super.value = target;
        this.equipmentName = equipmentName;
    }

    @Override
    public String toString(){
        return super.commandType.name()  + " " +this.equipmentName+ " " + super.value;
    }

    public String execute(GameState gameState){
        Player player = gameState.getPlayer();
        Room currentRoom = gameState.getMap().getCurrentRoom();
        String result = "";

        if(player.hasEquipment(equipmentName)){
            Equipment equipment = player.getEquipment(equipmentName);
            
            if(!equipment.getUseInformation().isUsed()){
                String target = equipment.getUseInformation().getTarget();
                String equipmentResult = equipment.getUseInformation().getResult();
                
                if(super.value!=null){
                    Item itemUsage = null;
                    for(Item item : player.getInventory()){
                        if(super.value.contains(item.getName())){
                            itemUsage = item;
                        }
                    }
                    
                    if(itemUsage==null){
                         
                        for(Feature feature : currentRoom.getFeatures()){
                            if((super.value.contains(feature.getName())) && (feature.getId().equals(target))){
                                
                                equipment.getUseInformation().setUsed(true);
                                result = equipment.getUseInformation().getMessage();

                                if(currentRoom.getEquipment(equipmentResult)!=null){ ////////FOR THE TESTS (AS THERE IS NO RESULT IN TEST)
                                    currentRoom.getEquipment(equipmentResult).setHidden(false);
                                }
                                else if(currentRoom.getItem(equipmentResult)!=null){
                                currentRoom.getItem(equipmentResult).setHidden(false);
                                }
                                else if(currentRoom.getFeature(equipmentResult)!=null){
                                    currentRoom.getFeature(equipmentResult).setHidden(false);
                                } 
                                else if(currentRoom.getExit(equipmentResult)!=null){
                                    currentRoom.getExit(equipmentResult).setHidden(false);
                                }
                                
                                player.getScore().addScore(10);
                                return result;
                            }

                        }

                    }
                    else{ 
                        equipment.getUseInformation().setUsed(true);
                        result = equipment.getUseInformation().getMessage();

                        if(currentRoom.getEquipment(equipmentResult)!=null){ ////////FOR THE TESTS (AS THERE IS NO RESULT IN TEST)
                            currentRoom.getEquipment(equipmentResult).setHidden(false);
                        }
                        else if(currentRoom.getItem(equipmentResult)!=null){
                            currentRoom.getItem(equipmentResult).setHidden(false);
                        }
                        else if(currentRoom.getFeature(equipmentResult)!=null){
                            currentRoom.getFeature(equipmentResult).setHidden(false);
                        } 
                        else if(currentRoom.getExit(equipmentResult)!=null){
                            currentRoom.getExit(equipmentResult).setHidden(false);
                        }
                            
                        player.getScore().addScore(10);
                        return result;
                    }

                    result="Invalid use target";
                }
                

                else{
                    //for(GameObject gameObject : currentRoom.getAll()){
                        //if(equipment.getUseInformation().getResult().equals(gameObject.getId())){

                        if(target.equals(currentRoom.getId())){
                            if(currentRoom.getExit(equipmentResult)!=null){  //CHECKING IF THE RESULT IF EXITS (it may be other feature);
                                currentRoom.getExit(equipmentResult).setHidden(false);    
                            }
                            else if(currentRoom.getFeature(equipmentResult)!=null){
                                currentRoom.getFeature(equipmentResult).setHidden(false);   
                            }
                            else if(currentRoom.getItem(equipmentResult)!=null){
                                currentRoom.getItem(equipmentResult).setHidden(false);  
                            }
                            else if(currentRoom.getEquipment(equipmentResult)!=null){
                                currentRoom.getEquipment(equipmentResult).setHidden(false);  
                            }
                            
                            equipment.getUseInformation().setUsed(true);
                            result = equipment.getUseInformation().getMessage();
                        
                            player.getScore().addScore(10);
                            return result;
                        }
                                
                        //}
                    //}
                        result="Wrong implementation of USE command.";
                }
                

            }
            else{
                result = "You have already used "+equipmentName;
            }
            
        }
        else{
            result = "You do not have "+equipmentName;
        }

        return result;
    }
  
}
