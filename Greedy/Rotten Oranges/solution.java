class Solution {
    public int orangesRotting(int[][] mat) {
        int n = mat.length, m = mat[0].length, ans = 0, count = 0;
        int[][] vis = new int[n][m];
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 2) {
                    vis[i][j] = 1;
                    q.add(new int[] { 0, i, j }); 
                    count++;
                } else if (mat[i][j] == 1) {
                    count++;
                }
            }
        }
        int[] radd = {-1, 1, 0, 0};
        int[] cadd = {0, 0, -1, 1};
        while (!q.isEmpty()) {
            int[] current = q.poll();
            int t = current[0];
            int row = current[1];
            int col = current[2];
            ans = Math.max(ans, t); 
            count--; 
                        for (int i = 0; i < 4; i++) {
                int nrow = row + radd[i], ncol = col + cadd[i];
                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] == 0 && mat[nrow][ncol] == 1) {
                    vis[nrow][ncol] = 1;
                    q.add(new int[] { t + 1, nrow, ncol });
                }
            }
        }
        if (count == 0) {
            return ans;
        } else {
            return -1;
        }
    }
}