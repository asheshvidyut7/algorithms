package Matching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Ashesh Vidyut (Drift King) *
 */
/*
    Kuhn's algorithm using Adjacency List
    *** Time Complexity *** O(E*V)

    A matching in a "Bipartite Graph" is a set of the edges chosen in such a way that no two edges share an endpoint.
    Implementation
    Kuhn Algorithm
    Take the input as Adjacency List
    The idea is to use DFS traversal to find a job for an applicant.
    In algorithm, we one by one try all jobs that an applicant ‘u’ is interested in until we find a job, or all jobs
    are tried without luck. For every job we try, we do following.

    1. If a job is not assigned to anybody, we simply assign it to the applicant and return true.
    2. If a job is assigned to somebody else say x, then we recursively check whether x can be assigned
    some other job. To make sure that x doesn’t get the same job again, we mark the job ‘v’ as seen
    before we make recursive call for x.
    If x can get other job, we change the applicant for job ‘v’ and return true.
    We use an array maxR[0..N-1] that stores the applicants assigned to different jobs.
    let there are n1 applicants and there are n2 jobs.
    we have to assign an applicant to each job.
 */
public class MaximumBipartiteMatchingKuhnAL {
    public boolean assignJob(List<Integer> graph[], int u, int matching[], boolean vis[]){
        // trying to assign a job in set (len - n2) to the vertex u
        vis[u] = true;
        // for every preferred job of the vertex u, that is every edge in graph[u]
        for( int v : graph[u]){
            int u2 = matching[v];
            // if v(preffered job of u) is not assigned to any one else
            if(u2 == -1){
                matching[u] = v;
                return true;
            }
            // if the preffered job is assigned to some other person - u2
            // then try to assign u2 some other job which he prefers
            else if(!vis[u2] && assignJob(graph, u2, matching, vis)){
                return true;
            }
        }
        return false;
    }
    public int maxMatching(List<Integer> graph[], int n1, int n2){
        int matching = 0;
        int matchar[] = new int[n2];
        Arrays.fill(matchar, -1);
        for (int i = 0; i < n1; i++) {
            boolean vis[] = new boolean[n1];
            if(assignJob(graph, i, matchar, vis)){
                ++matching;
            }
        }
        return matching;
    }
    public static void main(String[] args) {
        try {
            int n1 = 2;
            int n2 = 3;
            List<Integer>[] g = new List[n1];
            for (int i = 0; i < n1; i++) {
                g[i] = new ArrayList<Integer>();
            }
            g[0].add(2);
            g[0].add(0);
            g[1].add(2);
            MaximumBipartiteMatchingKuhnAL k = new MaximumBipartiteMatchingKuhnAL();
            long st = System.currentTimeMillis();
            System.out.println(k.maxMatching(g, 2, 3));
            long et = System.currentTimeMillis();
            System.err.println("time = " + (et-st));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
