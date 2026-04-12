class Solution {
    public boolean isToeplitz(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        
        for (int i = 0; i < rows - 1; i++) {
            for (int j = 0; j < cols - 1; j++) {
                if (mat[i][j] != mat[i + 1][j + 1]) {
                    return false;
                }
            }
        }
        return true;
    }
}