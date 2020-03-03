
/**
 * This class stores information about the Felix Felicis potion.
 *
 * @author The Order of the Phoenix: Jorge Cancho Casado, Rubén Costa Barriga and Arturo Mejías Velasco
 * @version 10/01/2020
 */
public class FelixFelicisPotion extends Potions
{
    /**
     * Constructor for objects of class FelixFelicisPotion.
     * 
     * @param character   The character that uses the potion.
     */
    public FelixFelicisPotion(Character character) {
        
        super(character);
    }

    @Override
    public double getOffensive() {
        
        return super.getOffensive() * 1.3;
    }
}
