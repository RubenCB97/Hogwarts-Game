import java.util.Collections;

/**
 * This class corresponds to the Hufflepuff house.
 *
 * @author The Order of the Phoenix: Jorge Cancho Casado, Rubén Costa Barriga and Arturo Mejías Velasco
 * @version 10/01/2020
 */
public class Hufflepuff extends House {
    
    @Override
    public void sortMembers() {
    
        Collections.sort(super.getHouseCharacters(), new OffensiveComparator());
    }
}
