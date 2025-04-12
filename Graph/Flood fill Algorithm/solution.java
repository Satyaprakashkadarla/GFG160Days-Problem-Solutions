class Solution {
    public int[][] floodFill(int[][] imageMatrix, int startRow, int startCol, int fillColor) {
        if (imageMatrix[startRow][startCol] == fillColor) {
            return imageMatrix;
        }
        int rows = imageMatrix.length;
        int cols = imageMatrix[0].length;
        performFloodFill(imageMatrix, imageMatrix[startRow][startCol], startRow, startCol, rows, cols, fillColor);
        return imageMatrix;
    }
    void performFloodFill(int[][] imageMatrix, int originalColor, int currentRow, int currentCol, int totalRows, int totalCols, int fillColor) {
        if (currentRow < 0 || currentCol < 0 || currentRow >= totalRows || currentCol >= totalCols) {
            return;
        }
        if (imageMatrix[currentRow][currentCol] == fillColor || imageMatrix[currentRow][currentCol] != originalColor) {
            return;
        }
        imageMatrix[currentRow][currentCol] = fillColor;
        performFloodFill(imageMatrix, originalColor, currentRow + 1, currentCol, totalRows, totalCols, fillColor);
        performFloodFill(imageMatrix, originalColor, currentRow - 1, currentCol, totalRows, totalCols, fillColor);
        performFloodFill(imageMatrix, originalColor, currentRow, currentCol - 1, totalRows, totalCols, fillColor);
        performFloodFill(imageMatrix, originalColor, currentRow, currentCol + 1, totalRows, totalCols, fillColor);
    }
}
