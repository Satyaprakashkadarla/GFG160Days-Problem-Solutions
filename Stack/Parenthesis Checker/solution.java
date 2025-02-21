import java.util.Stack;

class Solution {
    static boolean isBalanced(String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                st.push(ch);
            } else {
                if (!st.isEmpty() && ((st.peek() == '(' && ch == ')') ||
                                      (st.peek() == '[' && ch == ']') ||
                                      (st.peek() == '{' && ch == '}'))) {
                    st.pop();
                } else {
                    return false;
                }
            }
        }
        return st.isEmpty();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "()[]{}";
        System.out.println(solution.isBalanced(s)); // Expected Output: true
    }
}
