package NumberTheory;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Ashesh Vidyut (Drift King) *
 */
/*
    Euler Totient Theorem - (a ^ phi(n)) == 1 (mod n)
    Implies (a ^ phi(n)) mod n = 1
    For all a relatively prime to n, a and n are co prime, gcd(a, n) == 1
 */
public class EulerTotientTheorem {
    public static int[] phi(int upto){
        int [] phiar = new int[upto+1];
        boolean primear[] = new boolean[upto+1];
        Arrays.fill(primear, true);
        primear[0] = primear[1] = false;
        for(int i = 0 ; i < upto+1 ; i++){
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
    public static long binPow(long a , long b, int mod){
        long ans = 1;
        long pow = a;
        while(b > 0){
            if((b % 2) == 1){
                ans *= pow;
                if(mod != -1)
                    ans %= mod;
            }
            pow *= pow;
            if(mod != -1)
                pow %= mod;
            b /= 2;
        }
        return ans;
    }
    public static void main(String[] args) {
        try {
            int phar[] = phi(7);
//            System.out.println(phar[7]);
            System.out.println(binPow(20, phar[7], 7));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
