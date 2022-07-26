package Algorithms;

import Model.Club;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/****************************************************************************
 * Includes a The Algorithms.BucketSort Algorithm that sorts clubs according to the average age of their athletes
 *
 * @author Pol Navarro Solà
 * @author Óscar Cubeles Ollé
 *
 *
 * @since 2020-11-26
 *
 ****************************************************************************/


public class BucketSort {

    /**
     *
     * Bucketsort algorithm that sorts clubs according to the average age of their athletes
     *<p>
     * <b>Note:</b> For the recursive part, we have included methods from Java default package
     *
     * @author Pol Navarro Solà
     * @author Óscar Cubeles Ollé
     *
     * @param arr Array of clubs containing all the clubs and its information from a certain dataset
     *
     * @return Returns the array of clubs sorted according to the average age of their athletes
     *
     * @since 2020-11-26
     *
     * @see Collections#sort(List)
     * @see List#sort(Comparator)
     *
     */
    public Club[] bucketSort(Club[] arr) {
        //If the length of the array is zero we won't compute anything
        if (arr.length <= 0) return arr;

        LinkedList<Club>[] bucket = new LinkedList[arr.length + 1];

        //We create a new linked list for each bucket
        for (int i = 0; i < arr.length; i++) {
            bucket[i] = new LinkedList<>();
        }

        //We sort the clubs into the buckets by their average age
        for (Club club : arr) {
            bucket[(int) (club.getAverage_age() / 100 * arr.length)].add(club);
        }

        //The clubs inside the same bucket are sorted too
        for (int i = 0; i < arr.length; i++) {
            Collections.sort(bucket[i]);
        }

        //All the buckets are copied into the array again
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < bucket[i].size(); j++) {
                arr[index++] = bucket[i].get(j);
            }
        }
        return arr;
    }

}
