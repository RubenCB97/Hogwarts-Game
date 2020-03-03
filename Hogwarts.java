import java.util.Collections;
import java.util.Map;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;

/**
 * This class stores information about Hogwarts.
 * It contains different collections to store Hogwart's houses, characters that 
 * are going to duel, generic wands and characters with no energy points left.
 *
 * @author The Order of the Phoenix: Jorge Cancho Casado, Rubén Costa Barriga and Arturo Mejías Velasco
 * @version 10/01/2020
 */
public class Hogwarts {

    // static members
    private static Hogwarts instance;

    // instance variables
    private HashMap <String, House> housesCollection;   // collection where houses are stored
    private ArrayList <Character> duelingCharacters;    // collection where characters that are about to duel are stored 
    private TreeSet <Wand> wandsCollection;             // collection of every wand in the simulation
    private ArrayList <Character> dungeon;              // collection where characters that have no energy points left are stored

    /**
     * Constructor for objects of class Hogwarts. 
     */
    private Hogwarts() {

        housesCollection = new HashMap <String, House>();
        duelingCharacters = new ArrayList <Character>();
        wandsCollection = new TreeSet <Wand>(new NameComparator());
        dungeon = new ArrayList <Character>();
    }

    public synchronized static Hogwarts getInstance() {

        if(instance == null)
            instance = new Hogwarts();

        return instance;
    }

    /**
     * Adds a new house to the collection.
     * 
     * @param House   The house that is going to be added to the collection.
     */
    public synchronized void newHouse(House house) {

        this.housesCollection.put(house.getClass().getSimpleName(), house);
    }

    /**
     * Adds a new house to the collection.
     * 
     * @param wand   The wand that is going to be added to the collection.
     */
    public synchronized void newWand(Wand wand) {

        this.wandsCollection.add(wand);
    }

    /**
     * Removes a wand from the collection.
     * 
     * @param wand   The wand that is going to get removed from the collection.
     */
    public synchronized void removeWandFromCollection(Wand wand) {

        this.wandsCollection.remove(wand);
    }

    /**
     * Returns the first wand of the collection.
     * 
     * @return Wand - First wand of the collection.
     */
    public synchronized Wand getWandFromCollection() {

        Wand wand = this.wandsCollection.first();
        removeWandFromCollection(wand);
        return wand;
    }

    /**
     * Assigns a new wand to a character as long as wandsCollection is not empty.
     * 
     * @param character   The character that is going to receive a new wand.
     */
    public synchronized void changeWand(Character character) {

        character.assignWand(getWandFromCollection());
    }

    /**
     * Returns true if wandsCollection is empty and false if it isn't.
     * 
     * @return boolean - True if empty, false if not.
     */
    public synchronized boolean wandsCollectionIsEmpty() {

        if(this.wandsCollection.size() == 0)
            return true;

        return false;
    }

    /**
     * Adds a new character to the duelingCharacters collection.
     * 
     * @param character   The character that is going to be added.
     */
    public synchronized void newDuelingCharacter(Character character) {

        this.duelingCharacters.add(character);
        sortDuelingCharacters();
    }

    /**
     * Sorts duelingCharacters' information based on their energy.
     */
    public synchronized void sortDuelingCharacters() {

        Collections.sort(this.duelingCharacters, new EnergyComparator());
    }

    /**
     * Returns the character that occupies the position indicated by index.
     * 
     * @param index        Position of a character in the collection.
     * @return Character - The character that occupies the position of index.   
     */
    public synchronized Character getDuelingCharacter(int index) {

        return this.duelingCharacters.get(index);
    }

    /**
     * Returns the number of character that exist in the duelingCharacters collection.
     * 
     * @return int - Number of characters in the collection.
     */
    public synchronized int getNumberOfDuelingCharacters() {

        return this.duelingCharacters.size();
    }

    /**
     * Sends a character to the dungeon.
     * 
     * @param character   The character sent to the dungeon.
     */
    public synchronized void sendToDungeon(Character character) {

        this.dungeon.add(character);
    }

