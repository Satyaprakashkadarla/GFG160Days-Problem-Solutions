class Solution {
    public int maxAmount(int[] arr, int k) {
        int MOD = 1000000007;
        int low = 1, high = 0;
        for (int v : arr) high = Math.max(high, v);
        
        while (low <= high) {
            int mid = (low + high) / 2;
            long cnt = 0;
            for (int v : arr) {
                if (v >= mid) cnt += v - mid + 1;
                if (cnt >= k) break;
            }
            if (cnt >= k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        
        int T = high; // threshold
        long total = 0;
        long count = 0;
        for (int v : arr) {
            if (v >= T) {
                long n = v - T + 1;
                total += (long) (T + v) * n / 2;
                count += n;
            }
        }
        
        long extra = (k - count) * T;
        total += extra;
        return (int)(total % MOD);
    }
}