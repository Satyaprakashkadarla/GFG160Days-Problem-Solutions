class Solution {
    public int countKdivPairs(int[] arr, int k) {
        int[] freq = new int[k];
        int count = 0;
        for (int num : arr) {
            int r = num % k;
            if (r == 0) {
                count += freq[0];
            } else {
                count += freq[k - r];
            }
            freq[r]++;
        }
        return count;
    }
}