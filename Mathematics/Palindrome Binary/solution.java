class Solution {
    public boolean isBinaryPalindrome(int n) {
        String bin = Integer.toBinaryString(n);
        int left = 0, right = bin.length() - 1;
        while (left < right) {
            if (bin.charAt(left) != bin.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}