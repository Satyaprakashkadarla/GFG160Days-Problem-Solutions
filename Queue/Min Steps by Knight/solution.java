class Solution {
    public int minStepToReachTarget(int knightPos[], int targetPos[], int n) {

        int sx = knightPos[0] - 1;
        int sy = knightPos[1] - 1;
        int tx = targetPos[0] - 1;
        int ty = targetPos[1] - 1;

        if (sx == tx && sy == ty) return 0;

        int[][] moves = {
            {2, 1}, {2, -1},
            {-2, 1}, {-2, -1},
            {1, 2}, {1, -2},
            {-1, 2}, {-1, -2}
        };

        boolean[][] visited = new boolean[n][n];

        // Queue stores encoded (row, col)
        int[] queue = new int[n * n];
        int head = 0, tail = 0;

        queue[tail++] = sx * n + sy;
        visited[sx][sy] = true;

        int steps = 0;

        while (head < tail) {
            int size = tail - head;
            steps++;

            while (size-- > 0) {
                int pos = queue[head++];
                int x = pos / n;
                int y = pos % n;

                for (int[] move : moves) {
                    int nx = x + move[0];
                    int ny = y + move[1];

                    if (nx < 0 || nx >= n || ny < 0 || ny >= n ||
                        visited[nx][ny]) {
                        continue;
                    }

                    if (nx == tx && ny == ty) {
                        return steps;
                    }

                    visited[nx][ny] = true;
                    queue[tail++] = nx * n + ny;
                }
            }
        }

        return -1;
    }
}
