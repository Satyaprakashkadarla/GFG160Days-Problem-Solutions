class Solution {

    // Function to count the number of pairs in the array that sum up to the target value
    int countPairs(int arr[], int target) {
        // Create a map to store the frequency of elements we've seen so far
        Map<Integer, Integer> mp = new HashMap();
        
        // Variable to keep track of the number of valid pairs
        int count = 0;
        
        // Loop through each element in the array
        for (int i : arr) {
            // Check if the complement (target - i) exists in the map
            if (mp.containsKey(target - i)) {
                // If the complement exists, it means we have found valid pairs
                // Add the number of times the complement has appeared so far to the count
                count += mp.get(target - i);
            }
            
            // Update the map by incrementing the count of the current element i
            mp.put(i, mp.getOrDefault(i, 0) + 1);
        }
        
        // Return the total count of valid pairs
        return count;
    }
}