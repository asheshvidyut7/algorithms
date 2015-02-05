package NumberTheory;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * Ashesh Vidyut (Drift King) *
 */
/*
    Fermat's Little Theorem
    According to Fermat's Little Theorem if p is a prime number and a is a positive integer less than p, then
    a ^ p = a ( mod p ), and a ^ (p-1) = 1 ( mod p ) and again a ^ (p-2) = 1/a ( mod p )
    Uses -
    1.  Finding (nCr) mod prime, we can find n! (mod prime) to find ((n - r)! ^ -1) mod prime
        we use this theorem to find (n - r) ^ (prime - 2)
    Suppose you have to calculate (a/b) mod c and you encounter similar problem because a is too large directly, and gcd(b,c)!=1.
Let (a/b) mod c = y then (a/b) = xc+y (for some x)
=> a = xcb + yb => a = x(bc) + yb => a (mod (bc)) = yb so to calculate y, you can calculate a mod bc to get yb and divide by b to get y.
 */
public class FermatLittle {
    public static void main(String[] args) {
        try {
            final int prime = (int) 1e9+7;
            long a = 6565545454l;
            BinaryExponentiation be = new BinaryExponentiation();
            long ans = be.binPow(a, prime, prime);
            System.out.println(ans);
            long ans1 = a % prime;
            System.out.println(ans1);
            System.out.println(ans1 == ans);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