    /**
     * Adds one different character per house to the duelingCharacters collection.
     */
    public synchronized void getDuelingCharacters() {

        Iterator it = housesCollection.entrySet().iterator();

        while(it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            House house = (House)pair.getValue();
            if(house != null && house.getNumberOfMembers() > 0) {
                newDuelingCharacter(house.getMember(0));
            }
        }
    }

    /**
     * Returns the house to which the character belongs.
     * 
     * @param  character   The character we are looking for.
     * @return House - The house in which we are looking for the character.
     */
    public synchronized House searchCharacterHouse(Character character) {

        boolean found = false;
        House house = null;

        Iterator it = housesCollection.entrySet().iterator();

        while(it.hasNext() && !found) {
            Map.Entry pair = (Map.Entry)it.next();
            house = (House)pair.getValue();
            if(house != null && house.getNumberOfMembers() > 0 && house.searchCharacterHouse(character)) {
                found = true;
            }
        }

        return house;
    }

    /**
     * Removes every character from the duelingCharacters collection returning 
     * them to their respective houses. If a character has no energy points left,
     * it sends it to the dungeon.
     * It also returns the information of what happens to every character after dueling
     * as a String.
     * 
     * @return String - The information that is going to be shown. 
     */
    public synchronized String removeDuelingCharacters() {

        StringBuilder str = new StringBuilder();
        Iterator <Character> it = duelingCharacters.iterator();

        str.append("duel results:\n");
        str.append("-------------\n");

        while(it.hasNext()) {
            Character character = it.next();
            House house = searchCharacterHouse(character);
            house.removeMember(character);
            if(character.getEnergy() <= 0) {
                sendToDungeon(character);
                it.remove();
                str.append(toStringSendToDungeon(character));
            }
            else {
                str.append(toStringReturnToHouse(character));
                if(!wandsCollectionIsEmpty()) {
                    changeWand(character);
                    str.append(toStringNewWandAssigned(character.getWand()));
                }
                house.addMember(character);
                it.remove(); 
            }
        }  

        return str.toString();
    }

    /**
     * Makes every character in the duelingCharacters collection fight each other.
     * It also returns the information of each duel as a String.
     * 
     * @return String - The information that is going to be shown.
     */
    public synchronized String duel() {

        StringBuilder str = new StringBuilder();

        str.append("\nduels:\n");
        str.append("------\n");

        for(int i = 0; i < getNumberOfDuelingCharacters(); i++) {
            Character character1 = getDuelingCharacter(i);
            for(int j = 0; j < getNumberOfDuelingCharacters(); j++) {
                Character character2 = getDuelingCharacter(j);
                if(!character1.equals(character2)) {
                    str.append(toStringFightAgainst(character1, character2));
                    if(character1.getEnergy() > 0 && character2.getEnergy() > 0) {
                        str.append(toStringBeforeDuel(character1, character2));
                        character1.fight(character2);
                        str.append(toStringAfterDuel(character2));
                    }
                }
            }
        }

        return str.toString();
    }

    /**
     * Checks if there are two or more houses with no characters in them.
     * 
     * @return boolean - True if we have to end the simulation, false if we don't have to.
     */
    public synchronized boolean checkEndSimulation() {

        int index = 0;

        for(Map.Entry <String, House> entry : housesCollection.entrySet()) {
            if(entry.getValue().getNumberOfMembers() == 0)
                index++;
        }

        if(index >= 2)
            return true;
        else
            return false;
    }

    /**
     * Checks which house won the simulation and converts its information into a String.
     * 
     * @param end   It is used to know if the simulation ended by reaching the limit of
     *              turns or not.
     * @return - The information of the house that won the simulation.
     */
    public synchronized String checkWhoWon(boolean end) {

        StringBuilder str = new StringBuilder();

        if(end) {
            for(Map.Entry <String, House> entry : housesCollection.entrySet()) {
                if(entry.getValue().getNumberOfMembers() != 0) {
                    str.append("\nhouse:<" + entry.getKey() + ">\n");
                    str.append(entry.getValue().toString());
                }
            }
        }
        else {
            ArrayList <House> possibleHouses = new ArrayList <House>();
            for(Map.Entry <String, House> entry : housesCollection.entrySet()) {
                if(entry.getValue().getNumberOfMembers() > 0) {
                    possibleHouses.add(entry.getValue());
                }
            }
            
            possibleHouses = checkNumberOfMembers(possibleHouses);
            possibleHouses = checkHouseMostEnergy(possibleHouses);
            possibleHouses = checkHouseOffensiveDefensive(possibleHouses);
            
            str.append("\nhouse:<" + possibleHouses.get(0).getClass().getSimpleName() + ">\n");
            str.append(possibleHouses.get(0).toString());
        }
        
        return str.toString();
    }
    
