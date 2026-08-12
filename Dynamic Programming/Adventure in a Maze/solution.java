import java.util.ArrayList;

class Solution {
    static final int MOD = 1_000_000_007;

    public ArrayList<Integer> findWays(int[][] grid) {
        int n = grid.length;

        long[] ways = new long[n];
        int[] maxAdventure = new int[n];

        // -1 means the cell is unreachable
        for (int j = 0; j < n; j++) {
            maxAdventure[j] = -1;
        }

        // Starting cell
        ways[0] = 1;
        maxAdventure[0] = grid[0][0];

        for (int i = 0; i < n; i++) {
            long leftWays = 0;
            int leftMax = -1;

            for (int j = 0; j < n; j++) {

                // Start cell
                if (i == 0 && j == 0) {
                    leftWays = ways[j];
                    leftMax = maxAdventure[j];
                    continue;
                }

                long upWays = ways[j];
                int upMax = maxAdventure[j];

                long currWays = 0;
                int currMax = -1;

                // Come from TOP.
                // Top cell must allow moving DOWN: 2 or 3.
                if (i > 0 &&
                    (grid[i - 1][j] == 2 || grid[i - 1][j] == 3)) {

                    currWays = upWays;

                    if (upMax != -1) {
                        currMax = upMax + grid[i][j];
                    }
                }

                // Come from LEFT.
                // Left cell must allow moving RIGHT: 1 or 3.
                if (j > 0 &&
                    (grid[i][j - 1] == 1 || grid[i][j - 1] == 3)) {

                    currWays = (currWays + leftWays) % MOD;

                    if (leftMax != -1) {
                        currMax = Math.max(
                            currMax,
                            leftMax + grid[i][j]
                        );
                    }
                }

                ways[j] = currWays;
                maxAdventure[j] = currMax;

                // Current cell becomes LEFT for next iteration
                leftWays = currWays;
                leftMax = currMax;
            }
        }

        ArrayList<Integer> result = new ArrayList<>();

        // No valid path
        if (ways[n - 1] == 0) {
            result.add(0);
            result.add(0);
        } else {
            result.add((int) ways[n - 1]);
            result.add(maxAdventure[n - 1]);
        }

        return result;
    }
}