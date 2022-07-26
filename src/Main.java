import Algorithms.BucketSort;
import Algorithms.MergeSort;
import Algorithms.Optional;
import Algorithms.QuickSort;
import DataAccess.DataAccess;
import Logs.Console;
import Logs.ConsoleError;
import Model.Athlete;
import Model.Club;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/****************************************************************************
 * Program to run different sorting algorithms from different datasets
 *
 * @author Pol Navarro Solà
 * @author Óscar Cubeles Ollé
 *
 * @since 2020-11-26
 *
 ****************************************************************************/


public class Main {

    /****************************************************************************
     * The main function where the program is executed
     *
     * @author Pol Navarro Solà
     * @author Óscar Cubeles Ollé
     *
     * @param args Argument array where you can specify default parameters
     *
     * @since 2020-11-26
     *
     ****************************************************************************/
    public static void main(String[] args) {
        //Measuring elapsed time using System.nanoTime
        boolean leave = false, fileSelected = false;
        long startTime, elapsedTime;
        int option;

        DataAccess reader = new DataAccess();
        Club[] club = new Club[0];
        ArrayList<Athlete> ath;
        Club[] resultClub;

        do{
            Console.printMenu();
            option = Utils.getMainMenuOption();

            switch (option){
                case 1:
                    fileSelected = false;
                    Console.printChangeDatasetMenu();

                    do{
                        try {
                            String dataset = new Scanner(System.in).nextLine();
                            if(Utils.isDatasetValid(dataset)){
                                club = reader.readDataset(dataset);
                                Console.printSelectedDataset(dataset);
                                fileSelected = true;
                            }else if(dataset.equals("exit")){
                                Console.printExitMSG();
                                fileSelected = true;
                            }
                            else{
                                ConsoleError.printDatasetError();
                            }
                        }catch (FileNotFoundException e){
                            ConsoleError.printFileNotFound();
                        }
                    }while(!fileSelected);

                    break;

                case 2:
                    if(!fileSelected){
                        ConsoleError.printNotFileSelected();
                        break;
                    }
                    BucketSort bucketSort = new BucketSort();
                    Console.printSortClubs();

                    startTime = System.nanoTime();
                    resultClub = bucketSort.bucketSort(club);
                    elapsedTime = System.nanoTime() - startTime;

                    Console.printClubsSorted(elapsedTime, resultClub);
                    resultClub = null;
                    break;

                case 3:
                    if(!fileSelected){
                        ConsoleError.printNotFileSelected();
                        break;
                    }
                    Console.printSortAthletesByNation();

                    QuickSort nations = new QuickSort();
                    startTime = System.nanoTime();
                    ath = nations.quickSortByNation(club);
                    elapsedTime = System.nanoTime() - startTime;

                    Console.printSortedAthetesByNation(elapsedTime, ath);
                    ath = null;
                    break;

                case 4:
                    if(!fileSelected){
                        ConsoleError.printNotFileSelected();
                        break;
                    }
                    MergeSort mergeSortAge = new MergeSort();
                    boolean exit = false;

                    Console.printSortAthletesByPerformance();

                    do {
                        Console.printPerformanceMenu();
                        String userInput = new Scanner(System.in).nextLine();
                        if (Athlete.isValidAthlete(userInput)) {
                            startTime = System.nanoTime();
                            ath = mergeSortAge.mergeSort(club, userInput);
                            elapsedTime = System.nanoTime() - startTime;
                            Console.printSortedAthletes(elapsedTime, ath);
                            exit = true;
                        } else if (userInput.equals("exit")) {
                            exit = true;
                        } else {
                            ConsoleError.printInvalidAthlete();
                        }
                    }while (!exit);

                    ath = null;
                    break;

                case 5:
                    if(!fileSelected){
                        ConsoleError.printNotFileSelected();
                        break;
                    }
                    Optional optional = new Optional();
                    Console.printSortClubByName();

                    startTime = System.nanoTime();
                    resultClub = optional.quickSortByName(club);
                    elapsedTime = System.nanoTime() - startTime;

                    Console.printSortedClubsByName(elapsedTime, resultClub);
                    resultClub = null;
                    break;

                case 6:
                    leave = true;
                    Console.bye();
                    break;

                default:
                    ConsoleError.printIntOutOfBounds();
                    break;
            }

        }while(!leave);
    }
}
