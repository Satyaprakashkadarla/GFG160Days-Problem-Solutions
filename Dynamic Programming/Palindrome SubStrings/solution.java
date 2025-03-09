class Solution {
    public int countPS(String s) {
        int count = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            expandAroundCenter(s, i, i, count);
            expandAroundCenter(s, i, i + 1, count);
        }

        return count;
    }

    private void expandAroundCenter(String s, int left, int right, int count) {
        int n = s.length();
        while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
            if (right - left + 1 >= 2) {
                count++;
            }
            left--;
            right++;
        }
    }
}
