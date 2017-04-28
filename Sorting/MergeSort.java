package  Sorting;
/**
 * Ashesh Vidyut (Drift King) *
 */
import org.omg.PortableServer._ServantLocatorStub;

import java.io.*;
import java.util.*;

/*
    Initially the merge_sort routine goes on dividing the array into two parts until only two elements are left
    In first part only index 0 remains and in second part only index 1 remains
	When q goes down to 1, only then the merge routine executes and then write the merge routine considering only two index which are 
	0 and 1. So writing the merge routing we split the original array into two halves L[p,m] and K[m+1,q]. Next merge these two and store
	value in original array in sorted order. So since p = 0 and q = 1 so mid = 0, we see that for first array L the loop goes from 
	p to mid(inclusive) and for second from mid+1 to q(inclusive) because if we do < q then no element will be added to K.
    *** Time Complexity ***-- average (nlogn) worst (nlogn)
 */
public class MergeSort{
    public static void main(String[] args){
        try{

            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            String sar[] = (in.readLine()).split(" ");
            int ar[] = new int[sar.length];
            for (int i = 0; i < ar.length; i++){
                ar[i] = Integer.parseInt(sar[i]);
            }
            merge_sort(ar, 0, ar.length-1);
            System.out.println(Arrays.toString(ar));
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void merge_sort(int ar[], int p, int q){
        if(p < q){
            int mid = (p + q) / 2;
            merge_sort(ar, p, mid);
            merge_sort(ar, mid + 1, q);
            merge(ar, p, mid, q);
        }
    }
    public static void merge(int a[], int p, int m, int q){
        int len1 = m - p + 1;
        int len2 = q - m;
        int l[] = new int[len1+1];
        int k[] = new int[len2+1];
        int ind = 0;
        for (int i = p; i <= m; i++) {
            l[ind] = a[i];
            ind++;
        }
        ind = 0;
        for (int i = m+1; i <= q; i++) {
            k[ind] = a[i];
            ind++;
        }
        l[len1] = Integer.MAX_VALUE;
        k[len2] = Integer.MAX_VALUE;
        int ind1 = 0;
        int ind2 = 0;
        for (int i = p; i <= q; i++){
            if(l[ind1] < k[ind2]){
                a[i] = l[ind1];
                ind1++;
            }
            else{
                a[i] = k[ind2];
                ind2++;
            }
        }
    }
}
