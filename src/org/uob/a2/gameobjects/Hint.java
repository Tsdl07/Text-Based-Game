package org.uob.a2.gameobjects;

/**
 * Represents a hint for the user in the game, which is a type of {@code GameObject}.
 *
 * <p>
 * There is only 1 hint for the player in each room.
 * This class inherits common properties from {@code GameObject}.
 * </p>
 */

public class Hint extends GameObject {
    public Hint(String id, String name, String description, boolean hidden){
        super(id, name, description, hidden);
    }

    
     /**
     * Returns a string representation of the hint by calling the superclass's {@code toString} method.
     *
     * @return a string describing the hint.
     */
    @Override
    public String toString() {
        return super.toString();
    }
}