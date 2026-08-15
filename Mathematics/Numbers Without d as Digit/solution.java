class Solution {
    public int countWithout(int n, int d) {
        if (n == 0) return 0;

        char[] digits = String.valueOf(n).toCharArray();

        // dp[tight][started]
        long[][] dp = new long[2][2];
        dp[1][0] = 1; // no digit processed yet

        for (char ch : digits) {
            int limitDigit = ch - '0';
            long[][] next = new long[2][2];

            for (int tight = 0; tight <= 1; tight++) {
                for (int started = 0; started <= 1; started++) {
                    long ways = dp[tight][started];
                    if (ways == 0) continue;

                    int limit = (tight == 1) ? limitDigit : 9;

                    for (int digit = 0; digit <= limit; digit++) {
                        int newTight = (tight == 1 && digit == limitDigit) ? 1 : 0;

                        // Leading zero: don't treat it as digit d
                        if (started == 0 && digit == 0) {
                            next[newTight][0] += ways;
                        } else {
                            if (digit == d) continue;

                            next[newTight][1] += ways;
                        }
                    }
                }
            }

            dp = next;
        }

        // Count includes 0, so subtract it.
        return (int) (dp[0][1] + dp[1][1]);
    }
}
