
/**
 * Representation for all the valid behaviors a wand can have.
 * Each behavior has different attack, energy and defense modifiers that
 * affect a character's offensive or defensive points.
 * 
 * @author The Order of the Phoenix: Jorge Cancho Casado, Rubén Costa Barriga and Arturo Mejías Velasco
 * @version 10/01/2020
 */

public interface WandBehavior
{  
    /**
     * Returns the value that modifies an attacker's offensive points.
     * 
     * @return double - Attack modifying value when attacking.
     */
    public double getAttackModifier();
    
    /**
     * Returns the value that modifies an attacker's energy points.
     * 
     * @return double - Energy modifying value when attacking.
     */
    public double getEnergyModifierA();
    
    /**
     * Returns the value that modifies a defender's defensive points.
     * 
     * @return double - Defense modifying value when defending.
     */
    public double getDefenseModifier();
    
    /**
     * Returns the value that modifies a defender's energy points.
     * 
     * @return double - Energy modifying value when defending.
     */
    public double getEnergyModifierD();
}
