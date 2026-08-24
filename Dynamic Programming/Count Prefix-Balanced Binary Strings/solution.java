class Solution {
    static final long MOD = 1_000_000_007L;

    public int prefixStrings(int n) {
        long[] fact = new long[2 * n + 1];
        fact[0] = 1;

        for (int i = 1; i <= 2 * n; i++) {
            fact[i] = fact[i - 1] * i % MOD;
        }

        // C(2n, n) = (2n)! / (n! * n!)
        long comb = fact[2 * n];
        comb = comb * modPow(fact[n], MOD - 2) % MOD;
        comb = comb * modPow(fact[n], MOD - 2) % MOD;

        // Catalan(n) = C(2n, n) / (n + 1)
        return (int) (comb * modPow(n + 1, MOD - 2) % MOD);
    }

    private long modPow(long base, long exp) {
        long result = 1;

        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = result * base % MOD;
            }

            base = base * base % MOD;
            exp >>= 1;
        }

        return result;
    }
}
