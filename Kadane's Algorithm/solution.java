class Solution {
    int maxSubarraySum(int[] arr) {
        // Check for the empty array case
        if (arr.length == 0) {
            return 0; // or handle it as per your requirements
        }

        int maxSoFar = 0;
        int maxSum = Integer.MIN_VALUE;
        
        // Loop through the array
        for (int num : arr) {
            maxSoFar += num;
            
            // Update maxSum if we find a larger sum
            maxSum = Math.max(maxSum, maxSoFar);
            
            // If maxSoFar becomes negative, reset it to 0
            if (maxSoFar < 0) {
                maxSoFar = 0;
            }
        }
        
        return maxSum;
    }
}
s