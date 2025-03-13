class Solution {
    // Define the dp array
    private int[][] dp = new int[1001][1001];

    // Recursive function to solve the 0/1 knapsack problem
    private int solve(int W, int w, int[] val, int[] wt, int i) {
        if (i == wt.length) return 0; // Base case: no items left
        if (dp[i][w] != -1) return dp[i][w]; // Return memoized result if exists
        
        int pick = 0;
        if (w >= wt[i]) {
            pick = val[i] + solve(W, w - wt[i], val, wt, i + 1); // Pick the current item
        }
        int nopick = solve(W, w, val, wt, i + 1); // Don't pick the current item
        return dp[i][w] = Math.max(pick, nopick); // Store the result in dp and return
    }

    // Main knapsack function
    public int knapsack(int W, int[] val, int[] wt) {
        // Initialize dp array with -1
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return solve(W, W, val, wt, 0); // Start with the full capacity
    }
}