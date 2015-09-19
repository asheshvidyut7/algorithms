package AdvancedDataStructures;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.util.InputMismatchException;
import java.util.Vector;

/*
    Source - https://sites.google.com/site/indy256/algo/lca
    dfs is done to generate an order of nodes such that for any two nodes all nodes above them are present
    to do this, after adding a node to dfs order we just add the parent node after it. this will make the parent present
    after the node. so we will have redundant node. now we create a RMQ (Minimum) segment tree taking the depth as min value.
    so after that if we are given two node then we run the query from between the first occurrence or first node and first
    occurrence of last node (because between the first occurrence we will have all nodes that are above first one until second
    is found.
 */
/**
 *
 */
public class LowestCommonAncestor {
    int depth[];
    int dfs_order[];
    int n, ind;
    int first_occurr[];
    Vector<Integer> t[];
    SegmentTree st;
    public LowestCommonAncestor(Vector<Integer> tree[], int root){
        int nodes = tree.length;
        this.depth = new int[nodes];
        Arrays.fill(depth, -1);
        this.n = 2 * nodes - 1;
        this.dfs_order = new int[n];
        this.first_occurr = new int[n];
        Arrays.fill(first_occurr, -1);
        this.t = tree;
        ind = 0;
        dfs(root, 0);
        this.st = new SegmentTree(dfs_order, depth);
        for (int i = 0; i < n; i++) {
            if(first_occurr[dfs_order[i]] == -1)
                first_occurr[dfs_order[i]] = i;
        }
    }
    public int lca(int a, int b){
        int indexf = Math.min(first_occurr[a], first_occurr[b]);
        int indexs = Math.max(first_occurr[a], first_occurr[b]);
        return st.minquery(indexf, indexs);
    }
    public void dfs(int node, int dep){
        depth[node] = dep;
        dfs_order[ind++] = node;
        for(int ch : t[node]){
            if(depth[ch] == -1){
                dfs(ch, dep + 1);
                dfs_order[ind++] = node; //every node is added twice so size of dfs_order is 2 * nodes
            }
        }
    }
    public static void main(String[] args) {
        try {
            Vector<Integer> tree[] = new Vector[10];
            for (int i = 0; i < 10; i++) {
                tree[i] = new Vector<Integer>();
            }
            tree[0].add(1);
            tree[0].add(2);
            tree[1].add(0);
            tree[2].add(0);
            tree[2].add(5);
            tree[2].add(6);
            tree[5].add(2);
            tree[6].add(2);
            tree[1].add(3);
            tree[1].add(4);
            tree[3].add(1);
            tree[4].add(1);
            tree[3].add(7);
            tree[3].add(8);
            tree[8].add(3);
            tree[7].add(3);
            LowestCommonAncestor lca = new LowestCommonAncestor(tree, 0);
            for (int i = 0; i < 10; i++) {
                for (int j = i; j < 10; j++) {
                    System.out.println(i+" "+j+" lca = "+lca.lca(i, j));
                }
            }
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
class SegmentTree{
    int dar[], ar[];
    SegmentTNode root = null;
    public SegmentTree(int ar[], int depth[]){
        this.ar = ar;
        this.dar = depth;
        root = put(root, 0, ar.length - 1, ar, depth);
    }
    public SegmentTNode put(SegmentTNode n, int l, int r, int ar[], int dar[]){
        if(n == null){
            n = new SegmentTNode(l, r);
        }
        if(l < r){
            int mid = (l + r) >> 1;
            n.left = put(n.left, l, mid, ar, dar);
            n.right = put(n.right, mid + 1, r, ar, dar);
            if(dar[n.left.minpos] < dar[n.right.minpos]){
                n.minpos = n.left.minpos;
            }
            else{
                n.minpos = n.right.minpos;
            }
        }
        else if(l == r){
            n.minpos = ar[l];
        }
        else
            return null;
        return n;
    }
    public int minquery(int a, int b){
        return query(root, a, b);
    }
    public int query(SegmentTNode n, int a, int b){
        if(n == null){
            return Integer.MAX_VALUE;
        }
        if(n.l > b || n.r < a){
            return Integer.MAX_VALUE;
        }
        if(n.l >= a && n.r <= b){
            return n.minpos;
        }
        int maxql = query(n.left, a, b);
        int maxqr = query(n.right, a, b);
        if(maxql == Integer.MAX_VALUE){
            return maxqr;
        }
        else if(maxqr == Integer.MAX_VALUE){
            return maxql;
        }
        else{
            if(dar[maxql] < dar[maxqr]){
                return maxql;
            }
            else{
                return maxqr;
            }
        }
    }
}
class SegmentTNode{
    int l, r;
    int minpos;
    SegmentTNode left, right;
    public SegmentTNode(int l, int r){
        this.l = l;
        this.r = r;
    }
}