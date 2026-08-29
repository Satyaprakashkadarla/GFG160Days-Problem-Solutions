class Solution {
    public int countSubsequences(String s, int n) {
        final int MOD = 1_000_000_007;

        long[] dp = new long[n];

        for (int i = 0; i < s.length(); i++) {
            int d = s.charAt(i) - '0';

            // Contributions from subsequences that append this digit.
            long[] next = new long[n];

            for (int r = 0; r < n; r++) {
                if (dp[r] != 0) {
                    int nr = (int) (((long) r * 10 + d) % n);
                    next[nr] += dp[r];
                    if (next[nr] >= MOD) {
                        next[nr] -= MOD;
                    }
                }
            }

            // Start a new subsequence with just this digit.
            next[d % n]++;

            if (next[d % n] >= MOD) {
                next[d % n] -= MOD;
            }

            // Merge with subsequences that don't use this digit.
            for (int r = 0; r < n; r++) {
                dp[r] += next[r];
                if (dp[r] >= MOD) {
                    dp[r] -= MOD;
                }
            }
        }

        return (int) dp[0];
    }
}
