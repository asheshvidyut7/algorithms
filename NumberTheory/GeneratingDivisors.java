package NumberTheory;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.Scanner;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.util.InputMismatchException;
import java.util.Vector;

/**
 * Ashesh Vidyut (Drift King) *
 */
public class GeneratingDivisors {
    public static void main(String[] args) {
        try {
            int n = 100000;
            IO.InputReader in = new IO.InputReader(System.in);
            int ar[] = new int[n];
            for (int i = 0; i < n; i++) {
                ar[i] = in.readInt();
            }
            List<Integer> div[] = new Vector[100001];
            // stores the divisors of i
            for (int i = 0; i < div.length ;i++) {
                div[i] = new Vector<Integer>();
            }
            for (int i = 1; i < 100001; i++) {
                for (int j = i; j < 100001; j+=i) {
                    // for every multiple j of i, i is a divisor so div[j].add(i)
                    div[j].add(i);
                }
            }
            List<Integer> divvec[] = new Vector[100001];
            for (int i = 0; i < divvec.length; i++) {
                divvec[i] = new Vector<Integer>();
            }
            //storing the index of numbers in ar whose factor in i, for every i
            for (int i = 0; i < n; i++) {
                // for every divisor in i add this index i to divvec[d]
                for (int j = 0; j < div[ar[i]].size(); j++) {
                    int d = div[ar[i]].get(j);
                    divvec[d].add(i);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}