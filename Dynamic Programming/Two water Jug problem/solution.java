class Solution {
    
    // Euclidean algorithm to find GCD
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    
    // Count steps when pouring water from 'fromJug' to 'toJug'
    private int pour(int fromJug, int toJug, int d) {
        int from = fromJug; // Fill fromJug first
        int to = 0;
        int step = 1; // First step: fill fromJug
        
        while (from != d && to != d) {
            // Transfer water from fromJug to toJug
            int transfer = Math.min(from, toJug - to);
            to += transfer;
            from -= transfer;
            step++;
            
            // Check if target achieved
            if (from == d || to == d)
                break;
            
            // If fromJug becomes empty, refill it
            if (from == 0) {
                from = fromJug;
                step++;
            }
            
            // If toJug becomes full, empty it
            if (to == toJug) {
                to = 0;
                step++;
            }
        }
        
        return step;
    }
    
    public int minSteps(int m, int n, int d) {
        // If d is greater than both jug capacities, impossible
        if (d > Math.max(m, n))
            return -1;
        
        // If d is not divisible by gcd(m, n), impossible
        if (d % gcd(m, n) != 0)
            return -1;
        
        // Minimum of both possible ways:
        // 1. Pour from m -> n
        // 2. Pour from n -> m
        return Math.min(pour(m, n, d), pour(n, m, d));
    }
}