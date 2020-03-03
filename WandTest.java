
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class WandTest.
 *
 * @author The Order of the Phoenix: Jorge Cancho Casado, Rubén Costa Barriga and Arturo Mejías Velasco
 * @version 10/01/2020
 */
public class WandTest {
    
    private HawthornWandBehavior hawthorn1;
    private HollyWandBehavior hollyBeh1;
    private Wand wand1;
    private Wand wand2;

    /**
     * Default constructor for test class WandTest
     */
    public WandTest() {
        
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp() {
        
        hawthorn1 = new HawthornWandBehavior();
        hollyBeh1 = new HollyWandBehavior();
        wand1 = new Wand("Spruce", hawthorn1);
        wand2 = new Wand("Laurel", hollyBeh1);
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
     * Tests for method getWandName.
     */
    @Test
    public void getWandNameTest() {
        
        assertEquals("Spruce", wand1.getWandName());
        assertEquals("Laurel", wand2.getWandName());
    }

    /**
     * Tests for method getWandBehavior.
     */
    @Test
    public void getWandBehaviorTest() {
        
        assertEquals(hawthorn1, wand1.getBehavior());
        assertEquals(hollyBeh1, wand2.getBehavior());
    }

    /**
     * Tests for method getAttackModifier.
     */
    @Test
    public void getAttackModifierTest() {
        
        assertEquals(1.4, wand1.getAttackModifier(), 0.1);
        assertEquals(0.3, wand2.getAttackModifier(), 0.1);
    }

    /**
     * Tests for method getEnergyModifierA.
     */
    @Test
    public void getEnergyModifierATest() {
        
        assertEquals(0.6, wand1.getEnergyModifierA(), 0.1);
        assertEquals(0.7, wand2.getEnergyModifierA(), 0.1);
    }

    /**
     * Tests for method getDefenseModifier.
     */
    @Test
    public void getDefenseModifierTest() {
        
        assertEquals(0.2, wand1.getDefenseModifier(), 0.1);
        assertEquals(1.1, wand2.getDefenseModifier(), 0.1);
    }

    /**
     * Tests for method getEnergyModifierD.
     */
    @Test
    public void getEnergyModifierDTest() {
        
        assertEquals(0.8, wand1.getEnergyModifierD(), 0.1);
        assertEquals(0.9, wand2.getEnergyModifierD(), 0.1);
    }

    /**
     * Tests for method toString.
     */
    @Test
    public void toStringTest()
    {
        java.lang.String string1 = wand2.toString();
        assertEquals(wand2.toString(), string1);
        java.lang.String string2 = wand1.toString();
        assertEquals(wand1.toString(), string2);
    }
}
