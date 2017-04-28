package BitMask;

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
/*
    Finding all the subset of a set using bit masking
    For every set of n elements we will have 2 ^ n subsets
    every number from 0 to 2 ^ n - 1 in binary is less than 2 ^ n
    and its binary representation will give the power set,
    we will include elements where ith bit is 1 for every, binary rep of number i
    and for each i we will form a set
    finding all power set of set with 50 elements will take lot of time
    so we use this bit manipulation technique
 */
public class PowerSet {
    public static Vector<Vector<Integer>> powerSet(int ar[]){
        int n = ar.length;
        int maxset = 1 << n;
        Vector<Vector<Integer>> pset = new Vector<Vector<Integer>>();
        for (int setMask = 0; setMask < maxset; setMask++) {
            Vector<Integer> set = new Vector<Integer>();
            // for this mask find the set, take elements from arrays where
            // bin(setMask) == 1
            for (int i = 0; i < n; i++) {
                //for every bit position check if its one
                if((setMask & (1 << i)) != 0){
                    set.add(ar[i]);
                }
            }
            pset.add(set);
        }
        return pset;
    }
    public static void main(String[] args) {
        try {
            int ar[] = new int[]{1, 2, 3};
            System.out.println(powerSet(ar));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
