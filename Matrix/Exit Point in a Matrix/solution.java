import java.util.*;

class Solution {
    public List<Integer> exitPoint(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        int i = 0, j = 0;
        int dir = 0; // 0:right, 1:down, 2:left, 3:up
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};
        
        while (true) {
            if (mat[i][j] == 1) {
                dir = (dir + 1) % 4;
                mat[i][j] = 0;
            }
            int ni = i + dr[dir];
            int nj = j + dc[dir];
            if (ni < 0 || ni >= n || nj < 0 || nj >= m) {
                return Arrays.asList(i, j);
            }
            i = ni;
            j = nj;
        }
    }
}