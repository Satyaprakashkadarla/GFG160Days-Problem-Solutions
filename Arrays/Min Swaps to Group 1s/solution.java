class Solution {
    public int minSwaps(int[] arr) {
        int n = arr.length;
        int count1 = 0;
        for (int num : arr) if (num == 1) count1++;
        
        if (count1 == 0) return -1;
        
        int ones = 0;
        for (int i = 0; i < count1; i++) {
            if (arr[i] == 1) ones++;
        }
        
        int maxOnes = ones;
        for (int i = count1; i < n; i++) {
            if (arr[i] == 1) ones++;
            if (arr[i - count1] == 1) ones--;
            maxOnes = Math.max(maxOnes, ones);
        }
        
        return count1 - maxOnes;
    }
}