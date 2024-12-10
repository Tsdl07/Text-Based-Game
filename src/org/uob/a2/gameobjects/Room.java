package org.uob.a2.gameobjects;

import java.util.ArrayList;

/**
 * Represents a room in the game, which is a type of {@code GameObject}.
 * 
 * <p>
 * Rooms can have items, equipment, features, and exits. They also manage navigation
 * and interactions within the game world.
 * </p>
 */
public class Room extends GameObject {
    private ArrayList<Item> items;
    private ArrayList<Equipment> equipment;
    private ArrayList<Feature> features;
    private ArrayList<Exit> exits;
    private ArrayList<GameObject> allGameObjects;

    //private ArrayList<Hint> hints; //////////
    private Hint hint;
    
    public Room(String id, String name, String description, boolean hidden){
        super(id, name, description, hidden);
        this.items = new ArrayList<>();
        this.equipment = new ArrayList<>();
        this.features = new ArrayList<>();
        this.exits = new ArrayList<>();
        this.allGameObjects = new ArrayList<>();

        //this.hints = new ArrayList<>();
        this.hint = null;
    }

    public Room(){
    }

    @Override
    public void setName(String name){
        this.name = name;
    }

    @Override
    public String getName(){
        return this.name;
    }
    
    @Override
    public void setDescription(String description){
        this.description = description;
    }

    @Override
    public String getDescription(){
        return this.description;
    }

    public ArrayList<Exit> getExits(){
        return this.exits;        
    }

    public Exit getExit(String id){
        for(int i = 0; i<exits.size(); i++){
            if(exits.get(i).getId().equals(id)){
                return exits.get(i);
            }
        }
        return null;
    }

    public void addExit(Exit exit){
        this.exits.add(exit);
        this.allGameObjects.add(exit);
    }

    public ArrayList<Item> getItems(){
        return this.items;
    }

    public Item getItem(String id){
        for(int i = 0; i<items.size(); i++){
            if(items.get(i).getId().equals(id)){
                return items.get(i);
            }
        }
        return null;
    }

    public Item getItemByName(String name){
        for(int i = 0; i<items.size(); i++){
            if(items.get(i).getName().equals(name)){
                return items.get(i);
            }
        }
        return null;
    }

    public void addItem(Item item){
        this.items.add(item);  
        this.allGameObjects.add(item);
    }

    public boolean hasItem(String itemName){
        for(int i = 0; i<items.size(); i++){
            if(items.get(i).getName().equals(itemName)){
                return true;
            }
        }
        return false;
    }

    public ArrayList<Equipment> getEquipments(){
        return this.equipment;
    }

    public Equipment getEquipmentByName(String name){
        for(int i = 0; i<equipment.size(); i++){
            if(equipment.get(i).getName().equals(name)){
                return equipment.get(i);
            }
        }
        return null;
    }

    public Equipment getEquipment(String id){
        for(int i = 0; i<equipment.size(); i++){
            if(equipment.get(i).getId().equals(id)){
                return equipment.get(i);
            }
        }
        return null;
    }

    public void addEquipment(Equipment equipment){
        this.equipment.add(equipment);
        this.allGameObjects.add(equipment);
    }

    public boolean hasEquipment(String name){
        for(int i = 0; i<equipment.size(); i++){
            if(equipment.get(i).getName().equals(name)){
                return true;
            }
        }
        return false;
    }

    public Feature getFeature(String id){
        for(int i = 0; i<features.size(); i++){
            if(features.get(i).getId().equals(id)){
                return features.get(i);
            }
        }
        return null;
    }

    public ArrayList<Feature> getFeatures(){
        return this.features;
    }

    public Feature getFeatureByName(String name){
        for(int i = 0; i<features.size(); i++){
            if(features.get(i).getName().equals(name)){
                return features.get(i);
            }
        }
        return null;
    }

    public void addFeature(Feature feature){
        this.features.add(feature);
        this.allGameObjects.add(feature);
    }
    
    public ArrayList<GameObject> getAll(){
        return this.allGameObjects;
    }


    //////////////////////////////
    // public ArrayList<Hint> getHints(){
    //     return this.hints;
    // }

    // public void addHint(Hint hint){
    //     this.hints.add(hint);
    // }

    public void setHint(Hint hint){
        this.hint = hint;
    }

    public Hint getHint(){
        return this.hint;
    }

    ////////////////////////////////////
    

    

    
    /**
     * Returns a string representation of the room, including its contents and description.
     *
     * @return a string describing the room
     */
    @Override
    public String toString() {
        String out = "[" + id + "] Room: " + name + "\nDescription: " + description + "\nIn the room there is: ";
        for (Item i : this.items) {
            out += i + "\n";
        }
        for (Equipment e : this.equipment) {
            out += e + "\n";
        }
        for (Feature f : this.features) {
            out += f + "\n";
        }
        for (Exit e : this.exits) {
            out += e + "\n";
        }
        return out + "\n";
    }
}
