class Solution {
    // Function to convert a binary tree into its mirror tree.
    void mirror(Node node) {
        // Your code here
        solve(node);
    }
    Node solve(Node node) {
        if(node == null) {
            return null;
        }
        Node mirroredLeft = solve(node.left);
        Node mirroredRight = solve(node.right);
        node.left = mirroredRight;
        node.right = mirroredLeft;
        return node;
    }
}