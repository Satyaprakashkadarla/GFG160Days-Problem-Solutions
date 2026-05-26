class Solution {
    int minToggle(int[] arr) {
        int n = arr.length;
        int[] ones = new int[n + 1];
        int[] zeros = new int[n + 1];
        
        for (int i = 1; i <= n; i++) {
            ones[i] = ones[i - 1] + (arr[i - 1] == 1 ? 1 : 0);
        }
        for (int i = n - 1; i >= 0; i--) {
            zeros[i] = zeros[i + 1] + (arr[i] == 0 ? 1 : 0);
        }
        
        int minFlips = Integer.MAX_VALUE;
        for (int i = 0; i <= n; i++) {
            minFlips = Math.min(minFlips, ones[i] + zeros[i]);
        }
        return minFlips;
    }
}