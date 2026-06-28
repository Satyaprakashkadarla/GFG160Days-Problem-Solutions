class Solution {
    public int countStrings(int n, int k) {
        final long MOD = 1_000_000_007;
        
        // dp[i][j][last] = count of strings of length i 
        // with j occurrences of "11" pattern
        // last = 0 if string ends with 0, last = 1 if ends with 1
        
        long[][][] dp = new long[n + 1][k + 2][2];
        
        // Base case: string of length 0
        dp[0][0][0] = 1;
        
        // Fill the DP table
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= k; j++) {
                // Append '0' to strings ending with 0
                dp[i + 1][j][0] = (dp[i + 1][j][0] + dp[i][j][0]) % MOD;
                
                // Append '0' to strings ending with 1
                dp[i + 1][j][0] = (dp[i + 1][j][0] + dp[i][j][1]) % MOD;
                
                // Append '1' to strings ending with 0 (no new "11")
                dp[i + 1][j][1] = (dp[i + 1][j][1] + dp[i][j][0]) % MOD;
                
                // Append '1' to strings ending with 1 (creates new "11")
                if (j + 1 <= k) {
                    dp[i + 1][j + 1][1] = (dp[i + 1][j + 1][1] + dp[i][j][1]) % MOD;
                }
            }
        }
        
        // Answer: strings of length n with exactly k "11" patterns
        long result = (dp[n][k][0] + dp[n][k][1]) % MOD;
        return (int) result;
    }
}