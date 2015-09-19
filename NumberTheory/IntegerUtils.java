package NumberTheory;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/**
 *
 */
/*
    Uses of IntegerUtils
    1. Find nCr mod prime
    2. Find a % mod where a has 10^5 digits.
 */
public class IntegerUtils {
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
    public static long [] generateFactorialsUpto(int u, int m){
        long ar[] = new long[u+1];
        ar[0] = 1l;
        if(m == -1){
            for(int i = 1; i < ar.length; i++){
                ar[i] = (long)((long)ar[i-1] * (long)i);
            }
        }
        else{
            for(int i = 1; i < ar.length; i++){
                ar[i] = (ar[i-1] * i) % m;
            }
        }
        return ar;
    }
    /*  Using Fermat Little Theorem to find inverse factorial
        As (a ^ (prime - 2)) mod prime = (a ^ -1) mod prime
    */
    public static long [] inverseFactorial(int n, int mod){
        long gf[] = generateFactorialsUpto(n,mod);
        long invfact[] = new long[n+1];
        invfact[n] = binPow(gf[n], mod-2, mod);
        for(int i = n-1;i >= 0;i--){
            invfact[i] = ((i+1) * invfact[i+1]) % mod;
        }
        return invfact;
    }
    public static long bigMod(int a[], int mod){
        long res = 0;
        for(int i = 0; i < a.length; i++){
            res = ((res % mod * 10l) + a[i]) % mod;
        }
        return res % mod;
    }
    public static void main(String[] args) {
        try {
            long ivf[] = inverseFactorial(5, (int)1e9+7);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
