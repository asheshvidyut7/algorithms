package DynamicProgramming;

import Backtracking.SubSetSum;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Ashesh Vidyut (Drift King) *
 */
/*
    Given a set of non-negative integers, and a value sum, determine if there is a subset of the
    given set with sum equal to given sum.
    We create a boolean 2D table subset[][] and fill it in bottom up manner. The value of subset[i][j]
    will be true if there is a subset of set[0..j-1] with sum equal to i., otherwise false.
    Finally, we return subset[sum][n]
    *** Time complexity *** O(sum * n).
 */
public class SubsetSumDP {
    public boolean subsetSum(int set[], int sum){
        int n = set.length;
        boolean subset[][] = new boolean[sum + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            subset[0][i] = true;
        }
        for (int i = 1; i <= sum; i++) {
            subset[i][0] = false;
        }
        for (int i = 1; i <= sum ; i++) {
            for (int j = 1; j <= n ; j++) {
                subset[i][j] = subset[i][j - 1];
                if(i >= set[j - 1]){
                    /*
                    since sum i is greater than set[j-1] that means we can use set[j-1] to sum to i
                    only thing we have to find is the presence of (i - set[j-1]), if that is true,
                    we can get i.
                    if subset[i - set[j-1]][j-1] is true
                    means we have a subset of sum (i - set[j-1])
                    so now we have to get sum i with set[j-1]th element
                    we will get it if we have (i - set[j-1]) found
                    so the total will be i - set[j-1] + set[j-1] which is i */
                    subset[i][j] = subset[i][j] || subset[i-set[j-1]][j-1];
                }
            }
        }
        return subset[sum][n];
    }
    public static void main(String[] args) {
        try {
            SubsetSumDP ss = new SubsetSumDP();
            int set[] = {3, 34, 4, 12, 5, 2};
            System.out.println(ss.subsetSum(set, 9));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
