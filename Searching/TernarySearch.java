package Searching;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/**
<<<<<<< HEAD
 *
=======
 * Ashesh Vidyut (Drift King) *
>>>>>>> c6aee27e327e96a58c4583ac08325c3bed0bb43f
 */
/*
    Suppose you have a function f which is decreasing up to a certain point then increases
    (or vice versa) in the interval [a,b]. In the next paragraph, I assume decreasing first then
    increasing -- otherwise reverse the < and > signs.
    So, now let's say you want to find the point x in [a,b] such that f(x) is a minimum
    so pick g = a + (b-a)/3 and h = a + 2*(b-a)/3).
 */
public class TernarySearch {
    final int epsilon = (int)1e9;
    public int ternarySearch(int a, int b){
        int min = a;
        int max = b;
        int g, h;
        while(max - min > epsilon){
            g = min + (max - min)/3;
            h = min + 2 * (max - min)/3;
            if(f(g) < f(h))
                max = h;
            else
                min = g;
        }
        return (max + min)/2;
    }
    public int f(int g){
        return 1;
    }
    public static void main(String[] args) {
        try {

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
