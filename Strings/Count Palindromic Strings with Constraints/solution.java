class Solution {
    public int palindromicStrings(int n, int k) {
        long MOD = 1000000007;
        long total = 0;

        // Odd lengths: L = 2m + 1, where 0 <= m <= (n - 1) / 2
        int maxOddM = (n - 1) / 2;
        for (int m = 0; m <= maxOddM && m < k; m++) {
            long ways = 1;
            for (int i = 0; i <= m; i++) {
                ways = (ways * (k - i)) % MOD;
            }
            total = (total + ways) % MOD;
        }

        // Even lengths: L = 2m, where 1 <= m <= n / 2
        int maxEvenM = n / 2;
        for (int m = 1; m <= maxEvenM && m <= k; m++) {
            long ways = 1;
            for (int i = 0; i < m; i++) {
                ways = (ways * (k - i)) % MOD;
            }
            total = (total + ways) % MOD;
        }

        return (int) (total % MOD);
    }
}