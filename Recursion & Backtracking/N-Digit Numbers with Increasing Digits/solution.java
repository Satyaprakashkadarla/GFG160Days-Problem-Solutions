import java.util.*;

class Solution {
    public static ArrayList<Integer> increasingNumbers(int n) {
        ArrayList<Integer> result = new ArrayList<>();
        if (n == 1) {
            for (int i = 0; i <= 9; i++) result.add(i);
            return result;
        }
        if (n > 10) return result;
        
        for (int start = 1; start <= 9; start++) {
            backtrack(start, 1, n, result);
        }
        return result;
    }
    
    private static void backtrack(int num, int len, int n, ArrayList<Integer> result) {
        if (len == n) {
            result.add(num);
            return;
        }
        int lastDigit = num % 10;
        for (int next = lastDigit + 1; next <= 9; next++) {
            backtrack(num * 10 + next, len + 1, n, result);
        }
    }
}