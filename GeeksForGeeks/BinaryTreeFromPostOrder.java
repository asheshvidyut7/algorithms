package GeeksForGeeks;

import java.io.*;
import java.util.*;
import java.math.*;

/**
 * created by asheshvidyut on 27/07/17
 **/
public class BinaryTreeFromPostOrder {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            int tc = in.readInt();
            for (int t = 0; t < tc; t++) {
                int n = in.readInt();
                int inorder[] = new int[n];
                for (int i = 0; i < n; i++) {
                    inorder[i] = in.readInt();
                }
                int postorder[] = new int[n];
                for (int i = 0; i < n; i++) {
                    postorder[i] = in.readInt();
                }
                GfG g = new GfG();
                g.buildTree(inorder, postorder, n);
                preOrder(g.root);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void preOrder(Node node)
    {
        if (node == null)
            return;
        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }
}
/*
Please note that it's Function problem i.e.
you need to write your solution in the form Function(s) only.
Driver Code to call/invoke your function would be added by GfG's Online Judge.*/


class Node
{
	int data;
	Node left;
	Node right;

        Node(int value)
	{
		data = value;
		left = null;
		right = null;
	}
}

class GfG
{
    Node root = null;
    public void buildTree(int inorder[], int postorder[], int n) {
        int inStart = 0;
        int inEnd = inorder.length - 1;
        int postStart = 0;
        int postEnd = postorder.length - 1;
        root = buildTree(inorder, inStart, inEnd, postorder, postStart, postEnd);
    }
    public Node buildTree(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        if (inStart > inEnd || postStart > postEnd)
            return null;

        int rootValue = postorder[postEnd];
        Node root = new Node(rootValue);

        int k = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootValue) {
                k = i;
                break;
            }
        }

        root.left = buildTree(inorder, inStart, k - 1, postorder, postStart, postStart + (k - inStart) - 1);
        // Becuase k is not the length, it it need to -(inStart+1) to get the length
        root.right = buildTree(inorder, k + 1, inEnd, postorder, postStart + (k - inStart), postEnd - 1);
        // postStart+k-inStart = postStart+k-(inStart+1) +1

        return root;
    }
}
