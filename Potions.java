
/**
 * This class stores information about all the different potions a character can use.
 * A potion modifies a character's offensive or defensive stats.
 *
 * @author The Order of the Phoenix: Jorge Cancho Casado, Rubén Costa Barriga and Arturo Mejías Velasco
 * @version 10/01/2020
 */
public abstract class Potions extends Character
{
    private Character potionCharacter;    // character whose stats have been modified by a potion 

    /**
     * Constructor for objects of class Potions.
     * 
     * @param character   The character that is going to get its stats modified.
     */
    public Potions(Character character) {

        super(character.getCharacterName(), character.getCharacterSurname());
        super.assignWand(character.getWand());
        potionCharacter = character;
    }

    /**
     * Returns the character's offensive points modified by a potion.
     * 
     * @return double - Offensive points modified by a potion.  
     */
    public double getOffensive() {

        return potionCharacter.getOffensive();
    }

    /**
     * Returns the character's defensive points modified by a potion.
     * 
     * @return double - Defensive points modified by a potion.  
     */
    public double getDefensive() {

        return potionCharacter.getDefensive();
    }
}
