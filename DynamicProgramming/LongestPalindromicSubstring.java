package DynamicProgramming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 *
 */
/*
    Given a string, find the longest substring which is palindrome.
    *** Time Complexity *** O(n^2)
 */
public class LongestPalindromicSubstring {
    public int longestPalindromicSubstring(String s){
        int n = s.length();
        boolean table[][] = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            table[i][i] = true;
        }
        int max_length = 1;
        int start_ind = 0;
        for (int i = 0; i < n - 1; i++) {
            if(s.charAt(i) == s.charAt(i + 1)){
                table[i][i + 1] = true;
                max_length = 2;
                start_ind = i;
            }
        }
        for (int l = 3; l <= n; l++) {
            for (int i = 0; i < n - l + 1; i++) {
                int j = i + l - 1;
                if(table[i + 1][j - 1] && s.charAt(i) == s.charAt(j)){
                    table[i][j] = true;
                    if(l > max_length){
                        max_length = l;
                        start_ind = i;
                    }
                }
            }
        }
        System.out.println(s.substring(start_ind, start_ind+max_length));
        return max_length;
    }
    public static void main(String[] args) {
        try {
            LongestPalindromicSubstring lps = new LongestPalindromicSubstring();
            System.out.println(lps.longestPalindromicSubstring("forgeeksskeegfor"));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
