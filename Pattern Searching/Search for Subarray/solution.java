import java.util.*;

class Solution {
    public ArrayList<Integer> search(int[] a, int[] b) {
        ArrayList<Integer> result = new ArrayList<>();
        int n = a.length, m = b.length;
        if (m > n) return result;
        
        // Build LPS array
        int[] lps = new int[m];
        int len = 0;
        for (int i = 1; i < m; ) {
            if (b[i] == b[len]) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        
        // KMP search
        int i = 0, j = 0;
        while (i < n) {
            if (a[i] == b[j]) {
                i++;
                j++;
                if (j == m) {
                    result.add(i - m);
                    j = lps[j - 1];
                }
            } else {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        return result;
    }
}