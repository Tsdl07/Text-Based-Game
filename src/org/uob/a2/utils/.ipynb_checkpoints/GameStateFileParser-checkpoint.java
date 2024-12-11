package org.uob.a2.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

import org.uob.a2.gameobjects.*;

/**
 * Utility class for parsing a game state from a file.
 * 
 * <p>
 * This class reads a structured text file to create a {@code GameState} object,
 * including the player, map, rooms, items, equipment, features, and exits.
 * </p>
 */
public class GameStateFileParser {
    public GameStateFileParser(){
    }

    public static GameState parse(String filename){
        BufferedReader bufferedReader = null;

        try{
            bufferedReader = new BufferedReader(new FileReader(filename));
            String line;

            Map map = null;
            Player player = null;
            String name;
            String currentRoomId = "";
            String[] roomInfo;
            String[] objectInfo;
            Room room = null;
            int indexOfColon;
            boolean firstRoom = true;

            while((line=bufferedReader.readLine())!=null){
                if(line.contains("player:")){
                     int indexOfColonPlayer = line.indexOf(":");
                     name = line.substring(indexOfColonPlayer+1);
                     player = new Player(name);
                }
                else if(line.contains("map:")){
                     map = new Map();
                }
                else if(line.contains("room:")){
                    indexOfColon = line.indexOf(":");
                    roomInfo = line.substring(indexOfColon+1).split(",");
                    room = new Room(roomInfo[0], roomInfo[1], roomInfo[2], Boolean.parseBoolean(roomInfo[3]));
                    map.addRoom(room);
                    if(firstRoom){
                        map.setCurrentRoom(room.getId());
                        firstRoom = false;
                    }
                    
                }
                else if(line.contains("container:")){
                    indexOfColon = line.indexOf(":");
                    objectInfo = line.substring(indexOfColon+1).split(",");
                    Container container = new Container(objectInfo[0], objectInfo[1], objectInfo[2], Boolean.parseBoolean(objectInfo[3]));
                    if(room!=null){
                        room.addFeature(container);
                    }
                }
                else if(line.contains("equipment:")){
                    indexOfColon = line.indexOf(":");
                    objectInfo = line.substring(indexOfColon+1).split(",");
                    UseInformation useInformation = new UseInformation(false, objectInfo[4], objectInfo[5], objectInfo[6], objectInfo[7]);
                    Equipment equipment = new Equipment(objectInfo[0], objectInfo[1], objectInfo[2], Boolean.parseBoolean(objectInfo[3]), useInformation);
                    if(room!=null){
                        room.addEquipment(equipment);
                    }
                    
                }
                else if(line.contains("item:")){
                    indexOfColon = line.indexOf(":");
                    objectInfo = line.substring(indexOfColon+1).split(",");
                    Item item = new Item(objectInfo[0], objectInfo[1], objectInfo[2], Boolean.parseBoolean(objectInfo[3]));
                    if(room!=null){
                        room.addItem(item);
                    }
                }
                else if(line.contains("feature:")){
                    indexOfColon = line.indexOf(":");
                    objectInfo = line.substring(indexOfColon+1).split(",");
                    Feature feature = new Feature(objectInfo[0], objectInfo[1], objectInfo[2], Boolean.parseBoolean(objectInfo[3]));
                    if(room!=null){
                        room.addFeature(feature);
                    }
                }
                else if(line.contains("exit:")){
                    indexOfColon = line.indexOf(":");
                    objectInfo = line.substring(indexOfColon+1).split(",");
                    Exit exit = new Exit(objectInfo[0], objectInfo[1], objectInfo[2], objectInfo[3], Boolean.parseBoolean(objectInfo[4]));
                    if(room!=null){
                        room.addExit(exit);
                    }
                }

                /////////////////////////// READING HINT from the game.txt file and setting hint to the room:
                else if(line.contains("hint:")){
                    indexOfColon = line.indexOf(":");
                    objectInfo = line.substring(indexOfColon+1).split(",");
                    Hint hint = new Hint(objectInfo[0], objectInfo[1], objectInfo[2], Boolean.parseBoolean(objectInfo[3]));
                    if(room!=null){
                        room.setHint(hint);
                    }
                }
                ///////////////////////////////
            }

            GameState gameState = new GameState(map, player);

            bufferedReader.close();
            
            return gameState;
        }
        catch(Exception e){
            GameState gameState = null;
            return gameState;
        }    
    }
}
