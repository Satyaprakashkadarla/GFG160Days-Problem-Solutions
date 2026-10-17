class Solution {
    public boolean isItPossible(String s1, String s2) {
        int n = s1.length();

        if (n != s2.length()) {
            return false;
        }

        int i = 0, j = 0;

        while (i < n && j < n) {
            // Skip empty positions
            while (i < n && s1.charAt(i) == '#') i++;
            while (j < n && s2.charAt(j) == '#') j++;

            // Both strings must have matching characters
            if (i == n || j == n) {
                return i == n && j == n;
            }

            char c = s1.charAt(i);

            if (c != s2.charAt(j)) {
                return false;
            }

            // A can only move left
            if (c == 'A' && i < j) {
                return false;
            }

            // B can only move right
            if (c == 'B' && i > j) {
                return false;
            }

            i++;
            j++;
        }

        // Ensure no non-empty characters remain
        while (i < n && s1.charAt(i) == '#') i++;
        while (j < n && s2.charAt(j) == '#') j++;

        return i == n && j == n;
    }
}