class Solution {
    public char nthCharacter(int n) {
        long len = 1;
        long count = 9;
        long start = 1;

        while (n > len * count) {
            n -= len * count;
            len++;
            count *= 10;
            start *= 10;
        }

        long num = start + (n - 1) / len;
        int digitIndex = (int) ((n - 1) % len);

        return Long.toString(num).charAt(digitIndex);
    }
}