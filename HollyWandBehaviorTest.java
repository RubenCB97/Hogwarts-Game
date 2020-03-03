
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class HollyWandBehaviorTest.
 *
 * @author The Order of the Phoenix: Jorge Cancho Casado, Rubén Costa Barriga and Arturo Mejías Velasco
 * @version 10/01/2020
 */
public class HollyWandBehaviorTest {

    private HollyWandBehavior hollyBeh1;

    /**
     * Default constructor for test class HollyBehaviorTest
     */
    public HollyWandBehaviorTest() {

    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp() {
        
        hollyBeh1 = new HollyWandBehavior();
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
        
        assertEquals(0.3, hollyBeh1.getAttackModifier(), 0.1);
    }

    /**
     * Tests for method getEnergyModifierA.
     */
    @Test
    public void getEnergyModifierATest() {
        
        assertEquals(0.7, hollyBeh1.getEnergyModifierA(), 0.1);
    }

    /**
     * Tests for method getDefenseModifier.
     */
    @Test
    public void getDefensiveModifierTest() {
        
        assertEquals(1.1, hollyBeh1.getDefenseModifier(), 0.1);
    }

    /**
     * Tests for method getEnergyModifierD.
     */
    @Test
    public void getEnergyModifierDTest() {
        
        assertEquals(0.9, hollyBeh1.getEnergyModifierD(), 0.1);
    }
}
