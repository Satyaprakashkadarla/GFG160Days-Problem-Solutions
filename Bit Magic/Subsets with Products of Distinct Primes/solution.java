class Solution {
    static final int MOD = 1_000_000_007;
    static final int[] PRIMES = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};

    public int countSubsets(int[] arr) {
        int[] freq = new int[31];

        for (int x : arr) freq[x]++;

        // mask[i] = prime mask of i, -1 if not square-free
        int[] mask = new int[31];

        for (int i = 2; i <= 30; i++) {
            int x = i;
            int m = 0;
            boolean valid = true;

            for (int j = 0; j < 10; j++) {
                int p = PRIMES[j];
                int cnt = 0;
                while (x % p == 0) {
                    x /= p;
                    cnt++;
                }
                if (cnt > 1) {
                    valid = false;
                    break;
                }
                if (cnt == 1) m |= (1 << j);
            }

            mask[i] = valid ? m : -1;
        }

        long[] dp = new long[1 << 10];
        dp[0] = 1;

        // Process numbers 2..30
        for (int num = 2; num <= 30; num++) {
            if (freq[num] == 0 || mask[num] == -1) continue;

            long[] ndp = dp.clone();
            int m = mask[num];

            for (int state = 0; state < (1 << 10); state++) {
                if ((state & m) == 0) {
                    ndp[state | m] =
                        (ndp[state | m] + dp[state] * freq[num]) % MOD;
                }
            }
            dp = ndp;
        }

        long ans = 0;
        for (int state = 1; state < (1 << 10); state++) {
            ans = (ans + dp[state]) % MOD;
        }

        // Handle ones
        long mul = 1;
        for (int i = 0; i < freq[1]; i++) {
            mul = (mul * 2) % MOD;
        }

        ans = (ans * mul) % MOD;
        return (int) ans;
    }
}