package Backtracking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 *
 */
/*
    A Maze is given as N*N binary matrix of blocks where source block is the upper left most block i.e.
    , maze[0][0] and destination block is lower rightmost block i.e., maze[N-1][N-1]. A rat starts from
    source and has to reach destination. The rat can move only in two directions: forward and down.
 */
public class RatMaze {
    public void solveMaze(int m[][], int n){
        int sol[][] = new int[n][n];
        for (int i = 0; i < sol.length; i++) {
            Arrays.fill(sol[i], 0);
        }
        if(!solveMazeUtil(m, 0, 0, sol, n)){
            System.out.printf("Solution doesn't exist");
        }
        printSolution(sol,n);
    }
    public boolean solveMazeUtil(int m[][], int x, int y, int sol[][], int n){
        if(x == n - 1 && y == n - 1){
            sol[x][y] = 1;
            return true;
        }
        if(isSafe(m, x, y, n)){
            sol[x][y] = 1;
            if(solveMazeUtil(m, x + 1, y, sol, n)){
                return true;
            }
            if(solveMazeUtil(m, x, y + 1, sol, n)){
                return true;
            }
            sol[x][y] = 0;
            return false;
        }
        return false;
    }
    public boolean isSafe(int m[][], int x, int y, int n){
        if(x >= 0 && x < n && y >= 0 && y < n && m[x][y] == 1)
            return true;
        return false;
    }
    public void printSolution(int sol[][],int n){
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++)
                System.out.print(sol[i][j]);
            System.out.println();
        }
    }
    public static void main(String[] args) {
        try {
            int maze[][]  =  { {1, 0, 0, 0},
                    {1, 1, 0, 1},
                    {0, 1, 0, 0},
                    {1, 1, 1, 1}};
            RatMaze rm = new RatMaze();
            rm.solveMaze(maze,4);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
