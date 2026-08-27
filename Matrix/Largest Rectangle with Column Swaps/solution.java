import java.util.*;

class Solution {
    public int maxArea(int[][] mat) {
        int n = mat.length;    // rows
        int m = mat[0].length; // columns

        // dp[i][j] = number of consecutive 1s in column j ending at row i
        int[][] dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 1) {
                    dp[i][j] = (i == 0) ? 1 : dp[i - 1][j] + 1;
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        int maxArea = 0;

        // For each row, sort the dp values to find max rectangle
        for (int i = 0; i < n; i++) {
            // Get the dp values for this row
            Integer[] heights = new Integer[m];
            for (int j = 0; j < m; j++) {
                heights[j] = dp[i][j];
            }

            // Sort in descending order
            Arrays.sort(heights, (a, b) -> b - a);

            // Calculate maximum area with these heights
            for (int j = 0; j < m; j++) {
                int area = heights[j] * (j + 1);
                maxArea = Math.max(maxArea, area);
            }
        }

        return maxArea;
    }
}