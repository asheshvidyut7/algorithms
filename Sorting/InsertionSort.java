package Sorting;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Ashesh Vidyut (Drift King) *
 */
/*
    This approach of Sorting is a Dynamic Programing Approach, in this we assume that we have sorted the array till
    i and then we put the i+1 th item in the previous sorted array. This process for i goes from 0 to n-1
    *** Time Complexity *** worst_case (n^2) best case (n)
 */
public class InsertionSort {
    public static void main(String[] args) {
        try{
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            String sar[] = (in.readLine()).split(" ");
            int ar[] = new int[sar.length];
            for (int i = 0; i < ar.length; i++){
                ar[i] = Integer.parseInt(sar[i]);
            }
            insertion_sort(ar);
            System.out.println(Arrays.toString(ar));
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void insertion_sort(int a[]){
        for (int i = 1; i < a.length; i++) {
            int j = i - 1;
            int key = a[i];
            while(j >= 0 && a[j] > key){
                a[j+1] = a[j];
                j--;
            }
            a[j + 1] = key;
        }
    }
}
