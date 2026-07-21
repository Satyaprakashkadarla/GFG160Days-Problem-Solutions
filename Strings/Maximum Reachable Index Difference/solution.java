class Solution {
    public int maxIndexDifference(String s) {

        int n = s.length();
        int[] best = new int[26];

        for (int i = 0; i < 26; i++)
            best[i] = -1;

        int ans = -1;

        for (int i = n - 1; i >= 0; i--) {

            int c = s.charAt(i) - 'a';

            int reach = i;

            if (c == 25) {
                reach = i;
            } else if (best[c + 1] != -1) {
                reach = best[c + 1];
            }

            best[c] = Math.max(best[c], reach);

            if (c == 0) {
                ans = Math.max(ans, reach - i);
            }
        }

        return ans;
    }
}