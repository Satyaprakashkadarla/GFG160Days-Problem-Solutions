class Solution {
    public int peakElement(int[] arr) {
        int n = arr.length;
        
        // Edge case: if the array has only one element, it is the peak
        if (n == 1) {
            return 0;
        }

        int low = 0, high = n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Check if mid is a peak element
            if ((mid == 0 || arr[mid - 1] <= arr[mid]) && 
                (mid == n - 1 || arr[mid + 1] <= arr[mid])) {
                return mid;
            }
            // If the left neighbor is greater, move to the left half
            else if (mid > 0 && arr[mid - 1] > arr[mid]) {
                high = mid - 1;
            }
            // If the right neighbor is greater, move to the right half
            else {
                low = mid + 1;
            }
        }

        return -1;  // This line will never be reached since we are guaranteed to have a peak element
    }
}