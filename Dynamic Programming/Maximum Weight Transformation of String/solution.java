class Solution {
    public int getMaxWeight(String s) {
        int n = s.length();
        if (n < 2) {
            return n;
        }

        int prev2 = 0; // represents max weight up to i-2 edges
        int prev1 = 0; // represents max weight up to i-1 edges

        for (int i = 0; i < n - 1; i++) {
            // Net gain for forming a pair at index i and i+1
            int edgeWeight = (s.charAt(i) == s.charAt(i + 1)) ? 1 : 2;

            int curr = Math.max(prev1, edgeWeight + prev2);
            prev2 = prev1;
            prev1 = curr;
        }

        // Total maximum weight = base weight (all singletons) + max pair gains
        return n + prev1;
    }
}