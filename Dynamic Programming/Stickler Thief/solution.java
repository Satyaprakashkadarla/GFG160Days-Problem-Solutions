import java.util.List;

class Solution {
    public int findMaxSum(List<Integer> arr) {
        int n = arr.size();
        if (n == 0) return 0;
        if (n == 1) return arr.get(0);

        int prev2 = 0, prev1 = arr.get(0);

        for (int i = 1; i < n; i++) {
            int include = arr.get(i) + prev2;  // Loot current house
            int exclude = prev1;              // Skip current house
            int curr = Math.max(include, exclude); // Maximum of both options
            prev2 = prev1;                   // Update prev2
            prev1 = curr;                    // Update prev1
        }

        return prev1;  // Final result
    }
}
