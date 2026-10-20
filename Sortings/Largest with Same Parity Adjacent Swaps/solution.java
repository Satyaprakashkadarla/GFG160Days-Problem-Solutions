import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public ArrayList<Integer> lexicographicallyLargest(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> result = new ArrayList<>(n);
        for (int val : arr) {
            result.add(val);
        }

        int i = 0;
        while (i < n) {
            int j = i;
            boolean isEven = (arr[i] % 2 == 0);

            // Find the end of the contiguous segment with the same parity
            while (j < n && (arr[j] % 2 == 0) == isEven) {
                j++;
            }

            // Extract the subsegment
            List<Integer> subsegment = new ArrayList<>();
            for (int k = i; k < j; k++) {
                subsegment.add(arr[k]);
            }

            // Sort in descending order to maximize lexicographical value
            subsegment.sort(Collections.reverseOrder());

            // Put the sorted elements back into the result list
            for (int k = i; k < j; k++) {
                result.set(k, subsegment.get(k - i));
            }

            i = j;
        }

        return result;
    }
}