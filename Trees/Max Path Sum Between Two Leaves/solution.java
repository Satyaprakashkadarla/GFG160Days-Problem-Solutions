/* Node Structure
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
} */
class Solution {
    int maxSum;
    int leafCount;

    public int maxPathSum(Node root) {
        if (root == null) {
            return -1;
        }

        maxSum = Integer.MIN_VALUE;
        leafCount = 0;

        dfs(root);

        return leafCount >= 2 ? maxSum : -1;
    }

    // Returns maximum sum from node to a leaf
    private int dfs(Node node) {
        if (node == null) {
            return Integer.MIN_VALUE;
        }

        // Leaf node
        if (node.left == null && node.right == null) {
            leafCount++;
            return node.data;
        }

        int left = dfs(node.left);
        int right = dfs(node.right);

        // Both children exist:
        // path = leaf -> left subtree -> node -> right subtree -> leaf
        if (node.left != null && node.right != null) {
            maxSum = Math.max(maxSum, left + node.data + right);
            return node.data + Math.max(left, right);
        }

        // Only one child exists
        if (node.left != null) {
            return node.data + left;
        }

        return node.data + right;
    }
}
