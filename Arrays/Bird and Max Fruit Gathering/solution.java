class Solution {
    public int maxFruits(ArrayList<Integer> arr, int m) {
        int n = arr.size();
        m = Math.min(m, n);

        long sum = 0;
        long max = 0;

        // Initial window
        for (int i = 0; i < m; i++) {
            sum += arr.get(i);
        }
        max = sum;

        // Slide over the circular array
        for (int i = m; i < n + m; i++) {
            sum += arr.get(i % n);
            sum -= arr.get((i - m) % n);
            max = Math.max(max, sum);
        }

        return (int) max;
    }
}
