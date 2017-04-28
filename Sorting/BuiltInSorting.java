package Sorting;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 * Ashesh Vidyut (Drift King) *
 */

/**
 * Always use Wrapper for integer arrays that are to be sorted, never use primitives.
 */
/*
    Java uses "Quick Sort" for primitive types and "Merge Sort" for others.
    Use the wrapper classes for primitive type because Quick Sort has worst case time complexity
    of O(n^2) where as Merge sort run in O(nlogn) for sure.
 */
public class BuiltInSorting {
    public static void main(String[] args) {
        try {
            int primit_ar [] = new int[10000000];
            for (int i = 0; i < primit_ar.length; i++) {
                primit_ar[i] = 100000000-2*i;
            }
            Integer wraper_ar[] = new Integer[primit_ar.length];
            for (int i = 0; i < primit_ar.length; i++) {
                wraper_ar[i] = Integer.parseInt(Integer.toString(primit_ar[i]));
            }

            long st = System.currentTimeMillis();
            Arrays.sort(wraper_ar);
            long et = System.currentTimeMillis();
            System.out.println(et - st);

            st = System.currentTimeMillis();
            Arrays.sort(primit_ar);
            et = System.currentTimeMillis();
            System.out.println(et - st);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
