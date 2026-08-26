class Solution {
    public boolean isNegativeWeightCycle(int V, int[][] edges) {
        int E = edges.length;

        // Initialize distances with infinity
        int[] dist = new int[V];

        // Run Bellman-Ford from each vertex as source
        // Since graph might be disconnected, we need to try all vertices
        for (int source = 0; source < V; source++) {
            // Initialize distances to infinity
            for (int i = 0; i < V; i++) {
                dist[i] = Integer.MAX_VALUE;
            }
            dist[source] = 0;

            // Relax all edges V-1 times
            for (int i = 0; i < V - 1; i++) {
                boolean updated = false;
                for (int j = 0; j < E; j++) {
                    int u = edges[j][0];
                    int v = edges[j][1];
                    int w = edges[j][2];

                    if (dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v]) {
                        dist[v] = dist[u] + w;
                        updated = true;
                    }
                }
                if (!updated) break;
            }

            // Check for negative weight cycle
            for (int j = 0; j < E; j++) {
                int u = edges[j][0];
                int v = edges[j][1];
                int w = edges[j][2];

                if (dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v]) {
                    return true;
                }
            }
        }

        return false;
    }
}