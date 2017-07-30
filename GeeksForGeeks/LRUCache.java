package GeeksForGeeks;

import java.io.*;
import java.util.*;
import java.math.*;

/**
 * created by asheshvidyut on 30/07/17
 **/
public class LRUCache {
    int capacity;
    Map<Integer, LRUNode> map = new HashMap<>();
    LRUNode head = null;
    LRUNode end = null;
    public int get(int key){
        if (map.containsKey(key)) {
            LRUNode n = map.get(key);
            remove(n);
            setHead(n);
            return n.val;
        }
        return -1;
    }
    private void remove(LRUNode n) {
        if (n.prev != null) {
            n.prev.next = n.next;
        }
        else {
            head = n.next;
        }
        if (n.next != null) {
            n.next.prev = n.prev;
        }
        else {
            end = n.prev;
        }
    }
    private void setHead(LRUNode n) {
        n.next = head;
        n.prev = null;
        if (head != null) {
            head.prev = n;
        }
        head = n;
        if (end == null) {
            end = head;
        }
    }
    public void set(int key, int val) {
        if (map.containsKey(key)) {
            LRUNode old = map.get(key);
            old.val = val;
            remove(old);
            setHead(old);
        }
        else {
            LRUNode newNode = new LRUNode(key, val);
            if (map.size() >= capacity) {
                map.remove(end.key);
                remove(end);
            }
            setHead(newNode);
            map.put(key, newNode);
        }
    }
    public static void main(String args[]) {
        try {

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
class LRUNode{
    LRUNode next;
    LRUNode prev;
    int val;
    int key;

    public LRUNode (int k, int v) {
        this.key = k;
        this.val = v;
    }
}

