import java.util.*;

class Solution {
    public int orangesRot(int[][] mat) {
        int r = mat.length, c = mat[0].length;
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;
        
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (mat[i][j] == 2) {
                    q.add(new int[]{i, j, 0});
                } else if (mat[i][j] == 1) {
                    fresh++;
                }
            }
        }
        
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};
        int maxTime = 0;
        
        while (!q.isEmpty()) {
            int[] cell = q.poll();
            int x = cell[0], y = cell[1], t = cell[2];
            maxTime = Math.max(maxTime, t);
            
            for (int d = 0; d < 4; d++) {
                int nx = x + dr[d];
                int ny = y + dc[d];
                if (nx >= 0 && nx < r && ny >= 0 && ny < c && mat[nx][ny] == 1) {
                    mat[nx][ny] = 2;
                    fresh--;
                    q.add(new int[]{nx, ny, t + 1});
                }
            }
        }
        
        return fresh == 0 ? maxTime : -1;
    }
}