package Backtracking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 * Ashesh Vidyut (Drift King) *
 */
/*
    Given a set and a sum find all subsets that sum to the given sum.
 */
public class SubSetSum {
    public void subsetSum(int ar[], int s){
        Arrays.sort(ar);
        int csum = 0;   // current sum
        int rsum = 0;   // remaining sum
        for (int i = 0; i < ar.length; i++) {
            rsum+=ar[i];
        }
        checkSubsets(ar, 0, s, csum, rsum);
    }
    public void checkSubsets(int a[], int i, int s, int cs, int rs){
        if(cs + a[i] == s){
            System.out.println("yes");
            return ;
        }
        else if(i + 1 < a.length && cs + a[i] + a[i + 1] <= s){
            checkSubsets(a, i + 1, s, cs + a[i], rs - a[i]);
        }
        if(cs + rs - a[i] >= s && i + 1 < a.length && cs + a[i + 1] <= s)
            checkSubsets(a, i + 1, s, cs, rs - a[i]);
    }
    public static void main(String[] args) {
        try {
            SubSetSum ss = new SubSetSum();
            int ar[] = {1,9,3,5};
//            ss.subsetSum(ar,10);
//            ss.subsetSum(ar,9);
//            ss.subsetSum(ar,8);
//            ss.subsetSum(ar,14);
//            ss.subsetSum(ar,4);
            ss.subsetSum(ar,11);
            ss.subsetSum(ar,2);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
