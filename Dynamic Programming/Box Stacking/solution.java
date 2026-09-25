class Solution {
    private int[][] box;
    private int[] dp;

    public int maxHeight(int[] height, int[] width, int[] length) {
        int n = height.length;

        // 3 rotations for every box:
        // [base1, base2, height]
        box = new int[3 * n][3];

        int k = 0;

        for (int i = 0; i < n; i++) {
            k = add(box, k, width[i], length[i], height[i]);
            k = add(box, k, height[i], length[i], width[i]);
            k = add(box, k, height[i], width[i], length[i]);
        }

        dp = new int[k];
        Arrays.fill(dp, -1);

        int ans = 0;

        for (int i = 0; i < k; i++) {
            ans = Math.max(ans, dfs(i));
        }

        return ans;
    }

    private int add(int[][] box, int k, int a, int b, int h) {
        // Store base dimensions in descending order.
        if (a < b) {
            int temp = a;
            a = b;
            b = temp;
        }

        box[k][0] = a;
        box[k][1] = b;
        box[k][2] = h;

        return k + 1;
    }

    private int dfs(int i) {
        if (dp[i] != -1) {
            return dp[i];
        }

        int best = 0;

        for (int j = 0; j < box.length; j++) {
            // j can be placed on top of i.
            if (box[j][0] < box[i][0] &&
                box[j][1] < box[i][1]) {

                best = Math.max(best, dfs(j));
            }
        }

        return dp[i] = box[i][2] + best;
    }
}
