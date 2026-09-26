class Solution {
    public int minimumCost(int x, int s, int m, int l,
                           int cs, int cm, int cl) {

        int max = x + l;
        int INF = 1_000_000_000;

        int[] dp = new int[max + 1];
        Arrays.fill(dp, INF);
        dp[0] = 0;

        for (int i = 1; i <= max; i++) {
            if (i >= s)
                dp[i] = Math.min(dp[i], dp[i - s] + cs);

            if (i >= m)
                dp[i] = Math.min(dp[i], dp[i - m] + cm);

            if (i >= l)
                dp[i] = Math.min(dp[i], dp[i - l] + cl);
        }

        int ans = INF;
        for (int i = x; i <= max; i++) {
            ans = Math.min(ans, dp[i]);
        }

        return ans;
    }
}
