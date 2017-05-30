package Graph.WeightedGraph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
<<<<<<< HEAD
 *
=======
 * Ashesh Vidyut (Drift King) *
>>>>>>> c6aee27e327e96a58c4583ac08325c3bed0bb43f
 */
class EdgeC{
    public int to;
    public double cost;
    public EdgeC(int t, double c){
        this.to = t;
        this.cost = c;
    }
}
class VertexDist implements Comparator<VertexDist>{
    public int vertex;
    public double dist;
    public VertexDist(){

    }
    public VertexDist(int v, double d){
        this.vertex = v;
        this.dist = d;
    }
    public int compare(VertexDist v1, VertexDist v2){
        if(v1.dist < v2.dist){
            return -1;
        }
        else if(v1.dist > v2.dist){
            return 1;
        }
        else{
            return 0;
        }
    }
}
class DijkstrassSSSPAdjacencyList {
    public int n;
    public List<EdgeC>[] graph;
    public int parent[];
    public boolean visited[];
    public double dist[];
    public int source;
    public PriorityQueue<VertexDist> pq;
    public DijkstrassSSSPAdjacencyList(List<EdgeC> []gr, int n, int source){
        this.graph = gr;
        this.n = n;
        this.source = source;
        this.visited = new boolean[n];
        this.parent = new int[n];
        this.dist = new double[n];
        this.pq = new PriorityQueue<VertexDist>(n, new VertexDist());
        pq.add(new VertexDist(source, 0));
        Arrays.fill(parent, -1);
        Arrays.fill(dist, Double.MAX_VALUE);
        Arrays.fill(visited, false);
        dist[source] = 0;
        dijkstras();
        printResult();
    }
    public void dijkstras(){
        while(!pq.isEmpty()){
            int v = pq.poll().vertex;
            if(visited[v]){
                continue;
            }
            visited[v] = true;
            for (EdgeC e : graph[v]) {
                int ver = e.to;
                double cost = e.cost;
                if(!visited[ver] && dist[ver] > dist[v] + cost){
                    dist[ver] = dist[v] + cost;
                    parent[ver] = v;
                    pq.add(new VertexDist(ver, dist[ver]));
                }
            }
        }
    }
    public void printResult(){
        for (int i = 0; i < n; i++) {
            int v = i;
            System.out.println("v = " + v);
            System.out.println(dist[v]);
            if(v == source){
                continue;
            }
            while(v != source){
                v = parent[v];
                System.out.print(v + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//            BufferedReader in = new BufferedReader(new FileReader("inp.txt"));
            int n = Integer.parseInt(in.readLine());
            List<EdgeC> gr[] = new ArrayList[n];
            for (int i = 0; i < n; i++) {
                gr[i]= new ArrayList<EdgeC>();
            }
            int m = Integer.parseInt(in.readLine());
            for (int i = 0; i < m; i++) {
                String inp[] =(in.readLine()).split(" ");
                int v1 = Integer.parseInt(inp[0]);
                int v2 = Integer.parseInt(inp[1]);
                double c = Double.parseDouble(inp[2]);
                gr[v1].add(new EdgeC(v2,c));
                gr[v2].add(new EdgeC(v1,c));
            }
            long st = System.currentTimeMillis();
            DijkstrassSSSPAdjacencyList test = new DijkstrassSSSPAdjacencyList(gr, n, 0);
            long et = System.currentTimeMillis();
            System.out.println(et-st);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
