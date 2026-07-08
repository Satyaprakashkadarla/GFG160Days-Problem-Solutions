import java.util.*;

class Solution {
    public int countCoordinates(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        boolean[][] canP = new boolean[n][m];
        boolean[][] canQ = new boolean[n][m];
        
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};
        
        // BFS for P (top + left)
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            canP[i][0] = true;
            q.add(new int[]{i, 0});
        }
        for (int j = 0; j < m; j++) {
            canP[0][j] = true;
            q.add(new int[]{0, j});
        }
        bfs(mat, canP, q, dr, dc);
        
        // BFS for Q (bottom + right)
        q.clear();
        for (int i = 0; i < n; i++) {
            canQ[i][m - 1] = true;
            q.add(new int[]{i, m - 1});
        }
        for (int j = 0; j < m; j++) {
            canQ[n - 1][j] = true;
            q.add(new int[]{n - 1, j});
        }
        bfs(mat, canQ, q, dr, dc);
        
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (canP[i][j] && canQ[i][j]) count++;
            }
        }
        return count;
    }
    
    private void bfs(int[][] mat, boolean[][] can, Queue<int[]> q, int[] dr, int[] dc) {
        int n = mat.length, m = mat[0].length;
        while (!q.isEmpty()) {
            int[] cell = q.poll();
            int r = cell[0], c = cell[1];
            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if (nr >= 0 && nr < n && nc >= 0 && nc < m && !can[nr][nc] && mat[nr][nc] >= mat[r][c]) {
                    can[nr][nc] = true;
                    q.add(new int[]{nr, nc});
                }
            }
        }
    }
}