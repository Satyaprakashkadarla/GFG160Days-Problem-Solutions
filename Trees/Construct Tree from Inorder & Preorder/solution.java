class Solution {
    static int position;
    public static Node buildTree(int inorder[], int preorder[]) {
        position = 0;
        return solve(inorder,preorder,0,inorder.length-1);
    }
    static Node solve(int inorder[],int preorder[],int str, int end) {
        if(str>inorder.length || str > end) {
            return null;

        }
        Node root = new Node(preorder[position]);
        int div = 0;
        for(int i=str;i<=end;i++) {
            if(preorder[position]==inorder[i]) {
                div = i;
                break;
            }
        }
        position++;
        root.left = solve(inorder,preorder,str,div-1);
        root.right = solve(inorder,preorder,div+1,end);
        return root;
    }
}