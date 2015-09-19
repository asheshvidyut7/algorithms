package NumberTheory;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Hashtable;
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
    Number of ways to represent an integer in powers of two.
    we can use each non negative power of two, two times
    http://mathlesstraveled.com/2009/09/19/challenge-12-solution-part-ii/
    let h(n)  is our answer then
    let number is odd of form 2 * n + 1, then h(2 * n + 1) =   h(n)
    let number is even of form 2 * n + 2, then h(2 * n + 2) = h(n + 1) + h(n);
    and h(0) = 1
    these equations will give the answer
 */
public class HyperBinaryRepresentation {
    Hashtable<Long, Long> anstable = new Hashtable<Long, Long>();
    public long getNumber(long N) {
        anstable.put(0l, 1l);
        anstable.put(1l, 1l);
        anstable.put(2l, 2l);
        return findAns(N);
    }
    public long findAns(long N){
        if(anstable.containsKey(N)){
            return anstable.get(N);
        }
        if(N % 2 == 0){
            long n = (N - 2 )/ 2;
            long ans = findAns(n + 1) + findAns(n);
            anstable.put(N, ans);
            return ans;
        }
        long n = (N - 1) / 2;
        long ans = findAns(n);
        anstable.put(N, ans);
        return ans;
    }
    public static void main(String[] args) {
        try {
            HyperBinaryRepresentation tc = new HyperBinaryRepresentation();
            System.out.println(tc.getNumber(6l));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
