package Algorithms;

import Model.Club;

/****************************************************************************
 * Includes a The Algorithms.QuickSort Algorithm that sorts clubs according to their name
 *
 * @author Pol Navarro Solà
 * @author Óscar Cubeles Ollé
 *
 * @since 2020-11-26
 *
 ****************************************************************************/

public class Optional {

    /**
     *
     * @author Pol Navarro Solà
     * @author Óscar Cubeles Ollé
     *
     * Method that sorts the clubs according to their name
     * @param clubs Array of Clubs containing all the clubs from an specified json file
     * @param i Integer containing the bottom index
     * @param j Integer containing the top index
     *
     * @return returns an Array of clubs sorted according to their name
     *
     * @since 2020-11-26
     *
     */
    public Club[] quickSortByName(Club clubs[], int i, int j){
        //Checking the indexes
        if( j - i >= 1){
            int l = i;
            int r = j;
            Club temp = new Club();

            //Compute pivot (on position 0)
            String pivot  = clubs[i].getName();

            //Loop until r>l  by comparing elements with the pivot
            while( r > l ){
                //Comparing to the pivot and moving the l if necessary
                while(clubs[l].getName().compareTo(pivot) <= 0 && l <= j && r>l){
                    l++;
                }

                //Comparing to the pivot and moving the r if necessary
                while( clubs[r].getName().compareTo(pivot) > 0 && r >= i && r>=l){
                    r--;
                }

                if( r > l ) {
                    //Swap elements on Clubs array
                    temp = clubs[r];
                    clubs[r] = clubs[l];
                    clubs[l] = temp;

                }

            }
            //Swap elements on Clubs array
            temp = clubs[i];
            clubs[i] = clubs[r];
            clubs[r] = temp;

            //Calling again the algorithm
            quickSortByName(clubs, i, r-1);
            quickSortByName(clubs, r+1, j);

        }
        return clubs;
    }

    /**
     * @author Pol Navarro Solà
     * @author Óscar Cubeles Ollé
     *
     * Method that receives an array of Model.Club and returns it sorted alphabetically according to its name
     *
     * @param clubs Array of Model.Club containing all the information from all clubs
     *
     * @return returns the Array of Clubs sorted by name
     *
     * @since 2020-11-26
     *
     */
    public Club[] quickSortByName(Club[] clubs){
        QuickSort q = new QuickSort();

        //Calling the quicksort algorithm to obtain the clubs sorted
        clubs = quickSortByName(clubs, 0, clubs.length-1);

        return clubs;
    }

}

