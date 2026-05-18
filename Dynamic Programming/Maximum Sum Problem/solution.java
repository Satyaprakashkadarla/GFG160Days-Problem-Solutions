import java.util.*;

class Solution {
    public int maxSum(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = Math.max(i, dp[i/2] + dp[i/3] + dp[i/4]);
        }
        return dp[n];
    }
}