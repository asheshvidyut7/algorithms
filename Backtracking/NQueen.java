package Backtracking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 *
 */
/*
    The N Queen is the problem of placing N chess queens on an N×N chessboard so that no two queens
    attack each other.
 */
public class NQueen {
    public boolean isSafe(int board[][], int row, int col, int n){
        int i, j;
        for (i = 0; i < col; i++){
            if (board[row][i] == 1)
                return false;
        }
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--){
            if (board[i][j] == 1)
                return false;
        }
        for (i = row, j = col; j >= 0 && i < n; i++, j--){
            if (board[i][j] == 1)
                return false;
        }
        return true;
    }
    public void nqueen(int n, int b[][]){
        if(!nqueenutil(b,n,0)){
            System.out.println("no solution");
        }
        pritSolution(b, n);
    }
    public boolean nqueenutil(int board[][], int n, int col){
        if (col >= n)
            return true;
        for (int i = 0; i < n; i++){
            if(isSafe(board, i, col, n)){
                board[i][col] = 1;
                if (nqueenutil(board, n, col + 1))
                    return true;
                board[i][col] = 0; // BACKTRACK
            }
        }
        return false;
    }
    void pritSolution(int b[][], int n){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(b[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        try {
            int b[][]={{0,0,0,0,0,0,0,0}
                    ,{0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0}};
            NQueen ob=new NQueen();
            ob.nqueen(8, b);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
