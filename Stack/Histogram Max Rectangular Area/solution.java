class Solution {
    public int getMaxArea(int[] arr) {
        int n = arr.length;
        int[] prev = new int[n];
        int[] nex = new int[n];
        
        Stack<Integer> stack = new Stack<>();
        
        // Fill the prev array
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            prev[i] = (stack.isEmpty()) ? -1 : stack.peek();
            stack.push(i);
        }
        
        // Clear the stack
        stack.clear();
        
        // Fill the nex array
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            nex[i] = (stack.isEmpty()) ? n : stack.peek();
            stack.push(i);
        }
        
        // Calculate the maximum area
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            int height = arr[i];
            int width = nex[i] - prev[i] - 1;
            int area = height * width;
            maxArea = Math.max(maxArea, area);
        }
        
        return 