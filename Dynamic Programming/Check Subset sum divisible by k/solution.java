class Solution {
    public boolean divisibleByK(int[] arr, int k) {
        boolean[] dp = new boolean[k];
        dp[0] = true; // empty subset
        
        for (int num : arr) {
            int rem = num % k;
            if (rem == 0) return true;
            
            boolean[] newDp = dp.clone();
            for (int r = 0; r < k; r++) {
                if (dp[r]) {
                    int newR = (r + rem) % k;
                    newDp[newR] = true;
                    if (newR == 0 && r != 0) return true;
                }
            }
            dp = newDp;
        }
        return false;
    }
}