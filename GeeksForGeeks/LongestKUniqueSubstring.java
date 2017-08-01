package GeeksForGeeks;

import java.io.*;
import java.util.*;
import java.math.*;

/**
 * created by asheshvidyut on 01/08/17
 **/
public class LongestKUniqueSubstring {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
            int tc = in.readInt();
            for (int t = 0; t < tc; t++) {
                char st[] = in.readLine().toCharArray();
                int k = in.readInt();
                int start = 0;
                int maxLength = -1;
                int uniqueChars = 0;
                int hash[] = new int[265];
                for (int i = 0; i < st.length; i++) {
                    if (uniqueChars < k) {
                        if (hash[st[i] - 'a'] == 0) {
                            uniqueChars++;
                        }
                        hash[st[i] - 'a']++;
                    }
                    else {
                        if (hash[st[i] - 'a'] > 0) {
                            hash[st[i] - 'a']++;
                        }
                        else {
                            while(uniqueChars >= k) {
                                hash[st[start] - 'a']--;
                                if (hash[st[start] - 'a'] == 0) {
                                    uniqueChars--;
                                }
                                start++;
                            }
                            if (hash[st[i] - 'a'] == 0) {
                                uniqueChars++;
                            }
                            hash[st[i] - 'a']++;
                        }
                    }
                    maxLength = Math.max(maxLength, i - start + 1);
                }
                if (uniqueChars < k) {
                    out.write(Integer.toString(-1));
                }
                else {
                    out.write(Integer.toString(maxLength));
                }
                out.newLine();
            }
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
