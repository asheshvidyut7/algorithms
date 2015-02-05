package NumberTheory;

import java.io.*;
import java.util.*;
import java.math.*;

/**
 * Ashesh Vidyut (Drift King) *
 */
/*
    Total number of possible Binary Search Trees with n different keys = Catalan Number
    Cn = ((2n)!/n!*n!)(n+1)
    The first few Catalan numbers for n = 0, 1, 2, 3, … are 1, 1, 2, 5, 14, 42, 132, 429, 1430, 4862,
    Catalan numbers are a sequence of natural numbers that occurs in many interesting counting problems
    like following.
        1. Cn is the number of expressions containing n pairs of parentheses which are correctly matched. For n = 3,
           possible expressions are ((())), ()(()), ()()(), (())(), (()()).
        2. Cn is the number of possible "Binary Search Trees with n keys"
           Number of Binary Tree with n keys are 2^n - n
        3. Cn is the number of full binary trees (A rooted binary tree is full if every vertex has either two
           children or no children) with n+1 leaves.
        4. Cn is the number of different ways n + 1 factors can be completely parenthesized
           (or the number of ways of associating n applications of a binary operator).
           For n = 3, for example, we have the following five different parenthesizations of four factors:
           ((ab)c)d     (a(bc))d     (ab)(cd)     a((bc)d)     a(b(cd))
        5. Cn is the number of monotonic paths along the edges of a grid with n × n square cells, which do not pass
           above the diagonal. A monotonic path is one which starts in the lower left corner, finishes in the
           upper right corner, and consists entirely of edges pointing rightwards or upwards.
        6. Cn is the number of different ways a convex polygon with n + 2 sides can be cut into triangles by
           connecting vertices with straight lines (a form of Polygon triangulation).
        7. Cn is the number of permutations of {1, ..., n} that avoid the pattern 123 (or any of the other patterns
           of length 3); that is, the number of permutations with no three-term increasing subsequence.
           For n = 3, these permutations are 132, 213, 231, 312 and 321. For n = 4, they are 1432, 2143, 2413,
           2431, 3142, 3214, 3241, 3412, 3421, 4132, 4213, 4231, 4312 and 4321.
 */
public class CatalanNumber {
    // O(n^2) DP solution
    /*
        Using recursive formula Co = 1
        C(n+1) = {summation i = 0 to n (C(i) * C(n-i))} for n>=0
     */
    public long catalanDP(int n){
        long catalan[] = new long[n+1];
        catalan[0] = catalan[1] = 1;
        for (int i = 2 ; i <= n ; i++){
            catalan[i] = 0;
            for (int j = 0; j < i; j++)
                catalan[i] += catalan[j] * catalan[i-j-1];
        }
        return catalan[n];
    }
    // O(n) solution with Binomial Coefficient
    /* using the formula Cn = (n+1)^-1 * (2*n C n)    */
    public long catalan(int n){
        long res = ncr(2*n, n);
        return res/(n+1);
    }
    public long ncr(int n, int r){
        long res = 1;
        int i = Math.min(n-r, r);
        for (int j = 1; j <= i; j++,n--) {
            res *= n;
            res /= j;
        }
        return res;
    }
    public static void main(String[] args) {
        try {
            CatalanNumber cn = new CatalanNumber();
            System.out.println(cn.catalanDP(5));
            System.out.println(cn.catalanDP(9));
            System.out.println(cn.catalan(5));
            System.out.println(cn.catalan(9));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
