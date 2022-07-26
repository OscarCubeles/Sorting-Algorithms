package Algorithms;

import Model.Athlete;
import Model.Club;

import java.util.ArrayList;
import java.util.Collections;

/****************************************************************************
 * Includes a The Algorithms.QuickSort Algorithm that sorts athletes according to their nationality
 *
 * @author Pol Navarro Solà
 * @author Óscar Cubeles Ollé
 *
 * @since 2020-11-26
 *
 ****************************************************************************/


public class QuickSort {

    /**
     * @author Pol Navarro Solà
     * @author Óscar Cubeles Ollé
     *
     * Method that fills an ArrayList of athletes with the information of all athletes from all clubs
     *
     * @param clubs Array of clubs containing all the data from all clubs inside the json file specified
     *
     * @return returns an ArrayList of athletes containing all clubs from all clubs
     *
     * @since 2020-11-26
     *
     */
    static ArrayList<Athlete> fillArrayList(Club[] clubs){
        //Creating ArrayList
        ArrayList<Athlete> athletes = new ArrayList<>();

        //Filling the ArrayList with all athletes
        for (int i = 0; i < clubs.length; i++){
            for (int j = 0; j < clubs[i].getAtAsArray().length; j++) {
                athletes.add(clubs[i].getAt(j));

            }
        }
        return athletes;
    }

    /**
     * @author Pol Navarro Solà
     * @author Óscar Cubeles Ollé
     *
     * Method that sorts the athletes according to their nationality
     *
     * @param athletes ArrayList of Athletes to be sorted
     * @param i Integer number indicating the bottom index
     * @param j Integer number indicating the top index
     *
     * @return returns the ArrayList of athletes sorted according to their nationality
     *
     * @since 2020-11-26
     */
    public ArrayList<Athlete> quickSortByNation(ArrayList<Athlete> athletes, int i, int j){

        //Checking the indexes
        if( j - i >= 1){
            int l = i;
            int r = j;


            //Partition  Method Inside Quicksort:

            //Compute pivot (on position 0)
            String pivot  = athletes.get(i).getCountry();

            //Loop until r>l  by comparing elements with the pivot
            while( r > l ){

                //Comparing to the pivot and moving the l if necessary
                while(athletes.get(l).compareTo(athletes.get(i))<= 0 && l <= j && r>l){
                    l++;
                }

                //Comparing to the pivot and moving the r if necessary
                while( athletes.get(r).compareTo(athletes.get(i)) > 0 && r >= i && r>=l){
                    r--;
                }

                if( r > l ) {
                    //Swapping elements
                    Collections.swap(athletes, l, r);
                }
            }
            //Swapping elements
            Collections.swap(athletes, i, r);
            //End partition

            //Calling again the algorithm
            quickSortByNation(athletes, i, r-1);
            quickSortByNation(athletes, r+1, j);

        }
        return athletes;
    }

    /**
     * @author Pol Navarro Solà
     * @author Óscar Cubeles Ollé
     *
     * Method that returns an ArrayList of athletes sorted according to their nation
     *
     * @param clubs Array of clubs containing all the information from all clubs and its athletes
     *
     * @return returns the ArrayList of Athletes sorted according to their name
     *
     * @since 2020-11-26
     */
    public ArrayList<Athlete> quickSortByNation(Club[] clubs){
        ArrayList<Athlete> athletes = new ArrayList<Athlete>();

        athletes = fillArrayList(clubs);

        QuickSort q = new QuickSort();
        athletes = quickSortByNation(athletes, 0,athletes.size()-1);

        return  athletes;
    }
}
