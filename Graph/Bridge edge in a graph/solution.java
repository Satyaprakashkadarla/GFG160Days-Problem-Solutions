class Solution {
    public boolean isBridge(int V, int[][] edges, int c, int d) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < V; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int initialComponents = countComponents(V, adj);
        adj.get(c).remove(Integer.valueOf(d));
        adj.get(d).remove(Integer.valueOf(c));
        int newComponents = countComponents(V, adj);
        return newComponents > initialComponents;
    }
    private int countComponents(int V, List<List<Integer>> adj){
        boolean[] visited = new boolean[V];
        int components = 0;
        for(int i = 0; i < V; i++){
            if(!visited[i]){
                components++;
                dfs(i, visited, adj);
            }
        }
        return components;
    }
    private void dfs(int node, boolean[] visited, List<List<Integer>> adj){
        visited[node] = true;
        for(int neighbor : adj.get(node)){
            if(!visited[neighbor]){
                dfs(neighbor, visited, adj);
            }
        }
    }
}