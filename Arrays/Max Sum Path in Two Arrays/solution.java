class Solution {
    public int maxPathSum(int[] a, int[] b) {
        int n = a.length, m = b.length;
        int i = 0, j = 0;
        int sum1 = 0, sum2 = 0;
        int total = 0;
        
        while (i < n && j < m) {
            if (a[i] < b[j]) {
                sum1 += a[i++];
            } else if (a[i] > b[j]) {
                sum2 += b[j++];
            } else {
                total += Math.max(sum1, sum2) + a[i];
                sum1 = 0;
                sum2 = 0;
                i++;
                j++;
            }
        }
        
        while (i < n) sum1 += a[i++];
        while (j < m) sum2 += b[j++];
        
        total += Math.max(sum1, sum2);
        return total;
    }
}