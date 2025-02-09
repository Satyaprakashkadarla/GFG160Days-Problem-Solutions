class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

class Solution {
    int pathSum(Node root, int[] maxSum) {
        if (root == null) return 0;
        int left = Math.max(0, pathSum(root.left, maxSum));
        int right = Math.max(0, pathSum(root.right, maxSum));
        maxSum[0] = Math.max(maxSum[0], root.data + left + right);
        return root.data + Math.max(left, right);
    }

    int findMaxSum(Node root) {
        int[] maxSum = new int[1];
        maxSum[0] = Integer.MIN_VALUE;
        pathSum(root, maxSum);
        return maxSum[0];
    }
}
