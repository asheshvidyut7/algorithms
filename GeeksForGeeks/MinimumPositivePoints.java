package GeeksForGeeks;

import IO.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

/**
 * created by asheshvidyut on 22/06/17
 **/
public class MinimumPositivePoints {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            int tc = in.readInt();
            for (int t = 0; t < tc; t++) {
                int n = in.readInt();
                int m = in.readInt();
                int mat[][] = new int[n][m];
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        mat[i][j] = in.readInt();
                    }
                }
                int dp[][] = new int[n][m];
                int sol[][] = new int[n][m];
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        if (i - 1 >= 0 && j - 1 >= 0){
                            dp[i][j] = mat[i][j] + Math.max(dp[i - 1][j], dp[i][j - 1]);
                            if (dp[i][j] <= 0) {
                                sol[i][j] = -dp[i][j] + 1;
                            }
                        }
                        else if(i - 1 >= 0) {
                            dp[i][j] = dp[i - 1][j] + mat[i][j];
                            if (dp[i][j] <= 0) {
                                sol[i][j] = -dp[i][j] + 1;
                            }
                        }
                        else if (j - 1 >= 0){
                            dp[i][j] = dp[i][j - 1] + mat[i][j];
                            if (dp[i][j] <= 0) {
                                sol[i][j] = -dp[i][j] + 1;
                            }
                        }
                        else {
                            dp[i][j] = mat[i][j];
                            if (dp[i][j] <= 0) {
                                sol[i][j] = -dp[i][j] + 1;
                            }
                        }
                    }
                }
                Cell[][] car = new Cell[n][m];
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        car[i][j] = new Cell(i, j);
                    }
                }
                for (int i = 0; i < n; i++ ) {
                    for (int j = 0; j < m; j++ ) {
                        if (i - 1 >= 0 && j - 1 >= 0) {
                            sol[i][j] = Math.max(sol[i][j], Math.min(sol[i - 1][j], sol[i][j - 1]));
                            if (sol[i - 1][j] < sol[i][j - 1]) {
                                car[i][j].parent = new Cell(i - 1, j);
                            }
                            else {
                                car[i][j].parent = new Cell(i, j - 1);
                            }
                        }
                        else if (i - 1 >= 0) {
                            sol[i][j] = Math.max(sol[i][j], sol[i - 1][j]);
                            car[i][j].parent = new Cell(i - 1, j);
                        }
                        else if (j - 1 >= 0) {
                            sol[i][j] = Math.max(sol[i][j], sol[i][j - 1]);
                            car[i][j].parent = new Cell(i, j - 1);
                        }
                    }
                }
                //calculating path
                int xc = n - 1; int yc = m - 1;
                int val = sol[n - 1][m - 1] + mat[0][0];
                while(!(xc == 0 && yc == 0)) {
                    val += mat[xc][yc];
                    int nx = car[xc][yc].parent.x;
                    int ny = car[xc][yc].parent.y;
                    xc = nx;
                    yc = ny;
                }
                if (val == 0) {
                    sol[n - 1][m - 1]++;
                }
                if (sol[n - 1][m - 1] == 0) {
                    sol[n - 1][m - 1]++;
                }
                System.out.println(sol[n - 1][m - 1]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
class Cell{
    public int x;
    public int y;
    public Cell parent;
    public Cell(int i, int j) {
        this.x = i;
        this.y = j;
    }
}