    /**
     * Checks which house has the most members and returns it.
     * 
     * @param  possibleHouses      Collection with every house with a chance to win.
     * @return ArrayList <House> - A collection with every house with a chance to win.
     */
    public synchronized ArrayList <House> checkNumberOfMembers(ArrayList <House> possibleHouses) {
        
        if(possibleHouses.size() > 1) {
            
            House bestHouse = null;
            
            for(int index = 0; index < possibleHouses.size() - 1; index++ ) {
                bestHouse = possibleHouses.get(index);
                if(bestHouse.getNumberOfMembers() < possibleHouses.get(index + 1).getNumberOfMembers())
                    bestHouse = possibleHouses.get(index + 1);
            }
            
            Iterator <House> it = possibleHouses.iterator();
            
            while(it.hasNext()) {
                House house = it.next();
                if(!(house.equals(bestHouse))) {
                    if(house.getNumberOfMembers() < bestHouse.getNumberOfMembers()) {
                        it.remove();
                    }
                }    
            }
        }
        
        return possibleHouses;
    }
    
    /**
     * Returns the house whose characters have more energy points in total.
     * 
     * @param  possibleHouses      Collection with every house with a chance to win.
     * @return ArrayList <House> - A collection with every house with a chance to win.
     */
    public synchronized ArrayList <House> checkHouseMostEnergy(ArrayList <House> possibleHouses) {
    
        if(possibleHouses.size() > 1) {
            
            House bestHouse = null;
            
            for(int index = 0; index < possibleHouses.size() - 1; index++ ) {
                bestHouse = possibleHouses.get(index);
                if(bestHouse.getTotalEnergy() < possibleHouses.get(index + 1).getTotalEnergy())
                    bestHouse = possibleHouses.get(index + 1);
            }
            
            Iterator <House> it = possibleHouses.iterator();
            
            while(it.hasNext()) {
                House house = it.next();
                if(!(house.equals(bestHouse))) {
                    if(house.getTotalEnergy() < bestHouse.getTotalEnergy()) {
                        it.remove();
                    }
                }    
            }
        }
        
        return possibleHouses;
    }
    
    /**
     * Returns the house whose characters have less defensive and offensive points in total.
     * 
     * @param  possibleHouses      Collection with every house with a chance to win.
     * @return ArrayList <House> - A collection with every house with a chance to win.
     */
    public synchronized ArrayList <House> checkHouseOffensiveDefensive(ArrayList <House> possibleHouses) {
    
        
        if(possibleHouses.size() > 1) {
            
            House bestHouse = null;
            
            for(int index = 0; index < possibleHouses.size() - 1; index++ ) {
                bestHouse = possibleHouses.get(index);
                if(bestHouse.getTotalOffensivePlusDefensive() < possibleHouses.get(index + 1).getTotalOffensivePlusDefensive())
                    bestHouse = possibleHouses.get(index + 1);
            }
            
            Iterator <House> it = possibleHouses.iterator();
            
            while(it.hasNext()) {
                House house = it.next();
                if(!(house.equals(bestHouse))) {
                    if(house.getTotalOffensivePlusDefensive() < bestHouse.getTotalOffensivePlusDefensive()) {
                        it.remove();
                    }
                }    
            }
        }
        
        return possibleHouses;
    }

