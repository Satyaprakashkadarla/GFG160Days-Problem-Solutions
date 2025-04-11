class Solution {
    public int[] dijkstra(int n, int[][] edges, int src) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(new int[]{edge[1], edge[2]});
            adj.get(edge[1]).add(new int[]{edge[0], edge[2]});
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        pq.offer(new int[]{0, src});
        
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int wt = curr[0];
            int node = curr[1];
            
            for (int[] neighbor : adj.get(node)) {
                if (dist[neighbor[0]] > wt + neighbor[1]) {
                    dist[neighbor[0]] = wt + neighbor[1];
                    pq.offer(new int[]{dist[neighbor[0]], neighbor[0]});
                }
            }
        }
        
        for (int i = 0; i < n; i++) {
            if (dist[i] == Integer.MAX_VALUE) dist[i] = -1;
        }
        
        return dist;
    }
}