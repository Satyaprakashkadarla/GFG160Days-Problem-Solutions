import java.util.*;

class Solution {
    List<Integer> makeBeautiful(int[] arr) {
        Stack<Integer> st = new Stack<>();

        for (int num : arr) {
            // If stack is not empty and top element has different sign
            if (!st.isEmpty() && isDifferentSign(st.peek(), num)) {
                st.pop(); // remove both
            } else {
                st.push(num);
            }
        }

        return new ArrayList<>(st);
    }

    // Returns true if one number is negative and the other is non-negative
    private boolean isDifferentSign(int a, int b) {
        return (a < 0 && b >= 0) || (a >= 0 && b < 0);
    }
}