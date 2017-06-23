package GeeksForGeeks;

import IO.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

/**
 * created by asheshvidyut on 23/06/17
 **/
public class SumClosestToZero {
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
                Arrays.sort(ar);
                int closest = Integer.MAX_VALUE;
                int l = 0;
                int r = ar.length - 1;
                int f = -1, s = -1;
                while(l < r) {
                    int sum = ar[l] + ar[r];
                    if (closest > Math.abs(sum)) {
                        f = Math.min(ar[l], ar[r]);
                        s = Math.max(ar[l], ar[r]);
                    }
                    closest = Math.min(Math.abs(sum), closest);
                    if (sum < 0) {
                        l++;
                    }
                    else {
                        r--;
                    }
                }
                out.write(Integer.toString(f));
                out.write(" ");
                out.write(Integer.toString(s));
                out.newLine();
            }
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
