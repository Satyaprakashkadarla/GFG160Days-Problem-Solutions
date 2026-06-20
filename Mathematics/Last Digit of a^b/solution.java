class Solution {
    public int getLastDigit(String a, String b) {
        if (b.equals("0")) return 1;
        
        int base = a.charAt(a.length() - 1) - '0';
        
        // Compute b % 4
        int exp = 0;
        for (char ch : b.toCharArray()) {
            exp = (exp * 10 + (ch - '0')) % 4;
        }
        if (exp == 0) exp = 4;
        
        int result = 1;
        for (int i = 0; i < exp; i++) {
            result = (result * base) % 10;
        }
        return result;
    }
}