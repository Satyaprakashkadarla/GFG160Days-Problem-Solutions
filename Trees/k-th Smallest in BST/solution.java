import java.util.Stack;

class Solution {
    // Return the Kth smallest element in the given BST
    public int kthSmallest(Node root, int k) {
        Stack<Node> stack = new Stack<>();
        Node curr = root;
        int count = 0;
        
        while (curr != null || !stack.isEmpty()) {
            // Reach the leftmost node
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            
            // Pop the node and process it
            curr = stack.pop();
            count++;
            
            // If we've processed k nodes, return the kth smallest
            if (count == k) {
                return curr.data;
            }
            
            // Move to the right subtree
            curr = curr.right;
        }
        
        return -1; // In case k is invalid
    }
}
