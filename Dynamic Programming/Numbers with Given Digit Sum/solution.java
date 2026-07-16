class Solution {
    public int countWays(int n, int sum) {
        if (sum > 9 * n) return -1;
        int[][] dp = new int[n + 1][sum + 1];
        dp[n][0] = 1;
        
        for (int pos = n - 1; pos >= 0; pos--) {
            for (int s = 0; s <= sum; s++) {
                int start = (pos == 0) ? 1 : 0;
                for (int d = start; d <= 9 && d <= s; d++) {
                    dp[pos][s] += dp[pos + 1][s - d];
                }
            }
        }
        return dp[0][sum] == 0 ? -1 : dp[0][sum];
    }
}