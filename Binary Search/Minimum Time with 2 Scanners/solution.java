
class Solution {
    public int minTime(int n, int s1, int s2) {
        int low = 0, high = n;
        int ans = Integer.MAX_VALUE;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            int t1 = mid * s1;
            int t2 = (n - mid) * s2;

            ans = Math.min(ans, Math.max(t1, t2));

            if (t1 < t2) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }
}
