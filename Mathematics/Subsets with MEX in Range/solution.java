
class Solution {
    static final long MOD = 1_000_000_007L;

    public int cntSubsets(int arr[], int l, int r) {
        int n = arr.length;

        int[] freq = new int[n + 1];

        for (int x : arr) {
            if (x <= n) {
                freq[x]++;
            }
        }

        // Precompute powers of 2
        long[] pow2 = new long[n + 1];
        pow2[0] = 1;

        for (int i = 1; i <= n; i++) {
            pow2[i] = (pow2[i - 1] * 2) % MOD;
        }

        // F(x) = number of subsets with MEX <= x
        // Equivalently, total subsets minus subsets with MEX > x.
        // MEX > x requires all values 0...x to be present.

        long total = pow2[n];
        long requiredPresent = 1;

        // F(r) - F(l-1)
        long upper = countAtMost(r, freq, pow2, total, n);
        long lower = countAtMost(l - 1, freq, pow2, total, n);

        return (int) ((upper - lower + MOD) % MOD);
    }

    private long countAtMost(int x, int[] freq,
                             long[] pow2, long total, int n) {

        if (x < 0) return 0;

        if (x >= n) return total;

        long ways = 1;

        // Count subsets containing at least one occurrence
        // of every number from 0 through x.
        for (int i = 0; i <= x; i++) {
            if (freq[i] == 0) {
                return total;
            }

            ways = ways * ((pow2[freq[i]] - 1 + MOD) % MOD) % MOD;
        }

        // Elements greater than x can be selected freely.
        ways = ways * pow2[n - getCount(freq, x)] % MOD;

        return (total - ways + MOD) % MOD;
    }

    private int getCount(int[] freq, int x) {
        int count = 0;

        for (int i = 0; i <= x; i++) {
            count += freq[i];
        }

        return count;
    }
}
