package AdvancedDataStructures;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
<<<<<<< HEAD
 *
=======
 * Ashesh Vidyut (Drift King) *
>>>>>>> c6aee27e327e96a58c4583ac08325c3bed0bb43f
 */
/*
    Binary Index Tree or "Fenwick" Tree
    Alternative to RMQ
    Each integer can be represented as sum of powers of two. In the same way, cumulative frequency
    can be represented as sum of sets of sub-frequencies. In our case, each set contains some successive
    number of non-overlapping frequencies.
    Using some data structure (i.e. RMQ) we can solve this problem with the worst case time complexity
    of O(m log n). Another approach is to use Binary Indexed Tree data structure, also with the worst
    time complexity O(m log n) --
    but Binary Indexed Trees are much easier to code, and require less memory space, than RMQ.

    idx is some index of BIT. r is a position in idx of the last digit 1 (from left to right) in
    binary notation. tree[idx] is sum of frequencies from index (idx - 2^r + 1) to index idx
    (look at the Table 1.1 for clarification). We also write that idx is responsible for indexes
    from (idx - 2^r + 1) to idx (note that responsibility is the key in our algorithm and
    is the way of manipulating the tree).

	    	1	2		3	4		5	6		7	8		9	10		11	12		13	14		15	16
    tree	1	1..2	3	1..4	5	5..6	7	1..8	9	9..10	11	9..12	13	13..14	15	1..16

    given index in tree and the ranges sum it keeps
    it keeps ranges from (ind-2^r+1 to ind) where r is index of first one from right(in binary ind) 0-based

    cumulative frequency up to index ind(eg for 13) c[13]=tree[13]+tree[12]+tree[8];
    we get c[13] that is a[1]...a[13]

    To find next index in tree after 13 let ind be the variable we do ind+=(ind & -ind);
    To find next index in tree before ind we do ind-=(ind & -ind);
    *** Remember that in tree we don't use the index 0 tree is 1 based ***
*/

public class BinaryIndexedTree {
    public long binarIndexedTree[];
    public int ar[];
    public BinaryIndexedTree(int a[]){
        this.ar = new int[a.length + 1];
        System.arraycopy(a, 0, ar, 1, a.length);
        this.binarIndexedTree = new long[a.length + 1];
        buildTree();
    }
    public void buildTree(){
        for (int i = 1; i < ar.length; i++) {
            update(i, ar[i]);
        }
    }
    public void updateIndex(int ind, int v){
        int diff = v - ar[ind];
        ar[ind] += diff;
        update(ind, diff);
    }
    public void update(int ind, int v){
        for (int i = ind; i < binarIndexedTree.length; i+= (i & -i)) {
            binarIndexedTree[i] += v;
        }
    }
    public long cummulativeSum(int ind){
        long sum = 0;
        for (int i = ind; i >=1 ; i-= (i & -i)) {
            sum += binarIndexedTree[i];
        }
        return sum;
    }
    public long sumRange(int l, int r){
        return cummulativeSum(r) - cummulativeSum(l-1);
    }
    public static void main(String[] args) {
        try {
            int ar[] = {6, 4, 2, 7, 2, 7};
            BinaryIndexedTree bt = new BinaryIndexedTree(ar);
            System.out.println(Arrays.toString(bt.binarIndexedTree));
//            System.out.println(bt.sumRange(1,7));
//            System.out.println(bt.sumRange(1,6));
//            System.out.println(bt.sumRange(1,5));
//            System.out.println(bt.sumRange(4,5));
//            System.out.println(bt.sumRange(2,4));
//            System.out.println(bt.sumRange(7,7));
//            bt.updateIndex(2,10);
//            System.out.println(bt.sumRange(2,3));
//            System.out.println(bt.sumRange(1,3));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
