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
    Given a sequence, find the length of the longest palindromic subsequence in it.
    *** Time Complexity *** O(n^2)
 */
public class LongestPalindromicSubsequence {
    public int longestPalindromicSubseq(String st){
        int n = st.length();
        int L[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            L[i][i] = 1;
        }
        for (int l = 2; l <= n; l++) {  // length of window of subsequence
            for (int i = 0; i < n - l + 1; i++) {   //starting index of subsequence
                int j = i + l - 1;   // ending index
                if(st.charAt(i) == st.charAt(j)){
                    L[i][j] = L[i + 1][j - 1] + 2;
                }
                else{
                    L[i][j] = Math.max(L[i + 1][j], L[i][j - 1]);
                }
            }
        }
        return L[0][n - 1];
    }
    public static void main(String[] args) {
        try {
            LongestPalindromicSubsequence lpss = new LongestPalindromicSubsequence();
            String st = "GEEKS FOR GEEKS";
            System.out.println(lpss.longestPalindromicSubseq(st));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
