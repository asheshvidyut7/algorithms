package Sorting;

/**
 *
 */

/*
    In this we have a partition routine which takes two indices L(low) and H(high). Takes a key =Ar[high]
    Partitions the arrays such that all elements in the left of new index of key is smaller than key and
    all elements in the right of new index of key is greater than key. and returns the new_index of key.
    This process is repeated for L(low) new_index-1 and new_index+1 and H(high)
    *** Time Complexity ***-- average (nlogn) worst(n^2)
 */
import java.io.*;
import java.util.*;

public class QuickSort {
	public static void main(String[] args) {
		try{
		    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            String sar[] = (in.readLine()).split(" ");
            int ar[] = new int[sar.length];
            for (int i = 0; i < ar.length; i++){
                ar[i] = Integer.parseInt(sar[i]);
            }
			quick_sort(ar, 0, ar.length - 1);
            System.out.println(Arrays.toString(ar));
        }
		catch(Exception e){
			e.printStackTrace();	
		}
	}
	public static void quick_sort(int a[], int l, int h){
		if(l < h){
			int p = partition(a, l, h);
            quick_sort(a, l, p - 1);
            quick_sort(a, p + 1, h);
		}
	}
    public static int partition(int a[], int l, int h){
        int key = a[h];
        int swap_ind = l - 1;
        for (int i = l; i <= h; i++) {
            if(a[i] < key){
                swap_ind++;
                int tmp = a[swap_ind];
                a[swap_ind] = a[i];
                a[i] = tmp;
            }
        }
        int tmp = a[swap_ind + 1];
        a[swap_ind+1] = key;
        a[h] = tmp;
        return swap_ind + 1;
    }
}
