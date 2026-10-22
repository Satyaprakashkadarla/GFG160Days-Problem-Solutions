class Solution {
    public int minimumSum(String s) {
        int n = s.length();
        char[] arr = s.toCharArray();
        
        // Step 1: Check if palindrome is possible and fill symmetric pairs
        for (int i = 0; i < n / 2; i++) {
            char left = arr[i];
            char right = arr[n - i - 1];
            
            if (left != '?' && right != '?' && left != right) {
                return -1;
            } else if (left != '?' && right == '?') {
                arr[n - i - 1] = left;
            } else if (left == '?' && right != '?') {
                arr[i] = right;
            }
        }
        
        // Step 2: Fill remaining '?' using the nearest known character from the left
        char prev = ' ';
        for (int i = 0; i < n; i++) {
            if (arr[i] != '?') {
                prev = arr[i];
            } else if (prev != ' ') {
                arr[i] = prev;
            }
        }
        
        // Step 3: Fill remaining '?' from the right if any are left at the beginning
        prev = ' ';
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] != '?') {
                prev = arr[i];
            } else if (prev != ' ') {
                arr[i] = prev;
            }
        }
        
        // If the entire string was '?', default them to 'a'
        for (int i = 0; i < n; i++) {
            if (arr[i] == '?') {
                arr[i] = 'a';
            }
        }
        
        // Step 4: Calculate the minimum sum of absolute differences between adjacent characters
        int totalSum = 0;
        for (int i = 0; i < n - 1; i++) {
            totalSum += Math.abs(arr[i] - arr[i + 1]);
        }
        
        return totalSum;
    }
}