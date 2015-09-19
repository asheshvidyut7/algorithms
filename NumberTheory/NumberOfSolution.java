package NumberTheory;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.util.InputMismatchException;

/**
 *
 */
/*
    find the number of solution to equation
    x1 + x2 + x3 + x4 = m, such that for all i 1 to 4, xi >= 0
    complementary question find the number of ways of distributing n chocolates among four
    children such that any can get 0 or more chocolates.
    in this problem number of elements on LHS could be more
    So the solution is (m + n - 1 C m),
    now in the question if x1 should be greater than or equal to 4, x2 should be greater than
    or equal to 5, such conditions are given then se subtract all such values from m, and then
    calculate (m + n - 1 C m)
 */
public class NumberOfSolution {
    static final int maxn = (int)1e5 + 1;
    static long fac[] = new long[maxn];
    static long invfac[] = new long[maxn];
    public static long binPow(long a , long b, int mod){
        long ans = 1l;
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
    public static long  inverseFactorial(int n, int mod){
        long invfact = binPow(fac[n], mod - 2, mod);
        return invfact % mod;
    }
    public static long choose(int n, int r, int mod){
        long nf = fac[n];
        long invfr = invfac[r];
        long invfnmr = invfac[n - r];
        long val = (nf % mod * invfr % mod) % mod;
        val = (val % mod * invfnmr % mod) % mod;
        return val;
    }
    public static void main(String[] args) {
        try {
            final int mod = (int) 1e9 + 7;
            fac[0] = 1l;
            for (int i = 1; i < fac.length; i++) {
                fac[i] = (i % mod * fac[i - 1] % mod) % mod;
            }
            long invfact = inverseFactorial(maxn - 1, mod);
            invfac[maxn - 1] = invfact % mod;
            for (int i = maxn - 2; i >= 0; i--) {
                invfac[i] = (((i + 1) % mod) * (invfac[i + 1] % mod)) % mod;
            }
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
            String nm[] = (in.readLine().trim()).split(" ");
            int n = Integer.parseInt(nm[0]);
            int m = Integer.parseInt(nm[1]);
            int ar[] = new int[n];
            String sar[] = (in.readLine()).split(" ");
            for (int i = 0; i < n; i++) {
                ar[i] = Integer.parseInt(sar[i]);
                m -= ar[i];
            }
            if(m + n - 1 <= 0){
                out.write("0");
            }
            else{
                out.write(Long.toString(choose(m + n - 1, n - 1, mod)));
            }
            out.newLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
