package GeeksForGeeks;

import java.io.*;
import java.util.*;
import java.math.*;

/**
 * created by asheshvidyut on 01/08/17
 **/
public class LongestSubstringWithoutRepeating {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
            int tc = in.readInt();
            for (int t = 0; t < tc; t++) {
                char s[] = in.readLine().toCharArray();
                int n = s.length;
                int wl = 0;
                int wr = 0;
                int hash[] = new int[256];
                Arrays.fill(hash, -1);
                int ans = 0;
                while(wl < n && wr < n) {
                    if (hash[s[wr] - 'a'] >= wl) {
                        wl++;
                    }
                    else {
                        hash[s[wr] - 'a'] = wr;
                        wr++;
                    }
                    ans = Math.max(ans, wr - wl);
                }
                out.write(Integer.toString(ans));
                out.newLine();
            }
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
