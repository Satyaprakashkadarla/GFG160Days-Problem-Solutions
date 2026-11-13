/* Structure of a Binary Search Tree node
class Node {
  public int data;
  public Node left;
  public Node right;

  public Node(int val) {
      data = val;
      left = right = null;
  }
};
*/

import java.util.ArrayList;
import java.util.Stack;

class Solution {
    public ArrayList<Integer> findCommon(Node r1, Node r2) {
        ArrayList<Integer> result = new ArrayList<>();
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();

        while (true) {
            // Push all left nodes of the first tree
            while (r1 != null) {
                s1.push(r1);
                r1 = r1.left;
            }
            // Push all left nodes of the second tree
            while (r2 != null) {
                s2.push(r2);
                r2 = r2.left;
            }

            // If either stack is empty, we have exhausted one of the trees
            if (s1.isEmpty() || s2.isEmpty()) {
                break;
            }

            Node top1 = s1.peek();
            Node top2 = s2.peek();

            // If values match, it's a common node
            if (top1.data == top2.data) {
                result.add(top1.data);
                s1.pop();
                s2.pop();
                r1 = top1.right;
                r2 = top2.right;
            } 
            // If tree 1's value is smaller, advance in tree 1
            else if (top1.data < top2.data) {
                s1.pop();
                r1 = top1.right;
                r2 = null; // Keep s2 intact for the next comparison
            } 
            // If tree 2's value is smaller, advance in tree 2
            else {
                s2.pop();
                r2 = top2.right;
                r1 = null; // Keep s1 intact for the next comparison
            }
        }

        return result;
    }
}