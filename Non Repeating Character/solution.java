class Solution {
    // Function to find the first non-repeating character in a string.
    static char nonRepeatingChar(String s) {
        int[] arr = new int[26]; // Array to store the frequency of each character

        // Count the frequency of each character in the string
        for (char c : s.toCharArray()) {
            arr[c - 'a']++;  // Increment the count for the character
        }

        // Iterate through the string again to find the first non-repeating character
        for (char c : s.toCharArray()) {
            if (arr[c - 'a'] == 1) {
                return c;  // Return the first non-repeating character
            }
        }

        // If no non-repeating character is found, return '$'
        return '$';
    }
}
