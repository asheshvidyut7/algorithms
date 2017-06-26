package GeeksForGeeks;

import IO.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

/**
 * created by asheshvidyut on 26/06/17
 **/
public class TransformString {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
            int tc = in.readInt();
            for (int t = 0; t < tc; t++) {
                String ab[] = in.readLine().split(" ");
                char a[] = ab[0].toCharArray();
                char b[] = ab[1].toCharArray();
                int freqa[] = new int[26];
                int freqb[] = new int[26];
                for (int i = 0; i < a.length; i++) {
                    freqa[a[i] - 'a']++;
                }
                for (int i = 0; i < b.length; i++) {
                    freqb[b[i] - 'a']++;
                }
                if (Arrays.equals(freqa, freqb)) {
                    int j = a.length - 1;
                    int i = j;
                    int match = 0;
                    while(i >= 0 && j >= 0) {
                        if (a[i] == b[j]) {
                            match++;
                            i--;j--;
                        }
                        else {
                            i--;
                        }
                    }
                    out.write(Integer.toString(a.length - match));
                }
                else {
                    out.write(Integer.toString(-1));
                }
                out.newLine();
            }
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
