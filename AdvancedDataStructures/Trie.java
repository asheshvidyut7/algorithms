package AdvancedDataStructures;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

/**
 * Ashesh Vidyut (Drift King) *
 */
/*
    Trie is an efficient information retrieval data structure. Using trie, search complexities can be
    brought to optimal limit (key length). If we store keys in binary search tree, a well balanced BST
    will need time proportional to M * log N, where M is maximum string length and N is number of keys
    in tree. Using trie, we can search the key in O(M) time. However the penalty is on trie storage
    requirements.
    *** Time Complexity *** Insert and search costs O(key_length), however the memory requirements
        of trie is O(ALPHABET_SIZE * key_length * N) where N is number of keys in trie.

    There are efficient representation of trie nodes (e.g. compressed trie, ternary search tree, etc.)
    to minimize memory requirements of trie.
 */
public class Trie {
    public boolean del = true;
    class TrieNode{
        public char car;
        public boolean end; // true if it is end of word
        public Map<Character, TrieNode> child;
        public TrieNode(HashMap<Character, TrieNode> mp){
            this.child = mp;
        }
        public TrieNode(char c){
            this.car = c;
            this.child = null;
        }
        public TrieNode(char c, boolean e, HashMap<Character, TrieNode> map){
            this.car = c;
            this.child = map;
            this.end = e;
        }
        public String toString(){
            return this.car+ " " + child.toString()+" "+end;
        }
    }
    TrieNode root = new TrieNode(new HashMap<Character, TrieNode>());
    public void put(String s){
        put(root, s, 0);
    }
    public void put(TrieNode tn, String s, int ind){
        if(!tn.child.containsKey(s.charAt(ind))){
            boolean val = (ind + 1 == s.length());
            TrieNode n = new TrieNode(s.charAt(ind), val, new HashMap<Character, TrieNode>());
            tn.child.put(s.charAt(ind), n);
        }
        else{
            if(ind + 1 == s.length()){
                tn.child.get(s.charAt(ind)).end = true;
            }
        }
        if(ind + 1 != s.length())
            put(tn.child.get(s.charAt(ind)), s, ind + 1);
    }
    public boolean contains(String s){
        return contains(root, s, 0);
    }
    public boolean contains(TrieNode n, String s, int ind){
        if(ind == s.length()){
            return n.end;
        }
        if(n.child.containsKey(s.charAt(ind))){
            return contains(n.child.get(s.charAt(ind)), s, ind + 1);
        }
        return false;
    }
    public void delete(String s){
        if(!contains(s))
            return;
        del = true;
        delete(s, root, 0);
    }
    public void delete(String s, TrieNode n, int ind){
        if(ind == s.length()){
            if(n.child.isEmpty()){
                n = null;
            }
            else{
                del = false;
                n.end = false;
            }
            return ;
        }
        delete(s, n.child.get(s.charAt(ind)), ind+1);
        if(del){
            n.child.remove(s.charAt(ind));
        }
        if(n.end) {
            del = false;
        }
    }
    public int longestPrefixOf(String s){
        return longestPrefixOf(root, s, 0, 0);
    }
    public int longestPrefixOf(TrieNode n, String s, int ind, int len){
        if(n == null)
            return len;
        if(ind == s.length())
            return s.length();
        if(n.child.containsKey(s.charAt(ind))){
            return longestPrefixOf(n.child.get(s.charAt(ind)), s, ind + 1, len + 1);
        }
        else
            return len;
    }
    public void printTree(){
        levelOrderTraversal(root);
    }
    public void levelOrderTraversal(TrieNode n){
        Set<Character> s = n.child.keySet();
        if(n == root)
            System.out.println("root has "+s.size()+" children");
        else
            System.out.println("node with value  = "+n.car+" has "+s.size()+" children");
        if(n.end)
            System.out.println("this node is also an end of word");
        if(s.size()>0)
            System.out.println("their values are");
        for (Iterator i = s.iterator(); i.hasNext();) {
            char c = (char)i.next();
            System.out.println(n.child.get(c).car);
        }
        for (Iterator i = s.iterator(); i.hasNext();) {
            char c = (char)i.next();
            System.out.println();
            levelOrderTraversal(n.child.get(c));
        }
    }
    public static void main(String[] args) {
        try {
            Trie tob = new Trie();
//            String keys[] = {"the", "a", "there", "answer", "any", "by", "bye", "their", "ans"};
//            for (int i = 0; i < keys.length; i++) {
//                tob.put(keys[i]);
//            }
            tob.put("answers");
            tob.put("answer");
            tob.put("ans");
//            tob.printTree();
//            System.out.println(tob.contains("the"));
//            System.out.println(tob.contains("their"));
//            System.out.println(tob.contains("these"));
//            System.out.println(tob.contains("thaw"));
//            tob.delete("the");
//            tob.printTree();
//            System.out.println(tob.contains("the"));
//            System.out.println("new tree ***************************");
//            tob.delete("their");
//            System.out.println(tob.contains("their"));
//            System.out.println(tob.contains("answer"));
//            tob.delete("answer");
//            System.out.println(tob.contains("answer"));
//            tob.printTree();
//            System.out.println(tob.contains("ans"));
//            System.out.println(tob.contains("answer"));
//            tob.delete("answers");
//            System.out.println(tob.contains("ans"));
//            System.out.println(tob.contains("answer"));
//            System.out.println(tob.contains("answers"));
            System.out.println(tob.longestPrefixOf("an"));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
