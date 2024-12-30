class Solution {
    // Method to find the union of two arrays
    public static int findUnion(int a[], int b[]) {
        // Create a HashSet to store unique elements
        Set<Integer> hst = new HashSet<>();
        
        // Loop through the first array 'a' and add each element to the HashSet
        for (int i : a) {
            hst.add(i);  // HashSet automatically handles duplicates
        }

        // Loop through the second array 'b' and add each element to the HashSet
        for (int i : b) {
            hst.add(i);  // Duplicates will not be added to the HashSet
        }

        // The size of the HashSet gives the number of unique elements (union of arrays)
        return hst.size();
    }
}
