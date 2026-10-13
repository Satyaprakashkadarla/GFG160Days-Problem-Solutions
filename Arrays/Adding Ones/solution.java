import java.util.ArrayList;

class Solution {
    public ArrayList<Integer> update(int n, int[] updates) {
        int[] freq = new int[n + 2];

        // Count updates at each 1-based index
        for (int j : updates) {
            freq[j]++;
        }

        ArrayList<Integer> arr = new ArrayList<>(n);
        int count = 0;

        // Each update j affects all indices i >= j
        for (int i = 1; i <= n; i++) {
            count += freq[i];
            arr.add(count);
        }

        return arr;
    }
}