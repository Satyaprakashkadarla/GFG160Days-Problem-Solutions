class Solution {
    public int maximumSum(int[][] mat, int k) {
        int n = mat.length;
        int[][] pref = new int[n + 1][n + 1];
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                pref[i][j] = mat[i - 1][j - 1] + pref[i - 1][j] + pref[i][j - 1] - pref[i - 1][j - 1];
            }
        }
        
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i <= n - k; i++) {
            for (int j = 0; j <= n - k; j++) {
                int sum = pref[i + k][j + k] - pref[i][j + k] - pref[i + k][j] + pref[i][j];
                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }
}