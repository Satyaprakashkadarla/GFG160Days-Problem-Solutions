class Solution {
    public int maxDiffSubArrays(int[] arr) {
        int n = arr.length;
        int[] maxEnding = new int[n];
        int[] minEnding = new int[n];
        
        // Prefix max/min
        int maxCurr = arr[0], minCurr = arr[0];
        maxEnding[0] = maxCurr;
        minEnding[0] = minCurr;
        for (int i = 1; i < n; i++) {
            maxCurr = Math.max(arr[i], maxCurr + arr[i]);
            minCurr = Math.min(arr[i], minCurr + arr[i]);
            maxEnding[i] = maxCurr;
            minEnding[i] = minCurr;
        }
        
        // Suffix max/min
        int[] maxStarting = new int[n];
        int[] minStarting = new int[n];
        maxCurr = arr[n - 1];
        minCurr = arr[n - 1];
        maxStarting[n - 1] = maxCurr;
        minStarting[n - 1] = minCurr;
        for (int i = n - 2; i >= 0; i--) {
            maxCurr = Math.max(arr[i], maxCurr + arr[i]);
            minCurr = Math.min(arr[i], minCurr + arr[i]);
            maxStarting[i] = maxCurr;
            minStarting[i] = minCurr;
        }
        
        int maxDiff = 0;
        for (int i = 0; i < n - 1; i++) {
            int d1 = Math.abs(maxEnding[i] - minStarting[i + 1]);
            int d2 = Math.abs(minEnding[i] - maxStarting[i + 1]);
            maxDiff = Math.max(maxDiff, Math.max(d1, d2));
        }
        return maxDiff;
    }
}