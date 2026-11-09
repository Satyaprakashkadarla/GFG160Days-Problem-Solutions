class Solution {
    int getCount(String s, int k) {
        int[] freq = new int[26];

        int n = s.length();

        for (int i = 0; i < n; i++) {
            // Count a new group only when the character changes
            if (i == 0 || s.charAt(i) != s.charAt(i - 1)) {
                freq[s.charAt(i) - 'a']++;
            }
        }

        int count = 0;

        for (int i = 0; i < 26; i++) {
            if (freq[i] == k) {
                count++;
            }
        }

        return count;
    }
}