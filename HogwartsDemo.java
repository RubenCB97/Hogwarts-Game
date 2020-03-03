import java.io.File;
import java.io.PrintStream;
import java.io.FileNotFoundException;

/**
 * Main simulation class. 
 * First, initial data are loaded. 
 * Then, while is not the end of the simulation, the actions will be performed.
 *
 * @author The Order of the Phoenix: Jorge Cancho Casado, Rubén Costa Barriga and Arturo Mejías Velasco
 * @version 10/01/2020
 */
public class HogwartsDemo {

    public static void main(String[] args) throws FileNotFoundException {
    
        int turnNumber = 0;                          // define the current turn number
        int totalTurns = 10;                         // define the total number of turns
        boolean endSimulation = false;               // define the end of the simulation
        InitData initData = new InitData();          // init data of the simulation
          
        Hogwarts hogwarts = Hogwarts.getInstance();
        
        StringBuilder out = new StringBuilder();
        PrintStream output = new PrintStream(new File("output1.log"));
        PrintStream console = System.out;

        out.append(initData.initInfo());
        
        while(turnNumber < totalTurns && !endSimulation) {
            out.append("turn: <" + turnNumber + ">\n");
            hogwarts.getDuelingCharacters();
            out.append(hogwarts.toStringDuelingCharacters() + '\n');
            out.append(hogwarts.duel() + '\n');
            out.append(hogwarts.removeDuelingCharacters() + '\n');
            if(hogwarts.checkEndSimulation())
                endSimulation = true;
            turnNumber++; 
        }
        
        out.append("end of the simulation:\n");
        out.append("----------------------");
        
        out.append(initData.initInfo());
        
        out.append(hogwarts.toStringDungeon() + '\n');
        
        out.append("the winner house is:\n");
        out.append("--------------------");
        
        out.append(hogwarts.checkWhoWon(endSimulation));
        
        System.setOut(output);
        System.out.print(out.toString());
        
        System.setOut(console);
        System.out.print(out.toString());
    }
}
