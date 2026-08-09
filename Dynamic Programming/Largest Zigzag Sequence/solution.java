class Solution {
    public int zigzagSequence(int[][] mat) {
        int n = mat.length;

        // dp[j] = maximum sum ending at column j
        int[] dp = new int[n];

        // First row
        for (int j = 0; j < n; j++) {
            dp[j] = mat[0][j];
        }

        for (int i = 1; i < n; i++) {

            // Find largest and second-largest values
            // in the previous row.
            int max1 = Integer.MIN_VALUE;
            int max2 = Integer.MIN_VALUE;
            int maxCol = -1;

            for (int j = 0; j < n; j++) {
                if (dp[j] > max1) {
                    max2 = max1;
                    max1 = dp[j];
                    maxCol = j;
                } else if (dp[j] > max2) {
                    max2 = dp[j];
                }
            }

            int[] next = new int[n];

            for (int j = 0; j < n; j++) {
                // Can't use the same column as previous row.
                int bestPrevious = (j == maxCol) ? max2 : max1;

                next[j] = mat[i][j] + bestPrevious;
            }

            dp = next;
        }

        // Maximum sum ending anywhere in the last row.
        int answer = 0;
        for (int value : dp) {
            answer = Math.max(answer, value);
        }

        return answer;
    }
