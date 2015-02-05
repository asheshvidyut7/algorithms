package Graph.WeightedGraph;

import java.io.*;
import java.util.*;

/**
 * Ashesh Vidyut (Drift King) *
 */
/*
    MST for Undirected Graph Adjacency List representation
    Undirected Graph is Directed Graph with both the arrows, consider it to be two edges directed in opposite
    direction, add both the edges to the graph while creating the adjacency list representation.
    *** Time Complexity *** O((|V| + |E|) log |V|) = O(|E| log |V|)
 */
class EdgeCost{
    public int to;
    public double cost;
    public EdgeCost(int t, double c){
        this.to = t;
        this.cost = c;
    }
}
class VertexKey implements Comparator<VertexKey>{
    double key;
    int vertex;
    public VertexKey(){

    }
    public VertexKey(int v, double k){
        this.vertex = v;
        this.key = k;
    }
    public int compare(VertexKey v1, VertexKey v2){
        if(v1.key > v2.key){
            return  1;
        }
        else if(v1.key < v2.key){
            return  -1;
        }
        else return 0;
    }
}
class PrimsMSTAdjcencyList {
    public List<EdgeCost> wgraph[];
    public double key[];
    public int n;
    public boolean visited[];
    public int parent[];
    public double ans = 0;
    public PriorityQueue<VertexKey> pq; //heap to store the vertex and key after relaxing the vertex
    public PrimsMSTAdjcencyList(List<EdgeCost> wg[], int n){
        this.n = n;
        this.wgraph = wg;
        this.key = new double[n];
        this.parent = new int[n];
        this.visited = new boolean[n];
        Arrays.fill(parent, -1);
        Arrays.fill(visited, false);
        Arrays.fill(key, Double.MAX_VALUE);
        key[0] = 0;
        pq = new PriorityQueue<VertexKey>(n, new VertexKey());
        pq.add(new VertexKey(0,0));
        primMSTAL();
        printMSTWeight();
    }
    public void printMSTWeight(){
        for (int i = 0; i < n; i++) {
            ans += key[i];
        }
    }
    public void primMSTAL(){
        while(pq.size() != 0){
            int v = pq.poll().vertex;
            if(visited[v]){
                continue;
            }
            visited[v] = true;
            for(EdgeCost e : wgraph[v]){
                int ver = e.to;
                double weight = e.cost;
                if(!visited[ver] && key[ver] > e.cost){
                    key[ver]  = e.cost;
                    parent[ver] = v;
                    pq.add(new VertexKey(ver, key[ver]));
                }
            }
        }
    }
    public static void main(String[] args) {
        try{
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//            BufferedReader in = new BufferedReader(new FileReader("inp.txt"));
            int n = Integer.parseInt(in.readLine());
            List<EdgeCost> gr[] = new ArrayList[n];
            for (int i = 0; i < n; i++) {
                gr[i]= new ArrayList<EdgeCost>();
            }
            int m = Integer.parseInt(in.readLine());
            for (int i = 0; i < m; i++) {
                String inp[] =(in.readLine()).split(" ");
                int v1 = Integer.parseInt(inp[0]);
                int v2 = Integer.parseInt(inp[1]);
                double c = Double.parseDouble(inp[2]);
                gr[v1].add(new EdgeCost(v2,c));
                gr[v2].add(new EdgeCost(v1,c));
            }
            long st = System.currentTimeMillis();
            PrimsMSTAdjcencyList test = new PrimsMSTAdjcencyList(gr, n);
            System.out.println(test.ans);
            long et = System.currentTimeMillis();
            System.out.println(et-st);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
