class Solution {
    boolean findTarget(Node root, int target) {
        if(root == null) {
            return false;
        }
        return solve(root, root, target);
    }

    boolean solve(Node root, Node curr, int target) {
        if(curr == null) {
            return false;
        }
        return solve(root, curr.left, target) || solve(root, curr.right, target);
    }

    boolean findNode(Node root, int target, Node curr) {
        if(root == null) {
            return false;
        }
        if(root.data == target && root != curr) {  // Fixed the issue here
            return true;
        }
        if(root.data > target) {
            return findNode(root.left, target, curr);
        }
        return findNode(root.right, target, curr);
    }
}
