class Solution {
    public int maxSumSubarray(int[] arr) {
        int n = arr.length;
        int dp0 = arr[0];
        int dp1 = arr[0];
        int maxSum = arr[0];
        
        for (int i = 1; i < n; i++) {
            int dp0_prev = dp0;
            dp0 = Math.max(arr[i], dp0 + arr[i]);
            dp1 = Math.max(dp0_prev, dp1 + arr[i]);
            maxSum = Math.max(maxSum, Math.max(dp0, dp1));
        }
        return maxSum;
    }
}