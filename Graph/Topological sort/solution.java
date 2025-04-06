class Solution {
    public void dfs(int start, boolean[] visited, List<Integer> ans, ArrayList<ArrayList<Integer>> adj) {
        visited[start] = true;
        for (int it : adj.get(start)) {
            if (!visited[it]) {
                dfs(it, visited, ans, adj);
            }
        }
        ans.add(start);
    }

    public List<Integer> topoSort(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
        }

        List<Integer> ans = new ArrayList<>();
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i, visited, ans, adj);
            }
        }

        Collections.reverse(ans);
        return ans;
    }
}