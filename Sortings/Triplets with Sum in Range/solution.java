import java.util.*;

class Solution {
    public int countTriplets(int[] arr, int l, int r) {
        int n = arr.length;
        if (n < 3) return 0;

        Arrays.sort(arr);
        int count = 0;

        for (int i = 0; i < n - 2; i++) {
            // Find count of pairs with sum >= l - arr[i]
            int left = i + 1, right = n - 1;
            int countMin = 0, countMax = 0;

            // Count pairs with sum <= r - arr[i]
            countMax = countPairsWithMaxSum(arr, i + 1, n - 1, r - arr[i]);

            // Count pairs with sum < l - arr[i] (i.e., <= l - arr[i] - 1)
            int countLess = countPairsWithMaxSum(arr, i + 1, n - 1, l - arr[i] - 1);

            count += (countMax - countLess);
        }

        return count;
    }

    private int countPairsWithMaxSum(int[] arr, int start, int end, int maxSum) {
        int count = 0;
        int left = start, right = end;

        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum <= maxSum) {
                count += (right - left);
                left++;
            } else {
                right--;
            }
        }

        return count;
    }
}