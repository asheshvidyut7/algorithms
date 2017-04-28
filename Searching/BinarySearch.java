package Searching;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

/**
 * Ashesh Vidyut (Drift King) *
 */
public class BinarySearch {
    public static void main(String[] args) {
        try {
            int ar[] = {1, 2, 3, 4, 6};
            Vector<Integer> v = new Vector<Integer>();
            for(int ele : ar){
                v.add(ele);
            }
            int indar = Arrays.binarySearch(ar, 5);
            int var = Collections.binarySearch(v, 5);
            System.out.println(indar);
            System.out.println(var);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
