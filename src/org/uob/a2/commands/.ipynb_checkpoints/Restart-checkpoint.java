package org.uob.a2.commands;

import org.uob.a2.gameobjects.*;

public class Restart extends Command {
    public Restart(){
    }

    public String execute(GameState gameState){
        
        String result = "You are restarting the game!\n\n";

        result+=".........\n";
        result+="......\n";
        result+="...\n";
        result+="You woke up in a big creepy house. You are surrounded by the dark walls.\nYour first thought is to leave this house as soon as you can. But you find out it is not as easy as it seems....";
        
        
        return result;
    }
}