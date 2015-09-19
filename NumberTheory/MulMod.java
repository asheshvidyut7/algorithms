package NumberTheory;

/**
 *
 */
/*
    Calculating a * b % c where a * b overflows long
    Recursion Method -
    val = a * b =     2 * (a * b / 2) if b is even
                = a + 2 * (a * b / 2) if b is odd
 */

public class MulMod {
    public static long mulmod(long a, long b, long c){
        long x = 0, y = a % c;
        while(b > 0){
            if(b % 2 == 1){
                x = (x + y) % c;
            }
            y = (y * 2) % c;
            b /= 2;
        }
        return x % c;
    }
    public static long mulmod2(long a, long b, long c){
        if(b == 0){
            return 0l;
        }
        long res = mulmod2(a, b >> 1, c);
        res %= c;
        res = (res % c + res % c) % c;
        if((b & 1) == 1){
            //if b is odd then we express it as a * b = a+ a * (b>>1).
            // We have computed a*(b>>1) in the previous step by recursion
            // i.e the value ret. We now add the extra a to it.
            res = (res % c + a % c) % c;
        }
        return res % c;
    }
    public static void main(String[] args) {
        try {
            long l = Long.MAX_VALUE;
            System.out.println(mulmod(l, l, 4294967291111144554l));
            System.out.println(mulmod2(l, l, 4294967291111144554l));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
