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
    First we find fact[n] % prime, then to find (1/(r)) mod prime we use fermat little theorem
    to find (r) ^ prime - 2, now we have fact[n] % prime and (1/ r) mod prime and 1/ (n - r) mod prime.
    We multiply then to find the result.

    Suppose you have to calculate (a/b) mod c and you encounter similar problem because a is too large directly, and gcd(b,c)!=1.
Let (a/b) mod c = y then (a/b) = xc+y (for some x)
=> a = xcb + yb => a = x(bc) + yb => a (mod (bc)) = yb so to calculate y, you can calculate a mod bc to get yb and divide by b to get y.
 */
public class NCRmodPrime {
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
                ar[i] = (ar[i - 1] * i) % m;
            }
        }
        return ar;
    }
    /*  Using Fermat Little Theorem to find inverse factorial
        As (a ^ (prime - 2)) mod prime = (a ^ -1) mod prime
    */
    public static long [] inverseFactorial(int n, int mod){
        long gf[] = generateFactorialsUpto(n,mod);
        long invfact[] = new long[n + 1];
        invfact[n] = binPow(gf[n], mod - 2, mod);
        for(int i = n - 1; i >= 0; i--){
            invfact[i] = ((i + 1) * invfact[i + 1]) % mod;
        }
        return invfact;
    }
    public long choose(int n, int r, int mod){
        long far[] = generateFactorialsUpto(n, mod);
        long invfar[] = inverseFactorial(n, mod);
        long ans = far[n] % mod;
        ans = (ans % mod * invfar[n-r] % mod) % mod;
        ans = (ans % mod * invfar[r] % mod) % mod;
        return ans % mod;
    }
    public static void main(String[] args) {
        try {
            NCRmodPrime ncrp = new NCRmodPrime();
            final int mod = (int)1e9+7;
            System.out.println(ncrp.choose(100000, 3, mod));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
