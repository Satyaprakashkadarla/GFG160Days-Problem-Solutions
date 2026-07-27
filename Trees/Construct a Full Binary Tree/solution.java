/* Structure of Binary Tree Node
class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
} */

import java.util.*;

class Solution {
    public Node constructBinaryTree(int[] pre, int[] preMirror) {
        int n = pre.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(preMirror[i], i);
        }
        return build(pre, preMirror, 0, n - 1, 0, n - 1, map);
    }
    
    private Node build(int[] pre, int[] preMirror, int preL, int preR, int mirL, int mirR, Map<Integer, Integer> map) {
        if (preL > preR) return null;
        
        Node root = new Node(pre[preL]);
        if (preL == preR) return root;
        
        int leftRoot = pre[preL + 1];
        int pos = map.get(leftRoot);
        
        // right subtree size = pos - mirL - 1 (since mirL is root index)
        int rightSize = pos - mirL - 1;
        int leftSize = preR - preL - rightSize;
        
        root.left = build(pre, preMirror, preL + 1, preL + leftSize, pos, mirR, map);
        root.right = build(pre, preMirror, preL + leftSize + 1, preR, mirL + 1, pos - 1, map);
        
        return root;
    }
}