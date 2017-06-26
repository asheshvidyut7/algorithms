package GeeksForGeeks;

import IO.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

/**
 * created by asheshvidyut on 26/06/17
 **/
public class Sudoku {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
            int tc = in.readInt();
            for (int t = 0; t < tc; t++) {
                int mat[][] = new int[9][9];
                for (int i = 0; i < 9; i++) {
                    for (int j = 0; j < 9; j++) {
                        mat[i][j] = in.readInt();
                    }
                }
                solveSudoku(mat);
                for (int i = 0; i < 9; i++) {
                    for (int j = 0; j < 9; j++) {
                        out.write(Integer.toString(mat[i][j])+" ");
                    }
                }
                out.newLine();
            }
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static boolean solveSudoku(int m[][]) {
        boolean noZero = true;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (m[i][j] == 0) {
                    noZero = false;
                }
            }
        }
        if (noZero) {
            return true;
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (m[i][j] == 0) {
                    for (int k = 1; k <= 9; k++) {
                        if (isSafe(i, j, m, k)) {
                            m[i][j] = k;
                            if (solveSudoku(m)) {
                                return true;
                            }
                            m[i][j] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return false;
    }
    private static boolean isSafe(int r, int c, int m[][], int k) {
        for (int i = 0; i < m.length; i++) {
            if (m[i][c] == k) {
                return false;
            }
        }
        for (int i = 0; i < m[0].length; i++) {
            if (m[r][i] == k) {
                return false;
            }
        }
        for (int row = 0; row < 3; row++)
            for (int col = 0; col < 3; col++)
                if (m[row + r - r % 3][col + c - c % 3] == k)
                    return false;
        return true;
    }
}
