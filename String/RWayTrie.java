package String;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/**
 * Ashesh Vidyut (Drift King) *
 */
public class RWayTrie {
    public final int R = 256;
    class RTrieNode{
        public int val;
        public RTrieNode ar[] = new RTrieNode[R];
    }
    private  RTrieNode root = new RTrieNode();
    public void put(String s){
        root = put(root, s, 0);
    }
    public RTrieNode put(RTrieNode n, String s, int ind){
        if(n == null)
            n = new RTrieNode();
        if(ind == s.length())
            return n;
        char c = s.charAt(ind);
        n.ar[c] = put(n.ar[c], s, ind+1);
        return n;
    }
    public boolean contains(String s){
        RTrieNode n = contains(root, s, 0);
        if(n == null)
            return false;
        return true;
    }
    public RTrieNode contains(RTrieNode n, String s, int i){
        if(n == null)
            return null;
        if(i == s.length())
            return n;
        char c = s.charAt(i);
        return contains(n.ar[c], s, i+1);
    }
    public static void main(String[] args) {
        try {
            RWayTrie tob = new RWayTrie();
            String keys[] = {"the", "a", "there", "answer", "any", "by", "bye", "their"};
            for (int i = 0; i < keys.length; i++) {
                tob.put(keys[i]);
            }
//            tob.printTree();
            System.out.println(tob.contains("the"));
            System.out.println(tob.contains("their"));
            System.out.println(tob.contains("these"));
            System.out.println(tob.contains("thaw"));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
