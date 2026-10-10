class Solution {
    public boolean balancePan(int a, int b) {
        while (b > 0) {
            long r = b % a;

            if (r == 0) {
                b /= a;
            } else if (r == 1) {
                b /= a;
            } else if (r == a - 1) {
                b = (int) ((long) b / a + 1);
            } else {
                return false;
            }
        }
        return true;
    }
}