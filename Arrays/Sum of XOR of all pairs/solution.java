class Solution {
    public long sumXOR(int[] arr) {
        int n = arr.length;
        long total = 0;
        
        for (int b = 0; b < 32; b++) {
            int count1 = 0;
            for (int num : arr) {
                if ((num >> b & 1) == 1) count1++;
            }
            total += (long) count1 * (n - count1) * (1L << b);
        }
        return total;
    }
}