import java.util.Comparator;

/**
 * This class compares defensive points of two different characters. If defensive
 * points are the same, it compares their names.
 *
 * @author The Order of the Phoenix: Jorge Cancho Casado, Rubén Costa Barriga and Arturo Mejías Velasco
 * @version 10/01/2020
 */
public class DefensiveComparator implements Comparator <Character> {
    
    public int compare(Character c1, Character c2) {
        
        if(c1.getDefensive() == c2.getDefensive())
            return c1.getCharacterName().compareTo(c2.getCharacterName());
        else if(c1.getDefensive() > c2.getDefensive())   
            return 1;
        else
            return -1;
    }
}
