class Solution {
    public void mergeTwoParts(int[] arr) {
        int n = arr.length;
        int breakPoint = -1;

        // Find the break point
        for (int i = 1; i < n; i++) {
            if (arr[i] < arr[i - 1]) {
                breakPoint = i;
                break;
            }
        }

        // Already sorted
        if (breakPoint == -1) {
            return;
        }

        // Merge the two sorted parts
        int[] temp = new int[n];
        int i = 0, j = breakPoint, k = 0;

        while (i < breakPoint && j < n) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        while (i < breakPoint) {
            temp[k++] = arr[i++];
        }

        while (j < n) {
            temp[k++] = arr[j++];
        }

        // Copy the merged result back
        System.arraycopy(temp, 0, arr, 0, n);
    }
}