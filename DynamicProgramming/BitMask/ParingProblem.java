package DynamicProgramming.BitMask;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.util.InputMismatchException;

/**
 *
 */
/*
    Suppose we have 'n' boys and 'm' girls. Some boys don't like some girls and vice-versa.
    Lets say we have a boolean matrix valid[i][j] which says if ith boy can be paired with jth girl.
    We need to know how many ways can 'k' pairs be chosen for a dance competition. 1 <= n,m,k <=10,
    and k <= min (m , n)
    Let 'mask' be a bitwise array. Each set bit in the mask represents which girls have already been
    paired with some boys (we dont know who but we are sure that she is paired).

    Now read this line very carefully.
    dp[i][mask] represents number of ways of making pairs using some boys numbered from 1 to i and
    some girls represented by set bits of mask.

 */
public class ParingProblem {
    public static void main(String[] args) {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            int boys = Integer.parseInt(in.readLine());
            int girls = Integer.parseInt(in.readLine());
            int m = girls;
            int n = boys;
            int dp[][] = new int[n][1 << m];
            dp[0][0] = 1;
            for (int i = 0; i < n; i++ ){
                for ( int mask = 0; mask < (1 << m); mask++ ){
                    dp[i + 1][mask] += dp[i][mask];
                    for( int t = 0; t < m; t++)
//                        if ( ((mask >> t) & 1 == 0 && valid[i][t])  == true)
                            dp[i +1 ][mask | (1 << t)] += dp[i][mask];
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
