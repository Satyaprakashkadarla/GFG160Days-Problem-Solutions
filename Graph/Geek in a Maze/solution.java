import java.util.*;

class Solution {
    public int numberOfCells(int r, int c, int u, int d, char[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        if (mat[r][c] == '#') {
            return 0;
        }

        // dist[x][y] = minimum number of upward moves needed
        // to reach (x, y).
        int[][] dist = new int[n][m];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        ArrayDeque<Integer> deque = new ArrayDeque<>();

        dist[r][c] = 0;
        deque.add(r * m + c);

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!deque.isEmpty()) {
            int id = deque.pollFirst();
            int x = id / m;
            int y = id % m;

            int cur = dist[x][y];

            for (int k = 0; k < 4; k++) {
                int nx = x + dr[k];
                int ny = y + dc[k];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m ||
                    mat[nx][ny] == '#') {
                    continue;
                }

                // Moving up costs 1; every other move costs 0.
                int cost = (nx < x) ? 1 : 0;
                int next = cur + cost;

                if (next < dist[nx][ny]) {
                    dist[nx][ny] = next;

                    if (cost == 0) {
                        deque.addFirst(nx * m + ny);
                    } else {
                        deque.addLast(nx * m + ny);
                    }
                }
            }
        }

        int ans = 0;

        for (int x = 0; x < n; x++) {
            for (int y = 0; y < m; y++) {
                if (mat[x][y] == '#') {
                    continue;
                }

                int upMoves = dist[x][y];

                if (upMoves == Integer.MAX_VALUE) {
                    continue;
                }

                // downMoves = upMoves + (x - r)
                int downMoves = upMoves + (x - r);

                if (upMoves <= u && downMoves <= d) {
                    ans++;
                }
            }
        }

        return ans;
    }
}