package DynamicProgramming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
<<<<<<< HEAD
 *
=======
 * Ashesh Vidyut (Drift King) *
>>>>>>> c6aee27e327e96a58c4583ac08325c3bed0bb43f
 */
/*
    Longest Increasing Sub Sequence
    *** Time Complexity *** O(nlogn)
    https://sites.google.com/site/indy256/algo/lis_nlogn
 */
public class LongestIncreasingSubsequence2 {

    static int lower_bound(int[] a, int len, int key) {
        int lo = -1;
        int hi = len;
        while (hi - lo > 1) {
            int mid = (lo + hi) / 2;
            int midVal = a[mid];
            if (midVal < key) {
                lo = mid;
            } else {
                hi = mid;
            }
        }
        return hi;
    }

    public static int[] lis(int[] a) {
        int n = a.length;
        int[] b = new int[n];
        int[] len = new int[n];

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            // invariant: b[j] is the smallest number that ends a strictly-increasing subsequence of a[0..i-1] of length j+1
            // len[j] = length of LIS ending at a[j] for all j=0..i-1
            int j = lower_bound(b, cnt, a[i]);
            if (j == cnt) ++cnt;
            b[j] = a[i];
            len[i] = j + 1;
        }

        // reconstruct some LIS
        int[] res = new int[cnt];
        for (int i = n - 1; i >= 0; i--)
            if (len[i] == cnt && (cnt == res.length || a[i] < res[cnt]))
                res[--cnt] = a[i];
        return res;
    }

    // random test
    public static void main(String[] args) {
        int[] a = { 1, 5, 5, 4, 2, 3, 7, 6, 6 };
        int[] lis = lis(a);
        System.out.println(Arrays.toString(lis));

        Random rnd = new Random(1);
        for (int step = 0; step < 10000; step++) {
            int n = rnd.nextInt(10) + 1;
            int[] s = new int[n];
            for (int i = 0; i < n; i++)
                s[i] = rnd.nextInt(10);
            int res1 = lis(s).length;
            int res2 = getLisSlow(s);
            if (res1 != res2)
                throw new RuntimeException("error");
        }
    }

    public static int getLisSlow(int[] s) {
        int n = s.length;
        int res = 0;
        m1: for (int mask = 0; mask < 1 << n; mask++) {
            List<Integer> a = new ArrayList<Integer>();
            for (int i = 0; i < n; i++)
                if ((mask & (1 << i)) != 0)
                    a.add(s[i]);
            for (int i = 0; i + 1 < a.size(); i++)
                if (a.get(i) >= a.get(i + 1))
                    continue m1;
            res = Math.max(res, a.size());
        }
        return res;
    }
}
