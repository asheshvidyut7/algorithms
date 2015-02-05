package Graph.MaxFlowMinCut;

import java.util.*;

/**
 * Ashesh Vidyut (Drift King) *
 */
/*
    As the theorm of MaxFlow says that MaxFlow = MinCut (from s to t)
    So we use Ford-FulkersonMaxFlow to find the max flow. The steps to find the min cut edges are
    Following are steps to print all edges of minimum cut.
    1. Run Ford-Fulkerson algorithm and consider the final residual graph.
    2. Find the set of vertices that are reachable from source in the residual graph.
    3. All edges which are from a reachable vertex to non-reachable vertex are minimum cut edges.
       Print all such edges.
 */

public class FordFulkersonMinCut {
    public boolean bfs(int redgraph[][], int parent[], int s, int t){
        int n = redgraph.length;
        boolean vis[] = new boolean[n];
        Arrays.fill(vis, false);
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(s);
        parent[s] = -1;
        while(!q.isEmpty()){
            int u = q.poll();
            for (int v = 0; v < n; v++) {
                if(!vis[v] && redgraph[u][v]>0){
                    vis[v] = true;
                    q.add(v);
                    parent[v] = u;
                }
            }
        }
        return vis[t];
    }
    public void dfs(int v, int resg[][], boolean vis[]){
        vis[v] = true;
        for (int i = 0; i < resg.length; i++) {
            if(!vis[i] && resg[v][i] > 0){
                dfs(i, resg, vis);
            }
        }
    }
    public void fordfulkerson(int graph[][], int s, int t){
        int n = graph.length;
        int maxflow = 0;
        int redgraph [][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            redgraph[i] = Arrays.copyOf(graph[i], n);
        }
        int parent[] = new int[n];
        Arrays.fill(parent, -1);
        while(bfs(redgraph, parent, s, t)){
            int path_flow = Integer.MAX_VALUE;
            for (int v = t; v != s ; v = parent[v]) {
                int u = parent[v];
                path_flow = Math.min(path_flow, redgraph[u][v]);
            }
            maxflow += path_flow;
            for (int v = t; v != s; v = parent[v]) {
                int u = parent[v];
                redgraph[u][v] -= path_flow;
                redgraph[v][u] += path_flow;
            }
        }
        System.out.println("mincut = " + maxflow);
        boolean vis[] = new boolean[n];
        Arrays.fill(vis, false);
        dfs(0, redgraph, vis);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(vis[i] && !vis[j] && graph[i][j] > 0){
                    System.out.println("edge "+i+" "+j+" val - "+graph[i][j]);
                }
            }
        }
    }
    public static void main(String[] args) {
        try {
            int graph[][] = { {0, 16, 13, 0, 0, 0},
                            {0, 0, 10, 12, 0, 0},
                            {0, 4, 0, 0, 14, 0},
                            {0, 0, 9, 0, 0, 20},
                            {0, 0, 0, 7, 0, 4},
                            {0, 0, 0, 0, 0, 0}};
            FordFulkersonMinCut f = new FordFulkersonMinCut();
            f.fordfulkerson(graph, 0, 5);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
