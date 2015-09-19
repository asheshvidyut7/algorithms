package String;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

/**
 *
 */
/*
    Manber and Myers algorithm for construction of Suffix Array
    Suffix Array to find substrings, unique substrings etc
    *** Time Complexity *** "Linearithmic" O(n log n)

    Refer to "Suffix arrays: A new method for on-line string searches",
    by Udi Manber and Gene Myers

    Output:
    pos = The suffix array. Contains the n suffixes of str sorted in lexicographical order.
           Each suffix is represented as a single integer (the position of str where it starts).
    rank = The inverse of the suffix array. rank[i] = the index of the suffix str[i..n)
        in the pos array. (In other words, pos[i] = k <==> rank[k] = i)
        With this array, you can compare two suffixes in O(1): Suffix str[i..n) is smaller
        than str[j..n) if and only if rank[i] < rank[j]


    Begin of the O(n) longest common prefix algorithm
    Refer to "Linear-Time Longest-Common-Prefix Computation in Suffix
    Arrays and Its Applications" by Toru Kasai, Gunho Lee, Hiroki
    Arimura, Setsuo Arikawa, and Kunsoo Park.
    height[i] = length of the longest common prefix of suffix pos[i] and suffix pos[i-1]
    height[0] = 0

 */

public class SuffixArrayLinearithemic{
    private final int n;
    private final char[] str;
    public Integer[] pos;
    public int[] rank;
    private int[] cnt;
    private int[] next;
    public int[] lcp;
    private boolean[] bh;
    private boolean[] b2h;
    public SuffixArrayLinearithemic(char[] str){
        this.n = str.length;
        this.str = str;
        this.pos = new Integer[n];
        this.rank = new int[n];
        this.cnt = new int[n];
        this.next = new int[n];
        this.lcp = new int[n];
        this.bh = new boolean[n];
        this.b2h = new boolean[n];
        suffixSort();
        computeLCP();
    }
    public void suffixSort(){
        for (int i = 0; i < n; ++i)
            pos[i] = i;
        Arrays.sort(pos, 0, n, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return str[o1] - str[o2];
            }
        });
        for (int i = 0; i < n; ++i){
            bh[i] = i == 0 || str[pos[i]] != str[pos[i - 1]];
            b2h[i] = false;
        }
        for (int h = 1; h < n; h <<= 1){
            int buckets = 0;
            for (int i = 0, j; i < n; i = j){
                j = i + 1;
                while (j < n && !bh[j]) ++j;
                next[i] = j;
                ++buckets;
            }
            if (buckets == n) break;
            for (int i = 0; i < n; i = next[i]){
                cnt[i] = 0;
                for (int j = i; j < next[i]; ++j)
                    rank[pos[j]] = i;
            }
            ++cnt[rank[n - h]];
            b2h[rank[n - h]] = true;
            for (int i = 0; i < n; i = next[i]){
                for (int j = i; j < next[i]; ++j){
                    int s = pos[j] - h;
                    if (s >= 0) {
                        int head = rank[s];
                        rank[s] = head + cnt[head]++;
                        b2h[rank[s]] = true;
                    }
                }
                for (int j = i; j < next[i]; ++j){
                    int s = pos[j] - h;
                    if (s >= 0 && b2h[rank[s]])
                        for (int k = rank[s] + 1; k < n && !bh[k] && b2h[k]; ++k)
                            b2h[k] = false;
                }
            }
            for (int i = 0; i < n; ++i){
                pos[rank[i]] = i;
                bh[i] |= b2h[i];
            }
        }
        for (int i = 0; i < n; ++i)
            rank[pos[i]] = i;
    }

    public void computeLCP(){
        for (int i = 0, h = 0; i < n; ++i){
            if (rank[i] > 0) {
                int j = pos[rank[i] - 1];
                while (i + h < n && j + h < n && str[i + h] == str[j + h]) ++h;
                lcp[rank[i]] = h;
                if (h > 0) --h;
            }
        }
    }
    public Integer [] getArray(){
        return this.pos;
    }
    public int [] getLcp(){
        return this.lcp;
    }
    /*
    The first binary search locates the starting position of the interval,
    and the second one determines the end position:
    */
    public int[] search(String find){
        String text = String.valueOf(str);
        int n = text.length();
        int l = 0 , r = n;
        while(l < r){
            int mid = (l + r) / 2;
            String sufatmid = text.substring(pos[mid]);
            if (compare(find,sufatmid) == 1)
                l = mid + 1;
            else
                r = mid;
        }
        int s = l;r = n;
        while(l < r){
            int mid = (l + r) / 2;
            String sufatmid = text.substring(pos[mid]);
            if (compare(find,sufatmid) == -1)
                r = mid;
            else
                l = mid + 1;
        }
        int a[]={s,r};
        return a;
    }
    public int compare(String s1,String s2){
        int cmp = s1.compareTo(s2);
        if(cmp < 0)
            return -1;
        else if(cmp == 0)
            return 0;
        else
            return 1;
    }
    /* Longest Repeated Substring */
    public String lrs(){
        int ind = 1, maxlen = lcp[1];
        for(int i = 1; i < lcp.length; i++){
            if(lcp[i] > maxlen){
                ind = i;
                maxlen = lcp[i];
            }
        }
        String text = String.valueOf(str);
        String lrs = text.substring(pos[ind]).substring(0,maxlen);
        return lrs;
    }
    public static void main(String asdf[]){
        try{
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            String text = in.readLine();
            int n = text.length();
            SuffixArrayLinearithemic saob = new SuffixArrayLinearithemic(text.toCharArray());
            Integer []sa = saob.getArray();
            System.out.println("longest repeated substring");
            System.out.println(saob.lrs());

            int lcpar[]=saob.getLcp();
            for(int i=1;i<lcpar.length;i++){
                System.out.println(Integer.toString(lcpar[i]));
            }

            //********************finding the number of unique substrings
            long uniqsubstr = n-sa[0];
            for(int i=1;i<n;i++){
                int val = n - sa[i] - lcpar[i];
                uniqsubstr+=val;
            }
            System.out.println("Unique substring = "+Long.toString(uniqsubstr));

            /*********************finding the presence of substring
                Finding every occurrence of the pattern is equivalent to
                finding every suffix that begins with the substring */

            System.out.println("find the substring to find");
            String find = in.readLine();
            int ar[] = saob.search(find);
            int occuofsub = ar[1] - ar[0] + 1;
            if(ar[0] == ar[1]){
                if(ar[0] == sa.length){
                    System.out.println("no ocuurance");
                }
                else{
                    String contain = text.substring(sa[ar[0]]);
                    int ind = contain.indexOf(find);
                    if(ind >= 0)
                        System.out.println("occurance of substring in string is "+occuofsub);
                    else
                        System.out.println("no ocuurance");
                }
            }
            else
                System.out.println("occurance of substring in string is "+occuofsub);
            in.close();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}