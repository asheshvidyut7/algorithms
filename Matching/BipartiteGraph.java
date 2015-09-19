package Matching;

import java.util.*;

/**
 *
 */
/*
    Check whether the graph is "Bipartite Graph" or (Two-Colorable Graph)?
    Definition - A Bipartite Graph is a graph whose vertices can be divided into two independent sets,
    U and V such that every edge (u, v) either connects a vertex from U to V or a vertex from V to U.
    In other words, for every edge (u, v), either u belongs to U and v to V, or u belongs to V and v to U.
    We can also say that there is no edge that connects vertices of same set.

    A bipartite graph is possible if the graph coloring is possible using two colors such that vertices
    in a set are colored with the same color. Note that it is possible to color a cycle graph with even
    cycle using two colors.
    Solution 1 - We can use 2 coloring problem using Backtracking
    Solution 2 - Using Breadth First Search
        At first We use BFS and Adjacency Matrix to find whether we can 2 color a graph, the concept is simple
        start with a root and color is 1, then color all the adjacent vertex to 2 if they are not colored,
        if they are colored and if their color is 1, return false;
        DFS is also used

    Mistake on TopCoder
    Problem is simple as we have to check for bipartiteness of a graph and one dfs to test other property,
    Now the mistake that I made was in bipartiteness if graph is not connected then, for example we have
    0 - []
    1 - []
    2 - [1, 2]
    3 - [0 ,1]
    4 - [0, 2]
    This graph is not bipartite but if we start form 0 and color it and add its adjacent to queue after checking
    /marking the color, then none of its adjacent would be added, and we won't check for 2, 3, 4 as the queue
    is empty and we will break out of loop.
    So we have to check for every vertex until it is not visited, we definite have to keep a visited array.


 */
public class BipartiteGraph {

    /* BFS with Adjaceny Matrix Representation */
    public boolean isBipartiteAM(int graph[][]){
        int col[] = new int[graph.length];
        Arrays.fill(col, 0);
        col[0] = 1;
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(0);
        while(!q.isEmpty()){
            int v = q.poll();
            for (int i = 0; i < graph.length; i++) {
                if(graph[v][i] > 0 && col[i] == 0){
                    col[i] = col[v] == 1 ? 2 : 1;
                    q.add(i);
                }
                else if(graph[v][i] > 0 && col[i] == col[v])
                    return false;
            }
        }
        return true;
    }
    /* BFS with Adjacency List Representation */
    public boolean isBipartiteAL(List<Integer> graph[]){
        int col[] = new int[graph.length];
        Arrays.fill(col, 0);
        col[0] = 1;
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(0);
        // if graph is not connected then, keep a visited array to make sure all the vertex
        // is visited and each of its adjacent is bipartite or not
        // below is the code for not connected graph
        while(!q.isEmpty()){
            int v = q.poll();
            for (Integer u : graph[v]) {
                if(col[u] == 0){
                    col[u] = col[v] == 1 ? 2 : 1;
                    q.add(u);
                }
                else if(col[u] == col[v]){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean isBipartite(Vector<Integer> g[]){
        int n = g.length;
        int col[] = new int[n];
        col[0] = 1;
        Queue<Integer> ver = new LinkedList<Integer>();
        ver.add(0);
        boolean vis[] = new boolean[n];
        boolean alltrue [] = new boolean[n];
        Arrays.fill(alltrue, true);
        while(!Arrays.equals(vis, alltrue)){
            while(!ver.isEmpty()){
                int v = ver.poll();
                vis[v] = true;
                int coltoc = (col[v] == 1) ? 2 : 1;
                for( int fv : g[v]){
                    if(vis[fv]){
                        continue;
                    }
                    if(col[fv] == col[v]) {
                        return false;
                    }
                    else {
                        col[fv] = coltoc;
                        ver.add(fv);
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                if(!vis[i]){
                    ver.add(i);
                    col[i] = 1;
                    break;
                }
            }
        }
        return true;
    }
    /* DFS with Adjacency List Representation Assumption that graph is strongly connected,
       If the graph is not strongly connected then first we find the strongly connected components
       and run the Bipartite Algorithm on each component. */
    public boolean isBipartiteDfs(List<Integer> graph[]){
        int n = graph.length;
        int col[] = new int[n];
        col[0] = 1;
        if(dfs_visit(0, 1, col, graph))
            return true;
        return false;
    }
    public boolean dfs_visit(int v, int c, int col[], List<Integer> g[]){
        for (int f : g[v]) {
            if(col[f] == 0){
                col[f] = col[v] == 1 ? 2 : 1;
                dfs_visit(f, col[f], col, g);
            }
            else if(col[f] == c){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        try {
            int g[][] = {{0, 1, 0, 1},
                         {1, 0, 1, 0},
                         {0, 1, 0, 1},
                         {1, 0, 1, 0}};
            BipartiteGraph b = new BipartiteGraph();
            long st = System.currentTimeMillis();
            System.out.println(b.isBipartiteAM(g));
            long et = System.currentTimeMillis();
            System.out.println(et-st);
            List<Integer> gr[] = new Vector[4];
            for (int i = 0; i < 4; i++) {
                gr[i] = new Vector<Integer>();
            }
            gr[0].add(1);
            gr[0].add(3);
            gr[1].add(0);
            gr[3].add(0);
            gr[1].add(2);
            gr[2].add(1);
            gr[2].add(3);
            gr[3].add(2);
            st = System.currentTimeMillis();
            System.out.println(b.isBipartiteAL(gr));
            et = System.currentTimeMillis();
            System.out.println(et-st);
            st = System.currentTimeMillis();
            System.out.println(b.isBipartiteDfs(gr));
            et = System.currentTimeMillis();
            System.out.println(et-st);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
