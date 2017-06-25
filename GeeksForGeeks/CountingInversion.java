package GeeksForGeeks;

import IO.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

/**
 * created by asheshvidyut on 24/06/17
 **/
public class CountingInversion {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            int tc = in.readInt();
            for (int t = 0; t < tc; t++) {
                int n = in.readInt();
                int ar[] = new int[n];
                for (int i = 0; i < n; i++) {
                    ar[i] = in.readInt();
                }
                System.out.println(inversionCount(ar, 0, ar.length - 1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static int inversionCount(int ar[], int l, int r) {
        if (l < r) {
            int mid = (l + r) >> 1;
            int res = inversionCount(ar, l, mid);
            res += inversionCount(ar, mid + 1, r);
            res += merge(ar, l, mid, r);
            return res;
        }
        return 0;
    }
    private static int merge(int ar[], int l, int mid, int r) {
        int lr[] = new int[mid - l + 2];
        int kr[] = new int[r - mid + 1];
        int ind = 0;
        for (int i = l; i <= mid; i++) {
            lr[ind++] = ar[i];
        }
        ind = 0;
        for (int i = mid + 1; i <= r; i++) {
            kr[ind++] = ar[i];
        }
        lr[lr.length - 1] = Integer.MAX_VALUE;
        kr[kr.length - 1] = Integer.MAX_VALUE;
        int ind1 = 0;
        int ind2 = 0;
        int ans = 0;
        for (int i = l; i <= r; i++) {
            if (lr[ind1] <= kr[ind2]) {
                ar[i] = lr[ind1++];
            }
            else {
                ans += lr.length - 1 - ind1;
                ar[i] = kr[ind2++];
            }
        }
        return ans;
    }
}
