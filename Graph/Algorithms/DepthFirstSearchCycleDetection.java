package Graph.Algorithms;

import java.util.Arrays;
import java.util.Vector;

/**
 *
 */

/*
 * Finding a back edge
 * *** Time Complexity *** O(V+E)
 */
public class DepthFirstSearchCycleDetection {
    public Vector<Vector<Integer>> graph;
    public boolean discorverd[];    //visited or not array
    public int time=0;                //time variable to store time
    public int entry_time[];        //entry time
    public int exit_time[];         //exit time
    public int parent[];            //parent
    public boolean processed[];        //processed
    public int n;
    public boolean cycledetected=false;
    public boolean finished=false;  //turns true after finding the first cycle
    public DepthFirstSearchCycleDetection(Vector<Vector<Integer>> graph,int n){
        this.graph = graph;
        this.discorverd = new boolean[n];
        this.entry_time = new int[n];
        this.exit_time = new int[n];
        this.processed = new boolean[n];
        Arrays.fill(discorverd, false);
        Arrays.fill(processed, false);
        parent = new int[n];
        this.n = n;
        Arrays.fill(parent, -1);
        dfs();
    }
    public void dfs(){
        for(int i=0;i<n;i++){
            if(!discorverd[i]){
                dfs_visit(i);
            }
        }
    }
    public void dfs_visit(int v){
        if(finished) return;
        discorverd[v] = true;
        time++;
        entry_time[v] = time;
        Vector<Integer> neighbour_v = graph.get(v);
        for(int i = 0; i < neighbour_v.size(); i++){
            int f=neighbour_v.get(i);
                if(!discorverd[f]){         /*if vertex is not visited, dfs_visit*/
                    parent[f] = v;
                    dfs_visit(f);
                }
                else if(!(processed[f])){
                 /*
                    if vertex is visited, but not yet processed, means "f" is parent
                    because processed[i] is turned true at the end
                    now we check if again that parent of v is == f or not
                    if it is equal to f then no cycle in Undirected Graph , it could be the repetition
                    since we have done graph.get(0).add(1) and graph.get(1).add(0)
                */
                    process_edge(v, f);
                }
            if(finished) return;
        }
        time++;
        exit_time[v] = time;
        processed[v] = true;
    }
    public void process_edge(int v,int f){
        if (parent[v] != f) {               /* found back edge! */
            System.out.printf("Cycle from %d to %d:\n", v, f);
            finished = true;
            cycledetected = true;
        }

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
        DepthFirstSearchCycleDetection ob = new DepthFirstSearchCycleDetection(gr,n);
        if(!ob.cycledetected){
            System.out.println("no cycles");
        }
    }
}
