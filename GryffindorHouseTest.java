
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class GryffindorHouseTest.
 *
 * @author The Order of the Phoenix: Jorge Cancho Casado, Rubén Costa Barriga and Arturo Mejías Velasco
 * @version 10/01/2020
 */
public class GryffindorHouseTest
{
    private OffensiveCharacter Harry;
    private DefensiveCharacter Ron;
    private OffensiveCharacter Hermione;
    private Gryffindor Gryffindor;

    /**
     * Default constructor for test class GryffindorHouseTest
     */
    public GryffindorHouseTest() {
        
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
        Gryffindor = new Gryffindor();
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
        
        assertEquals(0, Gryffindor.getNumberOfMembers());
        Gryffindor.addMember(Hermione);
        assertEquals(1, Gryffindor.getNumberOfMembers());
        Gryffindor.addMember(Harry);
        assertEquals(2, Gryffindor.getNumberOfMembers());
        Gryffindor.addMember(Ron);
        assertEquals(3, Gryffindor.getNumberOfMembers());
    }

    /**
     * Tests for method removeMember.
     */
    @Test
    public void removeMemberTest() {
        
        Gryffindor.addMember(Harry);
        Gryffindor.addMember(Ron);
        assertEquals(2, Gryffindor.getNumberOfMembers());
        Gryffindor.removeMember(Ron);
        assertEquals(1, Gryffindor.getNumberOfMembers());
        Gryffindor.removeMember(Harry);
        assertEquals(0, Gryffindor.getNumberOfMembers());
    }

    /**
     * Tests for method getHouseChaarcters.
     */
    @Test
    public void getHouseCharactersTest() {
        
        Gryffindor.addMember(Hermione);
        Gryffindor.addMember(Harry);
        Gryffindor.addMember(Ron);
        java.util.ArrayList<Character> arrayLis1 = Gryffindor.getHouseCharacters();
        assertEquals(Gryffindor.getHouseCharacters(), arrayLis1);
    }

    /**
     * Tests for method getNumberOfMembers.
     */
    @Test
    public void getNumberOfMembersTest() {
        
        assertEquals(0, Gryffindor.getNumberOfMembers());
        Gryffindor.addMember(Ron);
        assertEquals(1, Gryffindor.getNumberOfMembers());
        Gryffindor.addMember(Harry);
        assertEquals(2, Gryffindor.getNumberOfMembers());
        Gryffindor.removeMember(Harry);
        assertEquals(1, Gryffindor.getNumberOfMembers());
    }
    
    /**
     * Tests for method getMember.
     */
    @Test
    public void getMemberTest()
    {
        Gryffindor.addMember(Ron);
        Gryffindor.addMember(Harry);
        Gryffindor.addMember(Hermione);
        Gryffindor.sortMembers();
        assertEquals(Harry, Gryffindor.getMember(0));
        assertEquals(Ron, Gryffindor.getMember(2));
    }    

    /**
     * Tests for method sortMembers.
     */
    @Test
    public void sortMembersTest() {
        
        Gryffindor.addMember(Ron);
        Gryffindor.addMember(Hermione);
        Gryffindor.addMember(Harry);
        Gryffindor.sortMembers();
        java.util.ArrayList<Character> arrayLis1 = Gryffindor.getHouseCharacters();
        assertEquals(Gryffindor.getHouseCharacters(), arrayLis1);
    }  
    
    /**
     * Test method for getTotalEnergy.
     */
    @Test
    public void getTotalEnergyTest() {
        
        Gryffindor.addMember(Hermione);
        Gryffindor.addMember(Harry);
        Gryffindor.addMember(Ron);
        assertEquals(60.0, Gryffindor.getTotalEnergy(), 0.1);
        Gryffindor.removeMember(Hermione);
        assertEquals(40.0, Gryffindor.getTotalEnergy(), 0.1);
    }

    /**
     * Test method for getTotalOffensivePlusDefensive.
     */
    @Test
    public void getTotalOffensivePlusDefensiveTest() {
        
        Gryffindor.addMember(Hermione);
        Gryffindor.addMember(Harry);
        assertEquals(90.0, Gryffindor.getTotalOffensivePlusDefensive(), 0.1);
        Gryffindor.addMember(Ron);
        assertEquals(135.0, Gryffindor.getTotalOffensivePlusDefensive(), 0.1);
    }
}
