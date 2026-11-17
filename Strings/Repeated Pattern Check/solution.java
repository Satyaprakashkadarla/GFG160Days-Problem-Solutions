
class Solution {
    public boolean findPattern(String s) {
        int n = s.length();
        int i = 0;

        while (i < n) {
            // Count consecutive x's
            int countX = 0;

            while (i < n && s.charAt(i) == 'x') {
                countX++;
                i++;
            }

            // At least one x is required
            if (countX == 0) return false;

            // Count consecutive y's
            int countY = 0;

            while (i < n && s.charAt(i) == 'y') {
                countY++;
                i++;
            }

            // Both counts must be equal
            if (countX != countY) return false;
        }

        return true;
    }
}
