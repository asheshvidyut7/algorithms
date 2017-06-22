package Basics;

import java.util.ArrayList;
import java.util.List;

/**
<<<<<<< HEAD
 *
=======
 * Ashesh Vidyut (Drift King) *
>>>>>>> c6aee27e327e96a58c4583ac08325c3bed0bb43f
 */
class BinaryTreeNode{
    public int val;
    public BinaryTreeNode left;
    public BinaryTreeNode right;
    public BinaryTreeNode(int v){
        this.val = v;
        this.left = null;
        this.right = null;
    }
    public BinaryTreeNode(int v, BinaryTreeNode l, BinaryTreeNode r){
        this.val = v;
        this.left = l;
        this.right = r;
    }
}

class BinarySearchTree {
    public BinaryTreeNode root;
    public BinarySearchTree(){
        root = null;
    }
    public BinarySearchTree(int v, BinaryTreeNode l, BinaryTreeNode r){
        root = new BinaryTreeNode(v, l, r);
    }
    public void addValue(int x){
        if(root == null){
            root = new BinaryTreeNode(x);
            return ;
        }
        addValue(x, root);
    }
    public void addValue(int x, BinaryTreeNode node){
        if( node.val > x){
            if( node.left == null){
                node.left = new BinaryTreeNode(x);
                return ;
            }
            else{
                addValue(x, node.left);
                return ;
            }
        }
        if( node.val < x ){
            if( node.right == null){
                node.right = new BinaryTreeNode(x);
                return;
            }
            else{
                addValue(x, node.right);
                return ;
            }
        }
    }
    public void printTree(){
        inorder_traversal(root);
    }
    public void inorder_traversal(BinaryTreeNode node){
        if(node != null){
            inorder_traversal(node.left);
            System.out.println(node.val);
            inorder_traversal(node.right);
        }
    }
    public void delete(int v){
        root = deleteBinaryTreeNode(root, v);
    }
    public BinaryTreeNode deleteBinaryTreeNode(BinaryTreeNode node, int d){
        BinaryTreeNode tmp;
        if(node == null){
            System.out.println("element not in tree");
        }
        else if(d < node.val){
            node.left = deleteBinaryTreeNode(node.left, d);
        }
        else if(d > node.val){
            node.right = deleteBinaryTreeNode(node.right, d);
        }
        else{
            //element found
            if(node.left != null && node.right != null){
                tmp = findMax(node.left);
                node.val = tmp.val;
                node.left = deleteBinaryTreeNode(node.left, node.val);
            }
            else{
                // only one child
                if(node.left == null){
                    node = node.right;
                }
                else{
                    node = node.left;
                }
            }
        }
        return node;
    }
    public BinaryTreeNode findMax(BinaryTreeNode n){
        List<BinaryTreeNode> l = new ArrayList<BinaryTreeNode>();
        inordertra(n,l);
        if(l.isEmpty()){
            return null;
        }
        BinaryTreeNode bn = l.get(0);
        int maxv = bn.val;
        for (BinaryTreeNode binaryTreeNode : l) {
            if(binaryTreeNode.val > maxv){
                maxv = binaryTreeNode.val;
                bn = binaryTreeNode;
            }
        }
        return bn;
    }
    public void inordertra(BinaryTreeNode n, List<BinaryTreeNode> l){
        if(n != null){
            inordertra(n.left, l);
            l.add(n);
            inordertra(n.right, l);
        }
    }
    public static void main(String[] args) {
        BinarySearchTree test = new BinarySearchTree();
        test.addValue(10);
        test.addValue(11);
        test.addValue(9);
        test.addValue(8);
        test.addValue(7);
        test.delete(9);
        test.printTree();
    }
}
