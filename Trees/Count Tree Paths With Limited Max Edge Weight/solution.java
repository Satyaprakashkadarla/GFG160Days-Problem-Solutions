
import java.util.*;

class Solution {
    public ArrayList<Integer> maximumWeight(int n, int[][] edges, int[] queries) {

        ArrayList<Integer> ans = new ArrayList<>();

        // Sort edges by weight
        Arrays.sort(edges, (a, b) -> Integer.compare(a[2], b[2]));

        // Store queries with their original indices
        int q = queries.length;
        int[][] qArr = new int[q][2];

        for (int i = 0; i < q; i++) {
            qArr[i][0] = queries[i];
            qArr[i][1] = i;
        }

        Arrays.sort(qArr, (a, b) -> Integer.compare(a[0], b[0]));

        int[] parent = new int[n + 1];
        int[] size = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        long[] result = new long[q];
        long count = 0;
        int j = 0;

        for (int i = 0; i < q; i++) {

            int limit = qArr[i][0];

            // Process all edges with weight <= query
            while (j < edges.length && edges[j][2] <= limit) {

                int u = edges[j][0];
                int v = edges[j][1];

                int pu = find(parent, u);
                int pv = find(parent, v);

                if (pu != pv) {

                    // Number of new paths formed
                    count += (long) size[pu] * size[pv];

                    union(parent, size, pu, pv);
                }

                j++;
            }

            result[qArr[i][1]] = count;
        }

        // Restore original query order
        for (long value : result) {
            ans.add((int) value);
        }

        return ans;
    }

    // Find with path compression
    private int find(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }

    // Union by size
    private void union(int[] parent, int[] size, int a, int b) {

        if (size[a] < size[b]) {
            int temp = a;
            a = b;
            b = temp;
        }

        parent[b] = a;
        size[a] += size[b];
    }
}
