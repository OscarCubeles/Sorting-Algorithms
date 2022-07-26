package Logs;

import Model.Athlete;
import Model.Club;

import java.util.ArrayList;

/****************************************************************************
 * Class with methods that log information in console
 *
 * @author Pol Navarro Solà
 * @author Óscar Cubeles Ollé
 *
 * @since 2020-11-26
 *
 ****************************************************************************/

public class Console {

    public static void printMenu(){
        System.out.println("\nWelcome to RunnersLS");
        System.out.println("\nHere, a menu with the options:\n");
        System.out.println("\t1. Change Dataset");
        System.out.println("\t2. Sort Clubs by their Age");
        System.out.println("\t3. Sort Athletes according their Nationality");
        System.out.println("\t4. Sort Athletes according to their Performance");
        System.out.println("\t5. Sort Clubs According to their Name ");
        System.out.println("\t6. Exit the program\n");
    }

    public static void printChangeDatasetMenu(){
        System.out.println("\n--------------------------------------------------------------------");
        System.out.print("\nYou selected Change Datasheet, here you can choose among: XS, S, M, L, XL, XXL or optional.");
        System.out.print("\nAlso, can write exit to go to the main menu without a new file.\n");
        System.out.print("\nPlease enter the dataset you want to read: ");
    }

    public static void printSelectDataset(){
        System.out.print("Please select an option: ");
    }

    public static void bye(){
        System.out.println("\n\nBye.");
    }

    public static void printSortClubs(){
        System.out.println("\n--------------------------------------------------------------------");
        System.out.println("You selected sorting club by the average age of their athletes.");
    }

    public static void printClubsSorted(long elapsedTime, Club[] resultClub){
        System.out.println("\nHere the list of the clubs sorted: \n");
        for (Club item : resultClub) {
            System.out.println(item.getName() + ": " + item.getNation());
            System.out.println("Average age: " + item.getAverage_age() + "\n");
        }
        System.out.println("\nTotal execution time: " + (elapsedTime/Math.pow(10,6)) + "ms");
        System.out.println("--------------------------------------------------------------------\n");
    }

    public static void printSortAthletesByNation(){
        System.out.println("\n--------------------------------------------------------------------");
        System.out.println("You selected sorting athletes by their nation.");
    }

    public static void printSortedAthetesByNation(long elapsedTime, ArrayList<Athlete> ath){
        System.out.println("\nHere the list of the athletes sorted: \n");

        for (Athlete athlete : ath) {
            System.out.println(athlete.getFullname() + ": " + athlete.getCountry() + "\n");
        }

        System.out.println("\nTotal execution time: " + (elapsedTime/Math.pow(10,6)) + "ms");
        System.out.println("--------------------------------------------------------------------\n");
    }

    public static void printSortAthletesByPerformance(){
        System.out.println("\n--------------------------------------------------------------------");
        System.out.println("You selected sorting athletes by their performance.");
    }

    public static void printPerformanceMenu(){
        System.out.print("\nPlease select which type of runner you want to sort. You can choose among: Sprinter, Trail Runner or Long distance Runner.");
        System.out.print("\nAlso, you can write exit to return to the main menu");
        System.out.print("\n\nPlease enter your option: ");
    }

    public static void printSortClubByName(){
        System.out.println("\n--------------------------------------------------------------------");
        System.out.println("You selected sorting club by their name.");
    }

    public static void printSortedClubsByName(long elapsedTime, Club[] resultClub){
        System.out.println("\nHere the list of the clubs sorted: \n");
        for (Club value : resultClub) {
            System.out.println(value.getName() + ": " + value.getNation() + "\n");
        }
        System.out.println("\nTotal execution time: " + (elapsedTime/Math.pow(10,6)) + "ms");
        System.out.println("--------------------------------------------------------------------\n");
    }

    public static void printExitMSG(){
        System.out.println("Returning to the main menu...");
        System.out.println("--------------------------------------------------------------------\n");
    }

    public static void printSelectedDataset(String dataset){
        System.out.println("\nYou selected the dataset: "+dataset+".json\n");
        System.out.println("--------------------------------------------------------------------");
    }

    public static void printSortedAthletes(long elapsedTime, ArrayList<Athlete> ath){
        System.out.println("\nHere the list of the athletes sorted: ");
        for (Athlete athlete : ath) {
            System.out.println(athlete.getFullname());
            System.out.println("  -Distance: " + athlete.getDistance());
            System.out.println("  -Performance: " + athlete.getPriority() + "\n");
        }
        System.out.println("\nTotal execution time: " + (elapsedTime/Math.pow(10,6)) + "ms");
        System.out.println("--------------------------------------------------------------------\n");
    }

}
