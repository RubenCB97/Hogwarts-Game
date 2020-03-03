
/**
 * This class stores information about the behavior of a hawthorn wand.
 * Contains attack, energy and defensive points modifiers.
 *
 * @author The Order of the Phoenix: Jorge Cancho Casado, Rubén Costa Barriga and Arturo Mejías Velasco
 * @version 10/01/2020
 */
public class HawthornWandBehavior implements WandBehavior {

    /**
     * Constructor for objects of class HawthornWandBehavior
     */
    public HawthornWandBehavior() {
        
    }

    @Override
    public double getAttackModifier() {

        return 1.4;
    }

    @Override
    public double getEnergyModifierA() {

        return 0.6;
    }

    @Override
    public double getDefenseModifier() {

        return 0.2;
    }

    @Override
    public double getEnergyModifierD() {

        return 0.8;
    }
}
