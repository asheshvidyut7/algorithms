package Sorting;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
<<<<<<< HEAD
 *
=======
 * Ashesh Vidyut (Drift King) *
>>>>>>> c6aee27e327e96a58c4583ac08325c3bed0bb43f
 */
/*
    Counting sort is a sorting technique based on keys between a specific range.
    It works by counting the number of objects having distinct key values (kind of hashing).
    Then doing some arithmetic to calculate the position of each object in the output sequence.
    *** Time Complexity *** O(n+k) where n is the number of elements and k is the range of input.
    Auxiliary Space: O(n+k)
 */

public class CountingSort {
    public int ar[];
    public int range;
    public CountingSort(int ar[], int range){
        this.ar = ar;
        this.range = range;
        countingsort();
    }
    public int[] countingsort(){
        int freqar[] = new int[range+1];
        for (int i = 0; i < ar.length; i++) {
            int i1 = ar[i];
            freqar[i1]++;
        }
        int cumulativef[] = new int[range+1];
        cumulativef[0] = freqar[0];
        for (int i = 1; i < range + 1; i++) {
            cumulativef[i]+= cumulativef[i-1]+freqar[i];
        }
        int new_ar[] = new int[ar.length];
        for (int i = 0; i < ar.length; i++) {
            new_ar[cumulativef[ar[i]] - 1] = ar[i]; // position of element in new array is cummulative frequency of
            cumulativef[ar[i]]--;                   // elements smaller than this
        }                                           // after this cummulative frequency is decremented
        return new_ar;
    }
    public static void main(String[] args) {
        try {
            int ar [] = {1,2,1,2,1,2,1,2,10,12,11,11,11};
            CountingSort s = new CountingSort(ar,12);
            System.out.println(Arrays.toString(s.countingsort()));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
