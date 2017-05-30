package Graph.Algorithms;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

/*
    Finding Connected Components of Undirected Graph with Depth First Search.
    *** Time Complexity *** O(E+V)
 */
/**
 *
 */

public class ConnectedComponentsDepthFirstSearch{
    public Map<Integer,Vector<Integer>> graph;
    public int n;
    public boolean discovered[];
    public Vector<Vector<Integer>> groups = new Vector<Vector<Integer>>();
    public ConnectedComponentsDepthFirstSearch(Map<Integer,Vector<Integer>> g, int n){
        this.n = n;
        this.graph = g;
        this.discovered = new boolean[n];
        Arrays.fill(discovered, false);
        dfs();
    }
    public void dfs(){
        for (int i = 0; i < n; i++){
            if(!discovered[i]){
                groups.add(new Vector<Integer>());
                int g_id = groups.size() - 1;
                dfs_visit(i, g_id);
            }
        }
    }
    public void dfs_visit(int v, int gid){
        discovered[v] = true;
        groups.get(gid).add(v);
        for( int f : graph.get(v)){
            if(!discovered[f]){
                dfs_visit(f, gid);
            }
        }
    }
    public Vector<Vector<Integer>> getConnectedComponent(){
        return groups;
    }
    public static void main(String[] args) {
        Map<Integer,Vector<Integer>> graph=new HashMap<Integer, Vector<Integer>>();
        for(int i=0;i<10;i++){
            graph.put(i,new Vector<Integer>());
        }
        graph.get(2).add(4);
        graph.get(4).add(2);
        graph.get(3).add(4);
        graph.get(4).add(3);
        graph.get(5).add(4);
        graph.get(4).add(5);
        graph.get(1).add(6);
        graph.get(6).add(1);
        graph.get(2).add(7);
        graph.get(7).add(2);
        ConnectedComponentsDepthFirstSearch ccob = new ConnectedComponentsDepthFirstSearch(graph,10);
        System.out.println(ccob.getConnectedComponent());
    }
}