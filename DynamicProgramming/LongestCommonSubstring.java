package DynamicProgramming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Ashesh Vidyut (Drift King) *
 */
/*
    Given Two String find the longest common substring. The DP solution is has
    *** Time Complexity *** O(m * n).
    Best way to solve the problem is by using suffix automaton or suffix tree in Time Complexity
    *** Time Complexity *** O(m + n)
 */
public class LongestCommonSubstring {
    public int longestCommonSubstring(String s1, String s2){
        int lcs[][] = new int[s1.length()][s2.length()];
        int res = 0;
        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                if(i == 0 || j == 0){
                    lcs[i][j] = 0;
                }
                else if(s1.charAt(i - 1) == s2.charAt(j - 1)){
                    lcs[i][j] = lcs[i - 1][j - 1] + 1;
                    res = Math.max(lcs[i][j],res);
                }
                else
                    lcs[i][j] = 0;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        try {
            LongestCommonSubstring lcs = new LongestCommonSubstring();
            System.out.println(lcs.longestCommonSubstring("OldSite:GeeksforGeeks.org","NewSite:GeeksQuiz.com"));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
