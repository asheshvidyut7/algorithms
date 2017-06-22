package Sorting;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
<<<<<<< HEAD
 *
=======
 * Ashesh Vidyut (Drift King) *
>>>>>>> c6aee27e327e96a58c4583ac08325c3bed0bb43f
 */
/*
    Heap Sort *** Time Complexity*** O(nlogn)
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
    Methods - Max Heapify (logn) {maintain the heap property},Build max heap (n) {
    build max heap from unordered array}

    Heap Sort
    In this we maintain a MaxBinaryHeap and since we know that Max Element is at the root,
    so we exchange the  last element with the root ,to get max at the last;
    after that we decrement the size of binary heap(to exclude the extracted element)
    Again we check for Max Heapify on root
    After that we again extract root since it is the largest and repeat the same
*/
public class HeapSort{
    private int bt[];
    public HeapSort(int n,int ar[])
    {
        bt = new int[n + 1];
        bt[0] = -7;
        for(int i = 0; i < n; i++)
            bt[i + 1] = ar[i];
        buildMaxHeap(bt);
    }
    public void buildMaxHeap(int a[]){        //build heap with max property
        int len = a.length;             //since len/2 nodes wont have child
                                   //because (len/2+1)*2 (left child) becomes greater than size
        for(int i = len / 2 ; i >= 1; i--){
            maxHeapify(a,i,len);
        }
    }
    //helper for HeapSort
    public void maxHeapify(int a[], int ind, int len){              //maintains heap property at ind
        int lind = ind * 2;
        int rind = (ind * 2) + 1;
        int largestind;
        if(lind >= len && rind >= len)
            return ;
        if(lind < len && a[lind] > a[ind]){	//voilated coz in max binary heap parent is max
            largestind = lind;
        }
        else largestind = ind;
        if(rind < len && a[rind] > a[largestind]){//comparing with right we want the max of 3 at root
            largestind = rind;
        }
        if(largestind != ind){
            //exchange largest with parent ; make this child the parent
            int temp = a[ind];
            a[ind] = a[largestind];
            a[largestind] = temp;
            // since it is reordered again check of Heap property at new index
            maxHeapify(a,largestind,len);
        }
    }
    public void printTree(){
        for(int i = 0; i < bt.length; i++){
            System.out.println(bt[i]);
        }
    }
    public void heapSort(){
        int size = bt.length;
        int i = bt.length - 1;
        while(i >= 2){
            int temp = bt[1];
            bt[1] = bt[i];
            bt[i] = temp;
            i--;
            size--;
            maxHeapify(bt, 1, size);
        }
    }

    public static void main(String[] args) {
        try{
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
            String sar[] = (in.readLine()).split(" ");
            int ar[] = new int[sar.length];
            for(int i = 0; i < sar.length; i++){
                ar[i]=Integer.parseInt(sar[i]);
            }
            HeapSort ob=new HeapSort(ar.length,ar);
            ob.heapSort();
            ob.printTree();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
