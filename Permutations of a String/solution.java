public class Solution {
    public List<String> findPermutation(String s) {
        // Convert the string to a character array and sort it
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        
        List<String> result = new ArrayList<>();
        result.add(new String(arr));
        
        // Generate the next permutations and add to the result
        while (nextPermutation(arr)) {
            result.add(new String(arr));
        }
        
        return result;
    }
    
    // Helper function to generate the next lexicographical permutation
    private boolean nextPermutation(char[] arr) {
        int i = arr.length - 2;
        
        // Find the first character that is smaller than the character next to it
        while (i >= 0 && arr[i] >= arr[i + 1]) {
            i--;
        }
        
        // If no such character is found, then it's the last permutation
        if (i < 0) {
            return false;
        }
        
        // Find the character that is larger than arr[i] from the right end
        int j = arr.length - 1;
        while (arr[j] <= arr[i]) {
            j--;
        }
        
        // Swap the characters
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        
        // Reverse the sequence after i
        reverse(arr, i + 1, arr.length - 1);
        
        return true;
    }