package Sorting;

import java.util.Arrays;

/**
<<<<<<< HEAD
 *
=======
 * Ashesh Vidyut (Drift King) *
>>>>>>> c6aee27e327e96a58c4583ac08325c3bed0bb43f
 */
/*
    Radix Sorting -
    All comparison sorting can never perform better than O(nlogn).
    Counting Sort performs in time O(n+k) but if the limit is n^2 then the it performs in O(n^2).
    Now comes Radix Sorting.
    *** Time Complexity *** Let there be d digits in input integers. Radix Sort takes O(d*(n+b))
    time where b is the base for representing numbers, for example, for decimal system, b is 10.
    Radix sort uses counting sort.
 */
public class RadixSort {
    public int getMax(int ar[], int n){
        int mx = ar[0];
        for (int i = 0; i < ar.length; i++) {
            int i1 = ar[i];
            mx = Math.max(mx, i1);
        }
        return mx;
    }
    /* A function to do counting sort of arr[] according to the digit represented by exp. */
    public void countingSort(int ar[], int n, int exp){
        int out[] = new int[n];
        int count[] = new int[10]; // since there are only 9 digits that is our range of counting sort
        for (int anAr1 : ar) {
            count[(anAr1 / exp) % 10]++;
        }
        for (int i = 1; i < 10; i++) {
            count[i] += count[i-1];
        }
        // building the output array
        /* the loop below will go from n-1 to 0 because at hundred place, we have 0 for many items,
           and for similar frequency we are placing the current item at the end and then decrementing
           the frequency, so at the end will the element which is at last in the previous place sorting
         */
        for (int i = n-1; i >= 0; i--){
            out[count[ (ar[i]/exp)%10 ] - 1] = ar[i];
            count[ (ar[i]/exp)%10 ]--;
        }
        System.arraycopy(out, 0, ar, 0, ar.length);
        return ;
    }
    public void radixSort(int ar[]){
        int n = ar.length;
        int m = getMax(ar, n);
        // soriting for first unit place, then tense, then hundreds .. upto length
        for (int exp = 1; m/exp > 0 ; exp*=10) {
            countingSort(ar, n, exp);
        }
    }
    public static void main(String[] args) {
        try {
            RadixSort rs = new RadixSort();
            int arr[] = {170, 45, 75, 90, 802, 24, 2, 66};
            rs.radixSort(arr);
            System.out.println(Arrays.toString(arr));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
