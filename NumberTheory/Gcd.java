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
public class Gcd {
    public long gcd(long a, long b){
        if(a == 0 || b == 0){
            return a + b;
        }
        return gcd(b, a % b);
    }
    public static void main(String[] args) {
        try {
            Gcd g = new Gcd();
            System.out.println(g.gcd(10,20));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
