package DynamicProgramming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Ashesh Vidyut (Drift King) *
 */
/*
    Given a cost matrix cost[][] and a position (m, n) in cost[][], write a function that returns
    cost of minimum cost path to reach (m, n) from (0, 0). Each cell of the matrix represents a
    cost to traverse through that cell. Total cost of a path to reach (m, n) is sum of all the
    costs on that path (including both source and destination). You can only traverse down, right
    and diagonally lower cells from a given cell, i.e., from a given cell (i, j), cells (i+1, j),
    (i, j+1) and (i+1, j+1) can be traversed. You may assume that all costs are positive integers.

    *** Time Complexity *** O(n^2)
 */
public class MinCostPath {
    public long minCostPath(int cost[][], int m, int n){
        long minc[][] = new long[m][n];
        minc[0][0] = cost[0][0];
        for (int i = 1; i < n; i++) {
            minc[0][i] = minc[0][i - 1] + cost[0][i];
        }
        for (int i = 1; i < m; i++) {
            minc[i][0] = minc[i - 1][0] + cost[i][0];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                minc[i][j] = Math.min(Math.min(minc[i - 1][j - 1], minc[i - 1][j]), minc[i][j - 1]) + cost[i][j];
            }
        }
        return minc[m - 1][n - 1];
    }
    public static void main(String[] args) {
        try {
            int cost[][] = { {1, 2, 3},
                               {4, 8, 2},
                               {1, 5, 3} };
            MinCostPath mp = new MinCostPath();
            System.out.println(mp.minCostPath(cost,3,3));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
