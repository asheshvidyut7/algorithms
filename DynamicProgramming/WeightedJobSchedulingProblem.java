package DynamicProgramming;

import IO.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

/**
 * created by asheshvidyut on 28/04/17
 **/
public class WeightedJobSchedulingProblem {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
            int n = in.readInt();
            Job ar[] = new Job[n];
            for (int i = 0; i < n; i++) {
                ar[i] = new Job(in.readInt(), in.readInt(), in.readInt());
            }
            Arrays.sort(ar);
            long ans[] = new long[n];
            for (int i = 0; i < ar.length; i++) {
                ans[i] = ar[i].profit;
            }
            for (int i = 1; i < n; i++) {
                ans[i] = Math.max(ans[i], ans[i - 1]);
                for (int j = i - 1; j >= 0; j--) {
                    if (!ar[i].overlap(ar[j])) {
                        ans[i] = Math.max(ans[i], ar[i].profit + ans[j]);
                        break;
                    }
                }
            }
            long res = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                res = Math.max(res, ans[i]);
            }
            out.write(Long.toString(res));
            out.newLine();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
class Job implements Comparable<Job>{
    public int start, end, profit;
    public Job(int s, int e, int p){
        this.start = s;
        this.end = e;
        this.profit = p;
    }
    public int compareTo(Job that) {
        return this.end - that.end;
    }
    protected boolean overlap(Job that) {
        if (this.end <= that.start) {
            return false;
        }
        if (this.start >= that.end) {
            return false;
        }
        return true;
    }
}
