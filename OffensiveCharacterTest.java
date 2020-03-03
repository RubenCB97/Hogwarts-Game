
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class OffensiveCharacterTest.
 *
 * @author The Order of the Phoenix: Jorge Cancho Casado, Rubén Costa Barriga and Arturo Mejías Velasco
 * @version 10/01/2020
 */
public class OffensiveCharacterTest {
    
    private OffensiveCharacter HarryPotter;
    private OffensiveCharacter RonWeasley;
    private HawthornWandBehavior hawthorn1;
    private HollyWandBehavior hollyWan1;
    private Wand HarryW;
    private Wand RonW;

    /**
     * Default constructor for test class OffensiveCharacterTest
     */
    public OffensiveCharacterTest() {
        
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp() {
        
        HarryPotter = new OffensiveCharacter("Harry", "Potter");
        RonWeasley = new OffensiveCharacter("Ron", "Weasley");
        hawthorn1 = new HawthornWandBehavior();
        hollyWan1 = new HollyWandBehavior();
        HarryW = new Wand("HarryW", hawthorn1);
        RonW = new Wand("RonW", hollyWan1);
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
     * Tests for method getCharacterName.
     */
    @Test
    public void getCharacterNameTest() {
        
        assertEquals("Harry", HarryPotter.getCharacterName());
        assertEquals("Ron", RonWeasley.getCharacterName());
    }
    
    /**
     * Tests for method getCharacterSurname.
     */
    @Test
    public void getCharacterSurnameTest() {
        
        assertEquals("Potter", HarryPotter.getCharacterSurname());
        assertEquals("Weasley", RonWeasley.getCharacterSurname());
    }

    /**
     * Tests for method getEnergy.
     */
    @Test
    public void getEnergyTest() {
        
        assertEquals(20.0, HarryPotter.getEnergy(), 0.1);
        assertEquals(20.0, RonWeasley.getEnergy(), 0.1);
    }

    /**
     * Tests for method setEnergy.
     */
    @Test
    public void setEnergyTest() {
        
        HarryPotter.setEnergy(25.5);
        assertEquals(25.5, HarryPotter.getEnergy(), 0.1);
        RonWeasley.setEnergy(28.2);
        assertEquals(28.2, RonWeasley.getEnergy(), 0.1);
    }

    /**
     * Tests for method getOffensive.
     */
    @Test
    public void getOffensiveTest() {
        
        assertEquals(25.0, HarryPotter.getOffensive(), 0.1);
        assertEquals(25.0, RonWeasley.getOffensive(), 0.1);
    }

    /**
     * Tests for method setOffensive.
     */
    @Test
    public void setOffensiveTest() {
        
        HarryPotter.setOffensive(32.0);
        assertEquals(32.0, HarryPotter.getOffensive(), 0.1);
        RonWeasley.setOffensive(23.0);
        assertEquals(23.0, RonWeasley.getOffensive(), 0.1);
    }

    /**
     * Tests for method getDefensive.
     */
    @Test
    public void getDefensiveTest() {
        
        assertEquals(20.0, HarryPotter.getDefensive(), 0.1);
        assertEquals(20.0, RonWeasley.getDefensive(), 0.1);
    }

    /**
     * Tests for method setDefensive.
     */
    @Test
    public void setDefensiveTest() {
        
        HarryPotter.setDefensive(34.5);
        assertEquals(34.5, HarryPotter.getDefensive(), 0.1);
        RonWeasley.setDefensive(24.6);
        assertEquals(24.6, RonWeasley.getDefensive(), 0.1);
    }

    /**
     * Tests for method getWand.
     */
    @Test
    public void getWandTest() {
        
        assertEquals(null, HarryPotter.getWand());
        HarryPotter.assignWand(HarryW);
        Wand wand1 = HarryPotter.getWand();
        assertEquals(HarryPotter.getWand(), wand1);
        assertEquals(null, RonWeasley.getWand());
        RonWeasley.assignWand(RonW);
        Wand wand2 = RonWeasley.getWand();
        assertEquals(RonWeasley.getWand(), wand2);
    }

    /**
     * Tests for method assignWand.
     */
    @Test
    public void assignWandTest() {
        
        HarryPotter.assignWand(HarryW);
        Wand wand1 = HarryPotter.getWand();
        assertEquals(HarryPotter.getWand(), wand1);
        RonWeasley.assignWand(RonW);
        Wand wand2 = RonWeasley.getWand();
        assertEquals(RonWeasley.getWand(), wand2);
    }

    /**
     * Tests for method hasAWand.
     */
    @Test
    public void hasAWandTest() {
        
        assertEquals(false, HarryPotter.hasAWand());
        HarryPotter.assignWand(HarryW);
        assertEquals(true, HarryPotter.hasAWand());
        assertEquals(false, RonWeasley.hasAWand());
        RonWeasley.assignWand(RonW);
        assertEquals(true, RonWeasley.hasAWand());
    }

    /**
     * Tests for method getAttackPoints.
     */
    @Test
    public void getAttackPointsTest() {
        
        HarryPotter.assignWand(HarryW);
        RonWeasley.assignWand(RonW);
        assertEquals(47.0, HarryPotter.getAttackPoints(), 0.1);
        assertEquals(21.5, RonWeasley.getAttackPoints(), 0.1);
    }

    /**
     * Tests for method getResistancePoints.
     */
    @Test
    public void getResistancePointsTest() {
        
        HarryPotter.assignWand(HarryW);
        RonWeasley.assignWand(RonW);
        assertEquals(20.0, HarryPotter.getResistancePoints(), 0.1);
        assertEquals(40.0, RonWeasley.getResistancePoints(), 0.1);
    }

    /**
     * Tests for method fight.
     */
    @Test
    public void fightTest() {
        
        HarryPotter.assignWand(HarryW);
        RonWeasley.assignWand(RonW);
        assertEquals(47.0, HarryPotter.getAttackPoints(), 0.1);
        assertEquals(40.0, RonWeasley.getResistancePoints(), 0.1);
        assertEquals(20.0, RonWeasley.getEnergy(), 0.1);
        HarryPotter.fight(RonWeasley);
        assertEquals(13.0, RonWeasley.getEnergy(), 0.1);
    }

    /**
     * Tests for method toString.
     */
    @Test
    public void toStringTest() {
        
        HarryPotter.assignWand(HarryW);
        RonWeasley.assignWand(RonW);
        java.lang.String string1 = HarryPotter.toString();
        assertEquals(HarryPotter.toString(), string1);
        java.lang.String string2 = RonWeasley.toString();
        assertEquals(RonWeasley.toString(), string2);
    }
}
