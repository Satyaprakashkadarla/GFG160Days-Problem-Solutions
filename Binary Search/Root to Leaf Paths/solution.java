import java.util.*;

class Solution {
    public void getPaths(Node root, List<Integer> path, List<List<Integer>> res) {
        if (root == null) return;
        path.add(root.data);
        if (root.left == null && root.right == null) res.add(new ArrayList<>(path));
        getPaths(root.left, path, res);
        getPaths(root.right, path, res);
        path.remove(path.size() - 1);
    }

    public List<List<Integer>> Paths(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        if (root == null) return res;
        getPaths(root, path, res);
        return res;
    }
}

// Definition for Node
class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}
