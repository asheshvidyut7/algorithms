package Graph.Algorithms;

import java.util.Arrays;
import java.util.Vector;

/**
 * Ashesh Vidyut (Drift King) *
 */
/*
    Simple Dfs with entry time and exit time
    *** Time Complexity *** O(E + V)
 */

public class DepthFirstSearch {
    public Vector<Vector<Integer>> graph;
    public boolean discorverd[];    //visited or not array
    public int time = 0;                //time variable to store time
    public int entry_time[];        //entry time
    public int exit_time[];         //exit time
    public int parent[];            //parent
    public int n;
    public DepthFirstSearch(Vector<Vector<Integer>> graph,int n){
        this.graph = graph;
        this.discorverd = new boolean[n];
        this.entry_time = new int[n];
        this.exit_time = new int[n];
        Arrays.fill(discorverd, false);
        parent = new int[n];
        this.n = n;
        for(int i = 0; i < n; i++){
            parent[i] = -1;
        }
        dfs();
    }
    public void dfs(){
        for(int i = 0; i < n; i++){
            if(!discorverd[i]){
                dfs_visit(i);
            }
        }
    }
    public void dfs_visit(int v){
        discorverd[v] = true;
        time++;
        entry_time[v] = time;
        Vector<Integer> neighbour_v = graph.get(v);
        if(neighbour_v.size() != 0){
            for(int f : neighbour_v){
                if(!discorverd[f]){
                    parent[f] = v;
                    dfs_visit(f);
                }
            }
        }
        time++;
        exit_time[v]=time;
    }
    public static void main(String[] args) {
        int n = 10;
        Vector<Vector<Integer>> gr = new Vector<Vector<Integer>>();
        for(int i = 0; i < n; i++){
            gr.add(new Vector<Integer>());
        }
        gr.get(1).add(2);
        gr.get(2).add(1);
        gr.get(0).add(1);
        gr.get(1).add(0);
        gr.get(9).add(0);
        gr.get(0).add(9);
        gr.get(4).add(9);
        gr.get(9).add(4);
        gr.get(5).add(6);
        gr.get(6).add(5);
        DepthFirstSearch ob = new DepthFirstSearch(gr,n);
        int par[] = ob.parent;
        int ent[] = ob.entry_time;
        int exit[] = ob.exit_time;
        for(int i = 0; i < n; i++){
            System.out.println("parent of i= "+i+" is= "+par[i]);
        }
        for(int i=0;i<n;i++){
            System.out.println("entry time of i= "+i+" is= "+ent[i]);
        }
        for(int i=0;i<n;i++){
            System.out.println("exit time of i= "+i+" is= "+exit[i]);
        }

    }
}