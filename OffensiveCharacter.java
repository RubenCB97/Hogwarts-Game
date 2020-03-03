
/**
 * This class contains information about an offensive character.
 * An offensive character has five more offensive points than a default character.
 *
 * @author The Order of the Phoenix: Jorge Cancho Casado, Rubén Costa Barriga and Arturo Mejías Velasco
 * @version 10/01/2020
 */
public class OffensiveCharacter extends Character {
    
    /**
     * Constructor for objects of class OffensiveCharacter.
     */
    public OffensiveCharacter(String name, String surname) {
        
        super(name, surname);
        super.setOffensive(25.0);
    }
}
