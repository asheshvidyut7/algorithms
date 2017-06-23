package GeeksForGeeks;

import IO.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

/**
 * created by asheshvidyut on 23/06/17
 **/
public class KthLargestElement {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
            int tc = in.readInt();
            for (int t = 0; t < tc; t++) {
                int k = in.readInt();
                int n = in.readInt();
                int a[] = new int[n];
                for (int i = 0; i < n; i++) {
                    a[i] = in.readInt();
                }
                int heap[] = new int[k + 1];
                for (int i = 0; i < n; i++) {
                    if (i < k - 1) {
                        heap[i + 1] = a[i];
                        out.write(Integer.toString(-1) + " ");
                        continue;
                    }
                    if (i == k - 1) {
                        heap[i + 1] = a[i];
                        for (int j = k / 2; j >= 1; j--) {
                            minHeapify(heap, j);
                        }
                        out.write(Integer.toString(heap[1]) + " ");
                        continue;
                    }
                    if (a[i] > heap[1]) {
                        heap[1] = a[i];
                        minHeapify(heap, 1);
                        out.write(Integer.toString(heap[1]) + " ");
                        continue;
                    }
                    out.write(Integer.toString(heap[1])+ " ");
                }
                out.newLine();
            }
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void minHeapify(int a[], int i) {
        int largest = i;
        int rind = 2 * i + 1;
        int lind = 2 * i;
        int val = -1;
        if (lind < a.length && a[largest] > a[lind]) {
            largest = lind;
            val = a[lind];
        }
        if (rind < a.length && a[largest] > a[rind]) {
            largest = rind;
            val = a[rind];
        }
        if (largest != i) {
            int temp = a[i];
            a[i] = val;
            a[largest] = temp;
            minHeapify(a, largest);
        }
    }
}
