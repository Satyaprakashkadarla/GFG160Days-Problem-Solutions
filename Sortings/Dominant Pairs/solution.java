import java.util.Arrays;

class Solution {
    public int dominantPairs(int[] arr) {
        int n = arr.length;
        int mid = n / 2;

        // Sort the second half
        int[] right = Arrays.copyOfRange(arr, mid, n);
        Arrays.sort(right);

        int count = 0;

        // For every element in the first half,
        // count elements x in right such that 5*x <= arr[i].
        for (int i = 0; i < mid; i++) {
            int lo = 0, hi = right.length;

            // Find first position where 5 * right[pos] > arr[i]
            while (lo < hi) {
                int m = lo + (hi - lo) / 2;

                if ((long) right[m] * 5 <= arr[i]) {
                    lo = m + 1;
                } else {
                    hi = m;
                }
            }

            count += lo;
        }

        return count;
    }
}
