class Solution {
    public int minDiff(int k, int[] arr) {
        int n = arr.length;

        // Edge case: if k is 0, no elements are removed
        if (k == 0) {
            int minVal = arr[0], maxVal = arr[0];
            for (int i = 1; i < n; i++) {
                minVal = Math.min(minVal, arr[i]);
                maxVal = Math.max(maxVal, arr[i]);
            }
            return maxVal - minVal;
        }

        // Prefix minimum and maximum arrays
        int[] prefMin = new int[n];
        int[] prefMax = new int[n];
        prefMin[0] = arr[0];
        prefMax[0] = arr[0];
        for (int i = 1; i < n; i++) {
            prefMin[i] = Math.min(prefMin[i - 1], arr[i]);
            prefMax[i] = Math.max(prefMax[i - 1], arr[i]);
        }

        // Suffix minimum and maximum arrays
        int[] suffMin = new int[n];
        int[] suffMax = new int[n];
        suffMin[n - 1] = arr[n - 1];
        suffMax[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffMin[i] = Math.min(suffMin[i + 1], arr[i]);
            suffMax[i] = Math.max(suffMax[i + 1], arr[i]);
        }

        int res = Integer.MAX_VALUE;

        // Try removing a subarray of size k starting at index i
        for (int i = 0; i <= n - k; i++) {
            int currentMax, currentMin;

            if (i == 0) {
                // Removing prefix of size k
                currentMax = suffMax[k];
                currentMin = suffMin[k];
            } else if (i == n - k) {
                // Removing suffix of size k
                currentMax = prefMax[n - k - 1];
                currentMin = prefMin[n - k - 1];
            } else {
                // Removing a middle subarray
                currentMax = Math.max(prefMax[i - 1], suffMax[i + k]);
                currentMin = Math.min(prefMin[i - 1], suffMin[i + k]);
            }

            res = Math.min(res, currentMax - currentMin);
        }

        return res;
    }
}