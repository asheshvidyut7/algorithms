package DynamicProgramming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 *
 */
public class LongestCommonSubsequence {
    public int lcsubs(char x[], char y[]){
        int m = x.length;
        int n = y.length;
        int lcs[][] = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if(i == 0 || j == 0){
                    lcs[i][j] = 0;
                }
                else if(x[i - 1] == y[j - 1]){
                    lcs[i][j] = lcs[i - 1][j - 1] + 1;
                }
                else{
                    lcs[i][j] = Math.max(lcs[i - 1][j], lcs[i][j - 1]);
                }
            }
        }
        return lcs[m][n];
    }
    public static void main(String[] args) {
        try {
            LongestCommonSubsequence l = new LongestCommonSubsequence();
            char x[] = "AGGTAB".toCharArray();
            char y[] = "GXTXAYB".toCharArray();
            System.out.println(l.lcsubs(x, y));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
