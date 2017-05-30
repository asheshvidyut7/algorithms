package AlgorithmGames;

import IO.InputReader;

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
<<<<<<< HEAD
 *
=======
 * Ashesh Vidyut (Drift King) *
>>>>>>> c6aee27e327e96a58c4583ac08325c3bed0bb43f
 */
/*
    Imparital Game in which both the player has equal opportunity to move, no restriction.
    In game of nim, we have n boxes and each box has a[i] item, a player can remove one or more element
    from any box, the player who can't make his move looses.
    To win this game optimally we have to remove x item form box i, such that XOR of remaining
    item in each box is 0.
    This is optimal for our win.
    Problem on HackerRank Chocolate in Box.
    We have to find number of ways in which the first player moving optimally win the game of nim.
    So XOR of array A expect A[i] = (XOR of all number in array) XOR A[i]
    So if XOR of array A expect A[i] < A[i]
    that means we can reduce A[i] such that total XOR is 0.
    Hence for every such i we do ans++;
 */
public class GameOfNim {
    public static void main(String[] args) {
        try {
            InputReader in = new InputReader(System.in);
            int n = in.readInt();
            int ar[] = new int[n];
            for (int i = 0; i < n; i++) {
                ar[i] = in.readInt();
            }
            int xorv = ar[0];
            for (int i = 1; i < n; i++) {
                xorv = xorv ^ ar[i];
            }
            int ans = 0;
            for (int i = 0; i < n; i++) {
                if((xorv ^ ar[i]) < ar[i])
                    ans++;
            }
            System.out.println(ans);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
