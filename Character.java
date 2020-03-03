
/**
 * This class stores information about a character that exists on the simulation.
 * It contains information such as its name, its energy, offensive and defensive points,
 * or the wand it wields.
 * 
 * @author The Order of the Phoenix: Jorge Cancho Casado, Rubén Costa Barriga and Arturo Mejías Velasco
 * @version 10/01/2020
 */
public abstract class Character {

    private String characterName;       // name of the character
    private String characterSurname;    // surname of the character
    private double energy;              // character's energy points
    private double offensive;           // character's offensive points
    private double defensive;           // character's defensive points
    private Wand wand;                  // the wand that the character wields

    /**
     * Default constructor for objects of class Character.
     * 
     * @param name      The name of the character.
     * @param surname   The surname of the character.
     */
    public Character(String name, String surname) {

        this.characterName = name;
        this.characterSurname = surname;
        this.energy = 20.0;
        this.offensive = 20.0;
        this.defensive = 20.0;
        this.wand = null;
    }

    /**
     * Returns the name of the character.
     * 
     * @return String - Character's name.
     */
    public String getCharacterName() {

        return this.characterName;
    }

    /**
     * Returns the surname of the character.
     * 
     * @return String - Character's surname.
     */
    public String getCharacterSurname() {

        return this.characterSurname;
    }

    /**
     * Returns the character's energy points.
     * 
     * @return double - Character's energy points.
     */
    public double getEnergy() {

        return Math.round(this.energy * 100.0) / 100.0;
    }

    /**
     * Sets character's energy to a new value (energy).
     * 
     * @param energy   New energy points.
     */
    public void setEnergy(double energy) {

        this.energy = energy;
    }

    /**
     * Returns the character's offensive points.
     * 
     * @return double - Character's offensive points.
     */
    public double getOffensive() {

        return this.offensive;
    }

    /**
     * Sets character's offensive points to a new value (offensive).
     * 
     * @param offensive   New offensive points.
     */
    public void setOffensive(double offensive) {

        this.offensive = offensive;
    }

    /**
     * Returns the character's defensive points.
     * 
     * @return double - Character's defensive points.
     */
    public double getDefensive() {

        return this.defensive;
    }

    /**
     * Sets character's defensive points to a new value (defensive).
     * 
     * @param defensive   New defensive points.
     */
    public void setDefensive(double defensive) {

        this.defensive = defensive;
    }

    /**
     * Returns the wand that the character is wielding. If it isn't wielding a
     * wand, the method returns null.
     * 
     * @return Wand - The wand the character is wielding.
     */
    public Wand getWand() {

        return this.wand;
    }

    /**
     * Assigns the character a different wand.
     * 
     * @param newWand   A new different wand.
     */
    public void assignWand(Wand newWand) {

        this.wand = newWand;
    }

    /**
     * Provides information on whether the character is wielding a wand or not.
     * 
     * @return boolean - True if the character is wielding a wand or false if it isn't.
     */
    public boolean hasAWand() {

        if(this.wand != null)
            return true;

        return false;
    }

    /**
     * Returns character's attack points.
     * 
     * @return double - Character's attack points.
     */
    public double getAttackPoints() {

        return Math.round((getEnergy() * wand.getEnergyModifierA() + getOffensive() * wand.getAttackModifier()) * 100.0) / 100.0;
    }

    /**
     * Returns character's resistance points.
     * 
     * @return double - Character's resistance points.
     */
    public double getResistancePoints() {
        
        return Math.round((getEnergy() * wand.getEnergyModifierD() + getDefensive() * wand.getDefenseModifier()) * 100.0) / 100.0;
    }   

    /**
     * Simulates a fight between two characters.
     * This method checks attacker's attack points and defender's resistance points.
     * If attacker's attack points are greater than defender's defensive points,
     * defender's energy will decrease.
     * 
     * @param opponent   The character it fights against.
     */
    public void fight(Character opponent) {

        if(getAttackPoints() > opponent.getResistancePoints()) {
            opponent.setEnergy(opponent.getEnergy() - (getAttackPoints() - opponent.getResistancePoints()));
        }
        
        if(opponent.getEnergy() < 0.0)
            opponent.setEnergy(0.0);
    }

    @Override
    public String toString() {

        return "character:<" + getCharacterName() + " " + getCharacterSurname() + "> <e: " + getEnergy() +
               "> <o: " + getOffensive() + "> <d: " + getDefensive() + "> <wand: " + wand.toString() + ">";
    }
    
    @Override
    public boolean equals(Object object) {
    
        if(this == object)
            return true;
        if(!(object instanceof Character))
            return false;
        
        Character other = (Character)object;
            
        return (getCharacterName().equals(other.getCharacterName()) && getCharacterSurname().equals(other.getCharacterSurname()));
    }
}
