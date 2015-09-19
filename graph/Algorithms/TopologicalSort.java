package Graph.Algorithms;

import java.util.Arrays;
import java.util.Collections;
import java.util.Vector;

/*
    Topological sorting is the most important operation on directed acyclic graphs
    (DAGs). It orders the vertices on a line such that all directed edges go from left to
    right. Such an ordering cannot exist if the graph contains a directed cycle, because
    there is no way you can keep going right on a line and still return back to where
    you started from!
    Each DAG has at least one topological sort. The importance of topological
    sorting is that it gives us an ordering to process each vertex before any of its
    successors. Suppose the edges represented precedence constraints, such that edge
    (x, y) means job x must be done before job y.
    Then, any topological sort defines a
    legal schedule. Indeed, there can be many such orderings for a given DAG.
    But the applications go deeper. Suppose we seek the shortest (or longest) path
    from x to y in a DAG. No vertex appearing after y in the topological order can
    contribute to any such path, because there will be no way to get back to y. We
    can appropriately process all the vertices from left to right in topological order,
    considering the impact of their outgoing edges, and know that we will have looked
    at everything we need before we need it. Topological sorting proves very useful in
    essentially any algorithmic problem on directed graphs, as discussed in the catalog

    Algorithm
    In topological sorting, we use a temporary stack. We don’t print the vertex immediately,
    we first recursively call topological sorting for all its adjacent vertices, then push it to a stack.
    Finally, print contents of stack. Note that a vertex is pushed to stack only when all of its adjacent
    vertices (and their adjacent vertices and so on) are already in stack.
    *** Time Complexity *** O(V+E)
*/

public class TopologicalSort {
    public Vector<Integer> graph[];
    public int n;
    public boolean discovered[];
    public Vector<Integer> toposort;
    public TopologicalSort(Vector<Integer> graph[],int n){
        this.graph = graph;
        this.n = n;
        this.discovered = new boolean[n];
        Arrays.fill(discovered,false);
        toposort = new Vector<Integer>();
        dfs();
    }
    public void dfs(){
        for(int i = 0; i < n; i++){
            if(!discovered[i]){
                dfs_visit(i);
            }
        }
        Collections.reverse(toposort);
    }
    public void dfs_visit(int v){
        discovered[v] = true;
        for(int f : graph[v]){
            if(!discovered[f]){
                dfs_visit(f);
            }
        }
        toposort.add(v);
    }
    public void printTopoLogicalSort(){
        System.out.println(toposort);
    }
    public static void main(String[] args) {
        Vector<Integer> g[] = new Vector[6];
        for(int i = 0; i < 6; i++){
            g[i] = new Vector<Integer>();
        }
        g[5].add(2);
        g[5].add(0);
        g[4].add(0);
        g[4].add(1);
        g[2].add(3);
        g[3].add(1);
        TopologicalSort tpob = new TopologicalSort(g, 6);
        tpob.printTopoLogicalSort();
    }
}
