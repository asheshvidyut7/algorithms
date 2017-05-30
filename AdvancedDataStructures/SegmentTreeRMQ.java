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
    Range Min/Max Query Problem with Segment Tree
    For solving the RMQ problem we can also use segment trees. A segment tree is a heap-like data structure
    that can be used for making update/query operations upon array intervals in logarithmical time.
    We define the segment tree for the interval [i, j] in the following recursive manner:
    the first node will hold the information for the interval [i, j]
    if i<j the left and right son will hold the information for the intervals [i, (i+j)/2] and [(i+j)/2+1, j]
    *** Time Complexity *** For tree construction is O(n). There are total 2n-1 nodes, and value of every node is
    calculated only once in tree construction.
    For query is O(logn). To query a range minimum, we process at most two nodes at every level and number of levels
    is O(logn).
 */

public class SegmentTreeRMQ {
    public int ar[];
    SegmentTreeNode root = null;
    public SegmentTreeRMQ(int ar[]){
        this.ar = ar;
        buildTree();
    }
    public void buildTree(){
        this.root = put(root, 0, ar.length - 1);
    }
    public SegmentTreeNode put(SegmentTreeNode node, int l, int r){
        if(node == null)
            node = new SegmentTreeNode(l,r);
        if(l == r){
            node.left = null;
            node.right = null;
            node.val = ar[l];
        }
        else if(l < r){
            int mid = (l + r) / 2;
            node.left = put(node.left, l, mid);
            node.right = put(node.right, mid + 1, r); /* for range max qurey, change to Math.max*/
            node.val = Math.min(node.left.val, node.right.val);
        }
        else
            return null;
        return node;
    }
    public int rangeMin(int l, int r){
        return findMin(root, l, r);
    }
    public int findMin(SegmentTreeNode node, int l, int r){
        if(node == null)
            return Integer.MAX_VALUE;
        if(l <= node.leftind && r >= node.rightind){
            return node.val;
        }
        if(node.rightind < l || node.leftind > r){      /** Important Line **/
            return Integer.MAX_VALUE;
        }
        return Math.min(findMin(node.left, l, r), findMin(node.right, l, r));
    }
    public static void main(String[] args) {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
            String sar[] = (in.readLine()).split(" ");
            int ar[] = new int[sar.length];
            for(int i = 0;i < sar.length; i++)
                ar[i] = Integer.parseInt(sar[i]);
            SegmentTreeRMQ stob = new SegmentTreeRMQ(ar);
            for(int i = 0; i < ar.length; i++)
                for(int j = i ;j < ar.length; j++){
                    System.out.println("Range Min for i "+i+" j "+j+"= "+stob.rangeMin(i, j));
                }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
