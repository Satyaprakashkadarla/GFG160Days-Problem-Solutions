class Solution {
    int minEdgesReq(int n, int[][] edges) {
        // Build adjacency list
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        
        // Find connected components
        boolean[] visited = new boolean[n];
        int components = 0;
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                components++;
                dfs(graph, visited, i);
            }
        }
        
        // Calculate extra edges
        int m = edges.length;
        int minEdgesNeeded = n - 1;
        int extraEdges = m - (n - components);
        
        // We need (components - 1) edges to connect all components
        int operationsNeeded = components - 1;
        
        return (extraEdges >= operationsNeeded) ? operationsNeeded : -1;
    }
    
    private void dfs(List<List<Integer>> graph, boolean[] visited, int node) {
        visited[node] = true;
        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                dfs(graph, visited, neighbor);
            }
        }
    }
}