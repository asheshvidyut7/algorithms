package NumberTheory;

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
 * Ashesh Vidyut (Drift King) *
 */
/*
    Find lcm of N numbers modulo (int) 1e9 + 7
    lcm(a, b, c) = lcm(a, lcm(b, c))
    The best way to find lcm of N numbers mod prime is by prime factorization
    Factorize all the numbers one by one and store in a factorfrequency[] array , the max frequency of
    prime associated with any N number (not the sum, but the max freq of prime while factorizing any prime).
    Then multiply them with taking pow and mod.
    example 20 and 42
    20 = 2^2 * 5
    42 = 2 * 3 * 7
    in our factorfrequency array we have
    factorfrequency[2] = Max(2, 1) =  2
    factorfrequency[3] = 1
    factorfrequency[5] = 1
    factorfrequency[7] = 1
    Now we multiply each by taking power and mod
 */
public class Lcm {
    public static int mod = (int) 1e9 + 7;
    public static long lcm(int n[]){
        int freqfactors[] = new int[100000];
        for (int num : n){
            int d = 2;
            while(num > 1){
                int fld = 0;
                while(num % d == 0){
                    num/= d;
                    fld++;
                }
                freqfactors[d] = Math.max(freqfactors[d], fld);
                d++;
            }
        }
        long ans = 1l;
        for (int i = 0; i < 100000; i++) {
            ans *= (int) Math.pow((double)i, (double)freqfactors[i]);
            ans %= mod;
        }
        ans %= mod;
        return ans;
    }
    public static void main(String[] args) {
        try {
            int ar[] = {20, 42};
            System.out.println(lcm(ar));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
