class Solution {
    public int waysToIncreaseLCSBy1(String s1, String s2) {
        int n1 = s1.length(), n2 = s2.length();
        int[][] L = new int[n1 + 1][n2 + 1];
        int[][] R = new int[n1 + 1][n2 + 1];
        
        // Prefix LCS
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    L[i][j] = L[i - 1][j - 1] + 1;
                } else {
                    L[i][j] = Math.max(L[i - 1][j], L[i][j - 1]);
                }
            }
        }
        
        // Suffix LCS
        for (int i = n1 - 1; i >= 0; i--) {
            for (int j = n2 - 1; j >= 0; j--) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    R[i][j] = R[i + 1][j + 1] + 1;
                } else {
                    R[i][j] = Math.max(R[i + 1][j], R[i][j + 1]);
                }
            }
        }
        
        int originalLCS = L[n1][n2];
        int ways = 0;
        
        for (int p = 0; p <= n1; p++) {
            for (char c = 'a'; c <= 'z'; c++) {
                boolean found = false;
                for (int k = 0; k < n2; k++) {
                    if (s2.charAt(k) == c) {
                        int newLCS = L[p][k] + 1 + R[p][k + 1];
                        if (newLCS == originalLCS + 1) {
                            ways++;
                            found = true;
                            break;
                        }
                    }
                }
            }
        }
        return ways;
    }
}