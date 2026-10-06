class Solution {
    public int longIncPath(int[][] matrix, int n, int m) {
        int[][] dp = new int[n][m];
        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans = Math.max(ans, dfs(matrix, dp, i, j, n, m));
            }
        }

        return ans;
    }

    private int dfs(int[][] matrix, int[][] dp,
                    int r, int c, int n, int m) {

        if (dp[r][c] != 0) {
            return dp[r][c];
        }

        int best = 1;

        // Up
        if (r > 0 && matrix[r - 1][c] > matrix[r][c]) {
            best = Math.max(best,
                    1 + dfs(matrix, dp, r - 1, c, n, m));
        }

        // Down
        if (r + 1 < n && matrix[r + 1][c] > matrix[r][c]) {
            best = Math.max(best,
                    1 + dfs(matrix, dp, r + 1, c, n, m));
        }

        // Left
        if (c > 0 && matrix[r][c - 1] > matrix[r][c]) {
            best = Math.max(best,
                    1 + dfs(matrix, dp, r, c - 1, n, m));
        }

        // Right
        if (c + 1 < m && matrix[r][c + 1] > matrix[r][c]) {
            best = Math.max(best,
                    1 + dfs(matrix, dp, r, c + 1, n, m));
        }

        return dp[r][c] = best;
    }
}
