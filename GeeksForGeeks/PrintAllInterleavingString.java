package GeeksForGeeks;

import IO.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

/**
 * created by asheshvidyut on 24/07/17
 **/
public class PrintAllInterleavingString {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
            String a = in.readLine();
            String b = in.readLine();
            char res[] = new char[a.length() + b.length()];
            printRes(res, 0, a, b, 0, 0, out);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void printRes(char r[], int ind, String a, String b, int m, int n, BufferedWriter out) throws IOException{
        if (m == a.length() && n == b.length()) {
            out.write(r);
            out.newLine();
            return;
        }
        if (m != a.length()) {
            r[ind] = a.charAt(m);
            printRes(r, ind + 1, a, b, m + 1, n, out);
        }
        if (n != b.length()) {
            r[ind] = b.charAt(n);
            printRes(r, ind + 1, a, b, m, n + 1, out);
        }
    }
}
