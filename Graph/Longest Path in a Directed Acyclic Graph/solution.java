import java.util.*;

class Solution {
    public int[] maxDistance(int V, int src, ArrayList<ArrayList<Integer>> edges) {

        // Build adjacency list
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        int[] indegree = new int[V];

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (ArrayList<Integer> e : edges) {
            int u = e.get(0);
            int v = e.get(1);
            int w = e.get(2);

            adj.get(u).add(new int[]{v, w});
            indegree[v]++;
        }

        // Topological sort
        Queue<Integer> q = new ArrayDeque<>();

        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        int[] topo = new int[V];
        int idx = 0;

        while (!q.isEmpty()) {
            int u = q.poll();
            topo[idx++] = u;

            for (int[] edge : adj.get(u)) {
                int v = edge[0];

                if (--indegree[v] == 0) {
                    q.offer(v);
                }
            }
        }

        // DP for longest distance
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MIN_VALUE);

        dist[src] = 0;

        for (int u : topo) {
            // Important: don't process unreachable vertices
            if (dist[u] == Integer.MIN_VALUE) {
                continue;
            }

            for (int[] edge : adj.get(u)) {
                int v = edge[0];
                int w = edge[1];

                dist[v] = Math.max(dist[v], dist[u] + w);
            }
        }

        return dist;
    }
}