    
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class HawthornWandBehaviorTest.
 *
 * @author The Order of the Phoenix: Jorge Cancho Casado, Rubén Costa Barriga and Arturo Mejías Velasco
 * @version 10/01/2020
 */
public class HawthornWandBehaviorTest {
    
    private HawthornWandBehavior hawthorn1;

    /**
     * Default constructor for test class HawthornWandBehaviorTest
     */
    public HawthornWandBehaviorTest() {
        
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp() {
        
        hawthorn1 = new HawthornWandBehavior();
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
     * Tests for method getAttackModifier.
     */
    @Test
    public void getAttackModifierTest() {
        
        assertEquals(1.4, hawthorn1.getAttackModifier(), 0.1);
    }

    /**
     * Tests for method getEnergyModifierA.
     */
    @Test
    public void getEnergyModifierATest() {
        
        assertEquals(0.6, hawthorn1.getEnergyModifierA(), 0.1);
    }

    /**
     * Tests for method getDefenseModifier.
     */
    @Test
    public void getDefensiveModifierTest() {
        
        assertEquals(0.2, hawthorn1.getDefenseModifier(), 0.1);
    }

    /**
     * Tests for method getEnergyModifierD.
     */
    @Test
    public void getEnergyModifierDTest() {
        
        assertEquals(0.8, hawthorn1.getEnergyModifierD(), 0.1);
    }
}
