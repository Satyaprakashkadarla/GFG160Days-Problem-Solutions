/* Structure of Binary Tree Node
class Node {
    int data;
    Node left;
    Node right;

    Node(int val) {
        data = val;
        left = right = null;
    }
} */

class Solution {
    public int numberOfTurns(Node root, int p, int q) {
        StringBuilder pathP = new StringBuilder();
        StringBuilder pathQ = new StringBuilder();

        findPath(root, p, pathP);
        findPath(root, q, pathQ);

        // find length of common prefix (path to LCA)
        int i = 0;
        int minLen = Math.min(pathP.length(), pathQ.length());
        while (i < minLen && pathP.charAt(i) == pathQ.charAt(i)) {
            i++;
        }

        // remaining edges below LCA
        String pFromLca = pathP.substring(i); // path LCA -> p
        String qFromLca = pathQ.substring(i); // path LCA -> q

        // combined sequence: reverse(pFromLca) + qFromLca
        StringBuilder combined = new StringBuilder();
        combined.append(new StringBuilder(pFromLca).reverse());
        combined.append(qFromLca);

        int turns = 0;
        for (int k = 1; k < combined.length(); k++) {
            if (combined.charAt(k) != combined.charAt(k - 1)) {
                turns++;
            }
        }

        return turns == 0 ? -1 : turns;
    }

    // returns true if target found in subtree, appending 'L'/'R' edges to path
    private boolean findPath(Node node, int target, StringBuilder path) {
        if (node == null) return false;
        if (node.data == target) return true;

        if (node.left != null) {
            path.append('L');
            if (findPath(node.left, target, path)) return true;
            path.deleteCharAt(path.length() - 1);
        }

        if (node.right != null) {
            path.append('R');
            if (findPath(node.right, target, path)) return true;
            path.deleteCharAt(path.length() - 1);
        }

        return false;
    }
}