package NumberTheory;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/**
 * Ashesh Vidyut (Drift King) *
 */
/*
    Binary exponentiation is a technique that allows you to build any number of n -th degree for
    multiplications (instead of the multiplications in the normal approach).
    Finding a^n if n is even then (a^n) = (a^(n/2))^2 = a^(n/2) * a^(n/2);
    if odd then a^(n) = a^(n-1) * a
*/
public class BinaryExponentiation {
    public long binPow(long a , long b, int mod){
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
    public long binPow2(long a, long b, int mod){
        String binb = Long.toBinaryString(b);
        long pow [] = new long[binb.length()];
        pow[0] = a;
        for (int i = 1; i < pow.length; i++) {
            pow[i] = (pow[i - 1] % mod * pow[i - 1] % mod) % mod;
        }
        long ans = 1;
        for (int i = 0; i < pow.length; i++) {
            if(binb.charAt(i) == '1'){
                int k = pow.length - i - 1;
                ans *= pow[k];
                ans %= mod;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        try {
            BinaryExponentiation be = new BinaryExponentiation();
            int mod = (int) 1e9 + 7;
            System.out.println(be.binPow(120, 132, mod));
            System.out.println(be.binPow2(120, 132, mod));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
