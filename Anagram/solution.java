class Solution {
    // Function is to check whether two strings are anagrams of each other
    public static boolean areAnagrams(String s1, String s2) {
        // If the lengths of the strings are not the same, they can't be anagrams
        if (s1.length() != s2.length()) {
            return false;
        }

        // Frequency array for counting occurrences of characters (assuming lowercase English letters)
        int[] freq = new int[26];

        // Traverse the first string and increment the frequency count
        for (char ch : s1.toCharArray()) {
            freq[ch - 'a']++;
        }

        // Traverse the second string and decrement the frequency count
        for (char ch : s2.toCharArray()) {
            freq[ch - 'a']--;
        }

        // If all counts are zero, the strings are anagrams
        for (int i : freq) {
            if (i != 0) {
                return false;
            }
        }

        return true;
    }
}
