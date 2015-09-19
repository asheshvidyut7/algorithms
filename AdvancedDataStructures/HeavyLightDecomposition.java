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

/**
 *
 */
/*
    In progress
    Theory Read Anudeep Blog
    We create a base array during HLD to keep successive nodes so that we can RQM in the chain
 */
public class HeavyLightDecomposition {
    int subsize[];
    int parent[];
    int depth[];
    int chainNo = 0;
    int chainHead[];
    int chainPos[];
    int chainInd[];
    int chainSize[];
    int n;
    Vector<Integer> tree[];
    public HeavyLightDecomposition (Vector<Integer> t[]){
        this.tree = t;
        this.n = t.length;
        this.chainHead = new int[n];
        this.chainInd = new int[n];
        this.chainPos = new int[n];
        this.chainSize = new int[n];
        this.parent = new int[n];
        this.subsize = new int[n];
        Arrays.fill(parent, -1);
        Arrays.fill(chainHead, -1);
        dfs(0, -1, 0); // to set subsize, depth, parent of each node
        hld(0); // heavy light decomposition
    }
//
//    int query_up(int u, int v) {
//        if(u == v) return 0; // Trivial
//        int uchain, vchain = chainInd[v], ans = -1;
//        // uchain and vchain are chain numbers of u and v
//        while(1) {
//            uchain = chainInd[u];
//            if(uchain == vchain) {
//                // Both u and v are in the same chain, so we need to query from u to v, update answer and break.
//                // We break because we came from u up till v, we are done
//                if(u==v) break;
//                query_tree(1, 0, ptr, posInBase[v]+1, posInBase[u]+1);
//                // Above is call to segment tree query function
//                if(qt[1] > ans) ans = qt[1]; // Update answer
//                break;
//            }
//            query_tree(1, 0, ptr, posInBase[chainHead[uchain]], posInBase[u]+1);
//            // Above is call to segment tree query function. We do from chainHead of u till u. That is the whole chain from
//            // start till head. We then update the answer
//            if(qt[1] > ans) ans = qt[1];
//            u = chainHead[uchain]; // move u to u's chainHead
//            u = pa[0][u]; //Then move to its parent, that means we changed chains
//        }
//        return ans;
//    }
    public void hld(int node){
        if(chainHead[chainNo] == -1)
            chainHead[chainNo] = node;
        chainInd[node] = chainNo;
        chainPos[node] = chainSize[chainNo];
        chainSize[chainNo]++;
        int ind = -1, maxsubind = -1;
        for (int ch : tree[node]){
            if(maxsubind < subsize[ch]){
                maxsubind = subsize[ch];
                ind = ch;
            }
        }
        if(ind >= 0){
            hld(ind);
        }
        for (int ch : tree[node]){
            if(ch != ind){
                chainNo++;
                hld(ch);
            }
        }
    }
    public void dfs(int node, int parent, int depthvar){
        this.parent[node] = parent;
        this.depth[node] = depthvar;
        this.subsize[node] = 1;
        for (int ch : tree[node]){
            if(ch != parent){
                dfs(ch, node, depthvar + 1);
                subsize[node] += subsize[ch];
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

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
