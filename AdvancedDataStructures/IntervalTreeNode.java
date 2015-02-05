package AdvancedDataStructures;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Ashesh Vidyut (Drift King) *
 */
public class IntervalTreeNode {
    public int leftind;
    public int rightind;
    public IntervalTreeNode left;
    public IntervalTreeNode right;
    public int max_below;   // stores maximum value of rightind in the subtree
    public IntervalTreeNode(int l, int r){
        this.leftind = l;
        this.rightind = r;
        this.max_below = r;
    }
    public String toString(){
        return leftind+" "+rightind+" "+max_below;
    }
}
