class Solution {
    public int minSubarraySum(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        int minSoFar = arr[0];
        int currentMin = arr[0];

        for (int i = 1; i < arr.length; i++) {
            // Either extend the previous minimum subarray or start a new one at arr[i]
            currentMin = Math.min(arr[i], currentMin + arr[i]);
            // Update the global minimum sum
            minSoFar = Math.min(minSoFar, currentMin);
        }

        return minSoFar;
    }
}