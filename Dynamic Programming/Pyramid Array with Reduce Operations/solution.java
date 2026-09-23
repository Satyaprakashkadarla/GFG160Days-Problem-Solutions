class Solution {
    public int formPyramid(int[] arr) {
        int n = arr.length;
        long total = 0;

        for (int x : arr) {
            total += x;
        }

        int[] left = new int[n];
        int[] right = new int[n];

        // Maximum possible increasing sequence ending at i
        left[0] = 1;
        for (int i = 1; i < n; i++) {
            left[i] = Math.min(arr[i], left[i - 1] + 1);
        }

        // Maximum possible decreasing sequence starting at i
        right[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.min(arr[i], right[i + 1] + 1);
        }

        int maxHeight = 1;

        for (int i = 0; i < n; i++) {
            maxHeight = Math.max(maxHeight, Math.min(left[i], right[i]));
        }

        return (int) (total - (long) maxHeight * maxHeight);
    }
}
