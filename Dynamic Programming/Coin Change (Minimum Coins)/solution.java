class Solution {
  public:
    int minCoins(vector<int> &coins, int sum) {
        int n = coins.size();
        vector<int>dp(sum+1,INT_MAX);
        dp[0]=0;
        for(int i=0;i<n;i++) {
            for(int s=0;s<=sum;s++) {
                if(coins[i]<=s && dp[s-coins[i]]!=INT_MAX) {
                    dp[s]=min(dp[s],1+dp[s-coins[i]]);
                }
            }
        }
        if(dp[sum]==INT_MAX) {
            return -1;
        }
        return dp[sum];
    }
};