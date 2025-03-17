class Solution {

    static Boolean isSubsetSum(int arr[], int sum) {
        int n = arr.length;
        Boolean dp[][] = new Boolean[n][sum + 1];
        return rec(n - 1 , arr , sum , dp);
    }
    private static Boolean rec(int id , int arr[] , int sum , Boolean dp[][]) {
        if(sum == 0) return true;
        if(id < 0 || sum < 0) return false;
        if(dp[id][sum]!=null) return dp[id][sum];
        Boolean pick=rec(id-1 , arr , sum - arr[id] , dp);
        Boolean notPick = rec (id - 1 , arr , sum , dp);
        return dp[id][sum]=pick || notPick;
    }
}