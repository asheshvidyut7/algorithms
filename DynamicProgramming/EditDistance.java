package DynamicProgramming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Ashesh Vidyut (Drift King) *
 */
/*
    Levenshtein distance
    Given two strings of size m, n and set of operations replace (R), insert (I) and delete (D) all at equal cost.
    Find minimum number of edits (operations) required to convert one string into another.
    The strings can be replaced by array of integers also.

 */
public class EditDistance {
    private int minimum(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }
    public int computeLevenshteinDistance(String str1,String str2){
        int[][] distance = new int[str1.length() + 1][str2.length() + 1];
        for (int i = 0; i <= str1.length(); i++)
            distance[i][0] = i;
        for (int j = 1; j <= str2.length(); j++)
            distance[0][j] = j;
        for (int i = 1; i <= str1.length(); i++)
            for (int j = 1; j <= str2.length(); j++)
                distance[i][j]=minimum(distance[i-1][j]+1,distance[i][j-1]+1,distance[i-1][j-1]+((str1.charAt(i-1)==str2.charAt(j-1))?0:1));
        return distance[str1.length()][str2.length()];
    }
    public int computeLevenshteinDistance(int ar1[],int ar2[]){
        int[][] distance = new int[ar1.length+1][ar2.length+1];
        for (int i=0;i<=ar1.length;i++)
            distance[i][0]=i;
        for (int j=1;j<=ar2.length;j++)
            distance[0][j] = j;
        for (int i=1;i<=ar1.length;i++)
            for (int j=1;j<= ar2.length;j++)
                distance[i][j]=minimum(distance[i - 1][j]+1,distance[i][j-1]+1,distance[i-1][j-1]+((ar1[i-1]==ar2[j-1])?0:1));
        return distance[ar1.length][ar2.length];
    }
    public static void main(String[] args) {
        try {
            EditDistance ed = new EditDistance();
            System.out.println(ed.computeLevenshteinDistance("Sunday", "Saturday"));
            int ar1[] = {1,2,3,4,5};
            int ar2[] = {1,3,4,4,5};
            System.out.println(ed.computeLevenshteinDistance(ar1,ar2));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
