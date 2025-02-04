class Solution {
    // Helper function to calculate the height of the tree and update the diameter
    private int diameterHelper(TreeNode root, int[] maxDiameter) {
        if (root == null) {
            return 0;
        }
        
        int leftHeight = diameterHelper(root.left, maxDiameter);
        int rightHeight = diameterHelper(root.right, maxDiameter);
        
        int diameterAtNode = leftHeight + rightHeight;
        maxDiameter[0] = Math.max(maxDiameter[0], diameterAtNode);
        
        return 1 + Math.max(leftHeight, rightHeight);
    }
    
    public int diameter(TreeNode root) {
        int[] maxDiameter = new int[1];  // Using an array to mimic passing by reference
        diameterHelper(root, maxDiameter);
        return maxDiameter[0];  // Return the diameter
    }
}