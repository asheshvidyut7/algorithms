package DynamicProgramming;

/**
 *
 */
/*
    Given a rod of length n inches and an array of prices that contains prices of all pieces
    of size smaller than n. Determine the maximum value obtainable by cutting up the rod and
    selling the pieces.
    *** Time Complexity *** O(n^2)
 */
public class RodCut {
    public long rodcut(int price[], int n){
        int dp[] = new int[n + 1];
        int p[] = new int[n + 1];
        p[0] = 0;
        for (int i = 0; i < n; i++) {
            p[i + 1] = price[i];
        }
        dp[0] = 0;
        dp[1] = p[1];
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= i; j++) {
                dp[i] = Math.max(dp[i], dp[j] + p[i - j]);
            }
        }
        return dp[n];
    }
    public static void main(String[] args) {
        try {
            RodCut rc = new RodCut();
            int arr[] = {1, 5, 8, 9, 10, 17, 17, 20};
            System.out.println(rc.rodcut(arr, 8));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
