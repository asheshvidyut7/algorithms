package GeeksForGeeks;

import IO.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

/**
 * created by asheshvidyut on 18/07/17
 **/
public class TrappingRain {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
            int tc = in.readInt();
            for (int t = 0; t < tc; t++) {
                int n = in.readInt();
                int ar[] = new int[n];
                for (int i = 0; i < n; i++) {
                    ar[i] = in.readInt();
                }
                int ans = 0;
                int maxLeft[] = new int[n];
                maxLeft[0] = ar[0];
                for (int i = 1; i < n; i++) {
                    maxLeft[i] = Math.max(ar[i], maxLeft[i - 1]);
                }
                int maxRight[] = new int[n];
                maxRight[n - 1] = ar[n - 1];
                for (int i = n - 2; i >= 0; i--) {
                    maxRight[i] = Math.max(maxRight[i + 1], ar[i]);
                }
                for (int i = 0; i < n; i++) {
                    ans += Math.min(maxRight[i], maxLeft[i]) - ar[i];
                }
                out.write(Integer.toString(ans));
                out.newLine();
            }
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
