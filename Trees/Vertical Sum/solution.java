import java.util.*;

class Solution {
    public ArrayList<Integer> verticalSum(Node root) {
        Map<Integer, Integer> map = new TreeMap<>();
        dfs(root, 0, map);
        return new ArrayList<>(map.values());
    }
    
    private void dfs(Node node, int hd, Map<Integer, Integer> map) {
        if (node == null) return;
        map.put(hd, map.getOrDefault(hd, 0) + node.data);
        dfs(node.left, hd - 1, map);
        dfs(node.right, hd + 1, map);
    }
}