import java.util.Collections;
import java.util.ArrayList;

/**
 * This class stores information about a house to which characters belong.
 * 
 * @author The Order of the Phoenix: Jorge Cancho Casado, Rubén Costa Barriga and Arturo Mejías Velasco
 * @version 10/01/2020
 */
public abstract class House {

    private ArrayList <Character> houseCharacters;   // collection of every character that belongs to the house

    /**
     * Constructor for objects of class House.
     */
    public House() {

        this.houseCharacters = new ArrayList <Character>();
    }   

    /**
     * Adds a new member to the house.
     * 
     * @param character   New member of the house.
     */
    public void addMember(Character character) {

        this.houseCharacters.add(character);
    }

    /**
     * Removes a character from the collection.
     * 
     * @param character   The member that is going to get removed.
     */
    public void removeMember(Character character) {

        this.houseCharacters.remove(character);
    }

    /**
     * Returns the collection where every character of the house is stored.
     * 
     * @return ArrayList <Character> - The collection where every character of the house is stored.
     */
    public ArrayList <Character> getHouseCharacters() {

        return this.houseCharacters;
    }

    /**
     * Returns the number of members of the house.
     * 
     * @return int - Number of members of the house.
     */
    public int getNumberOfMembers() {

        return this.houseCharacters.size();
    }

    /**
     * Returns the member of the house who occupies the position corresponding
     * to the index value.
     * 
     * @param index        Position of the member in the collection.
     * @return Character - First member of the house.
     */
    public Character getMember(int index) {

        return this.houseCharacters.get(index);
    }

    /**
     * Returns the sum of characters' energy points.
     * 
     * @return double - Sum of characters' energy points.
     */
    public double getTotalEnergy() {

        double total = 0.00;

        for(Character character : houseCharacters) {
            total = total + character.getEnergy();
        }

        return total;
    }

    /**
     * Returns the sum of characters' offensive and defensive points.
     * 
     * @return double - Sum of characters' offensive and defensive points.
     */
    public double getTotalOffensivePlusDefensive() {

        double total = 0.00;

        for(Character character : houseCharacters) {
            total = total + character.getOffensive() + character.getDefensive();
        }

        return total;
    }
    
        /**
     * Returns true if the character belongs to the house or false if it doesn't.
     * 
     * @param  character   The character we are looking for.
     * @return boolean - True if the character belongs to the house, false it it doesn't.
     */
    public synchronized boolean searchCharacterHouse(Character character) {

        int index = 0;
        boolean found = false; 

        while(index < getNumberOfMembers() && !found) {
            Character ch = getMember(index);
            if(character.equals(ch))
                found = true;
            else
                index++;
        }

        return found;
    }

    /**
     * Sorts every member that belongs to the house according to a certain criteria.
     */
    public abstract void sortMembers();

    @Override
    public String toString() {

        StringBuilder str = new StringBuilder();

        if(getNumberOfMembers() > 0) {
            for(Character character : houseCharacters) {
                str.append(character.toString() + '\n');
            }
        }
        else
            str.append("");

        return str.toString();
    }

    @Override
    public boolean equals(Object object) {

        if(this == object)
            return true;
        if(!(object instanceof House))
            return false;

        House other = (House)object;

        return getClass().getSimpleName().equals(other.getClass().getSimpleName());
    }
}
