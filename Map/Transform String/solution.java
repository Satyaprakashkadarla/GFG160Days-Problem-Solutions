class Solution {
    int transform(String s1, String s2) {
        int n = s1.length();

        // Case 1: Length mismatch
        if (n != s2.length()) {
            return -1;
        }

        // Case 2: Character frequency mismatch
        int[] freq = new int[256];
        for (int i = 0; i < n; i++) {
            freq[s1.charAt(i)]++;
            freq[s2.charAt(i)]--;
        }

        for (int i = 0; i < 256; i++) {
            if (freq[i] != 0) {
                return -1;
            }
        }

        // Case 3: Find minimum operations
        // We need to find the longest suffix of s2 that already exists 
        // in the correct order in s1 (as a subsequence)

        int i = n - 1;  // Traverse s1 from end
        int j = n - 1;  // Traverse s2 from end

        while (i >= 0 && j >= 0) {
            if (s1.charAt(i) == s2.charAt(j)) {
                // Found a match, move both pointers
                i--;
                j--;
            } else {
                // No match, move only s1 pointer
                // This character in s1 will need to be moved to the front
                i--;
            }
        }

        // j+1 characters from the start of s2 need to be moved
        // These are the characters that couldn't be matched from the end
        return j + 1;
    }
}