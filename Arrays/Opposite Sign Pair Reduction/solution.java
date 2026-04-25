import java.util.*;

class Solution {
    public ArrayList<Integer> reducePairs(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        
        for (int num : arr) {
            boolean push = true;
            while (!stack.isEmpty() && (stack.peek() > 0 && num < 0 || stack.peek() < 0 && num > 0)) {
                if (Math.abs(stack.peek()) == Math.abs(num)) {
                    stack.pop();
                    push = false;
                    break;
                } else if (Math.abs(stack.peek()) > Math.abs(num)) {
                    push = false;
                    break;
                } else {
                    stack.pop();
                }
            }
            if (push) {
                stack.push(num);
            }
        }
        
        return new ArrayList<>(stack);
    }
}