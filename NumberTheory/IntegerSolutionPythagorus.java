package NumberTheory;

import IO.InputReader;

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
<<<<<<< HEAD
 *
=======
 * Ashesh Vidyut (Drift King) *
>>>>>>> c6aee27e327e96a58c4583ac08325c3bed0bb43f
 */
/*
    Given r find the integral solution to x ^ 2 + y ^ 2 = r ^ 2 or
    Find the integral solution to x ^ 2 + y ^ 2 = n;
    Well, if you can factor n, you can make a complete list of all numbers that divide it,
    including 1 and n itself. Ignore the even divisors.
    Count the number of divisors that leave a remainder of 1 when divided by 4,
    call that count C1. Put another way, this is the count of d > 0,d | n, d ≡ 1 (mod4).
    Next, count the number of divisors that leave a remainder of 3 when divided by 4,
    call that count C3. This is the count of d > 0 , d | n , d ≡ 3 (mod4).
    The number of integer lattice points on the circle is 4 ( C1 − C3).
 */
public class IntegerSolutionPythagorus {
    public static void main(String[] args) {
        try {
            InputReader in = new InputReader(System.in);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
            long r = in.readLong();
            int c1 = 0, c2 = 0;
            for (int i = 1; i <= Math.sqrt(r); i++) {
                if(r % i == 0){
                    long fd = i;
                    long sd = (r) / fd;
                    if(fd % 2 == 1){
                        if(fd % 4 == 1){
                            c1++;
                        }
                        if(fd % 4 == 3){
                            c2++;
                        }
                    }
                    if(sd != fd){
                        if(sd % 2 == 1){
                            if(sd % 4 == 1){
                                c1++;
                            }
                            if(sd % 4 == 3){
                                c2++;
                            }
                        }
                    }
                }
            }
            long lpoint = 4 * (c1 - c2);
            System.out.println(lpoint);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
