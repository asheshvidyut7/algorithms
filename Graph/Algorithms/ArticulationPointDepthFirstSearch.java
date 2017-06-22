package Graph.Algorithms;
import java.util.Arrays;
import java.util.Vector;

/*
Tarjan’s algorithm for finding articulation points.
A O(V+E) algorithm to find all Articulation Points (APs)
The idea is to use DFS (Depth First Search). In DFS, we follow vertices in tree form called DFS tree.
In DFS tree, a vertex u is parent of another vertex v, if v is discovered by u (obviously v is an adjacent of u in graph).
In DFS tree, a vertex u is articulation point if one of the following two conditions is true.
1) u is root of DFS tree and it has at least two children.
2) u is not root of DFS tree and it has a child v such that no vertex in subtree rooted with v has a back edge to one
of the ancestors (in DFS tree) of u.
*/
/*
We do DFS traversal of given graph with additional code to find out Articulation Points (APs).
In DFS traversal, we maintain a parent[] array where parent[u] stores parent of vertex u.
Among the above mentioned two cases, the first case is simple to detect. For every vertex, count children.

If currently visited vertex u is root (parent[u] is NIL) and has more than two children, print it.

How to handle second case? The second case is trickier. We maintain an array disc[] to store discovery time of vertices.

For every node u, we need to find out the "earliest visited vertex" (the vertex with minimum discovery time) that
can be reached from subtree rooted with u. So we maintain an additional array low[] which is defined as follows.
low[u] = min(disc[u], disc[w])

where w is an ancestor of u and there is a back edge from
some descendant of u to w.

    *** Time Complexity *** O(V+E)
*/

public class ArticulationPointDepthFirstSearch {
    public int low[];
    public int parent[];
    public int entry_time[];
    public boolean proccessed[];
    public int exit_time[];
    public boolean discovered[];
    public boolean articulationpoint[];
    public int time = 0;
    public int n;
    public Vector<Vector<Integer>> graph;
    public ArticulationPointDepthFirstSearch(Vector<Vector<Integer>> graph,int n){
        this.n = n;
        this.graph = graph;
        low = new int[n];
        entry_time = new int[n];
        discovered = new boolean[n];
        parent = new int[n];
        exit_time = new int[n];
        articulationpoint = new boolean[n];
        proccessed = new boolean[n];
        Arrays.fill(articulationpoint,false);
        Arrays.fill(parent, -1);
        Arrays.fill(discovered,false);
        Arrays.fill(proccessed,false);
        dfs();
    }
    public void dfs(){
        for(int i = 0; i < n; i++){
            if(!discovered[i]){
                dfs_visit(i);
            }
        }
    }
    public void dfs_visit(int v){
        discovered[v]  = true;
        int children = 0;
        time++;
        entry_time[v] = time;
        low[v] = time;
        Vector<Integer> neighbour_v = graph.get(v);
        for(int f : neighbour_v){
            if(!discovered[f]){
                children++;
                parent[f] = v;
                dfs_visit(f);
                /*
                    for every child of root in dfs tree we have to check for the condition of articulation point
                    so for every non visited child we check low[v] = Math.min(low[v], low[f]);
                */
                low[v] = Math.min(low[v], low[f]);

                /*
                    for every child (of root of dfs tree) we have to check for the condition of articulation point
                    so if parent[v] == -1 that means it is root, we check the count of its children
                 */
                if(parent[v] == -1 && children > 1){
                    articulationpoint[v] = true;
                }
                /*
                    if the vertex is not root then we check low[f] that is low of current child f, that it is >= entry_time[v]
                    if it is true then it is articulation point
                 */
                if(parent[v] != -1 && low[f] >= entry_time[v]){
                    articulationpoint[v] = true;
                }
            }
            /*
                now comes the processing of back edge, the edge that is going to the ancestor
                now f is v, se we check if parent[v] != f, that means there is another vertex with edge to this child (back edge)
                so if it is back edge the low[v] is != low[v] but low[v] can be the entry_time of the vertex that it can reach with back edge
                so low[v] = Math.min(low[v], entry_time[f])
                this shows that it can reach a vertex f with back edge and the time is stored in low[v]
             */
            else if(!proccessed[v] && parent[v] != f){
                low[v] = Math.min(low[v], entry_time[f]);
            }
        }
        exit_time[v] = ++time;
        proccessed[v] = true;
    }
    public void printArticulationPoint(){
        for(int i = 0;i < n; i++){
            if(articulationpoint[i]){
                System.out.print(i+" ");
            }
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Vector<Vector<Integer>> g = new Vector<Vector<Integer>>();
        for(int i = 0; i < 7 ; i++){
            g.add(new Vector<Integer>());
        }
        g.get(1).add(0);
        g.get(0).add(1);
        g.get(2).add(1);
        g.get(1).add(2);
        g.get(0).add(2);
        g.get(2).add(0);
        g.get(1).add(3);
        g.get(4).add(1);
        g.get(1).add(4);
        g.get(1).add(6);
        g.get(6).add(1);
        g.get(3).add(5);
        g.get(5).add(3);
        g.get(5).add(4);
        g.get(4).add(5);
        ArticulationPointDepthFirstSearch ap = new ArticulationPointDepthFirstSearch(g,7);
        ap.printArticulationPoint();
    }
}