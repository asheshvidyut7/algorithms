package AdvancedDataStructures;

/**
 *
 */
public class SegmentTreeNode{
    public int val;
    public int leftind;
    public int rightind;
    public SegmentTreeNode left;
    public SegmentTreeNode right;
    public SegmentTreeNode(int lind, int rind){
        this.leftind = lind;
        this.rightind = rind;
        this.left = null;
        this.right = null;
    }
}