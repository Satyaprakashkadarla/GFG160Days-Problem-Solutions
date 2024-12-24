class Solution {
    // Function to search a given number in a row-column sorted matrix.
    public boolean searchMatrix(int[][] mat, int x) {
        // Get the number of rows (n) and columns (m) in the matrix.
        int n = mat.length, m = mat[0].length;
        
        // Initialize low to the first element and high to the last element.
        int low = 0, high = n * m - 1, mid = 0;

        // Perform binary search.
        while (low <= high) {
            // Calculate the middle index.
            mid = (low + high) / 2;
            
            // Find the value at the middle index.
            int temp = mat[mid / m][mid % m];
            
            // If the middle element is the target, return true.
            if (temp == x) return true;
            
            // If the middle element is less than the target, search the right half.
            else if (temp < x) low = mid + 1;
            
            // If the middle element is greater than the target, search the left half.
            else high = mid - 1;
        }
        
        // If the element is not found, return false.
        return false;
    }
}
