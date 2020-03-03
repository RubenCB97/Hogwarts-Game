
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class HufflepuffHouseTest.
 *
 * @author The Order of the Phoenix: Jorge Cancho Casado, Rubén Costa Barriga and Arturo Mejías Velasco
 * @version 10/01/2020
 */
public class HufflepuffHouseTest {

    private OffensiveCharacter Harry;
    private DefensiveCharacter Ron;
    private OffensiveCharacter Hermione;
    private Hufflepuff Hufflepuff;

    /**
     * Default constructor for test class HufflepuffHouseTest
     */
    public HufflepuffHouseTest() {

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
        Hufflepuff = new Hufflepuff();
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

        assertEquals(0, Hufflepuff.getNumberOfMembers());
        Hufflepuff.addMember(Hermione);
        assertEquals(1, Hufflepuff.getNumberOfMembers());
        Hufflepuff.addMember(Harry);
        assertEquals(2, Hufflepuff.getNumberOfMembers());
        Hufflepuff.addMember(Ron);
        assertEquals(3, Hufflepuff.getNumberOfMembers());
    }

    /**
     * Tests for method removeMember.
     */
    @Test
    public void removeMemberTest() {

        Hufflepuff.addMember(Harry);
        Hufflepuff.addMember(Ron);
        assertEquals(2, Hufflepuff.getNumberOfMembers());
        Hufflepuff.removeMember(Ron);
        assertEquals(1, Hufflepuff.getNumberOfMembers());
        Hufflepuff.removeMember(Harry);
        assertEquals(0, Hufflepuff.getNumberOfMembers());
    }

    /**
     * Tests for method getHouseChaarcters.
     */
    @Test
    public void getHouseCharactersTest() {

        Hufflepuff.addMember(Hermione);
        Hufflepuff.addMember(Harry);
        Hufflepuff.addMember(Ron);
        java.util.ArrayList<Character> arrayLis1 = Hufflepuff.getHouseCharacters();
        assertEquals(Hufflepuff.getHouseCharacters(), arrayLis1);
    }

    /**
     * Tests for method getNumberOfMembers.
     */
    @Test
    public void getNumberOfMembersTest() {

        assertEquals(0, Hufflepuff.getNumberOfMembers());
        Hufflepuff.addMember(Ron);
        assertEquals(1, Hufflepuff.getNumberOfMembers());
        Hufflepuff.addMember(Harry);
        assertEquals(2, Hufflepuff.getNumberOfMembers());
        Hufflepuff.removeMember(Harry);
        assertEquals(1, Hufflepuff.getNumberOfMembers());
    }
    
    /**
     * Tests for method getMember.
     */
    @Test
    public void getMemberTest()
    {
        Hufflepuff.addMember(Ron);
        Hufflepuff.addMember(Harry);
        Hufflepuff.addMember(Hermione);
        Hufflepuff.sortMembers();
        assertEquals(Harry, Hufflepuff.getMember(1));
        assertEquals(Ron, Hufflepuff.getMember(0));
    }

    /**
     * Tests for method sortMembers.
     */
    @Test
    public void sortMembersTest() {

        Hufflepuff.addMember(Ron);
        Hufflepuff.addMember(Hermione);
        Hufflepuff.addMember(Harry);
        Hufflepuff.sortMembers();
        java.util.ArrayList<Character> arrayLis1 = Hufflepuff.getHouseCharacters();
        assertEquals(Hufflepuff.getHouseCharacters(), arrayLis1);
    }
    
    /**
     * Test method for getTotalEnergy.
     */
    @Test
    public void getTotalEnergyTest() {
        
        Hufflepuff.addMember(Hermione);
        Hufflepuff.addMember(Harry);
        Hufflepuff.addMember(Ron);
        assertEquals(60.0, Hufflepuff.getTotalEnergy(), 0.1);
        Hufflepuff.removeMember(Hermione);
        assertEquals(40.0, Hufflepuff.getTotalEnergy(), 0.1);
    }

    /**
     * Test method for getTotalOffensivePlusDefensive.
     */
    @Test
    public void getTotalOffensivePlusDefensiveTest() {
        
        Hufflepuff.addMember(Hermione);
        Hufflepuff.addMember(Harry);
        assertEquals(90.0, Hufflepuff.getTotalOffensivePlusDefensive(), 0.1);
        Hufflepuff.addMember(Ron);
        assertEquals(135.0, Hufflepuff.getTotalOffensivePlusDefensive(), 0.1);
    }
}
