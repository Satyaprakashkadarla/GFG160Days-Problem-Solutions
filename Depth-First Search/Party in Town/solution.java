class Solution {
    public int partyHouse(ArrayList<ArrayList<Integer>> adj) {
        int n = adj.size();

        // BFS/DFS from any node to find one endpoint of diameter
        int farthest = bfs(adj, 1, n)[0];

        // BFS from that endpoint to find diameter
        int diameter = bfs(adj, farthest, n)[1];

        // Radius = ceil(diameter / 2)
        return (diameter + 1) / 2;
    }

    private int[] bfs(ArrayList<ArrayList<Integer>> adj, int start, int n) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);

        int[] queue = new int[n];
        int front = 0, rear = 0;

        queue[rear++] = start;
        dist[start] = 0;

        int farthest = start;

        while (front < rear) {
            int node = queue[front++];

            if (dist[node] > dist[farthest]) {
                farthest = node;
            }

            for (int next : adj.get(node - 1)) {
                if (dist[next] == -1) {
                    dist[next] = dist[node] + 1;
                    queue[rear++] = next;
                }
            }
        }

        return new int[]{farthest, dist[farthest]};
    }
}
