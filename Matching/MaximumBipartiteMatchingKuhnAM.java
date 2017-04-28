package Matching;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.List;

/**
 * Ashesh Vidyut (Drift King) *
 */
/*
        Kuhn's algorithm using Adjacency Matrix
        *** Time Complexity *** O(V^3)

        A matching in a "Bipartite Graph" is a set of the edges chosen in such a way that no two edges share an endpoint.
        Implementation
        Kuhn Algorithm
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
public class MaximumBipartiteMatchingKuhnAM {
    public boolean assignJob(int graph[][], int i, boolean v[], int matching[], int n1, int n2){
        v[i] = true;
        for (int j = 0; j < n2; j++) {
            if(graph[i][j] == 0){
                continue;
            }
            int u = matching[j];
            if(u == -1){
                matching[j] = i;
                return true;
            }
            else if(!v[u] && assignJob(graph, u, v, matching, n1, n2)){
                matching[j] = i;
                return true;
            }
        }
        return false;
    }
    public int maximumMatchingBipartite(int graph[][], int n1, int n2){
        int matchar[] = new int[n2];
        Arrays.fill(matchar, -1);
        int matching = 0;
        for (int i = 0; i < n1; i++) {
            boolean vis[] = new boolean[n1];
            Arrays.fill(vis, false);
            if(assignJob(graph, i, vis, matchar, n1, n2))
                ++matching;
        }
        return matching;
    }
    public static void main(String[] args) {
        try {
            int n1 = 2;
            int n2 = 2;
            int g[][] = {{1,1},{1,0}};
            MaximumBipartiteMatchingKuhnAM k = new MaximumBipartiteMatchingKuhnAM();
            long st = System.currentTimeMillis();
            System.out.println(k.maximumMatchingBipartite(g,2,2));
            long et = System.currentTimeMillis();
            System.err.println("time = " + (et-st));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
