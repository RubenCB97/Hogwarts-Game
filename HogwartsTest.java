
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class HogwartsTest.
 *
 * @author The Order of the Phoenix: Jorge Cancho Casado, Rubén Costa Barriga and Arturo Mejías Velasco
 * @version 10/01/2020
 */
public class HogwartsTest {
    
    private Hogwarts hogwarts;
    
    /**
     * Default constructor for test class HogwartsTest
     */
    public HogwartsTest() {
        
        hogwarts = Hogwarts.getInstance();
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp() {
        
        // New wands
        //-----------------------
        hogwarts.newWand(new Wand("Ivy", new HawthornWandBehavior()));
        hogwarts.newWand(new Wand("Larch",new HawthornWandBehavior()));
        hogwarts.newWand(new Wand("Rowan", new HollyWandBehavior()));
        
        
        
        // Gryffindor's characters
        //-----------------------------
        House gryffindor = new Gryffindor();

        Character harry = new OffensiveCharacter("Harry", "Potter");
        harry.assignWand(new Wand("HarryW", new HawthornWandBehavior()));
        harry = new InvigorationPotion(harry);
        harry = new FelixFelicisPotion(harry);

        Character hermione = new DefensiveCharacter("Hermione", "Granger");
        hermione.assignWand(new Wand("HermioneW", new HollyWandBehavior()));
        hermione = new InvigorationPotion(hermione);
        
        gryffindor.addMember(harry);
        gryffindor.addMember(hermione);
        gryffindor.sortMembers();

        hogwarts.newHouse(gryffindor);
        
        
        
        // Hufflepuff's characters
        //------------------------------
        House hufflepuff = new Hufflepuff();

        Character cedric = new DefensiveCharacter("Cedric", "Diggory");
        cedric.assignWand(new Wand("CedricW", new HawthornWandBehavior()));
        cedric = new InvigorationPotion(cedric);

        Character nymphadora = new DefensiveCharacter("Nymphadora", "Tonks");
        nymphadora.assignWand(new Wand("NymphadoraW", new HawthornWandBehavior()));
        
        hufflepuff.addMember(cedric);
        hufflepuff.addMember(nymphadora);
        hufflepuff.sortMembers();
        
        hogwarts.newHouse(hufflepuff);
        
        
        
        // Slytherin's characters
        //------------------------------
        House slytherin = new Slytherin();
        Character draco = new DefensiveCharacter("Draco", "Malfoy");
        draco.assignWand(new Wand("DracoW", new HollyWandBehavior()));

        Character dolores = new OffensiveCharacter("Dolores", "Umbridge");
        dolores.assignWand(new Wand("DoloresW", new HollyWandBehavior()));
        
        slytherin.addMember(draco);
        slytherin.addMember(dolores);
        slytherin.sortMembers();
        
        hogwarts.newHouse(slytherin);
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown() {
        
    }
    
    /**
     * Testing Hogwarts class behavior. Returns the results of a two turns
     * simulation. 
     * If everything works ok, the information shown on the terminal should match the
     * information of the following file: "hogwartsTest.txt".
     */
    @Test
    public void hogwartsTest() {
        
        int turnNumber = 0;                          // define the current turn number
        int totalTurns = 2;                          // define the total number of turns
        boolean endSimulation = false;               // define the end of the simulation
    
        StringBuilder out = new StringBuilder();

        out.append(hogwarts.toStringHousesCollection() + '\n');
        out.append(hogwarts.toStringWandsCollection() + '\n');
        
        while(turnNumber < totalTurns && !endSimulation) {
            out.append("turn: <" + turnNumber + ">\n");
            hogwarts.getDuelingCharacters();
            out.append(hogwarts.toStringDuelingCharacters() + '\n');
            out.append(hogwarts.duel() + '\n');
            out.append(hogwarts.removeDuelingCharacters() + '\n');
            if(hogwarts.checkEndSimulation())
                endSimulation = true;
            turnNumber++; 
        }
        
        out.append("end of the simulation:\n");
        out.append("----------------------");
        
        out.append(hogwarts.toStringHousesCollection() + '\n');
        out.append(hogwarts.toStringWandsCollection() + '\n');
        
        out.append("the winner house is:\n");
        out.append("--------------------");
        
        out.append(hogwarts.checkWhoWon(endSimulation));

        System.out.println(out);
    }
}
