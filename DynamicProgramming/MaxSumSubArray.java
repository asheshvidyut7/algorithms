package DynamicProgramming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 *
 */
/*
    Kadane Algorithm or Largest Sum Sub Array Algorithm
    *** Time Complexity *** O(n)
    Variation - In this we can store max_so_far for every index [i].
 */
public class MaxSumSubArray{
    public int kadane(int ar[]){
        int max_ending_here = ar[0];
        int max_so_far = ar[0];
        for (int i = 1; i < ar.length; i++) {
            max_ending_here = Math.max(max_ending_here + ar[i], ar[i]);
            max_so_far = Math.max(max_ending_here, max_so_far);
        }
        return max_so_far;
    }
    public static void main(String[] args) {
        try {
            int a[] =  {-2, -3, 4, -1, -2, 1, 5, -3};
            MaxSumSubArray ms = new MaxSumSubArray();
            System.out.println(ms.kadane(a));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
