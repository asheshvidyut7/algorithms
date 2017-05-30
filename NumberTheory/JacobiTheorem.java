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
<<<<<<< HEAD
 *
=======
 * Ashesh Vidyut (Drift King) *
>>>>>>> c6aee27e327e96a58c4583ac08325c3bed0bb43f
 */
/*
    Jacobi Four Square Theorem - Number of ways to represent an integer as a sum of four squares
    is eight times the sum of all its divisors which are not divisible by 4.
    Example for 1 we have 8 representations which are
    1^2 + 0^2 + 0^2 + 0^2
    0^2 + 1^2 + 0^2 + 0^2
    0^2 + 0^2 +1^2 + 0^2
    0^2 + 0^2 +0^2 + 1^2
    (-1)^2 + 0^2 + 0^2 + 0^2
    0^2 + (-1)^2 + 0^2 + 0^2
    0^2 + 0^2 + (-1)^2 + 0^2
    0^2 + 0^2 + 0^2 + (-1)^2

 */
public class JacobiTheorem {
    public static void main(String[] args) {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
            long n = Long.parseLong(in.readLine());
            long sod = 0l;
            for (int i = 1; i <= Math.sqrt(n); i++) {
                if(n % i == 0){
                    long fd = i;
                    long sd = n / i;
                    if(fd % 4 != 0){
                        sod += fd;
                    }
                    if(sd != fd && sd % 4 != 0){
                        sod += sd;
                    }
                }
            }
            long ans = 8l * sod;
            out.write(Long.toString(ans));
            out.newLine();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
