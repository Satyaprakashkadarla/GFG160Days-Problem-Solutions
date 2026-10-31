class Solution {
    public int maxPackages(int[] arr, int totalTime) {
        int n = arr.length;
        if (totalTime > n) {
            totalTime = n; // Handle edge case where totalTime exceeds array size
        }

        int currentSum = 0;

        // Sum of the first window of size 'totalTime'
        for (int i = 0; i < totalTime; i++) {
            currentSum += arr[i];
        }

        int maxSum = currentSum;

        // Slide the window across the rest of the array
        for (int i = totalTime; i < n; i++) {
            currentSum += arr[i] - arr[i - totalTime];
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}