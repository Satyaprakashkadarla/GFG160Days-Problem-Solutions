class Solution {
public:
    int solve(vector<int>& arr, int i, int n, vector<int>& dp) { // Correct declaration of parameters
        if (i >= n) return 0; // Check boundary condition
        if (dp[i] != -1) return dp[i]; // Return memoized value if present
        int pick = arr[i] + solve(arr, i + 2, n, dp); // Include current element
        int noPick = solve(arr, i + 1, n, dp); // Skip current element
        return dp[i] = max(pick, noPick); // Memoize the result
    }

    int maxValue(vector<int>& arr) {
        int n = arr.size();
        vector<int> dp(n, -1); // Initialize the dp array with size n and -1
        int case1 = solve(arr, 0, n - 1, dp); // Solve for case starting from 0

        fill(dp.begin(), dp.end(), -1); // Reset dp array
        int case2 = solve(arr, 1, n, dp); // Solve for case starting from 1

        return max(case1, case2); // Return maximum value between both cases
    }
};
