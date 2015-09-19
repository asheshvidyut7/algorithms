package Matching;

import java.util.*;

/**
 *
 */
/*
    Hopcroft-Karp for finding Maximum Bipartite Matching
    *** Time Complexity *** O(EV^0.5)
    G = (V, E) where V = L U R, let M be a matching in G. We say that simple path P in G is
    an augmenting path with respect to M, if it starts at an unmatched vertex in L and ends at
    an unmatched vertex in R, and its edge belongs alternatively to M and E - M. (Augmenting Path
    is related to Flow Network, but different from it)
    In this problem we treat a path as a sequence of edges rather than sequence of vertex.
    A shortest augmenting path with respect to a matching M is an augmenting path with min number of
    edges.

    Given two sets A and B, the symmetric difference A (+) B, is (A - B) U (B - A)
    Lemma - If M is a matching and P is augmenting path w.r.t M then the symmetric difference
    M (+) P is a matching and \ M (+) P \ = \ M \ + 1.
    If P1, P2, P3, ... Pk are vertex disjoint augmenting path with respect to M, then
    symmetric distance M (+) (P1 U P2 U P3 U P4 ... Pk) is matching with \ M \ + k.

    Algorithm
    M = nil
    repeat
        let P = { P1, P2, P3, ... Pk) be a maximal set of vertex-disjoint shortest augmenting path
        w.r.t M
        M = M (+) (P1, P2, P3, ... Pk)
    until P == nil
    return M

    Implementation -
    Let U and V be the two sets in the bipartition of G, and let the matching from U to V at any time
    be represented as the set M.
    Pseudo Code
    /*
    G = G1 ∪ G2 ∪ {NIL}
    where G1 and G2 are partition of graph and NIL is a special null vertex
    function BFS ()
        for v in G1
            if Pair_G1[v] == NIL
                Dist[v] = 0
                Enqueue(Q,v)
            else
                Dist[v] = ∞
        Dist[NIL] = ∞
        while Empty(Q) == false
            v = Dequeue(Q)
            if Dist[v] < Dist[NIL]
                for each u in Adj[v]
                    if Dist[ Pair_G2[u] ] == ∞
                        Dist[ Pair_G2[u] ] = Dist[v] + 1
                        Enqueue(Q,Pair_G2[u])
        return Dist[NIL] != ∞

        function DFS (v)
            if v != NIL
                for each u in Adj[v]
                    if Dist[ Pair_G2[u] ] == Dist[v] + 1
                        if DFS(Pair_G2[u]) == true
                            Pair_G2[u] = v
                            Pair_G1[v] = u
                            return true
                Dist[v] = ∞
                return false
            return true

        function Hopcroft-Karp
            for each v in G
                Pair_G1[v] = NIL
                Pair_G2[v] = NIL
                matching = 0
                while BFS() == true
                    for each v in G1
                        if Pair_G1[v] == NIL
                            if DFS(v) == true
                                matching = matching + 1
            return matching
*/

class Bipartite_Graph{
    int n;
    int m;
    List<Integer> adj[];
    public Bipartite_Graph(int n, int m){
        this.n = n;
        this.m = m;
        this.adj = new ArrayList[n+m+1];
        for (int i = 0; i < n + m + 1; i++) {
            this.adj[i] = new ArrayList<Integer>();
        }
    }
    public void add(int u, int v){
        adj[u].add(n+v);
        adj[n+v].add(u);
    }
}
public class HopcroftKarpMaxBipartiteMatching {
    public final int NIL = 0; /* special null vertex */
    public final int INFINITY = Integer.MAX_VALUE;
    public int match[];
    public int dist[];
    public int n;
    public int m;
    Bipartite_Graph bg = new Bipartite_Graph(n,m);
    public HopcroftKarpMaxBipartiteMatching(int n, int m, Bipartite_Graph b){
        this.match = new int[n+m+1];
        this.dist = new int[n+m+1];
        this.n = n;
        this.m = m;
        this.bg = b;
    }
    public int hopcroftkarp(){
        int matching = 0;
        while(bfs()){
            for (int i = 1; i <= n; i++) {
                if(match[i] == NIL && dfs(i))
                    matching++;
            }
        }
        return matching;
    }
    public boolean bfs(){
        Queue<Integer> q = new LinkedList<Integer>();
        for (int i = 0; i < n; i++) {
            if(match[i] == NIL){
                dist[i] = 0;
                q.add(i);
            }
            else{
                dist[i] = INFINITY;
            }
        }
        dist[NIL] = INFINITY;
        while(!q.isEmpty()){
            int v = q.poll();
            if(dist[v] < dist[NIL]){
                for (Integer u : bg.adj[v]) {
                    if(dist[match[u]] == INFINITY){
                        dist[match[u]] = dist[v]+1;
                        q.add(match[u]);
                    }
                }
            }
        }
        return dist[NIL] != INFINITY;
    }
    public boolean dfs(int v){
        if(v!=NIL){
            for(int u : bg.adj[v]) {
                if(dist[match[u]] == dist[v]+1){
                    if(dfs(match[u])){
                        match[u] = v;
                        match[v] = u;
                        return true;
                    }
                }
            }
            dist[v] = INFINITY;
            return false;
        }
        return true;
    }
    public static void main(String[] args) {
        try {
            Bipartite_Graph bg = new Bipartite_Graph(3,3);
            bg.add(0,2);
            bg.add(0,0);
            bg.add(1,2);
            HopcroftKarpMaxBipartiteMatching h = new HopcroftKarpMaxBipartiteMatching(3,3,bg);
            System.out.println(h.hopcroftkarp());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
