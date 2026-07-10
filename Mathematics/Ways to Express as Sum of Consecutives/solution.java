class Solution {
    public int getCount(int n) {
        int count = 0;
        for (int k = 2; k * (k - 1) < 2 * n; k++) {
            int num = 2 * n - k * (k - 1);
            if (num % (2 * k) == 0) {
                int a = num / (2 * k);
                if (a > 0) count++;
            }
        }
        return count;
    }
}