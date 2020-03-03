import java.util.Comparator;

/**
 * This class compares the names of two different characters.
 *
 * @author The Order of the Phoenix: Jorge Cancho Casado, Rubén Costa Barriga and Arturo Mejías Velasco
 * @version 10/01/2020
 */
public class NameComparator implements Comparator <Wand> {
    
    public int compare(Wand w1, Wand w2) {
        
        return w1.getWandName().compareTo(w2.getWandName()); 
    }
}
