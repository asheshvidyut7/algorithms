package AdvancedDataStructures;

/**
<<<<<<< HEAD
 *
=======
 * Ashesh Vidyut (Drift King) *
>>>>>>> c6aee27e327e96a58c4583ac08325c3bed0bb43f
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