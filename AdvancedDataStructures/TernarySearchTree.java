package AdvancedDataStructures;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/**
 *
 */
/*
    A ternary search tree is a special trie data structure where the child nodes of a standard
    trie are ordered as a binary search tree.

    Representation of ternary search trees:
    Unlike trie(standard) data structure where each node contains 26 pointers for its children,
    each node in a ternary search tree contains only 3 pointers:
        1. The left pointer points to the node whose value is less than the value in the current node.
        2. The equal pointer points to the node whose value is equal to the value in the current node.
        3. The right pointer points to the node whose value is greater than the value in the current node.

    Tries are suitable when there is a proper distribution of words over the alphabets so that spaces are
    utilized most efficiently. Otherwise ternary search trees are better.
    Ternary search trees are efficient to use(in terms of space) when the strings to be stored share a
    common prefix.

    Applications of ternary search trees:
    1. Ternary search trees are efficient for queries like “Given a word, find the next word in
    dictionary(near-neighbor lookups)” or “Find all telephone numbers starting with 9342 or “typing few starting
    characters in a web browser displays all website names with this prefix”(Auto complete feature)”.

    2. Used in spell checks: Ternary search trees can be used as a dictionary to store all the words.
    Once the word is typed in an editor, the word can be parallel searched in the ternary search tree to
    check for correct spelling.

 */
public class TernarySearchTree {
    public TSTNode root;
    class TSTNode{
        public char c;
        TSTNode left, right, mid;
        int val;
    }
    public boolean contains(String key){
        return get(key) != -1;
    }
    public int get(String key){
        TSTNode x = get(root, key, 0);
        if(x == null)
            return -1;
        return x.val;
    }
    private TSTNode get(TSTNode x, String key, int d){
        if (x == null) return null;
        char c = key.charAt(d);
        if      (c < x.c)              return get(x.left,  key, d);
        else if (c > x.c)              return get(x.right, key, d);
        else if (d < key.length() - 1) return get(x.mid,   key, d+1);
        else                           return x;
    }
    public void put(String s, int val) {
        if (!contains(s))
            root = put(root, s, val, 0);
    }

    private TSTNode put(TSTNode x, String s, int val, int d) {
        char c = s.charAt(d);
        if (x == null) {
            x = new TSTNode();
            x.c = c;
        }
        if      (c < x.c)             x.left  = put(x.left,  s, val, d);
        else if (c > x.c)             x.right = put(x.right, s, val, d);
        else if (d < s.length() - 1)  x.mid   = put(x.mid,   s, val, d+1);
        else                          x.val   = val;
        return x;
    }
    public String longestPrefixOf(String s) {
        if (s == null || s.length() == 0) return null;
        int length = 0;
        TSTNode x = root;
        int i = 0;
        while (x != null && i < s.length()) {
            char c = s.charAt(i);
            if      (c < x.c) x = x.left;
            else if (c > x.c) x = x.right;
            else {
                i++;
                if (x.val != -1) length = i;
                x = x.mid;
            }
        }
        return s.substring(0, length);
    }
    public static void main(String[] args) {
        try {
            TernarySearchTree st = new TernarySearchTree();
            st.put("ashesh",7);
            System.out.println(st.contains("ashesh"));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
