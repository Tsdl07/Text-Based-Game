package org.uob.a2.gameobjects;

import java.util.ArrayList;
import java.util.HashMap;
import java.io.*;
import java.nio.file.*;

import org.uob.a2.utils.*;

/**
 * Represents the game map, which consists of a collection of rooms and the current room the player is in.
 * 
 * <p>
 * The map allows for navigation between rooms, adding new rooms, and managing the current room context.
 * </p>
 */
public class Map {
    private Room currentRoom;
    private ArrayList<Room> rooms;

    public Map(){
        this.rooms = new ArrayList<>();
    }

    //For accessing the rooms in the map (particularly useful for displaying the map of the game):
    public ArrayList<Room> getRooms(){
        return this.rooms;
    }
    
    public Room getCurrentRoom(){
        return this.currentRoom;
    }

    public void addRoom(Room room){
        rooms.add(room);
    }

    public void setCurrentRoom(String roomId){
        for(int i = 0; i<rooms.size(); i++){
            if(rooms.get(i).getId().equals(roomId)){
                this.currentRoom = rooms.get(i);
            }
        }
    }
    
  
    /**
     * Returns a string representation of the map, including all rooms.
     *
     * @return a string describing the map and its rooms
     */
    @Override
    public String toString() {
        StringBuilder out = new StringBuilder("Map:\n");
        for (Room r : this.rooms) {
            out.append(r.toString()).append("\n");
        }
        return out.toString();
    }
}

