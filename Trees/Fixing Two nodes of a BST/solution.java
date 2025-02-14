class Solution {
    Node first = null , second = null , prev = null;
    void inorder(Node root) {
        if(root==null) return;
        inorder(root.left);
        if(prev!=null && root.data<prev.data) {
            if(first==null) {
                first=prev;
            }
            second = root;
        }
        prev = root;
        inorder(root.right);
    }
    void correctBST(Node root) {
        prev = first = second = null;
        inorder(root);
        if(first!=null && second!=null) {
            int temp = first.data;
            first.data = second.data;
            second.data = temp;
        }
    }
}