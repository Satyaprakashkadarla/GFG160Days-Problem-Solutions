class Solution {
    public int minMoves(int[] arr) {
        int n = arr.length;

        // Store position of each number
        int[] pos = new int[n + 1];
        for (int i = 0; i < n; i++) {
            pos[arr[i]] = i;
        }

        // Find the longest consecutive increasing subsequence in terms of positions
        int maxLen = 1;
        int currLen = 1;

        for (int i = 1; i <= n; i++) {
            if (i > 1 && pos[i] > pos[i - 1]) {
                currLen++;
                maxLen = Math.max(maxLen, currLen);
            } else {
                currLen = 1;
            }
        }

        // Minimum moves = n - longest consecutive subsequence
        return n - maxLen;
    }
}