import java.util.*;

class Solution {
    public ArrayList<Integer> cntInRange(int[] arr, int[][] queries) {
        Arrays.sort(arr);
        int n = arr.length;
        ArrayList<Integer> result = new ArrayList<>();
        
        for (int[] q : queries) {
            int a = q[0], b = q[1];
            int left = lowerBound(arr, a);
            int right = upperBound(arr, b);
            result.add(right - left);
        }
        
        return result;
    }
    
    // first index where arr[i] >= target
    private int lowerBound(int[] arr, int target) {
        int low = 0, high = arr.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] >= target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
    
    // first index where arr[i] > target
    private int upperBound(int[] arr, int target) {
        int low = 0, high = arr.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] > target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}