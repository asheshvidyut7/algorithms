package BitMask;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.BitSet;
import java.util.Scanner;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.util.InputMismatchException;

/**
 * Ashesh Vidyut (Drift King) *
 */
/*
    Using BitSet is very time efficient.
    So XOR of array A expect i = (XOR of all number in array) XOR A[i]
 */
public class BitSetTest {
    public static void main(String[] args) {
        try {
            BitSet bs = new BitSet(10000000);
            BitSet bs2 = new BitSet(10000000);
            bs.set(0, 10);
            bs2.set(5, 10);
            bs.and(bs2);
            System.out.println(bs.cardinality());
            bs.set(0);
            bs.set(2);
            bs.set(4);
            bs.set(99999);
            bs2.set(1);
            bs2.set(3);
            bs2.set(99999);
            long st = System.currentTimeMillis();
            boolean ans = bs.intersects(bs2);
            long et = System.currentTimeMillis();
            System.out.println(et - st);
            int ar[] = new int[10000000];
            int ar2[] = new int[10000000];
            ar[0] = 1;
            ar[2] = 1;
            ar[4] = 1;
            ar[99999] = 1;
            ar2[0] = 1;
            ar2[3] = 1;
            ar2[99999] = 1;
            boolean ans2 = false;
            st = System.currentTimeMillis();
            for (int i = 0; i < 1000000; i++) {
                if(ar[0] == 1 && ar2[0] == 1){
                    ans2 = true;
                }
            }
            et = System.currentTimeMillis();
            System.out.println(et - st);
            System.out.println(ans);
            System.out.println(ans2);
            st = System.currentTimeMillis();
            System.out.println(bs.cardinality());
            et = System.currentTimeMillis();
            System.out.println(et - st);
            st = System.currentTimeMillis();
            int count = 0;
            for (int i = 0; i < 10000000; i++) {
                if(ar[i] == 1)
                    count++;
            }
            System.out.println(count);
            et = System.currentTimeMillis();
            System.out.println(et - st);
            int max = (int)1e5 + 1;
            BitSet[] bsmax = new BitSet[max];
            for (int i = 0; i < max; i++) {
                bsmax[i] = new BitSet(max);
                bsmax[i].set(0, max);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
