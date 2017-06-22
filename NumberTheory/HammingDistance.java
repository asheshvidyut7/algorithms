package NumberTheory;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
<<<<<<< HEAD
 *
=======
 * Ashesh Vidyut (Drift King) *
>>>>>>> c6aee27e327e96a58c4583ac08325c3bed0bb43f
 */
/*
    Hamming distance between two strings of equal length is the number of positions at which the
    corresponding symbols are different. Hamming Distance between "karolin" and "kathrin" is 3.
    *** For binary strings a and b the Hamming distance is equal to the number of ones (population count)
    in a XOR b. ***
 */
public class HammingDistance {
    public static void main(String[] args) {
        try {
            int a = Integer.parseInt("1001",2);
            int b = Integer.parseInt("1101",2);
            int res = a ^ b;
            int ans = 0;
            String ress = Integer.toBinaryString(res);
            for (int i = 0; i < ress.length(); i++) {
                if(ress.charAt(i) == '1')
                    ans++;
            }
            System.out.println("ans = " + ans);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
