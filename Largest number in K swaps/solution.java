class Solution {
    // Helper function to recursively find the maximum number
    void findMaxUtil(char[] s, int k, StringBuilder maxStr, int index) {
        if (k == 0)
            return;

        int n = s.length;
        char maxChar = s[index];

        // Find the maximum digit to the right of the current index
        for (int i = index + 1; i < n; i++) {
            if (s[i] > maxChar)
                maxChar = s[i];
        }

        // If a larger digit is found, we will consider swapping
        if (maxChar != s[index])
            k--;

        for (int i = n - 1; i >= index; i--) {
            if (s[i] == maxChar) {
                // Swap characters
                char temp = s[i];
                s[i] = s[index];
                s[index] = temp;

                String currentStr = new String(s);
                if (currentStr.compareTo(maxStr.toString()) > 0)
                    maxStr.replace(0, maxStr.length(), currentStr);

                findMaxUtil(s, k, maxStr, index + 1);

                // Backtrack
                temp = s[i];
                s[i] = s[index];
                s[index] = temp;
            }
        }
    }

    String findMaximumNum(String s, int k) {
        StringBuilder maxStr = new StringBuilder(s);
        findMaxUtil(s.toCharArray(), k, maxStr, 0);
        return maxStr.toString();
    }
}
