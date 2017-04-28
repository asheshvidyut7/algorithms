package AdvancedDataStructures;

/**
 * Ashesh Vidyut (Drift King) *
 */
/*
    Left leaning red black tree is representation of 2-3 tree.
    2-3 tree is a balanced binary search tree.
    2-3 tree has node with 2 node(1 key and 2 link) and 3 node(2 key and 3 link)
    In 3 node which has three link, and 2 key in which the first link contains node with value
    less than the first key, the second link contains nodes with value in between the two
    key and third node contains the value greater than the second key.

    When we add a new value of node to this tree, we always augment the node, acc to value
    if the node becomes the four node, then we split the middle element to become the parent
    of two child nodes with value left and right.
    Else leave the node.

    Simulation of 2-3 tree with Left Leaning Red Black Tree.
    We always want a red link in the left. With node we keep a property of color (representing
    color with his parent).
    The red link shows that it is a 3 node, and black shows that it is connected to
    a 2 node (normal node). We always put a node with red color.
    *** Time Complexity *** O(logn) for all operations
    There are only three cases after putting

    Case 1 - If the insert operation is on the right side and the tree becomes right leaning,
             for this we do a leftRotate()
    Case 2 - If after left rotation the tree node becomes four node, that means two continuous
             left leaning red node, means h.left is red and h.left.left is left,
             in this case we do a rightRotation(), to make h.left the root
    Case 3 - After this the last come from the case 2, that is h.left is red and h.right is red
             in this we do a flip color operation to split the 4 node into 2 node.
    We check these cases sequentially after inserting the nodes at reach level.
 */
class RedBlackTree {
    final boolean RED = true;
    final boolean BLACK = false;
    public Node root;
    class Node{
        int val;
        Node left,right;
        boolean color; // color of parent link
        public Node(int v, boolean c){
            this.val = v;
            this.color = c;
            this.left = null;
            this.right = null;
        }
        public Node(int v, boolean c, Node l, Node r){
            this.val = v;
            this.color = c;
            this.left = l;
            this.right = r;
        }
    }
    public boolean isRed(Node x){
        if(x == null)
            return false;
        return x.color == RED;
    }
    // orient right leaning red link to lean left.
    public Node rotateLeft(Node h){
        // to rotate left we need right link to be red
        assert(isRed(h.right));
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;  //now x is parent so maintain the color
        return x;
    }
    public Node rotateRight(Node h){
        //to rotate right we need left link to be red
        assert(isRed(h.left));
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;  //now x is parent so maintain the color
        return x;
    }
    public void flipcolors(Node h){
        assert (!isRed(h));
        assert (isRed(h.left));
        assert (isRed(h.right));
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }
    public void put(int val) {
        root = put(root, val);
        root.color = BLACK;
        // assert check();
    }
    // insert the key-value pair in the subtree rooted at h
    public Node put(Node h, int val) {
        if (h == null) return new Node(val, RED);

        if (val < h.val) h.left  = put(h.left, val);
        else if (val > h.val) h.right = put(h.right, val);
        else h.val   = val;

        if (isRed(h.right) && !isRed(h.left))      h = rotateLeft(h); //case 1
        if (isRed(h.left)  &&  isRed(h.left.left)) h = rotateRight(h); //case 2
        if (isRed(h.left)  &&  isRed(h.right))     flipcolors(h);     //case 3
        return h;
    }
    public void inorderTraversal(Node node){
        if(node != null){
            inorderTraversal(node.left);
            System.out.println(node.val);
            System.out.println(node.color);
            inorderTraversal(node.right);
        }
    }
    public static void main(String[] args) {
        try {
            RedBlackTree rb = new RedBlackTree();
            rb.put(20);
            rb.put(10);
            rb.put(30);
            rb.put(40);
            rb.put(50);
//            rb.put(60);
//            rb.put(70);
            rb.inorderTraversal(rb.root);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
