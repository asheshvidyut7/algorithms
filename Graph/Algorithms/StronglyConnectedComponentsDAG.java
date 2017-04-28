package Graph.Algorithms;

import java.util.*;
/*
    Finding Strongly Connected Components in Directed Acyclic Graph. Strongly Connected Components means Components in
    Graph in which there is a path in between any two pair in the Component.
    Kosaraju Sharir Algorithm -reference Algorithms Part 2 Robert Sedgewick
    First find the reverse graph - Transpose of Graph all the edges in reversed. (The reverse graph will have the same
    connected components).
    Find the topological sort of the reverse graph.
    Run a dfs in the order of the Topological Sort calculated previously on the original graph.
    DFS will have the same methods like the connected component of undirected graph but the only difference is the
    order in which we discover the vertices. (given by topological sorting of reverse graph).
    Keep the scc_counter integer to assign the vertices and increment when new vertex is unvisited. (not the child)
    The scc will give the strongly connected components.
    Runs 2 Dfs
    *** Time Complexity *** O(V+E)
 */

public class StronglyConnectedComponentsDAG{
    public Vector<Integer> graph[];
    public int n;
    public Vector<Integer> rev_graph[];
    public List<Integer> topo_sort = new Vector<Integer>();
    public Vector<Vector<Integer>> groups = new Vector<Vector<Integer>>();
    public int scc_id[];       /*sometimes it is more handy to keep array of strongly connected component id of each vertex,
									to check for same component check scc_id[i] == scc_id[j]
								*/
    public int scc_counter = -1;
    public boolean discovered[];
    public StronglyConnectedComponentsDAG(Vector<Integer> g[], int n){
        this.graph = g;
        this.n = n;
        this.discovered = new boolean[n];
        this.scc_id = new int[n];
        this.rev_graph = new Vector[n];
        Arrays.fill(discovered, false);
        for (int i = 0; i < n; i++){
            rev_graph[i] = (Vector<Integer>) new Vector();
        }
        buildReverseGraph();
        findTopologicalSorting();
        Arrays.fill(discovered, false);
        dfs();
    }
    public void buildReverseGraph(){
        for (int i = 0; i < n; i++){
            for(int v : graph[i]){
                rev_graph[v].add(i);
            }
        }
    }
    public void findTopologicalSorting(){
        for (int i = 0; i < n; i++){
            if(!discovered[i]){
                dfs_tsort(i);
            }
        }
        Collections.reverse(topo_sort);
    }
    public void dfs_tsort(int v){
        discovered[v] = true;
        for( int f : rev_graph[v]){
            if(!discovered[f])
                dfs_tsort(f);
        }
        topo_sort.add(v);
    }
    public void dfs(){
        for (int i : topo_sort){
            if(!discovered[i]){
                scc_counter++;
                groups.add(new Vector<Integer>());
                int g_id = groups.size()-1;
                dfs_visit(i, g_id, scc_counter);
            }
        }
    }
    public void dfs_visit(int v, int gid, int scc_c){
        discovered[v] = true;
        groups.get(gid).add(v);
        scc_id[v] = scc_c;
        for( int f : graph[v]){
            if(!discovered[f]){
                dfs_visit(f, gid, scc_c);
            }
        }
    }
    public void printStronglyConnectedComponents(){
        Vector<Integer> [] scc_components = new Vector[scc_counter + 1];
        for(int i = 0; i <= scc_counter; i++){
            scc_components[i] = new Vector<Integer>();
        }
        for(int i = 0; i < n; i++){
            scc_components[scc_id[i]].add(i);
        }
        for(int i = 0; i <= scc_counter; i++){
            System.out.println(scc_components[i]);
        }
    }
    public static void main(String[] args) {
        try{
            Scanner sc=new Scanner(System.in);
            int n=sc.nextInt();
            Vector<Integer> graph[]=new Vector[n];
            int m=sc.nextInt();
            for(int i=0;i<n;i++){
                graph[i]=new Vector<Integer>();
            }
            for(int i=0;i<m;i++){
                int v1=sc.nextInt();
                int v2=sc.nextInt();
                graph[v1].add(v2);
            }
            StronglyConnectedComponentsDAG sob = new StronglyConnectedComponentsDAG(graph,n);
            sob.printStronglyConnectedComponents();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
