package Algorithms;

import Model.Athlete;
import Model.Club;

import java.util.ArrayList;

/****************************************************************************
 * Includes a The Mergesort Algorithm that sorts athletes according to their performance and to their type
 *
 * @author Pol Navarro Solà
 * @author Óscar Cubeles Ollé
 *
 * @since 2020-11-26
 *
 ****************************************************************************/


public class MergeSort {

    /**
     *
     * @author Pol Navarro Solà
     * @author Óscar Cubeles Ollé
     *
     * Method that merges two parts of the ArrayList of Athletes
     *
     * @param ath ArrayList of athletes
     * @param l Integer indicating the left index delimiter on the sub Array
     * @param half Integer indicating the middle point on the sub Array
     * @param r Index indicating the right index delimiter on the sub Array
     *
     * @return Returns the ArrayList merged
     *
     * @since 2020-11-26
     *
     */
    public ArrayList<Athlete> merge(ArrayList<Athlete> ath, int l, int half, int r) {
        int temp_num1 = half - l + 1;
        int temp_num2 = r - half;

        //Create temporal arrays to store the numbers
        Athlete[] temp_left = new Athlete[temp_num1];
        Athlete[] temp_right = new Athlete[temp_num2];

        //Copy until half of the array into temp_left
        for (int i = 0; i < temp_num1; i++){
            temp_left[i] = ath.get(l + i);
        }
        //Copy the other half of the array into temp_right
        for (int j = 0; j < temp_num2; j++){
            temp_right[j] = ath.get(half + 1 + j);
        }

        int i = 0, j = 0, k = l;
        while (i < temp_num1 && j < temp_num2) {
            if (temp_left[i].getPriority() >= temp_right[j].getPriority()) {
                if(temp_left[i].getPriority() > temp_right[j].getPriority()){
                    ath.set(k, temp_left[i]);
                    i++;
                }else if((temp_left[i].getPriority() == temp_right[j].getPriority())
                        &&  (temp_left[i].getDistance() > temp_right[j].getDistance())){
                    ath.set(k, temp_left[i]);
                    i++;
                }else{
                    ath.set(k, temp_right[j]);
                    j++;
                }
            }else {
                ath.set(k, temp_right[j]);
                j++;
            }
            k++;
        }

        //The rest that didn't change, copy it again to the main array
        while (i < temp_num1) {
            ath.set(k, temp_left[i]);
            i++;
            k++;
        }

        //The rest that didn't change, copy it again to the main array
        while (j < temp_num2) {
            ath.set(k, temp_right[j]);
            j++;
            k++;
        }

        return ath;
    }

    /**
     *
     * @author Pol Navarro Solà
     * @author Óscar Cubeles Ollé
     *
     * Mergesort algorithm that sorts an ArrayList of athletes according to their performance
     *
     * @param ath ArrayList of athletes containing all athletes to be sorted
     * @param l Integer indicating the left index
     * @param r Integer indicating the right index
     *
     * @return Returns the ArrayList of athletes sorted according to their performance
     *
     * @since 2020-11-26
     *
     */
    public ArrayList<Athlete> mergeSort(ArrayList<Athlete> ath, int l, int r) {
        if (l < r) {
            //Computing the half
            int half = (l + r) / 2;

            //Calling mergesort for the left half
            ath = mergeSort(ath, l, half);

            //Calling mergesort for the right half
            ath = mergeSort(ath, half + 1, r);

            //Merging the sub arrays
            ath = merge(ath, l, half, r);
        }

        return ath;
    }

    /**
     *
     * @author Pol Navarro Solà
     * @author Óscar Cubeles Ollé
     *
     * Method that fills and sorts  an ArrayList of athletes sorted according to their performance and
     * its type of athlete
     *
     * @param arr Array of Model.Club containing all the clubs from a given dataset
     * @param type String containing the type of athlete to be sorted
     *
     * @return Returns an ArrayList of athletes containing all the athletes from a certain type sorted according to their
     * performance
     *
     * @since 2020-11-26
     *
     */
    public ArrayList<Athlete> mergeSort(Club[] arr, String type) {
        ArrayList<Athlete> ath = new ArrayList<Athlete>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].getAtAsArray().length; j++) {
                if(arr[i].getAt(j).getType().equals(type)){
                    ath.add(arr[i].getAt(j));
                }
            }
        }

        ath = mergeSort(ath, 0, ath.size() - 1);

        return ath;
    }

}