class Solution {
    public int longestSubseq(int[] arr) {
        int maxVal = 1_000_000;
        int[] dp = new int[maxVal + 2];

        int ans = 1;

        for (int x : arr) {
            int curr = 1 + Math.max(dp[x - 1], dp[x + 1]);

            // Update only after reading neighbors,
            // so the same occurrence isn't reused.
            dp[x] = Math.max(dp[x], curr);

            ans = Math.max(ans, dp[x]);
        }

        return ans;
    }
}
