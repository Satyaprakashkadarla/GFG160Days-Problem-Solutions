class Solution {
    public int solve(int n, String s) {
        int[] state = new int[26];
        int available = n;
        int rejected = 0;

        for (char c : s.toCharArray()) {
            int idx = c - 'A';

            if (state[idx] == 0) {
                // Arrival
                if (available > 0) {
                    state[idx] = 1;
                    available--;
                } else {
                    state[idx] = 2;
                    rejected++;
                }
            } else if (state[idx] == 1) {
                // Departure of a customer who had a computer
                state[idx] = 0;
                available++;
            } else {
                // Departure of a rejected customer
                state[idx] = 0;
            }
        }

        return rejected;
    }
}