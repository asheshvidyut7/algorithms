package GeeksForGeeks;

import java.io.*;
import java.util.*;
import java.math.*;

/**
 * created by asheshvidyut on 30/07/17
 **/
public class MaxSumNonAdjacent {
    public static int maxSum(int ar[]) {
        int exc = 0;
        int inc = ar[0];
        for (int i = 1; i < ar.length; i++) {
            int temp = inc;
            inc = Math.max(exc + ar[i], inc);
            exc = temp;
        }
        return inc;
    }
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
            int n = in.readInt();
            int ar[] = new int[n];
            for (int i = 0; i < n; i++) {
                ar[i] = in.readInt();
            }
            out.write(Integer.toString(maxSum(ar)));
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
