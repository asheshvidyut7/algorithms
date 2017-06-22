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
    Euler's Phi (or Totient) function of a positive integer n is the number of integers in {1,2,3,...,n}
    which are relatively prime to n. In number theory, two integers a and b are said to be relatively prime,
    mutually prime, or co-prime, if the only positive integer that evenly divides both of them is 1.
    gcd(a, b) == 1, a and b are relatively prime.

    Clearly for primes p, phi(p) = p - 1.
    If p is prime and n is any positive integer, then phi(p ^ n) = (p ^ (n-1)) * (p-1).

    Calculating phi(n)
    phi(n) = n * (1 - 1 / p1) * (1 - 1 / p2) * .......... * (1 - 1 / pn)
    where p1, p2, ... pn are the distinct prime numbers dividing n.

 */
public class EulerTotientFunction {
    public int[] phi(int upto){
        int [] phiar = new int[upto + 1];
        boolean primear[] = new boolean[upto + 1];
        Arrays.fill(primear, true);
        primear[0] = primear[1] = false;
        for(int i = 0 ; i < upto + 1 ; i++){
            phiar[i] = i;
        }
        for(int i = 0; i < upto + 1; i++){
            if(primear[i]){
                phiar[i] = i - 1;
                for(int j = i + i; j < upto + 1; j += i){
                    phiar[j] *= (i - 1);
                    phiar[j] /= i;
                    primear[j] = false;
                }
            }
        }
        return phiar;
    }
    public static void main(String[] args) {
        try {
            EulerTotientFunction et = new EulerTotientFunction();
            System.out.println(Arrays.toString(et.phi(16)));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
