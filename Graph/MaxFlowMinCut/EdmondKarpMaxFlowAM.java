package Graph.MaxFlowMinCut;

import java.util.Arrays;
import java.util.List;
import java.util.Vector;

/**
 * Ashesh Vidyut (Drift King) *
 */
/*
    Edmonds-Karp Algorithm *** Time Complexity *** O(E^2 * V)

    Source - http://www.cse.unt.edu/~tarau/teaching/AnAlgo/Edmonds%E2%80%93Karp%20algorithm.pdf

    Edmonds–Karp algorithm is an implementation of the Ford–Fulkerson method for computing the
    maximum flow in a flow network in O(VE^2) time
    Algorithm
    The algorithm is identical to the  Ford–Fulkerson algorithm, except that the search order when
    finding the augmenting path is defined. The path found must be a "shortest path" that has available
    capacity. This can be found by a breadth-first search, as we let edges have unit length.

    The running time of O(VE^2). is found by showing that each augmenting path can be found in O(E)
    time, that every time at least one of the E edges becomes saturated,
    distance from the saturated edge to the source along the augmenting path must be longer than
    last time it was saturated, and that the length is at most  V.

    Another property of this algorithm is that the length of the shortest augmenting path increases
    monotonically.
 */
public class EdmondKarpMaxFlowAM {
    public int bfs(int n, int s, int t, int graph[][], int flowgraph[][], int parent[]){
        int m[] = new int[n]; //capacity of the path found
        Arrays.fill(m, 0);
        m[s] = Integer.MAX_VALUE;
        parent[s] = -2;
        List<Integer> q = new Vector<Integer>();
        q.add(s);
        while(!q.isEmpty()){
            int u = q.get(0);
            q.remove(0);
            for (int v = 0; v < n; v++) {
                /* check if residual graph is > 0, we can travel the edge */
                if(graph[u][v] - flowgraph[u][v] > 0 && parent[v] == -1){
                    parent[v] = u;
                    m[v] = Math.min(m[u], graph[u][v] - flowgraph[u][v]);
                    if(v != t){
                        q.add(v);
                    }
                    else{
                        return m[t];
                    }
                }
            }
        }
        return 0;
    }
    public int edmondkarpmaxflow(int graph[][], int s, int t){
        int n = graph.length;
        int flow[][] = new int[n][n];
        /* flow  = selected flow, the residual[i][j] is graph[i][j] - flow[i][j] */
        for (int i = 0; i < n; i++) {
            Arrays.fill(flow[i], 0);
        }
        int maxflow = 0;
        int parent[] = new int[n];
        while(true){
            Arrays.fill(parent, -1);
            parent[s] = -2;
            int m = bfs(n, s, t, graph, flow, parent);
            if(m == 0) {
                break;
            }
            maxflow += m;
            // update residual graph
            for(int v = t; v!=s; v = parent[v]){
                int u = parent[v];
                flow[u][v] += m;    /* we use to remove flow from the residualgrp[u][v] in FordFulkerson */
                flow[v][u] -= m;    /* and add in the residualgrp[v][u], so here its opposite */
            }
        }
        return maxflow;
    }
    public static void main(String[] args) {
        try{
            int n = 7;
            int g[][] = new int[n][n];
            g[0][3] = 3;
            g[0][1] = 3;
            g[1][2] = 4;
            g[2][0] = 3;
            g[2][3] = 1;
            g[2][4] = 2;
            g[3][4] = 2;
            g[3][5] = 6;
            g[4][1] = 1;
            g[4][6] = 1;
            g[5][6] = 9;
            EdmondKarpMaxFlowAM e = new EdmondKarpMaxFlowAM();
            System.out.println(e.edmondkarpmaxflow(g,0,6));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
