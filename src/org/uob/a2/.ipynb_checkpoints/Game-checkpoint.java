package org.uob.a2;

import java.util.Scanner;

import org.uob.a2.commands.*;
import org.uob.a2.gameobjects.*;
import org.uob.a2.parser.*;
import org.uob.a2.utils.*;

/**
 * Main class for the game application. Handles game setup, input parsing, and game execution.
 * 
 * <p>
 * This class initializes the game state, reads user input, processes commands, and maintains the game loop.
 * </p>
 */
public class Game {

    public static void main(String[] args){

        //Reading the file and creating the game (gameState):
        String file = "data/game.txt";
        GameStateFileParser gameCreate = new GameStateFileParser();
        GameState gameState = gameCreate.parse(file);

        //For getting input from the user:
        Scanner input = new Scanner(System.in);

        //Checking if the game is finished (useful for infinite loop for the user to enter only quit or restart once game is finished)
        boolean endOfGame = true;
        
        //Starting the game:
        //THE GAME INTRODUCTION:
        System.out.println(".........");
        System.out.println("......");
        System.out.println("...");
        System.out.println(".");
        System.out.println("You woke up in a big creepy house. You are surrounded by the dark walls.\nYour first thought is to leave this house as soon as you can. But you find out it is not as easy as it seems....");

        String output;

        
        while(true){
        Map map = gameState.getMap();
        Tokeniser tokeniser = new Tokeniser();
        Parser parser = new Parser();

        if(!(map.getRooms().get(map.getRooms().size()-1)==map.getCurrentRoom())){ //Checking if the player is in the last room, that is he finished the game.

            //Getting the input from the player and converting it into tokens:
            System.out.print(">>");
            String enterCommand = input.nextLine();

            tokeniser.tokenise(tokeniser.sanitise(enterCommand));
            
            try{
                //Creating the commands based on the user input:
                Command command = parser.parse(tokeniser.getTokens());
                
                if(command!=null){ //Checking if the valid input was entered by the user.
                    if(command instanceof Quit){ //Ending the game, if the input is QUIT.
                        System.out.println(command.execute(gameState)); //Showing current player status.
                        break;
                    }
                    else if(command instanceof Restart){ //Restarting the game, if the input is RESTART.
                        System.out.println(command.execute(gameState)); //Showing the game introduction.
                        gameState = gameCreate.parse(file); //READING THE FILE AGAIN FROM THE BEGINNING FOR RESTARTING THE GAME.
                        continue;
                    }
                    else{
                        output = command.execute(gameState); //Executing the command entered by the user.
                        
                        //SPECIFICALLY FOR LOOK AND STATUS COMMANDS, IF THE USER ENTERS INVALID SECOND WORD, THE ERROR MESSAGE WILL BE SHOWN:
                        if(output.isEmpty()){ //Checking if the output is empty, as execution of look and status commands returns empty for invalid second word in the input, which is required for the tests.
                            System.out.println("Invalid input!");
                        }
                        else{ //Showing the result of the command execution:
                            System.out.println(output);
                        }
                    }
                }
                else{
                    System.out.println("Please enter valid command!");
                }
            }
            catch(CommandErrorException e){ //Showing an exception message from the parser:
                System.out.println("Command not found: "+e.getMessage());
            }
         }
         else{
            if(endOfGame){ //If the game is finished, the final message will be shown:
                System.out.println("CONGRATULATIONS! You have escaped the house. You are free! Enjoy your freedom!");
                System.out.println("Now you can either restart the game or quit the game:");
            }

            //Enabling that the final message is shown only once, after the user finishes the game.
            endOfGame = false;
            

            //Getting input from the user and converting to tokens after the end of the game (can be either restart or quit):
            System.out.print("--");
            String enterInput = input.nextLine();
             
            tokeniser.tokenise(tokeniser.sanitise(enterInput));
            
            try{
                Command command = parser.parse(tokeniser.getTokens());
                
                if(command!=null){ //Checking if the entered command is valid.
                    if(command instanceof Quit){ //Ending the game, if the input is QUIT.
                        System.out.println(command.execute(gameState));
                        break;
                    }
                    else if(command instanceof Restart){ //Restarting the game, if the input is RESTART.
                        System.out.println(command.execute(gameState));
                        gameState = gameCreate.parse(file);
                        continue;
                    }
                    else{
                        System.out.println("You can only enter either quit or restart command!");
                    }
                }
                else{
                    System.out.println("Please enter valid command!");
                }
            }
            catch(CommandErrorException e){ //Showing exception for wrong inputs:
                System.out.println("You can only enter either quit or restart command!");
            }
         }
        } 
    }
}
