package NumberTheory;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.util.InputMismatchException;
import java.util.Vector;

/**
<<<<<<< HEAD
 *
=======
 * Ashesh Vidyut (Drift King) *
>>>>>>> c6aee27e327e96a58c4583ac08325c3bed0bb43f
 */
/*
    For every prime we have to find its maximum power for all N numbers,
    example if we have 4, 8
    we have to save for prime 2, value 3 only.
    Finding prime factor power of numbers till 10 ^ 6,
    so first use seive to find the the primes, and store the primes inside a vector,
    now for very number in range 1 to 10 ^ 6,
    start form prime with index 0 in the prime array,
    we will continuously divide the number with prime, and store its frequency
    but we will stop at prime at which (prime * prime) > number
    1 to sqrt(other number), so primes > sqrt(number), can never give max frequency
 */
public class MaxFreqPrimeFactorization {
    public static void main(String[] args) {
        try {
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
            final int max = (int) 1e6 + 1;
            Vector<Integer> primes = new Vector<Integer>();
            boolean isprime[] = new boolean[max];
            Arrays.fill(isprime, true);
            isprime[0] = false;
            isprime[1] = false;
            for (int i = 0; i < max; i++) {
                if(isprime[i]){
                    primes.add(i);
                    for (int j = 2 * i; j < max; j+=i) {
                        isprime[j] = false;
                    }
                }
            }
            int freq[] = new int[max];
            for (int i = 2; i < 100; i++) {
                int num = i;
                for (int j = 0; primes.get(j) * primes.get(j) <= i; j++) {
                    int prime = primes.get(j);
                    if(i % prime == 0){
                        int count = 0;
                        while(num % prime == 0){
                            num /= prime;
                            count++;
                        }
                        freq[prime] = Math.max(freq[prime], count);
                    }
                }
                if(isprime[i]){
                    freq[i] = Math.max(freq[i], 1);
                }
            }
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
