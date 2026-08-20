/* Structure of binary tree node
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
*/

class Solution {
    int maxDiff(Node root) {
        if (root == null) return 0;

        int[] maxDiff = {Integer.MIN_VALUE};

        // Start DFS from children with root as the initial ancestor
        dfs(root.left, root.data, maxDiff);
        dfs(root.right, root.data, maxDiff);

        return maxDiff[0];
    }

    private void dfs(Node node, int maxAncestor, int[] maxDiff) {
        if (node == null) return;

        // Update max difference with current ancestor
        maxDiff[0] = Math.max(maxDiff[0], maxAncestor - node.data);

        // Update max ancestor for children
        int newMaxAncestor = Math.max(maxAncestor, node.data);

        // Traverse children
        dfs(node.left, newMaxAncestor, maxDiff);
        dfs(node.right, newMaxAncestor, maxDiff);
    }
}