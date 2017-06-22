package AdvancedDataStructures;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.util.InputMismatchException;

/**
<<<<<<< HEAD
 *
=======
 * Ashesh Vidyut (Drift King) *
>>>>>>> c6aee27e327e96a58c4583ac08325c3bed0bb43f
 */
public class SegmentTreeLazy{
    // build tree as usual
    // for both query and update, first resolve the lazy flag of node
    // then propagate the lazy to its children
    // in this way we only update the parent of node and after propagation we return,
    // we do not update the children at the same time, this makes Segment Tree More efficient
    SegmentTreeNodeLazy root = null;
    public SegmentTreeLazy(int ar[]){
        buildTree(ar);
    }
    public void buildTree(int a[]){
        root = put(root, 0, a.length - 1, a);
    }
    public SegmentTreeNodeLazy put(SegmentTreeNodeLazy n, int l, int r, int a[]){
        if(n == null){
            n = new SegmentTreeNodeLazy(l, r);
        }
        if(l < r){
            int mid = (l + r) / 2;
            n.left = put(n.left, l, mid, a);
            n.right = put(n.right, mid + 1, r, a);
            n.val = Math.max(n.left.val, n.right.val);
        }
        else if(l == r){
            n.val = a[l];
        }
        else{
            return null;
        }
        return n;
    }
    // increment all elements in the range l , r with value val
    public void update(int l, int r, int val){
        updateTree(root, l, r, val);
    }
    public void updateTree(SegmentTreeNodeLazy n, int l, int r, int val){
        if(n == null)
            return;
        // updating the previously marked lazy for this node,
        if(n.lazy != 0){
            n.val += n.lazy;
            // processed the lazy and now we have to spread this to its children
            if(n.left != null){
                n.left.lazy += n.lazy;
            }
            if(n.right != null){
                n.right.lazy += n.lazy;
            }
            n.lazy = 0;
        }
        if(n.l > r || n.r < l ){
            // no need to update
            return ;
        }
        if(n.l >= l && n.r <= r){
            // fully inside the range update node value
            n.val += val;
            // do not update the children, just mark them to be updated
            // increment their lazy
            if(n.left != null)
                n.left.lazy += val;
            if(n.right != null)
                n.right.lazy += val;
            return ;
        }
        // if the node is not fully in range then its children need to be updated
        updateTree(n.left, l, r, val);
        updateTree(n.right, l, r, val);
        // update the value of this node which is max of child nodes
        n.val = Math.max(n.left.val, n.right.val);
    }
    public int query(int l, int r){
        return queryTree(root, l, r);
    }
    public int queryTree(SegmentTreeNodeLazy n, int l, int r){
        if(n == null)
            return Integer.MIN_VALUE;
        if(n.r < l || n.l > r){
            return Integer.MIN_VALUE;
        }
        //resolve the lazy first
        if(n.lazy != 0){
            n.val += n.lazy;
            if(n.left != null){
                n.left.lazy += n.lazy;
            }
            if(n.right != null){
                n.right.lazy += n.lazy;
            }
            n.lazy = 0;
        }
        if(n.l >= l && n.r <= r){
            return n.val;
        }
        return Math.max(queryTree(n.left, l, r), queryTree(n.right, l, r));
    }
}
class SegmentTreeNodeLazy{
    public int lazy = 0;
    public SegmentTreeNodeLazy left, right;
    public int l, r;
    public int val;
    public SegmentTreeNodeLazy(int l, int r){
        this.l = l;
        this.r = r;

    }

}
class SegmentTreeLazyTest {
    public static void main(String[] args) {
        try {
            int ar[] = new int[]{1,2,3,4,5,8};
            SegmentTreeLazy st = new SegmentTreeLazy(ar);
            st.update(0, 7, 1);
            System.out.println(st.query(0, 7));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}