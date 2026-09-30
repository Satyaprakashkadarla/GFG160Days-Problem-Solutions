class Solution {
    public int ways(int x, int y) {
        final int MOD = 1_000_000_007;

        int[] dp = new int[y + 1];
        java.util.Arrays.fill(dp, 1);

        for (int i = 1; i <= x; i++) {
            for (int j = 1; j <= y; j++) {
                dp[j] = (dp[j] + dp[j - 1]) % MOD;
            }
        }

        return dp[y];
    }
}
