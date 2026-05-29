class Solution {
    public int validGroups(String s) {
        int n = s.length();
        int maxSum = 9 * n;
        int[][] dp = new int[n + 1][maxSum + 1];
        dp[0][0] = 1;
        
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                int sum = 0;
                for (int k = j; k < i; k++) {
                    sum += s.charAt(k) - '0';
                }
                // sum of last group = sum
                for (int lastSum = 0; lastSum <= maxSum; lastSum++) {
                    if (dp[j][lastSum] > 0 && sum >= lastSum) {
                        dp[i][sum] += dp[j][lastSum];
                    }
                }
            }
        }
        
        int total = 0;
        for (int sum = 0; sum <= maxSum; sum++) {
            total += dp[n][sum];
        }
        return total;
    }
}