    /**
     * Converts housesCollection's information into a String.
     * 
     * @return String - The information that is going to be shown.
     */
    public synchronized String toStringHousesCollection() {

        StringBuilder str = new StringBuilder();

        str.append("\nhouses:\n");
        str.append("-------");

        for(Map.Entry <String, House> entry : housesCollection.entrySet()) {
            str.append("\nhouse:<" + entry.getKey() + ">\n");
            if(entry.getValue().getNumberOfMembers() > 0)
                str.append(entry.getValue().toString());
        }

        return str.toString();
    }

    /**
     * Converts wandsCollection's information into a String.
     * 
     * @return synchronized String - The information that is going to be shown.
     */
    public synchronized String toStringWandsCollection() {

        StringBuilder str = new StringBuilder();

        str.append("new wands:\n");
        str.append("-----------\n");

        if(!wandsCollectionIsEmpty()) {
            for(Wand wand : wandsCollection) {
                str.append("wand: <" + wand.toString()  + ">" + '\n');
            }
        }
        else
            str.append("");

        return str.toString();
    }

    /**
     * Converts duelingCharacter's information into a String.
     * 
     * @return synchronized String - The information that is going to be shown.
     */
    public synchronized String toStringDuelingCharacters() {

        StringBuilder str = new StringBuilder();

        str.append("characters who are going to duel:\n");
        str.append("---------------------------------\n");

        for (Character character : duelingCharacters) {
            str.append(character.toString() + '\n');
        }

        return str.toString();
    }

    /**
     * Converts dungeon's information into a String.
     * 
     * @return String - The information that is going to be shown.
     */
    public synchronized String toStringDungeon() {

        StringBuilder str = new StringBuilder();

        str.append("dungeon characters:\n");
        str.append("-------------------\n");
        for (Character character : dungeon) {
            str.append(character.toString() + '\n');
        }

        return str.toString();
    }

    /**
     * Converts characters' information before dueling into a String.
     * 
     * @param character1   The attacking character.
     * @param character2   The defending character.
     * @return String - The information that is going to be shown.
     */
    public synchronized String toStringFightAgainst(Character character1,Character character2) {

        return("<" + character1.getCharacterName() + " " + character1.getCharacterSurname() +
            "> is dueling against <" + character2.getCharacterName() + " " + character2.getCharacterSurname() + ">\n");
    }

    /**
     * Converts characters' information before dueling into a String.
     * 
     * @param character1   the attacking character.
     * @param character2   The defending character.
     * @return String - The information that is going to be shown.
     */
    public synchronized String toStringBeforeDuel(Character character1,Character character2) {

        StringBuilder str = new StringBuilder();

        str.append("attack points of <" + character1.getCharacterName() + " " +
                   character1.getCharacterSurname() + "> are: <" + character1.getAttackPoints() + ">\n");

        str.append("resistance points of <" + character2.getCharacterName() + " " +
                   character2.getCharacterSurname() + "> are: <" + character2.getResistancePoints() + ">\n");

        return str.toString();
    } 

    /**
     * Converts defending character's information after dueling into a String.
     * 
     * @param character   The defending character. 
     * @return String - The information that is going to be shown.
     */
    public synchronized String toStringAfterDuel(Character character) {

        return("the remaining energy of <" + character.getCharacterName() + " " + character.getCharacterSurname() + 
               "> after the duel are: <" + character.getEnergy() + ">\n\n");
    }

    /**
     * 
     * @param  character   The character sent to the dungeon.
     * @return String - The information that is going to be shown.
     */
    public synchronized String toStringSendToDungeon(Character character) {

        return (character.toString() + " goes to dungeon\n");
    }

    /**
     * Returns a String that contains information about the character telling
     * it is returning to the house it belongs.
     * 
     * @param  character   The returning character.
     * @return String - The information that is going to be shown.
     */
    public synchronized String toStringReturnToHouse(Character character) {

        return (character.toString() + " returns to the house\n");
    }

    /**
     * Returns a String that contains information about the new wand assigned.
     * 
     * @param  wand     The assigned wand.
     * @return String - The information we want to show.
     */
    public synchronized String toStringNewWandAssigned(Wand wand) {

        return ("new wand assigned: <" + wand.toString() + ">\n");
    }
}