package Logs;

/****************************************************************************
 * Class with methods that log errors in console
 *
 * @author Pol Navarro Solà
 * @author Óscar Cubeles Ollé
 *
 * @since 2020-11-26
 *
 ****************************************************************************/

public class ConsoleError {

    public static void printOptionError(){
        System.out.print("\n--------------------------------------------------------------------");
        System.out.println("\nError. Please input an integer value between 1 and 6.");
        System.out.println("--------------------------------------------------------------------\n");
    }

    public static void printIntOutOfBounds(){
        System.out.print("\n--------------------------------------------------------------------");
        System.out.println("\nError. The integer must be between 1 and 6 within.");
        System.out.println("--------------------------------------------------------------------\n");
    }

    public static void printDatasetError(){
        System.out.print("\nError. Please enter a valid datasheet (XS, S, M, L, XL, XXL or optional). \n");
        System.out.print("You can write exit to go to the main menu without a new file.\n");
        System.out.print("\nPlease enter the dataset you want to read: ");
    }

    public static void printNotFileSelected(){
        System.out.print("\n--------------------------------------------------------------------");
        System.out.println("\nError. You need to select first a file");
        System.out.println("--------------------------------------------------------------------\n");
    }

    public static void printFileNotFound(){
        System.out.println("\nThe dataset selected is missing, please select other size.");
    }

    public static void printInvalidAthlete(){
        System.out.print("\n--------------------------------------------------------------------------------------");
        System.out.print("\nError. Please enter a valid type (Sprinter, Trail Runner or Long distance Runner). \n");
        System.out.println("--------------------------------------------------------------------------------------\n");
    }

}
