package IO;

import java.io.*;
import java.util.Scanner;
import java.math.BigInteger;
import java.util.InputMismatchException;

/**
<<<<<<< HEAD
 *
=======
 * Ashesh Vidyut (Drift King) *
>>>>>>> c6aee27e327e96a58c4583ac08325c3bed0bb43f
 */
/**
 *  Always use BufferedReader and BufferedWriter to take input and print answer.
 *  Using System.out.println() will cause "Time Limit Exceeded Verdict".
 */
public class InputOutput {
    public static void main(String[] args) {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
//            BufferedReader in = new BufferedReader(new FileReader("aa"));
            String inp = in.readLine();
            out.write(inp);
            out.newLine();
            out.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}

