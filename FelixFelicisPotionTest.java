
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class FelixFelicisPotionTest.
 *
 * @author The Order of the Phoenix: Jorge Cancho Casado, Rubén Costa Barriga and Arturo Mejías Velasco
 * @version 10/01/2020
 */
public class FelixFelicisPotionTest {
    
    private OffensiveCharacter HarryP;
    private DefensiveCharacter RonW;

    /**
     * Default constructor for test class FelixFelicisPotionTest
     */
    public FelixFelicisPotionTest() {
        
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
     * Tests for method getOffensive.
     */
    @Test
    public void getOffensiveTest() {
        
        FelixFelicisPotion RonWFelicis = new FelixFelicisPotion(RonW);
        assertEquals(26.0, RonWFelicis.getOffensive(), 0.1);
        FelixFelicisPotion HarryPFelicis = new FelixFelicisPotion(HarryP);
        assertEquals(32.5, HarryPFelicis.getOffensive(), 0.1);
        FelixFelicisPotion HarryPFelicis2 = new FelixFelicisPotion(HarryPFelicis);
        assertEquals(42.25, HarryPFelicis2.getOffensive(), 0.1);
    }
}
