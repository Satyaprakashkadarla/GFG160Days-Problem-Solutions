import java.util.*;

class Solution {
    public int helper(int start, int end, List<Integer> arr, int[][] dp) {
        if (end - start == 1) return 0;
        if (dp[start][end] != -1) return dp[start][end];
        
        int ans = Integer.MAX_VALUE;
        for (int k = start + 1; k < end; k++) {
            int left = helper(start, k, arr, dp);
            int right = helper(k, end, arr, dp);
            ans = Math.min(ans, left + right + arr.get(start) * arr.get(k) * arr.get(end));
        }
        dp[start][end] = ans;
        return dp[start][end];
    }

    public int matrixMultiplication(List<Integer> arr) {
        int n = arr.size();
        int[][] dp = new int[n][n];
        for (int[] row : dp) Arrays.fill(row, -1);
        return helper(0, n - 1, arr, dp);
    }
}
