class Solution {
    public String compress(String s) {
        int n = s.length();
        if (n <= 1) return s;

        // Step 1: Compute KMP's Longest Prefix Suffix (LPS) array
        int[] lps = new int[n];
        for (int i = 1; i < n; i++) {
            int j = lps[i - 1];
            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = lps[j - 1];
            }
            if (s.charAt(i) == s.charAt(j)) {
                j++;
            }
            lps[i] = j;
        }

        // Step 2: Process from right to left using StringBuilder
        StringBuilder sb = new StringBuilder();
        int i = n - 1;

        while (i >= 0) {
            int len = i + 1;

            // Odd-length prefixes cannot be divided into two equal halves
            if (len % 2 != 0) {
                sb.append(s.charAt(i));
                i--;
                continue;
            }

            // Find matching prefix length using LPS array
            int j = lps[i];
            int half = len / 2;

            // Reduce j using LPS links to check if a valid half-match exists
            while (j > half) {
                j = lps[j - 1];
            }

            // If the first half equals the second half
            if (j == half) {
                sb.append('*');
                i = half - 1; // Jump to process the remaining first half
            } else {
                sb.append(s.charAt(i));
                i--;
            }
        }

        // Step 3: Reverse the result string as we built it right-to-left
        return sb.reverse().toString();
    }
}