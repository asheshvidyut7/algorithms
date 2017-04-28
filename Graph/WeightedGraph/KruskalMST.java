package Graph.WeightedGraph;

import java.io.*;
import java.util.*;

/**
 * Ashesh Vidyut (Drift King) *
 */
/*
    Advisible to use Kruskal MST in case of MST, because  TC is less
    *** Time Complexity *** O(ElogE)
    * Explantion - we have an array of E which we are sorting with merge sort
    * so merge sort goes in nlogn so time complexity is O(ElogE)
    * after that we are going through all E so time complexity is O(E)
    * Total Time Complextity is O(E) + O(ElogE) = O(ElogE)
 */
class Edge implements Comparator<Edge>{
    int from;
    int to;
    double d;
    public Edge(){
        this.from = -1;
        this.to = -1;
        this.d = 0.0d;
    }
    public Edge(int f, int t, double d){
        this.from = f;
        this.to = t;
        this.d = d;
    }
    public int compare(Edge f, Edge s){
        if(f.d < s.d){
            return -1;
        }
        else if(f.d > s.d){
            return 1;
        }
        else
            return 0;
    }
}
class UnionFind{
    public int n;
    public int id[];
    public int weight[];
    public UnionFind(int n){
        this.n = n;
        this.id = new int[n];
        this.weight = new int[n];
        for (int i = 0; i < n; i++){
            id[i] = i;
        }
        Arrays.fill(weight, 1);
    }
    public boolean connected(int p, int q){
        if(find(q) == find(p))
            return true;
        return false;
    }
    public int find(int i){
        while(id[i] != i){
            i = id[i];
        }
        return i;
    }
    public void union(int i, int j){
        int id_i = find(i);
        int id_j = find(j);
        if(id_i == id_j)
            return ;
        if(weight[id_i] > weight[id_j]){
            id[id_j] = id_i;
            weight[id_i] += weight[id_j];
        }
        else{
            id[id_i] = id_j;
            weight[id_j] += weight[id_i];
        }
    }
}
public class KruskalMST {
    public static void main(String[] args) {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(in.readLine());
            double tab [][] = new double[n][n];
            int m = Integer.parseInt(in.readLine());
            Edge[] ear = new Edge[m];
            for (int i = 0; i < m; i++) {
                String inp[] =(in.readLine()).split(" ");
                int v1 = Integer.parseInt(inp[0]);
                int v2 = Integer.parseInt(inp[1]);
                double c = Double.parseDouble(inp[2]);
                ear[i] = new Edge(v1, v2, c);
            }
            Arrays.sort(ear, new Edge());
            UnionFind uf = new UnionFind(n);
            double ans = 0;
            for (int i = 0; i < m; i++) {
                Edge e = ear[i];
                if(!uf.connected(e.from, e.to)){
                    uf.union(e.from, e.to);
                    ans += e.d;
                }
            }
            System.out.println(ans);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
