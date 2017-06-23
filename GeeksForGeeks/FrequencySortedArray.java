package GeeksForGeeks;

import IO.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

/**
 * created by asheshvidyut on 23/06/17
 **/
public class FrequencySortedArray {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
            int tc = in.readInt();
            for (int t = 0; t < tc; t++) {
                int n = in.readInt();
                int x = in.readInt();
                int a[] = new int[n];
                for (int i = 0; i < n; i++) {
                    a[i] = in.readInt();
                }
                int firstIndex = first(a, 0, a.length - 1, x);
                if (firstIndex == -1) {
                    out.write(Integer.toString(-1));
                    out.newLine();
                }
                else {
                    int lastIndex = last(a, 0, a.length - 1, x);
                    out.write(Integer.toString(lastIndex - firstIndex + 1));
                    out.newLine();
                }
            }
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static int first(int a[], int low, int high, int x) {
        if (high >= low) {
            int mid = (low + high) >> 1;
            if ((mid == 0 || a[mid - 1] < x) && a[mid] == x) {
                return mid;
            }
            else if(x <= a[mid]) {
                return first(a, low, mid - 1, x);
            }
            else {
                return first(a, mid + 1, high, x);
            }
        }
        return -1;
    }
    public static int last(int a[], int low, int high, int x) {
        if (high >= low) {
            int mid = (low + high) >> 1;
            if ((mid == a.length - 1 || a[mid + 1] > x) && a[mid] == x) {
                return mid;
            }
            else if(x < a[mid]) {
                return last(a, low, mid - 1, x);
            }
            else {
                return last(a, mid + 1, high, x);
            }
        }
        return -1;
    }
}
