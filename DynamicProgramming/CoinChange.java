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
    Given a value N, if we want to make change for N cents, and we have infinite supply of each of
    S = { S1, S2, .. , Sm} valued coins, how many ways can we make the change? The order of coins
    does not matter.
    *** Time Complexity *** O (m * n)
 */
public class CoinChange {
    public int count(int S[], int n){
        int m = S.length;
        int table[] = new int[n+1];
        table[0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = S[i]; j <= n; j++) {
                table[j] += table[j - S[i]];
            }
        }
        return table[n];
    }
    public static void main(String[] args) {
        try {
            CoinChange c = new CoinChange();
            int ar[] = {1, 2, 3};
            System.out.println(c.count(ar, 4));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
