class Solution {
    int maxPeopleDefeated(int p) {
        long low = 0, high = 20000; // safe upper bound
        while (low <= high) {
            long mid = (low + high) / 2;
            long sum = mid * (mid + 1) * (2 * mid + 1) / 6;
            if (sum <= p) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return (int) high;
    }
}