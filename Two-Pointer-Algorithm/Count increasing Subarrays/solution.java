class Solution {
    public int countIncreasing(int[] arr) {
        int n = arr.length;
        int total = 0;
        int len = 1;
        
        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[i - 1]) {
                len++;
            } else {
                total += len * (len - 1) / 2;
                len = 1;
            }
        }
        total += len * (len - 1) / 2;
        return total;
    }
}