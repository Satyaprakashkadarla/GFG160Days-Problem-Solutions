class Solution {
    public ArrayList<Integer> getMarks(int[] l, int[] r, int[] rank) {
        int n = l.length;
        ArrayList<Integer> ans = new ArrayList<>();

        // prefix[i] = number of valid marks in intervals [0..i]
        int[] prefix = new int[n];

        prefix[0] = r[0] - l[0] + 1;

        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + (r[i] - l[i] + 1);
        }

        for (int k : rank) {
            // Find first interval whose prefix count >= k
            int low = 0, high = n - 1;

            while (low < high) {
                int mid = low + (high - low) / 2;

                if (prefix[mid] >= k) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }

            int i = low;

            // Number of marks before this interval
            int before = (i == 0) ? 0 : prefix[i - 1];

            // Position inside the interval (1-indexed)
            int offset = k - before;

            ans.add(l[i] + offset - 1);
        }

        return ans;
    }
}
