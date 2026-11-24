
import java.util.*;

class Solution {
    public ArrayList<Integer> findPairs(int[] arr) {
        int n = arr.length;

        HashMap<Integer, int[]> map = new HashMap<>();

        int[] best = null;

        for (int a = 0; a < n; a++) {
            for (int b = a + 1; b < n; b++) {

                int sum = arr[a] + arr[b];

                if (map.containsKey(sum)) {
                    int[] p = map.get(sum);

                    if (p[0] != a && p[0] != b &&
                        p[1] != a && p[1] != b) {

                        int[] candidate;

                        if (p[0] < a || (p[0] == a && p[1] < b)) {
                            candidate = new int[]{
                                p[0], p[1], a, b
                            };
                        } else {
                            candidate = new int[]{
                                a, b, p[0], p[1]
                            };
                        }

                        if (best == null ||
                            compare(candidate, best) < 0) {
                            best = candidate;
                        }
                    }
                } else {
                    map.put(sum, new int[]{a, b});
                }
            }
        }

        if (best == null) {
            return new ArrayList<>(
                Arrays.asList(-1, -1, -1, -1)
            );
        }

        return new ArrayList<>(
            Arrays.asList(best[0], best[1], best[2], best[3])
        );
    }

    private int compare(int[] x, int[] y) {
        for (int i = 0; i < 4; i++) {
            if (x[i] != y[i]) {
                return Integer.compare(x[i], y[i]);
            }
        }
        return 0;
    }
}
