package NumberTheory;

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
    Generating Binomial Coefficients using Dynamic Programming Table Method
 */
public class NCRTable {
    public long[][] ncrTable(int maxn){
        long ncr[][] = new long[maxn+1][maxn+1];
        for (int i = 0; i < maxn + 1; i++) {
            for (int j = 0; j <= i; j++) {
                ncr[i][j] = j == 0 || j == i ? 1 : ncr[i-1][j-1] + ncr[i-1][j];
            }
        }
        return ncr;
    }
    public static void main(String[] args) {
        try {
            NCRTable nc = new NCRTable();
            long ncrtab[][] = nc.ncrTable(5);
            System.out.println(ncrtab[2][2]);
            System.out.println(ncrtab[2][0]);
            System.out.println(ncrtab[2][1]);
            System.out.println(ncrtab[3][2]);
            System.out.println(ncrtab[4][2]);
            System.out.println(ncrtab[5][4]);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
