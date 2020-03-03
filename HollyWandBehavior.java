/**
 * This class stores information about the behavior of a holly wand.
 * Contains attack, energy and defensive points modifiers.
 *
 * @author The Order of the Phoenix: Jorge Cancho Casado, Rubén Costa Barriga and Arturo Mejías Velasco
 * @version 10/01/2020
 */
public class HollyWandBehavior implements WandBehavior {

    /**
     * Constructor for objects of class HollyWandBehavior
     */
    public HollyWandBehavior() {

    }
    
    @Override
    public double getAttackModifier() {
        
        return 0.3;
    }
    
    @Override
    public double getEnergyModifierA() {
        
        return 0.7;
    }
    
    @Override
    public double getDefenseModifier() {
        
        return 1.1;
    }
    
    @Override
    public double getEnergyModifierD() {
        
        return 0.9;
    }
}
