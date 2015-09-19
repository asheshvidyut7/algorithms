package AdvancedDataStructures;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/**
 *
 */
public class BinaryIndexedTree2D {
    public static void add(int[][] t, int r, int c, int value) {
        for (int i = r; i < t.length; i += (i + 1) & -(i + 1))
            for (int j = c; j < t[0].length; j += (j + 1) & -(j + 1))
                t[i][j] += value;
    }
    public static int sum(int[][] t, int r, int c) {
        int res = 0;
        for (int i = r; i >= 0; i -= (i + 1) & -(i + 1))
            for (int j = c; j >= 0; j -= (j + 1) & -(j + 1))
                res += t[i][j];
        return res;
    }
    public static int sum(int[][] t, int r1, int c1, int r2, int c2) {
        return sum(t, r2, c2) - sum(t, r1 - 1, c2) - sum(t, r2, c1 - 1) + sum(t, r1 - 1, c1 - 1);
    }
    public static int get(int[][] t, int r, int c) {
        return sum(t, r, c, r, c);
    }
    public static void set(int[][] t, int r, int c, int value) {
        add(t, r, c, -get(t, r, c) + value);
    }
    public static void main(String[] args) {
        int[][] t = new int[10][20];
        add(t, 0, 0, 1);
        add(t, 9, 19, -2);
        System.out.println(-1 == sum(t, 0, 0, 9, 19));
    }
}