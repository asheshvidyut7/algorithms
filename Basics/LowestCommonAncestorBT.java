package Basics;

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
import java.util.Vector;

/**
<<<<<<< HEAD
 *
=======
 * Ashesh Vidyut (Drift King) *
>>>>>>> c6aee27e327e96a58c4583ac08325c3bed0bb43f
 */
class BTNode{
    int val;
    BTNode right;
    BTNode left;
    public BTNode(int v){
        this.val = v;
    }
}
public class LowestCommonAncestorBT {
    public int lca(BTNode root, int a, int b){
        Vector<Integer> path1, path2;
        path1 = new Vector<Integer>();
        path2 = new Vector<Integer>();
        if(findPath(root, a, path1) && findPath(root, b, path2)){
            int i;
            for (i = 0; i < Math.min(path1.size(), path2.size()); i++) {
                if(path1.get(i) != path2.get(i))
                    break;
            }
            return path1.get(i - 1);
        }
        else
            return -1;
    }
    public boolean findPath(BTNode root, int v, Vector<Integer> path){
        if(root == null){
            return false;
        }
        path.add(root.val);
        if(root.val == v)
            return true;
        if(findPath(root.left, v, path) || findPath(root.right, v, path)){
            return true;
        }
        path.remove(path.size() - 1);
        return false;
    }
    public static void main(String[] args) {
        try {
            BTNode root = new BTNode(1);
            root.left = new BTNode(2);
            root.right = new BTNode(3);
            root.right.right = new BTNode(7);
            root.right.left = new BTNode(6);
            root.left.right = new BTNode(5);
            root.left.left = new BTNode(4);
            LowestCommonAncestorBT lcabt = new LowestCommonAncestorBT();
            System.out.println(lcabt.lca(root, 4, 5));
            System.out.println(lcabt.lca(root, 4, 6));
            System.out.println(lcabt.lca(root, 3, 4));
            System.out.println(lcabt.lca(root, 2, 4));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
