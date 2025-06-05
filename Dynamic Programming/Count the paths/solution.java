import java.util.*;

class Solution {
    // Recursive DFS function to count paths from u to dest
    public int dfs(int u, int dest, List<List<Integer>> adj, int[] dp) {
        // Base Case: If current node is destination, count as 1 path
        if (u == dest) {
            return 1;
        }

        // If result already computed for u, return it
        if (dp[u] != -1) {
            return dp[u];
        }

        int count = 0;

        // Explore all neighbors of current node u
        for (int v : adj.get(u)) {
            count += dfs(v, dest, adj, dp);  // Recursive call to child node v
        }

        // Store result in dp array before returning
        return dp[u] = count;  // Total paths from u to dest
    }

    public int countPaths(int[][] edges, int V, int src, int dest) {
        // Step 1: Build adjacency list from edge list
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);  // Directed edge u -> v
        }

        // Step 2: Initialize dp array with -1 to represent uncomputed states
        int[] dp = new int[1001];
        Arrays.fill(dp, -1);

        // Step 3: Start DFS from source to destination
        return dfs(src, dest, adj, dp);
    }
}
