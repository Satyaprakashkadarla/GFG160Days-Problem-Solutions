
class Solution {
    int min;
        Stack<Integer> st = new Stack();
    public Solution() {}

    // Add an element to the top of Stack
    public void push(int x) {
        if(st.isEmpty()) {
            min = x;
        }
        else if (x <= min) {
            st.push(min);
            min = x;
        }
        else if (x <= min) {
            st.push(min);
            min = x;
        }
        st.push(x);
    }

    // Remove the top element from the Stack
    public void pop() {
        if(st.isEmpty())
        return;
        int temp = st.pop();
        if(temp == min) {
            if(!st.isEmpty()) {
                min = st.pop();
            }
        }
    }

    // Returns top element of the Stack
    public int peek() {
        if(st.isEmpty())
        return -1;
        return st.peek();
    }

    // Finds minimum element of Stack
    public int getMin() {
        if(st.isEmpty())
        return -1;
        return min;
    }
}