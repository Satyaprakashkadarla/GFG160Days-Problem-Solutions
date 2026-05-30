class Solution {
    public void replaceElements(int[] arr) {
        int n = arr.length;
        int[] original = arr.clone();
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                arr[i] = original[0] ^ original[1];
            } else if (i == n - 1) {
                arr[i] = original[n - 2] ^ original[n - 1];
            } else {
                arr[i] = original[i - 1] ^ original[i + 1];
            }
        }
    }
}