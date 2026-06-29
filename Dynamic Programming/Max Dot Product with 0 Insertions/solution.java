class Solution {
    public int maxDotProduct(int[] a, int[] b) {
        int n = a.length, m = b.length;
        int[][] dp = new int[n + 1][m + 1];
        
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (j == 0) dp[i][j] = 0;
                else if (i == 0) dp[i][j] = Integer.MIN_VALUE;
                else {
                    dp[i][j] = dp[i - 1][j];
                    if (dp[i - 1][j - 1] != Integer.MIN_VALUE) {
                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + a[i - 1] * b[j - 1]);
                    }
                }
            }
        }
        return dp[n][m];
    }
}