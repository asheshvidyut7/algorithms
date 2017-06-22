package Graph.WeightedGraph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
<<<<<<< HEAD
 *
=======
 * Ashesh Vidyut (Drift King) *
>>>>>>> c6aee27e327e96a58c4583ac08325c3bed0bb43f
 */
/*
    *** Time Complexity *** O(V^2)
 */
public class DijkstrasSSSP {
    public int n;
    public boolean visited[];
    public double dist[];
    public int parent[];
    public double edge[][];
    public int source;
    public DijkstrasSSSP(int n, double mat[][], int s){
        this.n = n;
        this.edge = mat;
        this.visited = new boolean[n];
        this.dist = new double[n];
        this.parent = new int[n];
        this.source = s;
        Arrays.fill(parent, -1);
        Arrays.fill(visited, false);
        Arrays.fill(dist, Double.MAX_VALUE);
        dist[source] = 0;
        dijkstra();
        displayPath();
    }
    public void dijkstra(){
        while(!allVisited(visited)){
            int v = findMin();
            visited[v] = true;
            for (int i = 0; i < n; i++) {
                if(!visited[i] && edge[i][v] >0 && dist[i]> edge[i][v] + dist[v]){
                    parent[i] = v;
                    dist[i] = edge[i][v] + dist[v];
                }
            }
        }
    }
    public void displayPath(){
        for (int i = 0; i < n; i++) {
            System.out.println("For vertex "+i);
            String path = "";
            int v = i;
            while(v != source){
                path += ""+v+" ";
                v = parent[v];
            }
            System.out.println(path);
            System.out.println(dist[i]);
            System.out.println();
        }
    }
    public boolean allVisited(boolean v[]){
        boolean av[] = new boolean[n];
        Arrays.fill(av, true);
        if(Arrays.equals(av,v))
            return true;
        return false;
    }
    public int findMin(){
        double x = Double.MAX_VALUE;
        int min_v = 0;
        for (int i = 0; i < n; i++) {
            if(!visited[i] && x > dist[i]){
                min_v = i;
                x = dist[i];
            }
        }
        return min_v;
    }
    public static void main(String[] args) {
        try{
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(in.readLine());
            double tab [][] = new double[n][n];
            for (int i = 0; i < n; i++) {
                Arrays.fill(tab[0], 0);
            }
            int m = Integer.parseInt(in.readLine());
            for (int i = 0; i < m; i++) {
                String inp[] =(in.readLine()).split(" ");
                int v1 = Integer.parseInt(inp[0]);
                int v2 = Integer.parseInt(inp[1]);
                double c = Double.parseDouble(inp[2]);
                tab[v1][v2] = c;
                tab[v2][v1] = c;
            }
            int source = Integer.parseInt(in.readLine());
            DijkstrasSSSP test = new DijkstrasSSSP(n, tab, source);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
