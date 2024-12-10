package org.uob.a2.gameobjects;

import java.util.ArrayList;

/**
 * Represents the player in the game, including their name, inventory, and equipment.
 * 
 * <p>
 * The player can carry items and equipment, interact with the game world, and perform
 * actions using their inventory or equipment.
 * </p>
 */
public class Player {
    private String name;
    private ArrayList<Item> inventory;
    private ArrayList<Equipment> equipment;

    //For storing the score of the player:
    private Score score;
    
    public Player(String name){
        this.name = name;
        this.inventory = new ArrayList<>();
        this.equipment = new ArrayList<>();

        //Setting up the initial score of the player to 0:
        score = new Score(0);
    }

    public Player(){
    }

    public String getName(){
        return this.name;
    }

    public ArrayList<Item> getInventory(){
        return this.inventory;
    }

    public boolean hasItem(String itemName){
        for(int i = 0; i<inventory.size(); i++){
            if(inventory.get(i).getName().equals(itemName)){
                return true;
            }
        }
        return false;
    }

    public Item getItem(String itemName){
        for(int i = 0; i<inventory.size(); i++){
            if(inventory.get(i).getName().equals(itemName)){
                return inventory.get(i);
            }
        }
        return null;
    }

    public void addItem(Item item){
        this.inventory.add(item);
    }

    public ArrayList<Equipment> getEquipment(){
        return this.equipment;
    }

    public boolean hasEquipment(String equipmentName){
        for(int i = 0; i<equipment.size(); i++){
            if(equipment.get(i).getName().equals(equipmentName)){
                return true;
            }
        }
        return false;
    }

    public Equipment getEquipment(String equipmentName){
        for(int i = 0; i<equipment.size(); i++){
            if(equipment.get(i).getName().equals(equipmentName)){
                return equipment.get(i);
            }
        }
        return null;
    }

    public void addEquipment(Equipment equipment){
        this.equipment.add(equipment);
    }


    //For accessing the score of the player:
    public Score getScore(){
       return score; 
    }
    
    

    /**
     * Returns a string representation of the player's current state, including their name,
     * inventory, and equipment descriptions.
     *
     * @return a string describing the player, their inventory, and equipment
     */
    @Override
    public String toString() {
        StringBuilder out = new StringBuilder("Player Name: " + this.name + "\nInventory:\n");
        for (Item i : this.inventory) {
            out.append("- ").append(i.getDescription()).append("\n");
        }
        out.append("Equipment:\n");
        for (Equipment e : this.equipment) {
            out.append("- ").append(e.getDescription()).append("\n");
        }
        return out.toString();
    }
}
