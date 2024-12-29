class Solution {
    public ArrayList<Integer> intersectionWithDuplicates(int[] a, int[] b) {
        // Create a HashSet to store unique elements from array 'a'
        Set<Integer> aSet = new HashSet();
        
        // Iterate through array 'a' and add each element to the set
        // The HashSet automatically handles duplicates (only unique values will be stored)
        for(int i : a) {
            aSet.add(i);
        }

        // Create an ArrayList to store the result of the intersection (with duplicates)
        ArrayList<Integer> res = new ArrayList();

        // Iterate through array 'b' and check if each element is present in 'aSet'
        // This is how we find the common elements (intersection)
        for(int i : b) {
            if(aSet.contains(i)) {
                // If element 'i' is present in 'aSet', add it to the result list
                res.add(i);
                // Remove the element from the set to handle duplicates
                // This ensures we only count the element once from array 'a'
                aSet.remove(i);
            }
        }

        // Return the list containing the intersection elements with duplicates
        return res;
    }
}
