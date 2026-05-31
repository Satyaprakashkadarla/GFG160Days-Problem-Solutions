class Solution {
    public boolean isSumOfConsecutive(int n) {
        if (n <= 2) return false;
        while (n % 2 == 0) {
            n /= 2;
        }
        return n > 1;
    }
}