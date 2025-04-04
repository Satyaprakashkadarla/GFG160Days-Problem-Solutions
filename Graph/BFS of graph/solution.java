import java.util.*;

class Solution {
    public List<Integer> bfs(List<List<Integer>> adj) {
        int n = adj.size();
        boolean[] visited = new boolean[n];  // Visited array
        List<Integer> result = new ArrayList<>();  // Result list
        Queue<Integer> queue = new LinkedList<>(); // Queue for BFS
        
        queue.add(0); // Start BFS from node 0
        visited[0] = true;
        
        while (!queue.isEmpty()) {
            int node = queue.poll(); // Remove the front of the queue
            result.add(node); // Add the node to the result list
            
            // Traverse all neighbors of the current node
            for (int neighbor : adj.get(node)) {
                if (!visited[neighbor]) { // If not visited
                    visited[neighbor] = true; // Mark as visited
                    queue.add(neighbor); // Add to the queue
                }
            }
        }
        return result; // Return the BFS traversal
    }
}
