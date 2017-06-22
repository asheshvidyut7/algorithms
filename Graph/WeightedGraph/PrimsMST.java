package Graph.WeightedGraph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
<<<<<<< HEAD
 *
=======
 * Ashesh Vidyut (Drift King) *
>>>>>>> c6aee27e327e96a58c4583ac08325c3bed0bb43f
 */
/*
    MST for Undirected Graph
    • The minimum spanning tree of a graph is unique if all m edge weights in the
    graph are distinct. Otherwise the order in which Prim’s/Kruskal’s algorithm breaks
    ties determines which minimum spanning tree is returned.
    There are two important variants of a minimum span

    Maximum Spanning Trees – Suppose an evil telephone company is contracted
    to connect a bunch of houses together; they will be paid a price proportional
    to the amount of wire they install. Naturally, they will build the most expen-
    sive spanning tree possible. The maximum spanning tree of any graph can be
    found by simply negating the weights of all edges and running Prim’s algo-
    rithm. The most negative tree in the negated graph is the maximum spanning
    tree in the original.
    Most graph algorithms do not adapt so easily to negative numbers. Indeed,
    shortest path algorithms have trouble with negative numbers, and certainly
    do not generate the longest possible path using this technique.

    • Minimum Product Spanning Trees – Suppose we seek the spanning tree that
    minimizes the product of edge weights, assuming all edge weights are positive.
    Since lg(a · b) = lg(a) + lg(b), the minimum spanning tree on a graph whose
    edge weights are replaced with their logarithms gives the minimum product
    spanning tree on the original graph.

    • Minimum Bottleneck Spanning Tree – Sometimes we seek a spanning tree
    that minimizes the maximum edge weight over all such trees. In fact, every
    minimum spanning tree has this property. The proof follows directly from
    the correctness of Kruskal’s algorithm.

    *** Time Complexity *** O(V^2)
 */
public class PrimsMST {
    public int n;
    public boolean visited[];
    public double key[];
    public int parent[];
    public double edge[][];
    public PrimsMST(int n, double mat[][]){
        this.n = n;
        this.edge = mat;
        this.visited = new boolean[n];
        this.key = new double[n];
        this.parent = new int[n];
        Arrays.fill(parent, -1);
        Arrays.fill(visited, false);
        Arrays.fill(key, Double.MAX_VALUE);
        key[0] = 0;
        prims();
        findMinimumWeight();
    }
    public void prims(){
        while(!allVisited(visited)){
            int v = findMin();
            visited[v] = true;
            for (int i = 0; i < n; i++) {
                if(!visited[i] && edge[i][v] >0 && key[i]> edge[i][v]){
                    parent[i] = v;
                    key[i] = edge[i][v];
                }
            }
        }
    }
    public double findMinimumWeight(){
        double w = 0;
        for (int i = 0; i < n; i++) {
            if(parent[i] != -1){
                w += key[i];
            }
        }
        return w;
    }
    public boolean allVisited(boolean v[]){
        boolean av[] = new boolean[n];
        Arrays.fill(av, true);
        if(Arrays.equals(av,v))
            return true;
        return false;
    }
    public int findMin(){
        double x = Double.MAX_VALUE;
        int min_v = 0;
        for (int i = 0; i < n; i++) {
            if(!visited[i] && x > key[i]){
                min_v = i;
                x = key[i];
            }
        }
        return min_v;
    }
    public static void main(String[] args) {
        try{
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//            BufferedReader in = new BufferedReader(new FileReader("inp.txt"));
            int n = Integer.parseInt(in.readLine());
            double tab [][] = new double[n][n];
            for (int i = 0; i < n; i++) {
                Arrays.fill(tab[0], 0);
            }
            int m = Integer.parseInt(in.readLine());
            for (int i = 0; i < m; i++) {
                String inp[] =(in.readLine()).split(" ");
                int v1 = Integer.parseInt(inp[0]);
                int v2 = Integer.parseInt(inp[1]);
                double c = Double.parseDouble(inp[2]);
                tab[v1][v2] = c;
                tab[v2][v1] = c;
            }
            long st = System.currentTimeMillis();
            PrimsMST test = new PrimsMST(n, tab);
            System.out.println(test.findMinimumWeight());
            long et = System.currentTimeMillis();
            System.out.println(et-st);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
