class Solution {
    static int[] nextPalindrome(int[] num) {
        int n = num.length;
        int[] res = num.clone();
        
        // Mirror left half to right
        for (int i = 0; i < n / 2; i++) {
            res[n - 1 - i] = res[i];
        }
        
        // If mirrored number is larger, return it
        if (isGreater(res, num)) {
            return res;
        }
        
        // Increment middle
        int carry = 1;
        for (int i = (n - 1) / 2; i >= 0 && carry > 0; i--) {
            int sum = res[i] + carry;
            res[i] = sum % 10;
            carry = sum / 10;
            res[n - 1 - i] = res[i];
        }
        
        // Handle all 9's case
        if (carry == 1) {
            int[] newRes = new int[n + 1];
            newRes[0] = 1;
            newRes[n] = 1;
            return newRes;
        }
        
        return res;
    }
    
    private static boolean isGreater(int[] a, int[] b) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            if (a[i] != b[i]) {
                return a[i] > b[i];
            }
        }
        return false;
    }
}