package DynamicProgramming;

import java.util.Arrays;

/**
 *
 */
/*
    Find the longest increasing Sub Sequence.
    Application of Longest Increasing Sub Sequence
    1. Building Bridges
        Given a river and n cities on left bank and n cities on right bank.
        Each city is given a number 1..n on left bank, and 1..n on right bank.
        Given two permutation of 1..n , first is left bank the second is right bank
        bridges can be built between two pairs at ith index of the permutation
        eg first perm = 7 4 3 6 2 1 5
          second perm = 5 3 2 4 6 1 7
          so bridge between 5 - 7, 3 - 4, 2 - 3 can be built
        Find the maximum number of bridges that can be built
        First sort second perm and swap corresponding element in firt
        first  = 1 3 4 6 7 2 5
        second = 1 2 3 4 5 6 7
        now just find the longest increasing subsequence in the first, this will give the answer
    2. Box Stacking Problem
    3. Maximum Sum Increasing SubSequence

    *** Time Complexity *** O(n^2)
 */
public class LongestIncreasingSubsequence {
    public int longestIncreasingSubsequence(int ar[]){
        int lis[] = new int[ar.length];
        Arrays.fill(lis, 1);
        for (int i = 1; i < ar.length; i++) {
            for (int j = 0; j < i; j++) {
                if(ar[i] > ar[j] && lis[i] < lis[j] + 1){
                    lis[i] =  lis[j] + 1;
                }
            }
        }
        int max_lis = Integer.MIN_VALUE;
        for (int i = 0; i < lis.length; i++) {
            int lc = lis[i];
            max_lis = Math.max(lc, max_lis);
        }
        return max_lis;
    }
    public static void main(String[] args) {
        try {
            LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
            int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 };
            System.out.println(lis.longestIncreasingSubsequence(arr));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
