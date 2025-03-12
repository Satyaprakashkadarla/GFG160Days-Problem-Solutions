import java.util.List;

class Solution {
    public int minCostClimbingStairs(List<Integer> cost) {
        int n = cost.size();
        if (n == 1) return cost.get(0); // Use `get` for accessing elements in a List
        int prev2 = cost.get(0);
        int prev1 = cost.get(1);
        for (int i = 2; i < n; i++) {
            int curr = Math.min(prev1, prev2) + cost.get(i);
            prev2 = prev1;
            prev1 = curr;
        }
        return Math.min(prev1, prev2);
    }
}
