import java.util.*;

class Solution {
    public int cntOnes(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();
        
        // Add boundary 1's
        for (int i = 0; i < n; i++) {
            if (grid[i][0] == 1) q.add(new int[]{i, 0});
            if (grid[i][m - 1] == 1) q.add(new int[]{i, m - 1});
        }
        for (int j = 0; j < m; j++) {
            if (grid[0][j] == 1) q.add(new int[]{0, j});
            if (grid[n - 1][j] == 1) q.add(new int[]{n - 1, j});
        }
        
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};
        
        while (!q.isEmpty()) {
            int[] cell = q.poll();
            int r = cell[0], c = cell[1];
            if (visited[r][c]) continue;
            visited[r][c] = true;
            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if (nr >= 0 && nr < n && nc >= 0 && nc < m && grid[nr][nc] == 1 && !visited[nr][nc]) {
                    q.add(new int[]{nr, nc});
                }
            }
        }
        
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) count++;
            }
        }
        return count;
    }
}