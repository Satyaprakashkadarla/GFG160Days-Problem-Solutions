/* The Node structure is defined as
 class Node {
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    public int absDiff(Node root) {
        Stack<Node> stack = new Stack<>();
        Node curr = root;

        int prev = -1;
        int minDiff = Integer.MAX_VALUE;

        while (curr != null || !stack.isEmpty()) {

            // Go to the smallest node.
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();

            // Compare with previous inorder value.
            if (prev != -1) {
                minDiff = Math.min(minDiff, curr.data - prev);
            }

            prev = curr.data;

            // Visit right subtree.
            curr = curr.right;
        }

        return minDiff;
    }
}
