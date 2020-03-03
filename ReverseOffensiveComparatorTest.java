
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ReverseOffensiveComparatorTest.
 *
 * @author The Order of the Phoenix: Jorge Cancho Casado, Rubén Costa Barriga and Arturo Mejías Velasco
 * @version 10/01/2020
 */
public class ReverseOffensiveComparatorTest {
    
    private OffensiveCharacter harry;
    private DefensiveCharacter ron;
    private OffensiveCharacter hermione;
    private ReverseOffensiveComparator reverseOff1;

    /**
     * Default constructor for test class EnergyComparatorTest
     */
    public ReverseOffensiveComparatorTest() {
        
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
        reverseOff1 = new ReverseOffensiveComparator();
        harry.setOffensive(28.0);
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
        
        assertEquals(-1, reverseOff1.compare(hermione, ron));
        assertEquals(1, reverseOff1.compare(hermione, harry));
        assertEquals(0, reverseOff1.compare(harry, harry));
    }
}
