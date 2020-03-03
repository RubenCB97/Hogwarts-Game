
/**
 * This class stores information about the Invigoration potion.
 *
 * @author The Order of the Phoenix: Jorge Cancho Casado, Rubén Costa Barriga and Arturo Mejías Velasco
 * @version 10/01/2020
 */
public class InvigorationPotion extends Potions
{
    /**
     * Constructor for objects of class InvigorationPotion.
     * 
     * @param character   The character that uses the potion.
     */
    public InvigorationPotion(Character character) {

        super(character);
    }

    @Override
    public double getDefensive() {

        return super.getDefensive() * 1.4;
    }
}
