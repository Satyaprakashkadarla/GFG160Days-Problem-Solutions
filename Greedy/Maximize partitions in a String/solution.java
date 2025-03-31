import java.util.*;

public class Solution {
    public int maxPartitions(String s) {
        int n = s.length();
        int[] last = new int[26];
        Arrays.fill(last, -1);
        for (int i = 0; i < n; i++) {
            last[s.charAt(i) - 'a'] = i;
        }
        int count = 0;
        int curr = -1;
        for (int i = 0; i < n; i++) {
            curr = Math.max(curr, last[s.charAt(i) - 'a']);
            if (curr == i) {
                count++;
                curr = -1;
            }
        }
        return count;
    }
}
