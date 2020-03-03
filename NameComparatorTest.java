
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class NameComparatorTest.
 *
 * @author The Order of the Phoenix: Jorge Cancho Casado, Rubén Costa Barriga and Arturo Mejías Velasco
 * @version 10/01/2020
 */
public class NameComparatorTest {
    
    private HawthornWandBehavior hawthorn1;
    private HollyWandBehavior hollyWan1;
    private HollyWandBehavior hollyWan2;
    private Wand wand1;
    private Wand wand2;
    private Wand wand3;
    private NameComparator nameComp1;
 
    /**
     * Default constructor for test class NameComparatorTest
     */
    public NameComparatorTest() {
        
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp() {
        hawthorn1 = new HawthornWandBehavior();
        hollyWan1 = new HollyWandBehavior();
        hollyWan2 = new HollyWandBehavior();
        wand1 = new Wand("Spruce", hollyWan1);
        wand2 = new Wand("Oak", hollyWan2);
        wand3 = new Wand("Laurel", hawthorn1);
        nameComp1 = new NameComparator();
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
        
        assertEquals(0, nameComp1.compare(wand2, wand2));
        assertEquals(7, nameComp1.compare(wand1, wand3));
    }
}

