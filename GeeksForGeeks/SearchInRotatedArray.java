package GeeksForGeeks;

import java.io.*;
import java.util.*;
import java.math.*;

/**
 * created by asheshvidyut on 29/07/17
 **/
public class SearchInRotatedArray {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
            int n = in.readInt();
            int ar[] = new int[n];
            for (int i = 0; i < n; i++) {
                ar[i] = in.readInt();
            }
            int k = in.readInt();
            int pivot = pivotPoint(ar, 0, ar.length - 1);
            if (Arrays.binarySearch(ar, 0, pivot, k) >= 0 || Arrays.binarySearch(ar, pivot + 1, ar.length - 1, k) >= 0) {
                System.out.println("yes");
                return;
            }
            System.out.println("no");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static int pivotPoint(int ar[], int l, int r) {
        int mid = (l + r) >> 1;
        if (mid - 1 >= 0 && ar[mid] < ar[mid - 1]) {
            return mid;
        }
        if (mid + 1 < ar.length && ar[mid + 1] < ar[mid]) {
            return mid + 1;
        }
        if (ar[l] < ar[mid]) {
            return pivotPoint(ar, mid + 1, r);
        }
        return pivotPoint(ar, l, mid - 1);
    }
}
