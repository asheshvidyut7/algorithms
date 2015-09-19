package NumberTheory;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 *
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
