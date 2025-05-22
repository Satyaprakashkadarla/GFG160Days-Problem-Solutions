class Solution {
    public int backtrack(int left, int right, String s, int[][] dp) {
        if (left >= right) return 0;
        if (dp[left][right] != -1) return dp[left][right];
        if (s.charAt(left) == s.charAt(right)) 
            return dp[left][right] = backtrack(left + 1, right - 1, s, dp);
        else 
            return dp[left][right] = 1 + Math.min(backtrack(left + 1, right, s, dp),
                                                  backtrack(left, right - 1, s, dp));
    }

    public int minDeletions(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++)
            Arrays.fill(dp[i], -1);
        return backtrack(0, n - 1, s, dp);
    }
}
