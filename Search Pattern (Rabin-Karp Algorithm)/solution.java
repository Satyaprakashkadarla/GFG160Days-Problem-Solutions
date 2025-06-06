class Solution {
    // Helper function to compare pattern with substring of text at index idx
    private boolean isMatch(String txt, String pat, int idx) {
        for (int i = 0; i < pat.length(); i++) {
            if (txt.charAt(idx + i) != pat.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public List<Integer> search(String pat, String txt) {
        int m = pat.length();  // Length of pattern
        int n = txt.length();  // Length of text

        int base = 26;       // Base for hash (26 lowercase letters)
        int mod  = 101;      // A prime modulus to avoid overflow and reduce collisions

        List<Integer> result = new ArrayList<>();
        int patHash = 0; // Hash value for pattern
        int txtHash = 0; // Rolling hash value for text
        int power = 1;   // Power of base (base^i)

        // Compute initial hash for pattern and first window of text
        for (int i = m - 1; i >= 0; i--) {
            int patVal = pat.charAt(i) - 'a' + 1;
            int txtVal = txt.charAt(i) - 'a' + 1;

            patHash = (patHash + patVal * power) % mod;
            txtHash = (txtHash + txtVal * power) % mod;
            power = (power * base) % mod;
        }

        // Compare first window hash
        if (txtHash == patHash && isMatch(txt, pat, 0)) {
            result.add(1); // Store 1-based index
        }

        // Precompute highest power for sliding window (base^(m-1))
        int highestPower = 1;
        for (int i = 1; i < m; i++) {
            highestPower = (highestPower * base) % mod;
        }

        // Slide window across text
        for (int i = 1; i <= n - m; i++) {
            int leftVal = txt.charAt(i - 1) - 'a' + 1;

            // Remove leftmost character from hash
            txtHash = (txtHash - (leftVal * highestPower) % mod + mod) % mod;
            txtHash = (txtHash * base) % mod;

            // Add new character to hash
            int newVal = txt.charAt(i + m - 1) - 'a' + 1;
            txtHash = (txtHash + newVal) % mod;

            // If hashes match, verify with character comparison
            if (txtHash == patHash && isMatch(txt, pat, i)) {
                result.add(i + 1); // Store 1-based index
            }
        }

        return result;
    }
}