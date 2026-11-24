class Solution {
    // Function to check if there are two numbers in arr[] that sum up to target
    boolean twoSum(int arr[], int target) {
        // HashSet to store the numbers we've seen so far
        Set<Integer> hst = new HashSet<>();
        
        // Traverse the array
        for (int i : arr) {
            // Check if the complement (target - i) exists in the set
            if (hst.contains(target - i)) {
                return true;  // Pair found
            }
            // Add the current number to the set
            hst.add(i);
        }
        
        // No pair found
        return false;
    }
}s