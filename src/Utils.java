import Logs.Console;
import Logs.ConsoleError;

import java.util.Scanner;

/****************************************************************************
 *
 *
 *
 * @author Pol Navarro Solà
 * @author Óscar Cubeles Ollé
 *
 *
 * @since 2020-11-26
 *
 ****************************************************************************/

public class Utils {

    /**
     * @author Pol Navarro Solà
     * @author Óscar Cubeles Ollé
     *
     * Method that asks the user for an integer to execute an algorithm
     *
     *
     * @return returns an integer with the option selected by the user
     *
     * @since 2020-11-26
     *
     */
    public static int getMainMenuOption() {
        String optionString;
        boolean flag = false;
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");

        do {
            Console.printSelectDataset();
            optionString = scanner.next();
            try {
                Integer.parseInt(optionString);
                flag = true;
            } catch (NumberFormatException inputError) {
                ConsoleError.printOptionError();
                flag = false;
            }
        } while (!flag);

        return Integer.parseInt(optionString);
    }

    /**
     * @author Pol Navarro Solà
     * @author Óscar Cubeles Ollé
     *
     * Method that checks if a dataset has one of the formats accepted by the program
     *
     *
     * @return returns an integer with the option selected by the user
     *
     * @since 2020-11-26
     *
     */
    public static boolean isDatasetValid(String dataset){
        return dataset.equals("XS") || dataset.equals("S")|| dataset.equals("M") || dataset.equals("L") ||
                dataset.equals("XL") || dataset.equals("XXL") || dataset.equals("optional");
    }
}