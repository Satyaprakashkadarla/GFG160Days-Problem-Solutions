class Solution {
    public int findMinCost(String s1, String s2, int costS1, int costS2) {
        int n = s1.length();
        int m = s2.length();

        // dp[j] = LCS length for current prefix of s1 and s2[0...j-1]
        int[] dp = new int[m + 1];

        for (int i = 1; i <= n; i++) {
            int diagonal = 0;

            for (int j = 1; j <= m; j++) {
                int old = dp[j];

                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[j] = diagonal + 1;
                } else {
                    dp[j] = Math.max(dp[j], dp[j - 1]);
                }

                diagonal = old;
            }
        }

        int lcs = dp[m];

        return (n - lcs) * costS1 + (m - lcs) * costS2;
    }
}