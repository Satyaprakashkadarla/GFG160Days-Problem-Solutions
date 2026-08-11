import java.util.*;

class Solution {

    ArrayList<Integer> largestSquare(int[][] mat, int[][] queries, int k) {
        int n = mat.length;
        int m = mat[0].length;

        // Build 2D prefix sum
        int[][] pref = new int[n + 1][m + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                pref[i + 1][j + 1] =
                    mat[i][j]
                    + pref[i][j + 1]
                    + pref[i + 1][j]
                    - pref[i][j];
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();

        for (int[] query : queries) {
            int r = query[0];
            int c = query[1];

            // Maximum possible radius
            int maxRadius = Math.min(
                Math.min(r, n - 1 - r),
                Math.min(c, m - 1 - c)
            );

            int low = 0;
            int high = maxRadius;
            int best = -1;

            while (low <= high) {
                int radius = low + (high - low) / 2;

                int top = r - radius;
                int bottom = r + radius;
                int left = c - radius;
                int right = c + radius;

                int ones = getSum(pref, top, left, bottom, right);

                if (ones <= k) {
                    best = radius;
                    low = radius + 1;
                } else {
                    high = radius - 1;
                }
            }

            // No valid square, including 1x1
            if (best == -1) {
                ans.add(-1);
            } else {
                ans.add(2 * best + 1);
            }
        }

        return ans;
    }

    private int getSum(int[][] pref, int r1, int c1, int r2, int c2) {
        return pref[r2 + 1][c2 + 1]
             - pref[r1][c2 + 1]
             - pref[r2 + 1][c1]
             + pref[r1][c1];
    }
}