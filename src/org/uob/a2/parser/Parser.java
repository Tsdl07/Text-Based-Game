package org.uob.a2.parser;

import java.util.ArrayList;

import org.uob.a2.commands.*;

/**
 * The {@code Parser} class processes a list of tokens and converts them into {@code Command} objects
 * that can be executed by the game.
 * 
 * <p>
 * The parser identifies the type of command from the tokens and creates the appropriate command object.
 * If the command is invalid or incomplete, a {@code CommandErrorException} is thrown.
 * </p>
 */
public class Parser {
    public Parser(){
    }

    public Command parse(ArrayList<Token> tokens) throws CommandErrorException{
        
        Command command = null;

        
            for(Token token : tokens){
                if(token.getTokenType()==TokenType.MOVE){
                    for(Token tokenValue : tokens){
                        if(tokenValue.getTokenType()==TokenType.VAR){
                            command = new Move(tokenValue.getValue());
                            return command;
                        }
                    }
                    throw new CommandErrorException("Invalid usage of MOVE command!");
                }

                else if(token.getTokenType()==TokenType.LOOK){

                    for(Token tokenValue : tokens){
                        if(tokenValue.getTokenType()==TokenType.VAR){
                            command = new Look(tokenValue.getValue());
                            return command;
                        }
                    }
                    throw new CommandErrorException("Invalid usage of LOOK command!");
                }
                    
                else if(token.getTokenType()==TokenType.GET){
                    for(Token tokenValue : tokens){
                        if(tokenValue.getTokenType()==TokenType.VAR){
                            command = new Get(tokenValue.getValue());
                            return command;
                        }
                    }
                    throw new CommandErrorException("Invalid usage of GET command!");
                }

                else if(token.getTokenType()==TokenType.DROP){
                    for(Token tokenValue : tokens){
                        if(tokenValue.getTokenType()==TokenType.VAR){
                            command = new Drop(tokenValue.getValue());
                            return command;
                        }
                    }
                    throw new CommandErrorException("Invalid usage of DROP command!");
                }

                else if(token.getTokenType()==TokenType.STATUS){
                    for(Token tokenValue : tokens){
                        if(tokenValue.getTokenType()==TokenType.VAR){
                            command = new Status(tokenValue.getValue());
                            return command;
                        }
                    }
                    throw new CommandErrorException("Invalid usage of STATUS command!");
                }

                

                else if(token.getTokenType()==TokenType.HELP){
                    if(tokens.size()<=3){
                        for(Token tokenValue : tokens){
                            if(tokenValue.getTokenType()==TokenType.VAR){
                                command = new Help(tokenValue.getValue());
                                return command;
                            }
                        }
                        command = new Help(null);
                        return command;
                    }
                    throw new CommandErrorException("Invalid usage of HELP command!");
                }
                    
                else if(token.getTokenType()==TokenType.USE){
                    String equipment = "";
                    String preposition = "";
                    
                    
                        for(Token tokenValue : tokens){
                            if(tokenValue.getTokenType()==TokenType.VAR){
                                equipment = tokenValue.getValue();
                            }
                            else if(tokenValue.getTokenType()==TokenType.PREPOSITION){
                                preposition = tokenValue.getValue();
                                break;
                            }
                        }

                        for(Token tokenValue2 : tokens){
                            
                            if(tokenValue2.getTokenType()==TokenType.VAR && !tokenValue2.getValue().equals(equipment)){
                                String target = tokenValue2.getValue();
                                command = new Use(equipment, preposition+" "+target);
                                return command;
                            }
                        }
                    
                        for(Token tokenValue : tokens){
                            if(tokenValue.getTokenType()==TokenType.VAR){
                                command = new Use(tokenValue.getValue(), null);
                                return command;
                            }
                        }
                    

                    throw new CommandErrorException("Invalid usage of USE command!");
                }

                else if(token.getTokenType()==TokenType.QUIT){
                    if(tokens.size()==2){
                        command = new Quit();
                        return command;
                    }
                    throw new CommandErrorException("Invalid usage of QUIT command!");
                    
                }

                ////////////////////////////////////////////////
                // else if(token.getTokenType()==TokenType.HINT){
                //     for(Token tokenValue : tokens){
                //         if(tokenValue.getTokenType()==TokenType.VAR){
                //             command = new HintCommand(tokenValue.getValue());
                //             return command;
                //         }
                //     }
                //     throw new CommandErrorException("Invalid usage of HINT command!");
                // }

                else if(token.getTokenType()==TokenType.HINT){
                    if(tokens.size()==2){
                        command = new HintCommand();
                        return command;
                    }
                    throw new CommandErrorException("Invalid usage of HINT command!");
                    
                }
                //////////////////////////////////////////////
                    
                else if(token.getTokenType()==TokenType.RESTART){
                    if(tokens.size()==2){
                        command = new Restart();
                        return command;
                    }
                    throw new CommandErrorException("Invalid usage of RESTART command!");
                    
                }

                else if(token.getTokenType()==TokenType.SEARCH){
                    for(Token tokenValue : tokens){
                        if(tokenValue.getTokenType()==TokenType.VAR){
                            command = new Search(tokenValue.getValue());
                            return command;
                        }
                    }
                    throw new CommandErrorException("Invalid usage of SEARCH command!");
                }

                else if(token.getTokenType()==TokenType.COMBINE){
                    String item1 = "";
                    
                    for(Token tokenValue : tokens){
                        if(tokenValue.getTokenType()==TokenType.VAR){
                            item1 = tokenValue.getValue();
                        }
                    }

                    for(Token tokenValue2 : tokens){
                        if(tokenValue2.getTokenType()==TokenType.VAR && !tokenValue2.getValue().equals(item1)){
                            String item2 = tokenValue2.getValue();
                            command = new Combine(item1, item2);
                            return command;
                        }
                    }
                    
                    throw new CommandErrorException("Invalid usage of COMBINE command!");
                }

                else{
                    throw new CommandErrorException("You have entered invalid command!");
                }

                
            }
            return command;

    }
 
}
