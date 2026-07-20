import java.util.*;

class Solution {
    class TrieNode {
        TrieNode[] child = new TrieNode[26];
        int count = 0;
    }
    
    public ArrayList<String> findPrefixes(ArrayList<String> arr) {
        TrieNode root = new TrieNode();
        
        // Insert all strings
        for (String s : arr) {
            TrieNode node = root;
            for (char ch : s.toCharArray()) {
                int idx = ch - 'a';
                if (node.child[idx] == null) {
                    node.child[idx] = new TrieNode();
                }
                node = node.child[idx];
                node.count++;
            }
        }
        
        ArrayList<String> result = new ArrayList<>();
        for (String s : arr) {
            TrieNode node = root;
            StringBuilder prefix = new StringBuilder();
            for (char ch : s.toCharArray()) {
                node = node.child[ch - 'a'];
                prefix.append(ch);
                if (node.count == 1) {
                    break;
                }
            }
            result.add(prefix.toString());
        }
        return result;
    }
}