import java.util.*;

class Solution {
    public ArrayList<Integer> optimalArray(int[] arr) {
        int n = arr.length;
        long[] prefix = new long[n];
        prefix[0] = arr[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + arr[i];
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int midIdx = i / 2;
            int mid = arr[midIdx];
            long leftSum = (midIdx > 0) ? prefix[midIdx - 1] : 0;
            long rightSum = prefix[i] - prefix[midIdx];
            int leftCount = midIdx;
            int rightCount = i - midIdx;
            long ops = leftCount * 1L * mid - leftSum + rightSum - rightCount * 1L * mid;
            result.add((int) ops);
        }
        return result;
    }
}