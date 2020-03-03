
/**
 * This class stores information about a wand such as its name or its behavior.
 * Wands also modify character's stats when they are fighting in a duel.
 * 
 * @author The Order of the Phoenix: Jorge Cancho Casado, Rubén Costa Barriga and Arturo Mejías Velasco
 * @version 10/01/2020
 * 
 */
public class Wand {
    
    private String wandName;        // the name of the wand
    private WandBehavior behavior;  // the wand's behavior
    
    /**
     * Constructor for objects of class Wand.
     * 
     * @param wandName   Name of the wand.
     * @param behavior   Wand's behavior.
     */
    public Wand(String wandName,WandBehavior behavior) {
        
        this.wandName = wandName;
        this.behavior = behavior;
    }
    
    /**
     * Returns the name of the wand.
     * 
     * @return String - Wand's name.
     */
    public String getWandName() {
        
        return this.wandName;
    }

    /**
     * Returns wand's behavior.
     * 
     * @return WandBehavior - Wand's behavior.
     */
    public WandBehavior getBehavior() {
        
        return this.behavior;
    }

    /**
     * Returns the attack modifier corresponding to the behavior when a
     * character is attacking.
     * 
     * @return double - Behavior's offensive attack modifier.
     */
    public double getAttackModifier() {
        
        return this.behavior.getAttackModifier();
    }
    
    /**
     * Returns the energy modifier corresponding to the behavior when a
     * character is attacking.
     * 
     * @return double - Behavior's offensive energy modifier.
     */
    public double getEnergyModifierA() {
        
        return this.behavior.getEnergyModifierA();
    }
    
    /**
     * Returns the attack modifier corresponding to the behavior when a
     * character is defending.
     * 
     * @return double - Behavior's defensive attack modifier.
     */
    public double getDefenseModifier() {
        
        return this.behavior.getDefenseModifier();
    }
    
    /**
     * Returns the energy modifier corresponding to the behavior when a
     * character is defending.
     * 
     * @return double - Behavior's defensive energy modifier.
     */
    public double getEnergyModifierD() {
        
        return this.behavior.getEnergyModifierD();
    }
    
    @Override
    public String toString() {
        
        return wandName + " (" + behavior.getClass().getSimpleName() + ")";
    }
}
