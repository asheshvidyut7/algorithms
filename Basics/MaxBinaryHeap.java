package Basics;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Ashesh Vidyut (Drift King) *
 */
/*
    Binary heap--Array representation of Heap ordered Complete Binary Tree
    Complete Binary tree has both nodes left and right except at bottom(Perfectly balanced)
    Parent(i)->at i/2 ; Left Child 2*(i) ;Rigth Child 2*(i)+1
    Heap property order in which trees nodes are kept
    2 types of Heap Max Heap, Min Heap
        In Max Heap-> A[Parent(i)]>=A[i]              Element at parent is greater than Child
        In Min Heap -> A[Parent(i)]<=A[i]				Element at parent is less than its Child
    Largest Element in Max Heap is at root
    Smallest Element in Min Heap is at root
    For Heap Sort Max Heap is Used, HeapSort(nlogn)
    Methods-Max Heapify (logn) {maintain the heap property},Build max heap (n)
    {build max heap from unordered array}
*/
public class MaxBinaryHeap {
    private int bt[];
    public MaxBinaryHeap(int n,int ar[]){
        bt = new int[n+1];
        bt[0] = -7;
        for(int i = 0; i < n; i++)
            bt[i + 1] = ar[i];
        buildMaxHeap(bt);
    }
    public void buildMaxHeap(int a[]){        //build heap with max property
        int len = a.length;   //since len/2 nodes wont have child
                            //because (len/2+1)*2 (left child) becomes greater than size
        for(int i = len / 2; i >= 1; i--){
            maxHeapify(a, i);
        }
    }
    public void maxHeapify(int a[],int ind){              //maintains heap property at ind
        int lind = ind * 2;
        int rind = (ind * 2) + 1;
        int largestind;
        if(lind >= a.length && rind >= a.length)
            return ;
        if(lind < a.length && a[lind] > a[ind]){ //voilated coz in max binary heap parent is max
            largestind = lind;
        }
        else largestind = ind;
        if(rind < a.length && a[rind] > a[largestind]){//comparing with right we want the max of 3 at root
            largestind = rind;
        }
        if(largestind != ind){
            //exchange largest with parent ; make this child the parent
            int temp = a[ind];
            a[ind] = a[largestind];
            a[largestind] = temp;
            // since it is reordered again check of Heap property at new index
            maxHeapify(a, largestind);
        }
    }
    public void printTree(){
        for(int i = 0;i < bt.length; i++){
            System.out.println(bt[i]);
        }
    }
    public static void main(String[] args) {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
            String sar[] = (in.readLine()).split(" ");
            int ar[] = new int[sar.length];
            for(int i = 0;i < sar.length; i++){
                ar[i]=Integer.parseInt(sar[i]);
            }
            MaxBinaryHeap ob = new MaxBinaryHeap(ar.length,ar);
            ob.printTree();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}