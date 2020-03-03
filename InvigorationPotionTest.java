
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class InvigorationPotionTest.
 *
 * @author The Order of the Phoenix: Jorge Cancho Casado, Rubén Costa Barriga and Arturo Mejías Velasco
 * @version 10/01/2020
 */
public class InvigorationPotionTest {
    
    private OffensiveCharacter HarryP;
    private DefensiveCharacter RonW;

    /**
     * Default constructor for test class InvigorationPotionTest
     */
    public InvigorationPotionTest() {
        
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp() {
        
        HarryP = new OffensiveCharacter("Harry", "Potter");
        RonW = new DefensiveCharacter("Ron", "Weasley");
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
     * Tests for method getDefense.
     */
    @Test
    public void getDefenseTest() {
        
        InvigorationPotion RonWInvigoration = new InvigorationPotion(RonW);
        assertEquals(35.0, RonWInvigoration.getDefensive(), 0.1);
        InvigorationPotion HarryPInvigoration = new InvigorationPotion(HarryP);
        assertEquals(28.0, HarryPInvigoration.getDefensive(), 0.1);
        InvigorationPotion RonWInvigoration2 = new InvigorationPotion(RonWInvigoration);
        assertEquals(49.0, RonWInvigoration2.getDefensive(), 0.1);
    }
}
