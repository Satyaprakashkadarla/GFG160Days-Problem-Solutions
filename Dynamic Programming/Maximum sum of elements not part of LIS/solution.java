class Solution {
    public int nonLisMaxSum(int[] arr) {
        int n = arr.length;
        int total = 0;
        int maxLen = 0;
        int minLisSum = Integer.MAX_VALUE;

        int[] len = new int[n];  // LIS length ending at i
        int[] sum = new int[n];  // LIS sum ending at i

        for (int i = 0; i < n; i++) {
            total += arr[i];
            len[i] = 1;
            sum[i] = arr[i];

            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && len[j] + 1 >= len[i]) {
                    len[i] = len[j] + 1;
                    sum[i] = sum[j] + arr[i];
                }
            }

            maxLen = Math.max(maxLen, len[i]);
        }

        for (int i = 0; i < n; i++) {
            if (len[i] == maxLen) {
                minLisSum = Math.min(minLisSum, sum[i]);
            }
        }

        return total - minLisSum;
    }
}