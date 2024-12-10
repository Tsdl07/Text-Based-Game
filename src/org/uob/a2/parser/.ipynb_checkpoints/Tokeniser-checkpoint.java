package org.uob.a2.parser;

import java.util.ArrayList;

/**
 * The {@code Tokeniser} class is responsible for converting a string input into a list of tokens
 * that can be parsed into commands by the game.
 * 
 * <p>
 * The tokeniser identifies keywords, variables, and special symbols, assigning each a {@code TokenType}.
 * </p>
 */
public class Tokeniser {
    private ArrayList<Token> tokens;
    
    public Tokeniser(){
        this.tokens = new ArrayList<>();    
    }

    public ArrayList<Token> getTokens(){
        return this.tokens;
    }

    public String sanitise(String s){
        String lowerS = s.toLowerCase();
        String result = lowerS.trim();
        return result;
    }

    public void tokenise(String s){

        String[] tokenString = s.split("\\s+");
        
        for(int i = 0; i<tokenString.length; i++){
            if(tokenString[i].equals("use")){
                if(tokenString.length==(i+4) &&(tokenString[i+2].equals("on")||tokenString[i+2].equals("with"))){
                    Token item = new Token(TokenType.VAR, tokenString[i+1]);
                    Token preposition = new Token(TokenType.PREPOSITION, tokenString[i+2]);
                    Token target = new Token(TokenType.VAR, tokenString[i+3]);
                    Token use = new Token(TokenType.USE);

                    tokens.add(use);
                    tokens.add(item);
                    tokens.add(preposition);
                    tokens.add(target);
                }
                
                else if(tokenString.length==(i+2)){
                    Token item = new Token(TokenType.VAR, tokenString[i+1]);
                    Token use = new Token(TokenType.USE);
                    
                    tokens.add(use);
                    tokens.add(item);
                    
                }
                else{
                    Token use = new Token(TokenType.USE);
                    tokens.add(use);
                }

                break;
            }

            else if(tokenString[i].equals("get")){
                if(tokenString.length==(i+2)){
                    Token item = new Token(TokenType.VAR, tokenString[i+1]);
                    Token get = new Token(TokenType.GET);
                    
                    tokens.add(get);
                    tokens.add(item);
                    
                }
                else{
                    Token get = new Token(TokenType.GET);
                    tokens.add(get);
                }

                break;
            }

            else if(tokenString[i].equals("drop")){
                if(tokenString.length==(i+2)){
                    Token item = new Token(TokenType.VAR, tokenString[i+1]);
                    Token drop = new Token(TokenType.DROP);
                    
                    tokens.add(drop);
                    tokens.add(item);
                }
                else{
                    Token drop = new Token(TokenType.DROP);
                    tokens.add(drop);
                }

                break;
            }

            else if(tokenString[i].equals("look")){
                if(tokenString.length==(i+2)){
                    Token target = new Token(TokenType.VAR, tokenString[i+1]);
                    Token look = new Token(TokenType.LOOK);
                    
                    tokens.add(look);
                    tokens.add(target);
                }
                else{
                    Token look = new Token(TokenType.LOOK);
                    tokens.add(look);
                }

                break;
            }

            else if(tokenString[i].equals("status")){
                if(tokenString.length==(i+2)){
                    Token topic = new Token(TokenType.VAR, tokenString[i+1]);
                    Token status = new Token(TokenType.STATUS);
                    
                    tokens.add(status);
                    tokens.add(topic);
                }
                else{
                    Token status = new Token(TokenType.STATUS);
                    tokens.add(status);
                }

                break;
            }

            else if(tokenString[i].equals("help")){
                if(tokenString.length==(i+2)){
                    Token topic = new Token(TokenType.VAR, tokenString[i+1]);
                    Token help = new Token(TokenType.HELP);
                    
                    tokens.add(help);
                    tokens.add(topic);
                }
                else if(tokenString.length>(i+2)){
                    Token help = new Token(TokenType.HELP);
                    Token topic = new Token(TokenType.VAR, tokenString[i+1]);
                    Token unknown = new Token(TokenType.VAR, tokenString[i+2]);
                    
                    
                    tokens.add(help);
                    tokens.add(topic);
                    tokens.add(unknown);
                }
                else{
                    Token help = new Token(TokenType.HELP);
                    tokens.add(help);
                }

                break;
            }

            else if(tokenString[i].equals("quit")){
                Token quit = new Token(TokenType.QUIT);
                tokens.add(quit);
            }

            //////////////////////// TOKENISING RESTART COMMAND (Additional command):    
            else if(tokenString[i].equals("restart")){
                Token restart = new Token(TokenType.RESTART);
                tokens.add(restart);
            }
            /////////////////////////////

            //////////////////////// TOKENISING HINT COMMAND (Additional command):
            else if(tokenString[i].equals("hint")){
                Token hint = new Token(TokenType.HINT);
                tokens.add(hint);
            }
            
            ///////////////////////////////////////

            //////////////////////// TOKENISING SEARCH COMMAND (Additional command):
            else if(tokenString[i].equals("search")){
                if(tokenString.length==(i+2)){ //Checking whether the user has entered 2 words as input.
                    Token container = new Token(TokenType.VAR, tokenString[i+1]);
                    Token search = new Token(TokenType.SEARCH);
                    
                    tokens.add(search);
                    tokens.add(container);
                }
                else{ //If the user enters invalid number of words for search command, returning only SEARCH token and throwing exception in parser.
                    Token status = new Token(TokenType.SEARCH);
                    tokens.add(status);
                }

                break;
            }
            ////////////////////////////////////////
            
            else if(tokenString[i].equals("move")){
                if(tokenString.length==(i+2)){
                    Token direction = new Token(TokenType.VAR, tokenString[i+1]);
                    Token move = new Token(TokenType.MOVE);
                    
                    tokens.add(move);
                    tokens.add(direction);
                }
                else{
                    Token move = new Token(TokenType.MOVE);
                    tokens.add(move);
                }

                break;
                
            }

            //////////////////////// TOKENISING COMBINE COMMAND (New feature):
            else if(tokenString[i].equals("combine")){
                if(tokenString.length==(i+4) && tokenString[i+2].equals("and")){ //Checking whether the user has entered 4 words as input, including the preposition "and".
                    Token item1 = new Token(TokenType.VAR, tokenString[i+1]);
                    Token preposition = new Token(TokenType.PREPOSITION, tokenString[i+2]);
                    Token item2 = new Token(TokenType.VAR, tokenString[i+3]);
                    Token combine = new Token(TokenType.COMBINE);

                    tokens.add(combine);
                    tokens.add(item1);
                    tokens.add(preposition);
                    tokens.add(item2);
                }
                else{ //If the user enters invalid number of words for combine command or wrong preposition, returning only COMBINE token and throwing exception in parser.
                    Token combine = new Token(TokenType.COMBINE);
                    tokens.add(combine);
                }
                break;
            }
            /////////////////////////////////////////////////////

            else{
                Token unknown = new Token(TokenType.VAR, tokenString[i]);
                tokens.add(unknown);
            }
        }

        Token eol = new Token(TokenType.EOL);
        tokens.add(eol);
    }
   
}
