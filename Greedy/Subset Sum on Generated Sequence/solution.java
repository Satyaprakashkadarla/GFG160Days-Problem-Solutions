class Solution {
    public boolean isPossible(int[] arr, int s, int x) {
        // If x is 0, we can always form it with empty sum
        if (x == 0) return true;

        // If s > x, we can't use s (but maybe we can use other numbers?)
        // Actually, we can still use paper numbers even if s > x, but since all numbers are positive,
        // if s > x, we'll skip s and check others. But s is the first number.

        List<Long> paper = new ArrayList<>();
        paper.add((long)s);

        long sum = s;

        // Generate paper numbers until they exceed x or we've processed all arr
        for (int i = 0; i < arr.length; i++) {
            long next = sum + arr[i];
            if (next > x && sum > x) {
                // If both current sum and next are > x, further numbers will only be larger
                break;
            }
            paper.add(next);
            sum += next;
        }

        // Greedy check for super-increasing sequence
        long remaining = x;
        for (int i = paper.size() - 1; i >= 0; i--) {
            if (paper.get(i) <= remaining) {
                remaining -= paper.get(i);
            }
            if (remaining == 0) return true;
        }

        return remaining == 0;
    }
}