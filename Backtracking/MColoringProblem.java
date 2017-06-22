package Backtracking;

import java.util.Arrays;

/**
<<<<<<< HEAD
 *
=======
 * Ashesh Vidyut (Drift King) *
>>>>>>> c6aee27e327e96a58c4583ac08325c3bed0bb43f
 */
/*
    Given an undirected graph and a number m,
    determine if the graph can be colored with at most m colors such that no two adjacent vertices
    of the graph are colored with same color.
    Coloring of a graph means assignment of colors to all vertices.

    Backtracking Algorithm
        The idea is to assign colors one by one to different vertices, starting from the vertex 0.
        Before assigning a color, we check for safety by considering already assigned colors to the
        adjacent vertices. If we find a color assignment which is safe, we mark the color assignment
        as part of solution. If we do not a find color due to clashes then we backtrack and return false.
 */
public class MColoringProblem {
    public boolean isSafe(int v, int c, int col[], int graph[][]){
        for (int i = 0; i < graph.length; i++) {
            if(graph[i][v] ==1 && col[i] == c){
                return false;
            }
        }
        return true;
    }
    public boolean graphColoringUtil(int graph[][], int m, int col[], int v){
        /* base case: If all vertices are assigned a color then return true */
        if(v == col.length){
            return true;
        }
        /* Consider this vertex v and try different colors */
        for (int i = 1; i <= m; i++) {
            if(isSafe(v, i, col, graph)){
                col[v] = i;
                /* recur to assign colors to rest of the vertices */
                if(graphColoringUtil(graph, m, col, v + 1)){
                    return true;
                }
                /* If assigning color c doesn't lead to a solution then remove it */
                col[v] = 0;
            }
        }
        return  false;
    }
    public void graphColoring(int g[][], int m){
        int col[] = new int[g.length];
        Arrays.fill(col, 0);
        if(graphColoringUtil(g, m, col, 0)){
            for (int i = 0; i < col.length; i++) {
                int i1 = col[i];
                System.out.println(i1);
            }
        }
    }
    public static void main(String[] args) {
        try {
            int n = 4;
            int graph[][] = {{0, 1, 1, 1},
                                {1, 0, 1, 0},
                                {1, 1, 0, 1},
                                {1, 0, 1, 0}};
            int m = 3; // Number of colors
            MColoringProblem c = new MColoringProblem();
            c.graphColoring(graph,m);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
