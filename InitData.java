import java.io.File;
import java.io.PrintStream;
import java.io.IOException;

/**
 * Class to init data of the simulation. 
 * It could be used also to write finals results.
 * 
 * @author The Order of the Phoenix: Jorge Cancho Casado, Rubén Costa Barriga and Arturo Mejías Velasco
 * @version 10/01/2020
 */
public class InitData {

    private Hogwarts hogwarts;

    /**
     * Constructor for objects of class InitData.
     */
    public InitData() {

        hogwarts = Hogwarts.getInstance();
        initData1();
    }

    private void initData1() {

        // FILE: "initData1.txt"
        
        // New wands
        //-----------------------
        hogwarts.newWand(new Wand("Ivy", new HawthornWandBehavior()));
        hogwarts.newWand(new Wand("Larch",new HawthornWandBehavior()));
        hogwarts.newWand(new Wand("Rowan", new HollyWandBehavior()));
        hogwarts.newWand(new Wand("Yew", new HawthornWandBehavior()));
        hogwarts.newWand(new Wand("Hazel", new HawthornWandBehavior()));
        hogwarts.newWand(new Wand("Pine", new HawthornWandBehavior()));
        hogwarts.newWand(new Wand("Tamarack", new HollyWandBehavior()));
        hogwarts.newWand(new Wand("Spruce", new HawthornWandBehavior()));
        hogwarts.newWand(new Wand("Pear", new HawthornWandBehavior()));
        hogwarts.newWand(new Wand("Laurel", new HawthornWandBehavior()));
        
        
        
        // Gryffindor's characters
        //-----------------------------
        House gryffindor = new Gryffindor();

        Character harry = new OffensiveCharacter("Harry", "Potter");
        harry.assignWand(new Wand("HarryW", new HawthornWandBehavior()));
        harry = new InvigorationPotion(harry);
        harry = new FelixFelicisPotion(harry);

        Character hermione = new DefensiveCharacter("Hermione", "Granger");
        hermione.assignWand(new Wand("HermioneW", new HollyWandBehavior()));
        hermione = new InvigorationPotion(hermione);

        Character ron = new DefensiveCharacter("Ron", "Weasley");
        ron.assignWand(new Wand("RonW", new HawthornWandBehavior()));
        ron = new FelixFelicisPotion(ron);

        Character neville = new DefensiveCharacter("Neville", "Longbottom");
        neville.assignWand(new Wand("NevilleW", new HawthornWandBehavior()));

        gryffindor.addMember(harry);
        gryffindor.addMember(hermione);
        gryffindor.addMember(ron);
        gryffindor.addMember(neville);
        gryffindor.sortMembers();

        hogwarts.newHouse(gryffindor);
        
        
        
        // Hufflepuff's characters
        //------------------------------
        House hufflepuff = new Hufflepuff();

        Character cedric = new DefensiveCharacter("Cedric", "Diggory");
        cedric.assignWand(new Wand("CedricW", new HawthornWandBehavior()));
        cedric = new InvigorationPotion(cedric);

        Character nymphadora = new DefensiveCharacter("Nymphadora", "Tonks");
        nymphadora.assignWand(new Wand("NymphadoraW", new HawthornWandBehavior()));

        Character pomona = new OffensiveCharacter("Pomona", "Sprout");
        pomona.assignWand(new Wand("PomonaW", new HawthornWandBehavior()));
        pomona = new FelixFelicisPotion(pomona);

        Character rolf = new DefensiveCharacter("Rolf", "Scamander");
        rolf.assignWand(new Wand("RolfW", new HawthornWandBehavior()));

        hufflepuff.addMember(cedric);
        hufflepuff.addMember(nymphadora);
        hufflepuff.addMember(pomona);
        hufflepuff.addMember(rolf);
        hufflepuff.sortMembers();

        hogwarts.newHouse(hufflepuff);     
        
        
        
        // Slytherin's characters
        //------------------------------
        House slytherin = new Slytherin();
        Character draco = new DefensiveCharacter("Draco", "Malfoy");
        draco.assignWand(new Wand("DracoW", new HollyWandBehavior()));

        Character dolores = new OffensiveCharacter("Dolores", "Umbridge");
        dolores.assignWand(new Wand("DoloresW", new HollyWandBehavior()));

        Character pansy = new OffensiveCharacter("Pansy", "Parkinson");
        pansy.assignWand(new Wand("PansyW", new HawthornWandBehavior()));
        pansy = new FelixFelicisPotion(pansy);

        Character albus = new OffensiveCharacter("Albus", "Severus Potter");
        albus.assignWand(new Wand("AlbusW", new HollyWandBehavior()));

        slytherin.addMember(draco);
        slytherin.addMember(dolores);
        slytherin.addMember(pansy);
        slytherin.addMember(albus);
        slytherin.sortMembers();

        hogwarts.newHouse(slytherin);   
    }
    
