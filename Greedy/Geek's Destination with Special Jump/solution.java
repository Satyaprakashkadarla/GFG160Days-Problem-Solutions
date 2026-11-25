class Solution {
    private static final long MOD = 1_000_000_007L;

    public int minTime(int a, int b, int d, int l, int r) {
        long la = a, lb = b, ld = d;
        long delta = la - lb; // >= 1 since 0 < b < a

        long tNoJump = minNormalTime(ld, la, lb, delta);

        long leftX = ld - r;
        long rightX = ld - l;

        // Find the smallest X in [leftX, rightX] where jumpTime(X) > tNoJump
        long lo = leftX, hi = rightX, firstOver = rightX + 1;
        while (lo <= hi) {
            long mid = lo + (hi - lo) / 2;
            if (jumpTime(mid, la, lb, delta) > tNoJump) {
                firstOver = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        long ans = 0;
        if (leftX < firstOver) {
            long endUncapped = firstOver - 1;
            long count = endUncapped - leftX + 1;
            // Sum of (X + 1) for X in [leftX, endUncapped]
            long sumXPlus1 = (count % MOD) * (((leftX + endUncapped + 2) % MOD)) % MOD;
            if ((count & 1L) == 0) {
                sumXPlus1 = (((count / 2) % MOD) * (((leftX + endUncapped + 2) % MOD))) % MOD;
            } else {
                long evenPart = ((leftX + endUncapped + 2) / 2) % MOD;
                sumXPlus1 = ((count % MOD) * evenPart) % MOD;
            }

            long kSum = (prefixK(endUncapped, la, delta) - prefixK(leftX - 1, la, delta) + MOD) % MOD;
            long extraJumpTime = (((2L * lb) % MOD) * kSum) % MOD;
            ans = (sumXPlus1 + extraJumpTime) % MOD;
        }

        if (firstOver <= rightX) {
            long cappedCount = (rightX - firstOver + 1) % MOD;
            ans = (ans + cappedCount * (tNoJump % MOD)) % MOD;
        }

        return (int) (ans % MOD);
    }

    private long kMin(long x, long a, long delta) {
        if (x <= a) {
            return 0L;
        }
        return (x - a + delta - 1) / delta;
    }

    private long minNormalTime(long x, long a, long lb, long delta) {
        return x + 2L * lb * kMin(x, a, delta);
    }

    private long jumpTime(long x, long a, long lb, long delta) {
        return minNormalTime(x, a, lb, delta) + 1L;
    }

    // Sum of kMin(x) for x in [0, limit]
    private long prefixK(long limit, long a, long delta) {
        if (limit <= a) {
            return 0L;
        }
        long n = limit - a - 1; // >= 0
        long countAfterA = limit - a;
        long floorSum = floorDivSum(n, delta);
        return (countAfterA + floorSum) % MOD;
    }

    // Sum of floor(x / delta) for x in [0, n] where n >= 0, delta >= 1
    private long floorDivSum(long n, long delta) {
        long q = n / delta;
        long rem = n % delta;

        // delta * q * (q - 1) / 2
        long p1 = q;
        long p2 = q - 1;
        if ((p1 & 1L) == 0) {
            p1 /= 2;
        } else {
            p2 /= 2;
        }
        long fullBlocks = (((delta % MOD) * (p1 % MOD)) % MOD) * (p2 % MOD) % MOD;
        long partialBlock = ((q % MOD) * ((rem + 1) % MOD)) % MOD;
        return (fullBlocks + partialBlock) % MOD;
    }
}