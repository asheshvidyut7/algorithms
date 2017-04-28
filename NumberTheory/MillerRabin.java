package NumberTheory;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.math.*;
/**
 * Ashesh Vidyut (Drift King) *
 */
/*
    Miler Rabin Primality Testing for number - n
    Algorithm - First represent (n - 1) as 2 ** s * d
    We take trials, in each trial we take a random number a between 2...(n) and run the below code
    for i in range(_mrpt_num_trials):
        a = random.randrange(2, n)
        if try_composite(a):
            return False

    def try_composite(a):
        if pow(a, d, n) == 1:
            return False
        for i in range(s):
            if pow(a, 2**i * d, n) == n-1:
                return False
        return True # n is definitely composite
 */
public class MillerRabin{
    public static void main(String[] args) {
        long num = (long) 1e9+7;
        BigInteger n = new BigInteger(Long.toString(num));
        int certainty = Integer.parseInt("10");
        System.out.println(n.toString() + " is " + (n.isProbablePrime(certainty) ? "probably prime" : "composite"));
    }
}
