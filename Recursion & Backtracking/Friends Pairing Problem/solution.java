class Solution {
    private long[] memo;
    
    public int countFriendsPairings(int n) {
        memo = new long[n + 1];
        return (int)countWays(n);
    }
    
    private long countWays(int n) {
        if (n <= 1) return 1;
        if (memo[n] != 0) return memo[n];
        
        memo[n] = countWays(n - 1) + (n - 1) * countWays(n - 2);
        return memo[n];
    }
}