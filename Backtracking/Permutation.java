package Backtracking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 * Ashesh Vidyut (Drift King) *
 */
/*
    Generate all permutation of a array of numbers or characters.
    It is less time consuming to use c++ next permuation method for generating permutation
    do{
    }while(next_permutation(array, array+len)); or
    do{
    }while(next_permutation(st.begin(), st.end())); or
 */
public class Permutation {
    public void permute(int ar[], int i){
        if(i == ar.length){
            System.out.println(Arrays.toString(ar));
            return ;
        }
        for (int j = i; j < ar.length; j++) {
            int tmp = ar[j];
            ar[j] = ar[i];
            ar[i] = tmp;
            permute(ar, i + 1);
            tmp = ar[j];
            ar[j] = ar[i];
            ar[i] = tmp;
        }
    }
    public static void main(String[] args) {
        try {
            Permutation p = new Permutation();
            int ar[] = {1, 2, 3, 4, 5, 6};
            p.permute(ar, 0);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
