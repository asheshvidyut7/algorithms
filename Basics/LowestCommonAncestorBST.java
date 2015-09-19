package Basics;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 *
 */
/*
    The LCA of n1 and n2 in T is the shared ancestor of n1 and n2 that is located farthest from the root.
    Computation of lowest common ancestors may be useful, for instance, as part of a procedure for
    determining the distance between pairs of nodes in a tree: the distance from n1 to n2 can be computed
    as the distance from the root to n1, plus the distance from the root to n2, minus twice the distance
    from the root to their lowest common ancestor.

    Solution -
    The main idea of the solution is, while traversing from top to bottom,
    the first node n we encounter with value between n1 and n2, i.e., n1 < n < n2 or
    same as one of the n1 or n2, is LCA of n1 and n2 (assuming that n1 < n2).

    So just recursively traverse the BST in, if node's value is greater than both n1 and n2 then our
    LCA lies in left side of the node, if it's is smaller than both n1 and n2, then LCA lies on right side.
    Otherwise root is LCA (assuming that both n1 and n2 are present in BST)
 */
class BSTNode{
    int val;
    BSTNode left;
    BSTNode right;
    public BSTNode(int v){
        this.val = v;
    }
    public BSTNode(int v, BSTNode l, BSTNode r){
        this.val = v;
        this.left = l;
        this.right = r;
    }
}
class LowestCommonAncestorBST {
    public BSTNode lca(BSTNode root, int n1, int n2){
        if(root == null){
            return null;
        }
        if(n1 < root.val && n2 < root.val){
            return lca(root.left, n1, n2);
        }
        else if(n2 >root.val && n1 > root.val){
            return lca(root.right, n1, n2);
        }
        return root;
    }
    public static void main(String[] args) {
        try {
            LowestCommonAncestorBST lca = new LowestCommonAncestorBST();
            BSTNode root = new BSTNode(20);
            root.left = new BSTNode(8);
            root.right = new BSTNode(22);
            root.left.left = new BSTNode(4);
            root.left.right = new BSTNode(12);
            root.left.right.left = new BSTNode(10);
            root.left.right.right = new BSTNode(14);
            System.out.println(lca.lca(root,10,14).val);
            System.out.println(lca.lca(root,14,8).val);
            System.out.println(lca.lca(root,10,22).val);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
