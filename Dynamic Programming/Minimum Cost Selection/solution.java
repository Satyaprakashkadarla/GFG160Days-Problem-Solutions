class Solution {
    public int minCost(int[][] mat) {
        int n = mat.length;

        // Base case: costs for the first row
        int prev0 = mat[0][0];
        int prev1 = mat[0][1];
        int prev2 = mat[0][2];

        // Iterate through the remaining rows
        for (int i = 1; i < n; i++) {
            int curr0 = mat[i][0] + Math.min(prev1, prev2);
            int curr1 = mat[i][1] + Math.min(prev0, prev2);
            int curr2 = mat[i][2] + Math.min(prev0, prev1);

            prev0 = curr0;
            prev1 = curr1;
            prev2 = curr2;
        }

        // The answer is the minimum cost among the three choices at the last row
        return Math.min(prev0, Math.min(prev1, prev2));
    }
}