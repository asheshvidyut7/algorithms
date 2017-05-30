package NumberTheory;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/**
<<<<<<< HEAD
 *
=======
 * Ashesh Vidyut (Drift King) *
>>>>>>> c6aee27e327e96a58c4583ac08325c3bed0bb43f
 */
/*
    Wilson Theorem states that a natural number n > 1 is a prime number if and only if
    (n - 1)! mod n == (n - 1) mod n
 */
public class WilsonTheorem {
    public boolean isPrime(int n){
        long fac = 1l;
        for (int i = 1; i < n; i++) {
            fac *= i;
        }
        if(fac % n == (n - 1) % n)
            return true;
        return false;
    }
    public static void main(String[] args) {
        try {
            WilsonTheorem wt = new WilsonTheorem();
            System.out.println(wt.isPrime(7));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}