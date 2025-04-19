import java.util.*;

class TrieNode {
    TrieNode[] children;

    public TrieNode() {
        children = new TrieNode[2]; // Binary Trie for bits 0 and 1
    }
}

class Solution {
    private TrieNode root;

    public Solution() {
        root = new TrieNode();
    }

    public void insert(int num) {
        TrieNode node = root;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (node.children[bit] == null) {
                node.children[bit] = new TrieNode();
            }
            node = node.children[bit];
        }
    }

    public int findMaxXOR(int num) {
        TrieNode node = root;
        int maxXor = 0;

        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            int toggledBit = 1 - bit;

            if (node.children[toggledBit] != null) {
                maxXor |= (1 << i);
                node = node.children[toggledBit];
            } else {
                node = node.children[bit];
            }
        }

        return maxXor;
    }

    public int maxXor(int[] arr) {
        int maxResult = 0;
        
        for (int num : arr) {
            insert(num);
        }
        
        for (int num : arr) {
            maxResult = Math.max(maxResult, findMaxXOR(num));
        }

        return maxResult;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr = {3, 10, 5, 25, 2, 8};
        System.out.println("Maximum XOR Pair Value: " + sol.maxXor(arr));
    }
}
