class Solution {
    public int goodIndices(int[] arr) {
        int n = arr.length;
        int[] state = new int[n];
        // 0 = unvisited, 1 = visiting, 2 = good, 3 = bad

        int good = 0;

        for (int i = 0; i < n; i++) {
            if (state[i] == 0) {
                int curr = i;
                java.util.ArrayList<Integer> path = new java.util.ArrayList<>();

                while (curr >= 0 && curr < n && state[curr] == 0) {
                    state[curr] = 1;
                    path.add(curr);

                    int next = curr + arr[curr];
                    curr = next;
                }

                boolean isGood = curr < 0 || curr >= n || state[curr] == 2;

                for (int j = path.size() - 1; j >= 0; j--) {
                    int node = path.get(j);

                    if (state[node] == 1) {
                        state[node] = isGood ? 2 : 3;
                    }
                }

                // Correctly mark nodes leading into a cycle as bad.
                for (int node : path) {
                    if (state[node] == 2) {
                        good++;
                    }
                }
            }
        }

        for (int s : state) {
            if (s == 2) {
                // Count good nodes once in the final pass instead.
            }
        }

        good = 0;
        for (int s : state) {
            if (s == 2) good++;
        }

        return good;
    }
}