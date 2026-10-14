class Solution {
    public String findRollOut(String s, int[] roll) {
        int n = s.length();
        int[] diff = new int[n + 1];

        // Count how many rolls affect each prefix.
        for (int r : roll) {
            diff[0]++;
            diff[r]--;
        }

        StringBuilder result = new StringBuilder(n);
        int count = 0;

        for (int i = 0; i < n; i++) {
            count += diff[i];

            int shift = count % 26;
            char ch = (char) ('a' + (s.charAt(i) - 'a' + shift) % 26);

            result.append(ch);
        }

        return result.toString();
    }
}