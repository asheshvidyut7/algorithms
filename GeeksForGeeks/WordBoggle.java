package GeeksForGeeks;

import IO.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

/**
 * created by asheshvidyut on 26/06/17
 **/
public class WordBoggle {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
            int tc = in.readInt();
            for (int t = 0; t < tc; t++) {
                int x = in.readInt();
                String ar[] = in.readLine().split(" ");
                int n = in.readInt();
                int m = in.readInt();
                char mat[][] = new char[n][m];
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        mat[i][j] = in.readCharacter();
                    }
                }
                HashSet<String> resSet = new HashSet<>();
                for (int i = 0; i < x; i++) {
                    if (boggle(mat, ar[i])) {
                        resSet.add(ar[i]);
                    }
                }
                Vector<String> res = new Vector<>(resSet);
                Collections.sort(res);
                if (res.size() == 0) {
                    out.write(Integer.toString(-1));
                }
                else {
                    for (String ans : res) {
                        out.write(ans + " ");
                    }
                }
                out.newLine();
            }
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static boolean boggle(char mat[][], String s) {
        boolean ans = false;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == s.charAt(0)) {
                    ans = ans || search(new boolean[mat.length][mat[0].length], 0, i, j, mat, s);
                }
            }
        }
        return ans;
    }
    private static boolean search(boolean v[][], int index, int r, int c, char m[][], String s) {
        if (index == s.length()) {
            return true;
        }
        if (r < 0 || c < 0 || r >= m.length || c >= m[0].length) {
            return false;
        }
        if (v[r][c]) {
            return false;
        }
        if (s.charAt(index) != m[r][c]) {
            return false;
        }
        v[r][c] = true;
        return search(v, index + 1, r - 1, c, m, s) ||
                search(v, index + 1, r - 1, c - 1, m, s) ||
                search(v, index + 1, r - 1, c + 1, m, s) ||
                search(v, index + 1, r, c - 1, m, s) ||
                search(v, index + 1, r, c + 1, m, s) ||
                search(v, index + 1, r + 1, c, m, s) ||
                search(v, index + 1, r + 1, c + 1, m, s) ||
                search(v, index + 1, r + 1, c - 1, m, s);
    }
}
