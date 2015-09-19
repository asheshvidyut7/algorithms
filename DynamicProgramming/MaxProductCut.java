package DynamicProgramming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 *
 */
/*
    Given a rope of length n meters, cut the rope in different parts of integer lengths in a way
    that maximizes product of lengths of all parts. You must make at least one cut. Assume that the
    length of rope is more than 2 meters.

    So max_product(n) = {Math.max( max_product(n - i) * i , i * (n-i))} for i = 1...n

    *** Time Complexity *** O(n^2)
 */
public class MaxProductCut {
    public int maxProduct(int n){
        int val [] = new int[n+1];
        val[0] = val[1] = 0;
        for (int i = 0; i <= n; i++) {
            int max_val = 0;
            for (int j = 0; j <= i/2; j++) {
                max_val = Math.max(Math.max(max_val, val[i - j] * j), (i - j) * j);
            }
            val [i] = max_val;
        }
        return val[n];
    }
    public static void main(String[] args) {
        try {
            MaxProductCut mpc = new MaxProductCut();
            System.out.println(mpc.maxProduct(10));
            System.out.println(mpc.maxProduct(11));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
