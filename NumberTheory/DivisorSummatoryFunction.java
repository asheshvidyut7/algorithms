package NumberTheory;

import com.sun.org.apache.xpath.internal.operations.Div;

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
    Divisor Summatory Function -
    The divisor summatory function is defined as summation {for i in 1..n } d(n).
    where d(n) is divisor function.
    Divisor function counts the number of ways that the integer n can be written as a product of two integers.
    Source - http://en.wikipedia.org/wiki/Divisor_summatory_function

    Number of number that are multiple of X and are less than equal to N are N / X.
 */
public class DivisorSummatoryFunction {
    public long dsf(int n){
        int sq = (int)Math.sqrt(n);
        long ans = 0;
        for(int i = 1; i <= sq; i++){
            ans += (n/i);
        }
        ans *= 2;
        ans -= (sq * sq);
        return ans;
    }
    public static void main(String[] args) {
        try {
            DivisorSummatoryFunction dsfo = new DivisorSummatoryFunction();
            System.out.println(dsfo.dsf(5));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
