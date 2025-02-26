class Solution {
    public ArrayList<Integer> maxOfMins(int[] arr) {
        int n = arr.length;
        int[] prev = new int[n];
        int[] next = new int[n];
        Arrays.fill(prev,-1);
        Arrays.fill(next,n);
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<n;i++) {
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            if(!stack.isEmpty()) {
                prev[i] = stack.peek();
            }
            stack.push(i);
        }
        stack.clear();
        for(int i=n-1;i>=0;i--) {
            while(!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            if(!stack.isEmpty()) {
                next[i] = stack.peek();
            }
            stack.push(i);
        }
        int[] maxOfMins = new int[n+1];
        for(int i=0;i<n;i++) {
            int length = next[i] - prev[i] -1;
            maxOfMins[length] = Math.max(maxOfMins[length],arr[i]);
        }
        for(int i=n-1;i>=1;i--) {
            maxOfMins[i] = Math.max(maxOfMins[i],maxOfMins[i+1]);
        }
        ArrayList<Integer> result = new ArrayList<>();
        for(int i=1;i<=n;i++) {
            result.add(maxOfMins[i]);
        }
        return result;
    }
}