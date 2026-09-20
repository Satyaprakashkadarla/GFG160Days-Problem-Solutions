class Solution {
    public int largestSubsquare(char mat[][]) {
        int n = mat.length;

        int[][] left = new int[n][n];
        int[][] up = new int[n][n];

        // Precompute consecutive X's ending at each cell.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 'X') {
                    left[i][j] = 1 + (j > 0 ? left[i][j - 1] : 0);
                    up[i][j] = 1 + (i > 0 ? up[i - 1][j] : 0);
                }
            }
        }

        int max = 0;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {

                // j and i are the bottom-right corner.
                int side = Math.min(left[i][j], up[i][j]);

                while (side > max) {
                    int top = i - side + 1;
                    int leftCol = j - side + 1;

                    // Check top and left boundaries.
                    if (left[top][j] >= side && up[i][leftCol] >= side) {
                        max = side;
                        break;
                    }

                    side--;
                }
            }
        }

        return max;
    }
}
