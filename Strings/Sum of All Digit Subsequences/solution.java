class Solution {
    public int subsequenceSum(String s) {
        long MOD = 1_000_000_007;
        long ans = 0;

        for (int i = 0; i < s.length(); i++) {
            long digit = s.charAt(i) - '0';

            // Each digit appears in 2^(n-1) subsequences
            ans = (ans + digit * modPow(2, s.length() - 1, MOD)) % MOD;
        }

        return (int) ans;
    }

    private long modPow(long base, int exp, long mod) {
        long result = 1;

        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = (result * base) % mod;
            }

            base = (base * base) % mod;
            exp >>= 1;
        }

        return result;
    }
}