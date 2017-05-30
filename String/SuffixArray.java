package String;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 *
 */
/*
    Suffix Array =  Array of Index of Suffixes that are sorted on the basis of their string.
    Use linearithmic time complexity Manber - Myer Algorithm linearithmic - O(nlogn)
    Uses -
        Suffix Array to find sub strings, unique sub strings ,longest repeating sub strings
        Suffix Array  construction in O(n^2(logn))

    *** Time Complexity *** O(n^2logn), O(nLogn) algorithm used for sorting.
    The sorting step itself takes O(n^2Logn) time as every comparison is a comparison of two strings
    and the comparison takes O(n) time.
    Naive Implementation of Suffix Array. Not recommended for use.
    Uses
        1. Finding Longest Repeated Substring
            *** Time Complexity *** O(n^2 log n ) pre processing O(n) finding
        2. Searching a String
            *** Time Complexity *** O(n^2 log n ) pre processing O(mLogn)
        3. Number of Unique Sub Strings in a String
            "Basically it length of suffix - the length of lcp with previous"
            uniq_sub_strings = |s| - S[1] + 1
            // thus we count all prefixes of the first suffix
            for i = 2 to N
            uniq_sub_strings += |s| - S[i] + 1 - L[i]

 */
public class SuffixArray {
    public Suffix suffix_ar[];
    public int lcp[];
    public String t;
    public SuffixArray(String s){
        this.t = s;
        suffix_ar = new Suffix[t.length()];
        lcp = new int[t.length()];
        lcp[0] = -7;
        for (int i = 0; i < t.length(); i++) {
            suffix_ar[i] = new Suffix(t, i);
        }
        Arrays.sort(suffix_ar);
        buildLcp();
    }
    public void buildLcp(){
        for (int i = 1; i < lcp.length; i++) {
            lcp[i] = lcp(suffix_ar[i-1].string, suffix_ar[i].string);
        }
    }
    public int lcp(String a, String b){
        for (int i = 0; i < Math.min(a.length(), b.length()); i++) {
            if(a.charAt(i) != b.charAt(i)){
                return i;
            }
        }
        return Math.min(a.length(), b.length());
    }
    public String longestRepeatedSubstring(){
        String ans;
        int maxlcp = -1; int maxind = -1;
        for (int i = 0; i < lcp.length; i++) {
            if(lcp[i] > maxlcp){
                maxlcp = lcp[i];
                maxind = i;
            }
        }
        ans = suffix_ar[maxind].string.substring(0, maxlcp);
        return ans;
    }
    public void search(String s){
        int i = 0; int j = suffix_ar.length-1;
        while(i <= j){
            int mid = (i + j) / 2;
            if(suffix_ar[mid].string.contains(s)){
                System.out.println("pattern found at index "+mid);
                return;
            }
            int cmp = suffix_ar[mid].string.compareTo(s);
            if(cmp < 0 ){
                i = mid + 1;
            }
            else
                j = mid - 1;
        }
        System.out.println("pattern not found");
    }
    public static void main(String[] args) {
        try {
            SuffixArray sa = new SuffixArray("geeksforgeeks is the best forgeeks");
            System.out.println(sa.longestRepeatedSubstring());
            SuffixArray sb = new SuffixArray("banana");
            sb.search("nan");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
