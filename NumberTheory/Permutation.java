package NumberTheory;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/**
 * Ashesh Vidyut (Drift King) *
 */
public class Permutation {
    public static long nextPermutation(long x) {
        long s = x & -x;
        long r = x + s;
        long ones = x ^ r;
        ones = (ones >> 2) / s;
        return r | ones;
    }

    public static void main(String[] args) {
        try {
            Permutation p = new Permutation();
            System.out.println(p.nextPermutation(1235678));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
