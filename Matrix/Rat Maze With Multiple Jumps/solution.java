import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public ArrayList<ArrayList<Integer>> shortestDist(int[][] mat) {
        int n = mat.length;
        int[][] ans = new int[n][n];
        
        // Handle 1x1 matrix edge case
        if (n == 1) {
            ArrayList<ArrayList<Integer>> res = new ArrayList<>();
            res.add(new ArrayList<>(Arrays.asList(1)));
            return res;
        }

        // memo[i][j] will be true if cell (i, j) has been proven to be a dead end
        boolean[][] memo = new boolean[n][n];

        // Initialize the starting position
        ans[0][0] = 1;
        
        if (solve(0, 0, mat, ans, n, memo)) {
            // Convert int[][] to ArrayList<ArrayList<Integer>>
            ArrayList<ArrayList<Integer>> result = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                ArrayList<Integer> row = new ArrayList<>();
                for (int j = 0; j < n; j++) {
                    row.add(ans[i][j]);
                }
                result.add(row);
            }
            return result;
        }
        
        // If no path is found, return [[-1]]
        ArrayList<ArrayList<Integer>> noPath = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(-1);
        noPath.add(temp);
        return noPath;
    }

    private boolean solve(int i, int j, int[][] mat, int[][] ans, int n, boolean[][] memo) {
        // If destination reached, we found our valid path
        if (i == n - 1 && j == n - 1) {
            return true;
        }

        // If this cell is already known to be a dead end, skip it
        if (memo[i][j]) {
            return false;
        }

        int maxJumps = mat[i][j];

        // Explore shorter jumps first (1 to maxJumps)
        for (int jump = 1; jump <= maxJumps; jump++) {
            
            // Priority 1: Move Forward (Right)
            if (j + jump < n) {
                ans[i][j + jump] = 1; // Choose
                if (solve(i, j + jump, mat, ans, n, memo)) {
                    return true; // Found path, propagate true up
                }
                ans[i][j + jump] = 0; // Backtrack
            }

            // Priority 2: Move Downward
            if (i + jump < n) {
                ans[i + jump][j] = 1; // Choose
                if (solve(i + jump, j, mat, ans, n, memo)) {
                    return true; // Found path, propagate true up
                }
                ans[i + jump][j] = 0; // Backtrack
            }
        }

        // If no path from this cell succeeded, mark it as a dead end
        memo[i][j] = true;
        return false;
    }
}