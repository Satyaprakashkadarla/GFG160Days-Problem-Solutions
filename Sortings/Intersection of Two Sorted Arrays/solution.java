import java.util.*;

class Solution {
    ArrayList<Integer> intersection(int[] a, int[] b) {
        ArrayList<Integer> result = new ArrayList<>();
        int n = a.length, m = b.length;
        int i = 0, j = 0;
        
        while (i < n && j < m) {
            // skip duplicates in a
            while (i + 1 < n && a[i] == a[i + 1]) i++;
            // skip duplicates in b
            while (j + 1 < m && b[j] == b[j + 1]) j++;
            
            if (a[i] == b[j]) {
                result.add(a[i]);
                i++;
                j++;
            } else if (a[i] < b[j]) {
                i++;
            } else {
                j++;
            }
        }
        return result;
    }
}