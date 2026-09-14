class Solution {
    int shortestPath(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        boolean[][] unsafe = new boolean[n][m];
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        // Mark landmines and their adjacent cells as unsafe
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (mat[r][c] == 0) {
                    unsafe[r][c] = true;
                    for (int k = 0; k < 4; k++) {
                        int nr = r + dr[k];
                        int nc = c + dc[k];

                        if (nr >= 0 && nr < n && nc >= 0 && nc < m)
                            unsafe[nr][nc] = true;
                    }
                }
            }
        }

        // BFS: store r, c, distance
        int[][] dist = new int[n][m];
        java.util.ArrayDeque<int[]> q = new java.util.ArrayDeque<>();

        for (int r = 0; r < n; r++) {
            if (!unsafe[r][0]) {
                dist[r][0] = 1;
                q.offer(new int[]{r, 0});
            }
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1];

            if (c == m - 1)
                return dist[r][c];

            for (int k = 0; k < 4; k++) {
                int nr = r + dr[k];
                int nc = c + dc[k];

                if (nr >= 0 && nr < n && nc >= 0 && nc < m &&
                    !unsafe[nr][nc] && dist[nr][nc] == 0) {

                    dist[nr][nc] = dist[r][c] + 1;
                    q.offer(new int[]{nr, nc});
                }
            }
        }

        return -1;
    }
}
