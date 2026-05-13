import java.util.*;

class Solution {
    public int findMotherVertex(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
        }
        
        boolean[] visited = new boolean[V];
        int lastVertex = 0;
        
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i, adj, visited);
                lastVertex = i;
            }
        }
        
        Arrays.fill(visited, false);
        dfs(lastVertex, adj, visited);
        for (boolean v : visited) {
            if (!v) return -1;
        }
        return lastVertex;
    }
    
    private void dfs(int u, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
        visited[u] = true;
        for (int v : adj.get(u)) {
            if (!visited[v]) dfs(v, adj, visited);
        }
    }
}