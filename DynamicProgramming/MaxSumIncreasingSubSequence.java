package DynamicProgramming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
<<<<<<< HEAD
 *
=======
 * Ashesh Vidyut (Drift King) *
>>>>>>> c6aee27e327e96a58c4583ac08325c3bed0bb43f
 */
/*
    Variation of Longest Increasing Subsequence
    *** Time Complexity *** O(n^2)
 */
public class MaxSumIncreasingSubSequence {
    public long maxSumIncreasingSubSequence(int ar[]){
        long maxsis[] = new long[ar.length];
        for (int i = 0; i < ar.length; i++) {
            maxsis[i] = ar[i];
        }
        for (int i = 0; i < ar.length; i++) {
            for (int j = 0; j < i; j++) {
                if(ar[i] > ar[j] && maxsis[i] < maxsis[j] + ar[i]){
                    maxsis[i] = maxsis[j] + ar[i];
                }
            }
        }
        long max_ans = maxsis[0];
        for (int i = 0; i < maxsis.length; i++) {
            long maxsi = maxsis[i];
            max_ans = Math.max(max_ans, maxsi);
        }
        return max_ans;
    }
    public static void main(String[] args) {
        try {
            MaxSumIncreasingSubSequence ms = new MaxSumIncreasingSubSequence();
            int arr[] = {1, 101, 2, 3, 100, 4, 5};
            System.out.println(ms.maxSumIncreasingSubSequence(arr));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
