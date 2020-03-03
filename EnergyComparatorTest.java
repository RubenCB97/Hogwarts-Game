
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class EnergyComparatorTest.
 *
 * @author The Order of the Phoenix: Jorge Cancho Casado, Rubén Costa Barriga and Arturo Mejías Velasco
 * @version 10/01/2020
 */
public class EnergyComparatorTest {
    
    private OffensiveCharacter harry;
    private DefensiveCharacter ron;
    private OffensiveCharacter hermione;
    private EnergyComparator energyCo1;

    /**
     * Default constructor for test class EnergyComparatorTest
     */
    public EnergyComparatorTest() {
        
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp() {
        
        harry = new OffensiveCharacter("Harry", "Potter");
        ron = new DefensiveCharacter("Ron", "Weasley");
        hermione = new OffensiveCharacter("Hermione", "Granger");
        energyCo1 = new EnergyComparator();
        hermione.setEnergy(28.0);
        ron.setEnergy(23.2);
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
     * Tests for method compare.
     */
    @Test
    public void compareTest() {
        
        assertEquals(1, energyCo1.compare(hermione, ron));
        assertEquals(-1, energyCo1.compare(harry, ron));
        assertEquals(0, energyCo1.compare(harry, harry));
    }
}

