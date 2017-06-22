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
    The problem is to count all the possible paths from top left to bottom right of a m * n matrix with
    the constraints that from each cell you can either move only to "right or down"
 */
public class CountPossiblePath {
    public int countpath(int m, int n){
        int count[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            count[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            count[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                count[i][j] += count[i - 1][j];
                count[i][j] += count[i][j - 1];
            }
        }
        return count[m - 1][n - 1];
    }
    public static void main(String[] args) {
        try {
            CountPossiblePath cp = new CountPossiblePath();
            System.out.println(cp.countpath(3,3));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
