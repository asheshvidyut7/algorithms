package DynamicProgramming;
/**
 *
 */
/*
    Given a Binary Tree, find size of the Largest Independent Set(LIS) in it.
    A subset of all tree nodes is an independent set if there is no edge between any two nodes of the subset.
    DP solution
    Let LISS(X) indicates size of largest independent set of a tree with root X.

    LISS(X) = MAX { (1 + sum of LISS for all grandchildren of X),(sum of LISS for all children of X) }
    The idea is simple, there are two possibilities for every node X, either X is a member of the set or
    not a member. If X is a member, then the value of LISS(X) is 1 plus LISS of all grandchildren.
    If X is not a member, then the value is sum of LISS of all children.

    *** Time Complexity *** O(n) where n is the number of nodes in given Binary tree.
 */
class BinaryTreeNode{
    int val;
    int liss;
    BinaryTreeNode left;
    BinaryTreeNode right;
    public BinaryTreeNode(int v){
        this.val = v;
        this.liss = 0;
    }
    public BinaryTreeNode(int v, BinaryTreeNode l ,BinaryTreeNode r){
        this.val = v;
        this.left = l;
        this.right = r;
        this.liss = 0;
    }
}
public class LargestIndependentSet {
    public int lis(BinaryTreeNode root){
        if(root == null){
            return 0;
        }
        if(root.liss != 0){
            return root.liss;
        }
        //excluding the current node
        int ex = lis(root.left) + lis(root.right);
        // includeing the current node
        int in = 1;
        if(root.left != null){
            in += lis(root.left.left) + lis(root.left.right);
        }
        if(root.right != null){
            in += lis(root.right.left) + lis(root.right.right);
        }
        root.liss = Math.max(in, ex);
        return root.liss;
    }
    public static void main(String[] args) {
        try {
            BinaryTreeNode root = new BinaryTreeNode(20);
            root.left                = new BinaryTreeNode(8);
            root.left.left          = new BinaryTreeNode(4);
            root.left.right         = new BinaryTreeNode(12);
            root.left.right.left   = new BinaryTreeNode(10);
            root.left.right.right  = new BinaryTreeNode(14);
            root.right               = new BinaryTreeNode(22);
            root.right.right        = new BinaryTreeNode(25);
            LargestIndependentSet lis = new LargestIndependentSet();
            System.out.println(lis.lis(root));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
