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
    Finding nCr with formula (n!)/(n-r)!/(r)!
 */
public class NCR {
    public double ncr(int n, int r){
        double ans = 1d;
        int k = Math.min(n - r, r);
        for (int i = k; i >= 1 ; i--) {
            ans *= (n);
            ans /= (i);
            n--;
        }
        return ans;
    }
    public static void main(String[] args) {
        try {
            NCR ncr = new NCR();
            System.out.println(ncr.ncr(2, 2));
            System.out.println(ncr.ncr(2, 0));
            System.out.println(ncr.ncr(2, 1));
            System.out.println(ncr.ncr(3, 2));
            System.out.println(ncr.ncr(4, 2));
            System.out.println(ncr.ncr(5, 4));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
