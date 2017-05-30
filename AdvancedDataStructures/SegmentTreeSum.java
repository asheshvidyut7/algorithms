package AdvancedDataStructures;

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
    Segment Tree can also be used for find sum of numbers in the given range.
    *** Time Complexity ***
    For tree construction is O(n).
    For query is O(logn).
    For update is also O(logn).
 */
public class SegmentTreeSum {
    public SegmentTreeNode root;
    public int ar[];
    public SegmentTreeSum(int ar[]){
        this.ar = ar;
        buildTree();
    }
    public void buildTree(){
        this.root = put(null, 0, ar.length - 1);
    }
    public SegmentTreeNode put(SegmentTreeNode node, int l, int r){
        if(node == null){
            node = new SegmentTreeNode(l, r);
        }
        if(l == r){
            node.val = ar[l];
        }
        else if(l < r){
            int mid = ( l + r) / 2;
            node.left = put(node.left, l, mid);
            node.right = put(node.right, mid + 1, r);
            node.val = node.left.val + node.right.val;
        }
        else {
            return null;
        }
        return node;
    }
    public int rangeSum(int l, int r){
        return findSum(root, l, r);
    }
    public int findSum(SegmentTreeNode node, int l, int r){
        if(node == null)
            return 0;
        else if(l <= node.leftind && r >= node.rightind){
            return node.val;
        }
        else if( l > node.rightind || r < node.leftind)
            return 0;
        return findSum(node.left, l, r) + findSum(node.right, l, r);
    }
    public void update(int ind, int new_val){
        int diff = new_val - ar[ind];
        ar[ind] = new_val;
        updateTree(root, ind, diff);
    }
    public void updateTree(SegmentTreeNode node, int ind, int d){
        if(node == null)
            return ;
        if(node.leftind <= ind && ind <= node.rightind){
            node.val += d; /** do not return here because child containing the ind should be updated too. **/
        }
        else if( ind < node.leftind || ind > node.rightind){
            return ;
        }
        updateTree(node.left, ind, d);
        updateTree(node.right, ind, d);
    }
    public static void main(String[] args) {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
            String sar[] = (in.readLine()).split(" ");
            int ar[] = new int[sar.length];
            for(int i = 0;i < sar.length; i++)
                ar[i] = Integer.parseInt(sar[i]);
            SegmentTreeSum stob = new SegmentTreeSum(ar);
            for(int i = 0; i < ar.length; i++)
                for(int j = i+1;j < ar.length; j++){
                    System.out.println("Range Sum for i "+i+" j "+j+"= "+stob.rangeSum(i, j));
                }
            stob.update(0, 0);
            System.out.println("update 0 0");
            for(int i = 0; i < ar.length; i++)
                for(int j = i+1;j < ar.length; j++){
                    System.out.println("Range Sum for i "+i+" j "+j+"= "+stob.rangeSum(i, j));
                }
            stob.update(ar.length-1, 100);
            System.out.println("update last 100");
            for(int i = 0; i < ar.length; i++)
                for(int j = i+1;j < ar.length; j++){
                    System.out.println("Range Sum for i "+i+" j "+j+"= "+stob.rangeSum(i, j));
                }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
