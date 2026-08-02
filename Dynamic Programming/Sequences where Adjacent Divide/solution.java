class Solution {
    public int count(int n, int m) {
        if (n == 1) return m;
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= m; i++) dp[n][i] = 1;
        
        for (int pos = n - 1; pos >= 1; pos--) {
            for (int prev = 1; prev <= m; prev++) {
                int ways = 0;
                for (int curr = 1; curr <= m; curr++) {
                    if (curr % prev == 0 || prev % curr == 0) {
                        ways += dp[pos + 1][curr];
                    }
                }
                dp[pos][prev] = ways;
            }
        }
        
        int total = 0;
        for (int first = 1; first <= m; first++) {
            for (int second = 1; second <= m; second++) {
                if (second % first == 0 || first % second == 0) {
                    total += dp[2][second];
                }
            }
        }
        return total;
    }
}