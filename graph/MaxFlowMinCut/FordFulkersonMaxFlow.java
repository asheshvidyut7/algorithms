package Graph.MaxFlowMinCut;

/*
    In optimization theory, the max-flow min-cut theorem states that in a flow network,
    the maximum amount of flow passing from the source to the sink is equal to the minimum capacity that,
    when removed in a specific way from the network,
    causes the situation that no flow can pass from the source to the sink.
 */
import java.util.*;

/**
 *
 */
/*
    The following is simple idea of Ford-Fulkerson algorithm:
        1. Start with initial flow as 0.
        2. While there is a augmenting path from source to sink.
           Add this path-flow to flow.
        3. Return flow.
    *** Time Complexity *** O(E * V^3) or O(max_flow * E).
     Time complexity of the above algorithm is O(max_flow * E).
     We run a loop while there is an augmenting path.
     In worst case, we may add 1 unit flow in every iteration.
     Therefore the time complexity becomes O(max_flow * E).
     O(EV^3) solution
     Algorithm distilled - Every time we do a BFS and check if we can reach the terminal(t),
     if we can reach then for this path represented by the parent, we find the minimum flow in residual graph,
     add it to the max_flow and update the residual graph.
 */

public class FordFulkersonMaxFlow {
    /* Returns true if there is a path from source 's' to sink 't' in
    residual graph. Also fills parent[] to store the path. Initially residual graph is the original graph*/
    boolean bfs(int resGraph[][], int s, int t, int parent[]){
        boolean vis[] = new boolean[resGraph.length];
        Arrays.fill(vis, false);
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(s);
        parent[s] = -1;
        vis[s] = true;
        while(!q.isEmpty()){
            int u = q.poll();
            for (int v = 0; v < resGraph.length; v++) {
                if(!vis[v] && resGraph[u][v] > 0){
                    parent[v] = u;
                    q.add(v);
                    vis[v] = true;
                }
            }
        }
        return vis[t];
    }
    public int fordfulkerson(int graph[][], int s, int t){
        int n = graph.length;
        int residual_grp [][] = new int[n][n];
        /* Residual graph where rGraph[i][j] indicates
            residual capacity of edge from i to j (if there
            is an edge. If rGraph[i][j] is 0, then there is not. */
        for (int i = 0; i < n; i++) {
            residual_grp[i] = Arrays.copyOf(graph[i], n);
        }
        int parent[] = new int[n]; /* This array is filled by BFS and to store path */
        int max_flow = 0;
        while(bfs(residual_grp, s, t, parent)){
            /* Find minimum residual capacity of the edhes along the
             path filled by BFS. Or we can say find the maximum flow
             through the path found. */
            int path_flow = Integer.MAX_VALUE;
            /* since parent[s] = -1, so we start from t and trace back to s */
            for (int v = t; v != s; v = parent[v]) {
                int u = parent[v];
                path_flow = Math.min(path_flow, residual_grp[u][v]);
            }
            max_flow += path_flow;
            /* update residual capacity of edges, again starting from end */
            for (int v = t; v != s; v = parent[v]) {
                int u = parent[v];
                residual_grp[u][v] -= path_flow;
                residual_grp[v][u] += path_flow;
            }
        }
        return max_flow;
    }
    public static void main(String[] args) {
        try {
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
            FordFulkersonMaxFlow ff = new FordFulkersonMaxFlow();
            System.out.println(ff.fordfulkerson(g, 0, 6));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
