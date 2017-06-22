package Graph.WeightedGraph;

import java.io.*;
import java.util.*;

/**
<<<<<<< HEAD
 *
=======
 * Ashesh Vidyut (Drift King) *
>>>>>>> c6aee27e327e96a58c4583ac08325c3bed0bb43f
 */
/*
    Floyd Warshall All Pair Shortest Path to find shortest path between each pair of vertices.
    *** Time Complexity *** O(n^3)
 */
public class FloydWarshallAPSP {
    public static void main(String[] args) {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(in.readLine());
            double tab [][] = new double[n][n];
            for (int i = 0; i < n; i++) {
                Arrays.fill(tab[i], Integer.MAX_VALUE);
            }
            int m = Integer.parseInt(in.readLine());
            for (int i = 0; i < m; i++) {
                String inp[] =(in.readLine()).split(" ");
                int v1 = Integer.parseInt(inp[0]);
                int v2 = Integer.parseInt(inp[1]);
                double c = Double.parseDouble(inp[2]);
                tab[v1][v2] = c;
                tab[v2][v1] = c;
            }
            for (int k = 0; k < n; k++) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        tab[i][j] = Math.min(tab[i][j], tab[i][k] + tab[k][j]);
                    }
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
