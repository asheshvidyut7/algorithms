package DynamicProgramming;

/**
<<<<<<< HEAD
 *
=======
 * Ashesh Vidyut (Drift King) *
>>>>>>> c6aee27e327e96a58c4583ac08325c3bed0bb43f
 */
/*
    A thief robbing a store and can carry a maximal weight of W into their knapsack. There are n items and
    ith  item weigh wt[i] and is worth val[i] dollars. What items should thief take?
    0-1 KnapSack Problem we can take an item or leave it we can't take fraction of it.
    *** Time Complexity *** O(n * W)
 */
public class KnapSackProblem {
    public long knapSack(int wt[], int val[], int W, int n){
<<<<<<< HEAD
        long k[][] = new long[n + 1][W + 1];
=======
        long k[][] = new long[n+1][W+1];
>>>>>>> c6aee27e327e96a58c4583ac08325c3bed0bb43f
        for(int i = 0; i <= n; i++){
            for(int w = 0; w <= W; w++){
                if(i == 0 || w == 0)
                    k[i][w] = 0;
                else if(wt[i - 1] <= w)
<<<<<<< HEAD
                    k[i][w] = Math.max(k[i - 1][w], val[i - 1] + k[i - 1][w - wt[i - 1]]);
                else
                    k[i][w] = k[i - 1][w];
=======
                    k[i][w] = Math.max(k[i - 1][w], val[i - 1] + k[i - 1][w - wt[i-1]]);
                else
                    k[i][w] = k[i-1][w];
>>>>>>> c6aee27e327e96a58c4583ac08325c3bed0bb43f
            }
        }
        return k[n][W];
    }
    public static void main(String[] args) {
        int val[] = {60, 100, 120};
        int wt[] = {10, 20, 30};
        int  W = 50;
        KnapSackProblem ksp = new KnapSackProblem();
        System.out.println(ksp.knapSack(wt, val, W, 3));
    }
}
