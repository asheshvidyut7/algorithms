package NumberTheory;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
<<<<<<< HEAD
 *
=======
 * Ashesh Vidyut (Drift King) *
>>>>>>> c6aee27e327e96a58c4583ac08325c3bed0bb43f
 */
/*
    Sieve Of Eratosthenes - finding all primes in a range.
    *** Time Complexity *** O(n log log n)
    Uses
    1. Finding number of distinct prime factors of a number.
 */
public class SieveOfEratosthenes {
    public boolean[] seive(int upto){
        boolean [] prime_ar = new boolean[upto + 1];
        Arrays.fill(prime_ar, true);
        prime_ar[0] = false;
        prime_ar[1] = false;
        prime_ar[2] = true;
        for(int i = 2; i < upto + 1 ; i++)
            if(prime_ar[i])
                for(int j = i + i; j < upto + 1 ; j += i)
                    prime_ar[j] = false;
        return prime_ar;
    }
    public boolean[] seive2(int N){
        boolean[] isPrime = new boolean[N + 1];
        for (int i = 2; i <= N; i++) {
            isPrime[i] = true;
        }
        for (int i = 2; i*i <= N; i++) {
            if (isPrime[i]) {
                for (int j = i; i*j <= N; j++) {
                    isPrime[i*j] = false;
                }
            }
        }
        return isPrime;
    }
    public static boolean[]	segSeive(boolean isPrime[], int l, int r){
        boolean atret[] = new boolean[r-l+1];
        Arrays.fill(atret, true);
        for(int i = 0; i < isPrime.length; i++){
            if(isPrime[i]){
                //skipping the intermediate values
                int d = l/i;
                d = d * i;
                if(d < l)
                    d += i;
                if(d == i)
                    d += i;
                for(int j = d;j < r + 1 ; j += i)
                {
                    atret[j - l] = false;
                }
            }
        }
        return atret;
    }
    public static int[] uniqPrimeFactors(int upto){
        int [] df = new int[upto+1];
        boolean [] primear = new boolean[upto+1];
        Arrays.fill(primear, true);
        Arrays.fill(df,0);
        primear[0] = false;
        primear[1] = false;
        primear[2] = true;
        df[2] = 0;
        for(int i = 2; i < primear.length; i++)
            if(primear[i])
                for(int j = i + i; j < primear.length; j += i){
                    df[j]++;
                    primear[j] = false;
                }
        for(int i = 2 ; i < df.length; i++)
            if(df[i]==0)
                df[i]+=1;
        return df;
    }
    public static void main(String[] args) {
        try {
            SieveOfEratosthenes se = new SieveOfEratosthenes();
            int upto = (int)1e8;
            long st = System.currentTimeMillis();
            boolean par[] = se.seive(upto);
            long et = System.currentTimeMillis();
            System.out.println(et - st);
            st = System.currentTimeMillis();
            boolean par2[] = se.seive2(upto);
            et = System.currentTimeMillis();
            System.out.println(et - st);
            System.out.println(Arrays.equals(par, par2));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
