class Solution {
    public int countWays(int n, int m) {
        int MOD = 1000000007;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1];
            if (i >= m) {
                dp[i] = (dp[i] + dp[i - m]) % MOD;
            }
        }
        return dp[n];
    }
}