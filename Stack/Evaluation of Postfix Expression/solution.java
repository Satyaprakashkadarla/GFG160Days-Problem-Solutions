
class Solution {
    public int evaluate(String[] arr) {
        Stack<Integer> st = new Stack<>();
        for(String x : arr) {
            if(isNumber(x)) {
                st.push(Integer.parseInt(x));
            }
            else {
                int n1 = st.pop();
                int n2 = st.pop();
                switch (x) {
                    case "+":
                        st.push(n2 + n1);
                        break;
                    case "-":
                        st.push(n2 - n1);
                        break;
                    case "*":
                        st.push(n2 * n1);
                        break;
                    case "/":
                        st.push(n2 / n1);
                }
            }
        }
        return st.peek();
    }
    boolean isNumber(String s) {
        if(s.isEmpty()) return false;
        if(s.length() > 1 && s.charAt(0) == '-') s = s.substring(1);
        for(char c : s.toCharArray()) {
            if(!Character.isDigit(c)) return false;
        }
        return true;
    }
}
