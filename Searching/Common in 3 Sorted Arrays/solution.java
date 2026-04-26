import java.util.*;

class Solution {
    public ArrayList<Integer> commonElements(int[] a, int[] b, int[] c) {
        ArrayList<Integer> result = new ArrayList<>();
        int i = 0, j = 0, k = 0;
        
        while (i < a.length && j < b.length && k < c.length) {
            if (a[i] == b[j] && b[j] == c[k]) {
                result.add(a[i]);
                i++; j++; k++;
                // skip duplicates
                while (i < a.length && a[i] == a[i - 1]) i++;
                while (j < b.length && b[j] == b[j - 1]) j++;
                while (k < c.length && c[k] == c[k - 1]) k++;
            } else if (a[i] <= b[j] && a[i] <= c[k]) {
                i++;
            } else if (b[j] <= a[i] && b[j] <= c[k]) {
                j++;
            } else {
                k++;
            }
        }
        return result;
    }
}