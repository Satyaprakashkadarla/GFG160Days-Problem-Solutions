class Solution {
    public int myAtoi(String s) {
        // Constants for 32-bit signed integer limits
        int INT_MAX = Integer.MAX_VALUE;
        int INT_MIN = Integer.MIN_VALUE;

        // Trim any leading or trailing whitespace
        s = s.trim();
        
        // If the string is empty, return 0
        if (s.isEmpty()) {
            return 0;
        }

        int sign = 1;
        int result = 0;
        int index = 0;
        int n = s.length();

        // Check the sign of the number
        if (s.charAt(index) == '-' || s.charAt(index) == '+') {
            sign = (s.charAt(index) == '-') ? -1 : 1;
            index++;
        }

        // Convert the digits into an integer
        while (index < n && Character.isDigit(s.charAt(index))) {
            int digit = s.charAt(index) - '0'; // Convert char to int
            // Check for overflow
            if (result > (INT_MAX - digit) / 10) {
                return (sign == 1) ? INT_MAX : INT_MIN;
            }
            result = result * 10 + digit;
            index++;
        }

        // Return the final result with the sign applied
        return sign * result;
    }
}
