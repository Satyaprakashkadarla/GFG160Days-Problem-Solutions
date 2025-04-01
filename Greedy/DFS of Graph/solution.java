import java.util.ArrayList;
import java.util.List;

class Solution {
    public void dfsHelper(int node, List<List<Integer>> adj, boolean[] visited, List<Integer> result) {
        visited[node] = true; // Mark the current node as visited
        result.add(node);    // Add the current node to the result
        for (int neighbor : adj.get(node)) { // Traverse neighbors of the node
            if (!visited[neighbor]) {
                dfsHelper(neighbor, adj, visited, result);
            }
        }
    }

    public List<Integer> dfs(List<List<Integer>> adj) {
        int V = adj.size(); // Number of vertices
        boolean[] visited = new boolean[V]; // To track visited nodes
        List<Integer> result = new ArrayList<>(); // Store the DFS traversal
        dfsHelper(0, adj, visited, result); // Start DFS from node 0
        return result;
    }
}
