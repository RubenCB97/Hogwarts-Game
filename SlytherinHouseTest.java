
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class SlytherinHouseTest.
 *
 * @author The Order of the Phoenix: Jorge Cancho Casado, Rubén Costa Barriga and Arturo Mejías Velasco
 * @version 10/01/2020
 */
public class SlytherinHouseTest {
    
    private OffensiveCharacter Harry;
    private DefensiveCharacter Ron;
    private OffensiveCharacter Hermione;
    private Slytherin Slytherin;

    /**
     * Default constructor for test class SlytherinHouseTest
     */ 
    public SlytherinHouseTest() {
        
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp() {
        
        Harry = new OffensiveCharacter("Harry", "Potter");
        Ron = new DefensiveCharacter("Ron", "Weasley");
        Hermione = new OffensiveCharacter("Hermione", "Granger");
        Slytherin = new Slytherin();
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
     * Tests for method addMember.
     */
    @Test
    public void addMemberTest() {
        
        assertEquals(0, Slytherin.getNumberOfMembers());
        Slytherin.addMember(Hermione);
        assertEquals(1, Slytherin.getNumberOfMembers());
        Slytherin.addMember(Harry);
        assertEquals(2, Slytherin.getNumberOfMembers());
        Slytherin.addMember(Ron);
        assertEquals(3, Slytherin.getNumberOfMembers());
    }

    /**
     * Tests for method removeMember.
     */
    @Test
    public void removeMemberTest() {
        
        Slytherin.addMember(Harry);
        Slytherin.addMember(Ron);
        assertEquals(2, Slytherin.getNumberOfMembers());
        Slytherin.removeMember(Ron);
        assertEquals(1, Slytherin.getNumberOfMembers());
        Slytherin.removeMember(Harry);
        assertEquals(0, Slytherin.getNumberOfMembers());
    }

    /**
     * Tests for method getHouseChaarcters.
     */
    @Test
    public void getHouseCharactersTest() {
        
        Slytherin.addMember(Hermione);
        Slytherin.addMember(Harry);
        Slytherin.addMember(Ron);
        java.util.ArrayList<Character> arrayLis1 = Slytherin.getHouseCharacters();
        assertEquals(Slytherin.getHouseCharacters(), arrayLis1);
    }

    /**
     * Tests for method getNumberOfMembers.
     */
    @Test
    public void getNumberOfMembersTest() {
        
        assertEquals(0, Slytherin.getNumberOfMembers());
        Slytherin.addMember(Ron);
        assertEquals(1, Slytherin.getNumberOfMembers());
        Slytherin.addMember(Harry);
        assertEquals(2, Slytherin.getNumberOfMembers());
        Slytherin.removeMember(Harry);
        assertEquals(1, Slytherin.getNumberOfMembers());
    }
    
    /**
     * Tests for method getMember.
     */
    @Test
    public void getMemberTest()
    {
        Slytherin.addMember(Ron);
        Slytherin.addMember(Harry);
        Slytherin.addMember(Hermione);
        Slytherin.sortMembers();
        assertEquals(Harry, Slytherin.getMember(1));
        assertEquals(Ron, Slytherin.getMember(2));
    }
    
    /**
     * Tests for method sortMembers.
     */
    @Test
    public void sortMembersTest() {
        
        Slytherin.addMember(Ron);
        Slytherin.addMember(Hermione);
        Slytherin.addMember(Harry);
        Slytherin.sortMembers();
        java.util.ArrayList<Character> arrayLis1 = Slytherin.getHouseCharacters();
        assertEquals(Slytherin.getHouseCharacters(), arrayLis1);
    }

    /**
     * Test method for getTotalEnergy.
     */
    @Test
    public void getTotalEnergyTest() {
        
        Slytherin.addMember(Hermione);
        Slytherin.addMember(Harry);
        Slytherin.addMember(Ron);
        assertEquals(60.0, Slytherin.getTotalEnergy(), 0.1);
        Slytherin.removeMember(Hermione);
        assertEquals(40.0, Slytherin.getTotalEnergy(), 0.1);
    }

    /**
     * Test method for getTotalOffensivePlusDefensive.
     */
    @Test
    public void getTotalOffensivePlusDefensiveTest() {
        
        Slytherin.addMember(Hermione);
        Slytherin.addMember(Harry);
        assertEquals(90.0, Slytherin.getTotalOffensivePlusDefensive(), 0.1);
        Slytherin.addMember(Ron);
        assertEquals(135.0, Slytherin.getTotalOffensivePlusDefensive(), 0.1);
    }
}
