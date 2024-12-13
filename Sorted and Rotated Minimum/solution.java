class Solution {
    public int findMin(int[] arr) {
        int left = 0, right = arr.length - 1;
        
        while (left < right) {
            int mid = left + (right - left) / 2;  // Calculate the middle index
            
            if (arr[mid] > arr[right]) {
                left = mid + 1;  // The minimum must be to the right of mid
            } else {
                right = mid;  // The minimum is at mid or to the left of mid
            }
        }
        
        return arr[left];  // Return the minimum element
    }
}

