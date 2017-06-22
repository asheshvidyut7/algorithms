package Graph.Algorithms;

import java.util.Arrays;
import java.util.Vector;

/*
    Bridges in a graph
    An edge in an undirected connected graph is a bridge iff removing it disconnects the graph.
    For a disconnected undirected graph, definition is similar, a bridge is an edge removing which
    increases number of connected components.
    Like Articulation Points,bridges represent vulnerabilities in a connected network and
    are useful for designing reliable networks. For example, in a wired computer network,
    an articulation point indicates the critical computers and a bridge indicates the critical wires
    or connections.
    Algorithm -
    In DFS tree an edge (u, v) (u is parent of v in DFS tree) is bridge if there does not exit any
    other alternative to reach u or an ancestor of u from subtree rooted with v. As discussed in the
    previous post, the value low[v] indicates earliest visited vertex reachable from subtree rooted with v.
    The condition for an edge (u, v) to be a bridge is, “low[v] > disc[u]“.
        *** Time Complexity *** O(V+E)
*/

public class BridgesDepthFirstSearch {
    public int entry_time[];
    public boolean discovered[];
    public int parent[];
    public int low[];
    public int time=0;
    public int n;
    Vector<Vector<Integer>> graph;
    public BridgesDepthFirstSearch(Vector<Vector<Integer>> graph,int n){
        this.graph = graph;
        this.n = n;
        discovered = new boolean[n];
        entry_time = new int[n];
        low = new int[n];
        parent = new int[n];
        Arrays.fill(discovered,false);
        dfs();
    }
    public void dfs(){
        for(int i = 0; i < n ; i++){
            if(!discovered[i]){
                dfs_visit(i);
            }
        }
    }
    public void dfs_visit(int v){
        discovered[v] = true;
        time++;
        entry_time[v] = time;
        low[v] = time;
        for(int f : graph.get(v)){
            if(!discovered[f]){
                parent[f] = v;
                dfs_visit(f);
                low[v] = Math.min(low[v], low[f]);
                /*
                    testing for each edge whether it is bridge of not
                    similar to testing each child for the assertiveness of articulation point of
                    node, so if low[child (f)] > entry_time[v] then it is bridge
                 */
                if(low[f] > entry_time[v]){
                    System.out.println("Bridge between "+v+" "+f);
                }
            }
            else if(parent[v] != f){
                /*
                    found a back edge of vertex v, so low[v] = Math.min(low[v], entry_time[f])
                 */
                low[v] = Math.min(low[v], entry_time[f]);
            }
        }
    }
    public static void main(String[] args) {
        Vector<Vector<Integer>> gr = new Vector<Vector<Integer>>();
        for(int i=0;i<5;i++){
            gr.add(new Vector<Integer>());
        }
        gr.get(1).add(0);
        gr.get(0).add(1);
        gr.get(0).add(2);
        gr.get(2).add(0);
        gr.get(2).add(1);
        gr.get(1).add(2);
        gr.get(0).add(3);
        gr.get(3).add(0);
        gr.get(3).add(4);
        gr.get(4).add(3);
        BridgesDepthFirstSearch bob = new BridgesDepthFirstSearch(gr,5);
    }
}