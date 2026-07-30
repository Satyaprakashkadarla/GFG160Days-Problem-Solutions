class Solution {
    public int maxSubsetXOR(int[] arr) {
        int[] basis = new int[20];
        for (int num : arr) {
            int x = num;
            for (int i = 19; i >= 0; i--) {
                if (((x >> i) & 1) == 0) continue;
                if (basis[i] == 0) {
                    basis[i] = x;
                    break;
                }
                x ^= basis[i];
            }
        }
        int maxXor = 0;
        for (int i = 19; i >= 0; i--) {
            if ((maxXor ^ basis[i]) > maxXor) {
                maxXor ^= basis[i];
            }
        }
        return maxXor;
    }
}