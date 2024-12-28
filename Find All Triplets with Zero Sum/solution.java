class Solution {
    public List<List<Integer>> findTriplets(int[] arr) {
        // A Set to store unique triplets as Lists to avoid duplicates
        Set<List<Integer>> ansSet = new HashSet<>();
        
        // A Map to store pairs of elements that sum to a certain value
        Map<Integer, List<int[]>> mp = new HashMap<>();
        
        // Step 1: Generate all pairs (i, j) and store them in the map with their sum as the key
        // The map stores sums as keys and lists of pairs (i, j) as values
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int sum = arr[i] + arr[j];
                
                // If the sum is not already a key in the map, initialize it with an empty list
                if (!mp.containsKey(sum)) {
                    mp.put(sum, new ArrayList<>());
                }
                
                // Add the pair (i, j) to the list of pairs that sum to 'sum'
                mp.get(sum).add(new int[]{i, j});
            }
        }
        
        // Step 2: For each element arr[i], check if -arr[i] is a key in the map
        // If it is, we can form a triplet by combining arr[i] with the pairs that sum to -arr[i]
        for (int i = 0; i < arr.length; i++) {
            int target = -arr[i];  // The value we need to complement arr[i] to make the sum 0
            
            // If there are pairs that sum to target (i.e., -arr[i]), process them
            if (mp.containsKey(target)) {
                List<int[]> pairs = mp.get(target);
                
                // Check each pair of indices (pair[0], pair[1]) to form a triplet
                for (int[] pair : pairs) {
                    // Ensure that the current index 'i' is not part of the pair to avoid duplicates
                    // The pair indices should be different from 'i'
                    if (pair[0] != i && pair[1] != i) {
                        // Create a list of indices representing the triplet
                        List<Integer> curr = Arrays.asList(i, pair[0], pair[1]);
                        
                        // Sort the triplet to ensure the order i < j < k (since i, j, k are indices)
                        Collections.sort(curr);
                        
                        // Add the triplet to the result set to ensure uniqueness
                        ansSet.add(curr);
                    }
                }
            }
        }
        
        // Return the result as a List of Lists, converted from the Set
        return new ArrayList<>(ansSet);
    }
}