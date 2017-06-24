package GeeksForGeeks;

import IO.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

/**
 * created by asheshvidyut on 24/06/17
 **/
public class KthSmallestRowColumnSorted {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            int tc = in.readInt();
            for (int t = 0; t < tc; t++) {
                int n = in.readInt();
                int ar[][] = new int[n][n];
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        ar[i][j] = in.readInt();
                    }
                }
                int k = in.readInt();
                HeapNode heap[] = new HeapNode[n + 1];
                for (int i = 1; i <= n; i++) {
                    heap[i] = new HeapNode(ar[i - 1][0], i, 0);
                }
                for (int i = n / 2; i >= 1; i--) {
                    minHeapify(heap, i);
                }
                HeapNode hr = heap[1];
                for (int i = 0; i < k; i++) {
                    hr = heap[1];
                    int nextval = (hr.r < n - 1 ? ar[hr.r + 1][hr.c] : Integer.MAX_VALUE);
                    heap[1] = new HeapNode(nextval, hr.r + 1, hr.c);
                    minHeapify(heap, 1);
                }
                System.out.println(hr.val);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void minHeapify(HeapNode ar[], int i) {
        int lind = 2 * i;
        int rind = 2 * i + 1;
        int smallest = i;
        if (lind < ar.length && ar[smallest].val > ar[lind].val) {
            smallest = lind;
        }
        if (rind < ar.length && ar[smallest].val > ar[rind].val) {
            smallest = rind;
        }
        if (smallest != i) {
            HeapNode temp = ar[i];
            ar[i] = ar[smallest];
            ar[smallest] = temp;
            minHeapify(ar, smallest);
        }
    }
}
class HeapNode{
    public int val, r, c;
    public HeapNode(int v, int r, int c) {
        this.val = v;
        this.r = r;
        this.c = c;
    }
}
