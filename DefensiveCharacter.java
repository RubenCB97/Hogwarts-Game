
/**
 * This class contains information about a defensive character.
 * A defensive character has 5 more defensive points than a default character.
 *
 * @author The Order of the Phoenix: Jorge Cancho Casado, Rubén Costa Barriga and Arturo Mejías Velasco
 * @version 10/01/2020
 */
public class DefensiveCharacter extends Character {
    
    /**
     * Constructor for objects of class OffensiveCharacter.
     */
    public DefensiveCharacter(String name, String surname) {
        
        super(name, surname);
        super.setDefensive(25.0);
    }
}