    private void initData2() {
        
        // FILE: "initData2.txt"

        // New wands
        //-----------------------
        hogwarts.newWand(new Wand("Ivy", new HawthornWandBehavior()));
        hogwarts.newWand(new Wand("Larch", new HawthornWandBehavior()));
        hogwarts.newWand(new Wand("Rowan", new HollyWandBehavior()));
        hogwarts.newWand(new Wand("Yew", new HawthornWandBehavior()));
        hogwarts.newWand(new Wand("Hazel", new HawthornWandBehavior()));
        hogwarts.newWand(new Wand("Pine", new HawthornWandBehavior()));
        hogwarts.newWand(new Wand("Tamarack", new HollyWandBehavior()));
        hogwarts.newWand(new Wand("Spruce", new HawthornWandBehavior()));
        hogwarts.newWand(new Wand("Pear", new HawthornWandBehavior()));
        hogwarts.newWand(new Wand("Laurel", new HawthornWandBehavior()));
        hogwarts.newWand(new Wand("Cypress", new HollyWandBehavior()));
        hogwarts.newWand(new Wand("Ebony", new HollyWandBehavior()));
        hogwarts.newWand(new Wand("Reed", new HawthornWandBehavior()));
        hogwarts.newWand(new Wand("Aspen", new HollyWandBehavior()));
        hogwarts.newWand(new Wand("Walnut", new HawthornWandBehavior()));
        
        
        
        // Gryffindor's characters
        //-----------------------------
        House gryffindor = new Gryffindor();

        Character harry = new OffensiveCharacter("Harry", "Potter");
        harry.assignWand(new Wand("HarryW", new HollyWandBehavior()));
        harry = new InvigorationPotion(harry);
        harry = new FelixFelicisPotion(harry);

        Character hermione = new OffensiveCharacter("Hermione", "Granger");
        hermione.assignWand(new Wand("HermioneW", new HollyWandBehavior()));
        hermione = new InvigorationPotion(hermione);
        hermione = new FelixFelicisPotion(hermione);

        Character ron = new OffensiveCharacter("Ron", "Weasley");
        ron.assignWand(new Wand("RonW", new HollyWandBehavior()));
        ron = new FelixFelicisPotion(ron);

        gryffindor.addMember(harry);
        gryffindor.addMember(hermione);
        gryffindor.addMember(ron);
     
        gryffindor.sortMembers();

        hogwarts.newHouse(gryffindor);


        
        // Hufflepuff's characters
        //------------------------------
        House hufflepuff = new Hufflepuff();

        Character cedric = new DefensiveCharacter("Cedric", "Diggory");
        cedric.assignWand(new Wand("CedricW", new HawthornWandBehavior()));
        cedric = new InvigorationPotion(cedric);

        Character nymphadora = new DefensiveCharacter("Nymphadora", "Tonks");
        nymphadora.assignWand(new Wand("NymphadoraW", new HawthornWandBehavior()));

        Character pomona = new DefensiveCharacter("Pomona", "Sprout");
        pomona.assignWand(new Wand("PomonaW", new HawthornWandBehavior()));
        pomona = new FelixFelicisPotion(pomona);

        Character rolf = new DefensiveCharacter("Rolf", "Scamander");
        rolf.assignWand(new Wand("RolfW", new HawthornWandBehavior()));

        Character silvanus = new DefensiveCharacter("Silvanus", "Kettle");
        silvanus.assignWand(new Wand("SilvanusW", new HawthornWandBehavior()));
        silvanus = new FelixFelicisPotion(silvanus);

        Character susan = new DefensiveCharacter("Susan", "Bones");
        susan.assignWand(new Wand("SusanW", new HawthornWandBehavior()));

        Character newton = new DefensiveCharacter("Newton", "Scamander");
        newton.assignWand(new Wand("NewtonW", new HawthornWandBehavior()));

        Character hannah = new DefensiveCharacter("Hannah", "Abbott");
        hannah.assignWand(new Wand("HannahW", new HawthornWandBehavior()));
        hannah = new FelixFelicisPotion(hannah);

        hufflepuff.addMember(cedric);
        hufflepuff.addMember(nymphadora);
        hufflepuff.addMember(pomona);
        hufflepuff.addMember(rolf);
        hufflepuff.addMember(silvanus);
        hufflepuff.addMember(susan);
        hufflepuff.addMember(newton);
        hufflepuff.addMember(hannah);
        hufflepuff.sortMembers();

        hogwarts.newHouse(hufflepuff);
        
        
        
        // Slytherin's characters
        //------------------------------
        House slytherin = new Slytherin();

        Character draco = new DefensiveCharacter("Draco", "Malfoy");
        draco.assignWand(new Wand("DracoW", new HollyWandBehavior()));
        draco = new FelixFelicisPotion(draco);

        slytherin.addMember(draco);
        slytherin.sortMembers();

        hogwarts.newHouse(slytherin);
    }

    /**
     * Returns a String that contains initData's information.
     * 
     * @return String - initData information.
     */
    public String initInfo() {

        StringBuilder str = new StringBuilder();

        str.append(hogwarts.toStringHousesCollection() + '\n');
        str.append(hogwarts.toStringWandsCollection() + '\n');

        return str.toString();
    }
}
