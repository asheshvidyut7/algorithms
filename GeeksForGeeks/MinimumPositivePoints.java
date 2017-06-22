package GeeksForGeeks;

import java.io.*;
import java.util.*;
import java.math.*;

/**
 * created by asheshvidyut on 22/06/17
 **/
public class MinimumPositivePoints {
    public static void main(String args[]) {
        try {
            int mat[][] = new int[][]{
                    {-2,-3,3},
                    {-5,-10,1},
                    {10,30,-5}
            };

            int n = mat.length;
            int m = mat[0].length;
            int dp[][] = new int[n][m];
            int sol[][] = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (i - 1 >= 0 && j - 1 >= 0){
                        dp[i][j] = mat[i][j] + Math.max(dp[i - 1][j], dp[i][j - 1]);
                        if (dp[i][j] <= 0) {
                            sol[i][j] = -dp[i][j];
                        }
                    }
                    else if(i - 1 >= 0) {
                        dp[i][j] = dp[i - 1][j] + mat[i][j];
                        if (dp[i][j] <= 0) {
                            sol[i][j] = -dp[i][j];
                        }
                    }
                    else if (j - 1 >= 0){
                        dp[i][j] = dp[i][j - 1] + mat[i][j];
                        if (dp[i][j] <= 0) {
                            sol[i][j] = -dp[i][j];
                        }
                    }
                    else {
                        dp[i][j] = mat[i][j];
                    }
                }
            }
            for (int i = 0; i < n; i++ ) {
                for (int j = 0; j < m; j++ ) {
                    if (i - 1 >= 0 && j - 1 >= 0) {
                        sol[i][j] = sol[i][j] + Math.min(sol[i - 1][j], sol[i][j - 1]);
                    }
                    else if (i - 1 >= 0) {
                        sol[i][j] = sol[i][j] + sol[i - 1][j];
                    }
                    else if (j - 1 >= 0) {
                        sol[i][j] = sol[i][j] + sol[i][j - 1];
                    }
                }
            }
            System.out.println(sol[n - 1][m - 1]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

