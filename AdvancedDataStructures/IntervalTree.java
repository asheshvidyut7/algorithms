package AdvancedDataStructures;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 *
 */

public class IntervalTree {
    public IntervalTreeNode root;
    public void insert(int l, int r){
        root = put(root, l, r);
    }
    public IntervalTreeNode put(IntervalTreeNode node, int l, int r){
        if(node == null){
            node = new IntervalTreeNode(l, r);
            return node;
        }
        if(node.leftind > l){
            node.left = put(node.left, l, r);
        }
        else
            node.right = put(node.right, l, r);
        node.max_below = Math.max(r, node.max_below);
        return node;
    }
    public IntervalTreeNode search(int l, int r){
        return intervalSearch(root, l, r);
    }
    public IntervalTreeNode intervalSearch(IntervalTreeNode node, int l, int r){
        if(node == null)
            return null;
        if(overlap(node, l, r)){
            return node;
        }
        if(node.left != null && node.left.max_below >= l){
            return intervalSearch(node.left, l, r);
        }
        return intervalSearch(node.right, l, r);
    }
    public boolean overlap(IntervalTreeNode n, int l, int r){
        if(n.leftind <= r && l <= n.rightind){
            return true;
        }
        return false;
    }
    public void inorder(IntervalTreeNode node){
        if(node!=null){
            inorder(node.left);
            System.out.println(node);
            inorder(node.right);
        }
    }
    public static void main(String[] args) {
        try {
            IntervalTree it = new IntervalTree();
            int ar[][] = {{15, 20}, {10, 30}, {17, 19},
                    {5, 20}, {12, 15}, {30, 40}};
            for (int i = 0; i < ar.length; i++) {
                it.insert(ar[i][0], ar[i][1]);
            }
            it.inorder(it.root);
            IntervalTreeNode s = it.search(6, 7);
            System.out.println("search result");
            if(s == null){
                System.out.println("no overlap");
            }
            else{
                System.out.println(s);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
