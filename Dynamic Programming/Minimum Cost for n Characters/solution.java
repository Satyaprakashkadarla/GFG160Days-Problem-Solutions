class Solution {
    public int minCost(int n, int i, int d, int c) {
        if (n == 0) return 0;

        long[] memo = new long[n + 2];
        java.util.Arrays.fill(memo, -1);

        return (int) solve(n, i, d, c, memo);
    }

    private long solve(int n, int i, int d, int c, long[] memo) {
        if (n == 0) return 0;
        if (n == 1) return i;

        if (memo[n] != -1) {
            return memo[n];
        }

        // Build n entirely using insertions
        long ans = (long) n * i;

        if (n % 2 == 0) {
            // Reach n/2, then copy-paste
            ans = Math.min(ans,
                    solve(n / 2, i, d, c, memo) + c);
        } else {
            // Reach (n-1)/2, copy, then insert
            ans = Math.min(ans,
                    solve(n / 2, i, d, c, memo) + c + i);

            // Reach (n+1)/2, copy, then delete
            ans = Math.min(ans,
                    solve((n + 1) / 2, i, d, c, memo) + c + d);
        }

        memo[n] = ans;
        return ans;
    }
}
