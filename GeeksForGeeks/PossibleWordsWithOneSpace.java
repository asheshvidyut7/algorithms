package GeeksForGeeks;

import java.io.*;
import java.util.*;
import java.math.*;

/**
 * created by asheshvidyut on 28/07/17
 **/
public class PossibleWordsWithOneSpace {
    public static void printPossible(char res[], char s[], int i, int j, int n) {
        if (i == n) {
            System.out.println(new String(res));
            return;
        }
        res[j] = s[i];
        printPossible(res, s, i + 1, j + 1, n);
        res[j] = ' ';
        res[j + 1] = s[i];
        printPossible(res, s, i + 1, j + 2, n);
    }
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            char s[] = in.readLine().toCharArray();
            int i = 1;
            int j = 1;
            int n = s.length;
            char res[] = new char[2 * n];
            Arrays.fill(res, ' ');
            res[0] = s[0];
            printPossible(res, s, i, j, n);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
