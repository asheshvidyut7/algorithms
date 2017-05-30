package Graph.WeightedGraph;

import java.io.*;
import java.util.*;

/**
<<<<<<< HEAD
 *
=======
 * Ashesh Vidyut (Drift King) *
>>>>>>> c6aee27e327e96a58c4583ac08325c3bed0bb43f
 */
/*
     Dijkstra doesn’t work for Graphs with negative weight edges,
     Bellman-Ford works for such graphs. Bellman-Ford is also simpler than Dijkstra and
     suites well for distributed systems. But time complexity of Bellman-Ford is O(VE),
     which is more than Dijkstra.

     The Algorithm
     Following are the detailed steps.
     Input: Graph and a source vertex src
     Output: Shortest distance to all vertices from src.
     If there is a negative weight cycle, then shortest distances are not calculated,
     negative weight cycle is reported.

        1. This step initializes distances from source to all vertices as infinite and distance to
        source itself as 0. Create an array dist[] of size |V| with all values as infinite except
        dist[src] where src is source vertex.

        2. This step calculates shortest distances.
        Do following |V|-1 times where |V| is the number of vertices in given graph.
            a. Do following for each edge u-v
                If dist[v] > dist[u] + weight of edge uv, then update dist[v]
                dist[v] = dist[u] + weight of edge uv

        3. This step reports if there is a negative weight cycle in graph. Do following for each edge u-v
        If dist[v] > dist[u] + weight of edge uv, then “Graph contains negative weight cycle”
        The idea of step 3 is, step 2 guarantees shortest distances if graph doesn’t contain negative
        weight cycle. If we iterate through all edges one more time and get a shorter path for any vertex,
        then there is a negative weight cycle
        *** Time Complexity *** O(V*E)
 */
class WEdge{
    public int to;
    public int from;
    public int cost;
    public WEdge(int f,int t, int c){
        this.to = t;
        this.from = f;
        this.cost = c;
    }
}
class BellmanFordSSSP {
    public int n;
    public int source;
    public int dist[];
    public int parent[];
    public List<WEdge> graph;
    public BellmanFordSSSP(int n, List<WEdge> gr, int s){
        this.n = n;
        this.source = s;
        this.graph = gr;
        this.parent = new int[n];
        this.dist = new int[n];
        Arrays.fill(parent, -1);
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;
        bellmanford();  //this will garauntee the dist[v] is minimum if there is no negative weight cycle
        boolean negwc = checkNegWeightCycle();
        if(!negwc){
            for (int i = 0; i < n; i++) {
                System.out.println(i+" = " + dist[i]);
            }
        }
        else
            System.out.println("contains neg weight cycle");
    }
    public boolean checkNegWeightCycle(){
        for (Iterator<WEdge> iterator = graph.iterator(); iterator.hasNext(); ) {
            WEdge next = iterator.next();
            int s = next.from;
            int d = next.to;
            if(dist[d] > dist[s] + next.cost){
                return true;
            }
        }
        return false;
    }
    public void bellmanford(){
        for (int step = 0; step < n; step++) {
            for (WEdge e : graph) {
                int u = e.from;
                int v = e.to;
                if(dist[v] > dist[u] + e.cost){
                    dist[v] = dist[u] + e.cost;
                }
            }
        }
    }
    public static void main(String[] args) {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            int v = Integer.parseInt(in.readLine());
            int e = Integer.parseInt(in.readLine());
            List<WEdge> gr = new ArrayList<WEdge>();
            for (int i = 0; i < e; i++) {
                String inpp[] = (in.readLine()).split(" ");
                gr.add(new WEdge(Integer.parseInt(inpp[0]),Integer.parseInt(inpp[1]),Integer.parseInt(inpp[2])));
            }
            BellmanFordSSSP test = new BellmanFordSSSP(v, gr, 0);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
