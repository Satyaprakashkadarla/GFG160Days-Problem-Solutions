import java.util.*;

class Solution {
    public int findWays(int[][] matrix, int k) {
        final int MOD = 1_000_000_007;
        int n = matrix.length, m = matrix[0].length;

        // rowSuf[r][c] = true if row r has a 1 in columns [c, m)
        boolean[][] rowSuf = new boolean[n][m + 1];
        for (int r = 0; r < n; r++) {
            rowSuf[r][m] = false;
            for (int c = m - 1; c >= 0; c--)
                rowSuf[r][c] = rowSuf[r][c + 1] || (matrix[r][c] == 1);
        }

        // colSuf[c][r] = true if column c has a 1 in rows [r, n)
        boolean[][] colSuf = new boolean[m][n + 1];
        for (int c = 0; c < m; c++) {
            colSuf[c][n] = false;
            for (int r = n - 1; r >= 0; r--)
                colSuf[c][r] = colSuf[c][r + 1] || (matrix[r][c] == 1);
        }

        // R[i][c] = max row index r' in [0,i) with rowSuf[r'][c]==true, else -1
        int[][] R = new int[n + 1][m + 1];
        Arrays.fill(R[0], -1);
        for (int i = 1; i <= n; i++)
            for (int c = 0; c <= m; c++) {
                boolean has = (c < m) && rowSuf[i - 1][c];
                R[i][c] = has ? (i - 1) : R[i - 1][c];
            }

        // C[i][r] = max col index c' in [0,i) with colSuf[c'][r]==true, else -1
        int[][] C = new int[m + 1][n + 1];
        Arrays.fill(C[0], -1);
        for (int i = 1; i <= m; i++)
            for (int r = 0; r <= n; r++) {
                boolean has = (r < n) && colSuf[i - 1][r];
                C[i][r] = has ? (i - 1) : C[i - 1][r];
            }

        // base layer: f[r][c][1]
        long[][] prev = new long[n + 1][m + 1];
        for (int r = 0; r <= n; r++)
            for (int c = 0; c <= m; c++)
                prev[r][c] = (R[n][c] >= r) ? 1 : 0;

        if (k == 1) return (int) prev[0][0];

        long[][] cur = new long[n + 1][m + 1];

        for (int j = 2; j <= k; j++) {
            for (long[] row : cur) Arrays.fill(row, 0);

            // Horizontal-cut contribution: for each c, difference array over r
            for (int c = 0; c <= m; c++) {
                long[] diff = new long[n + 2];
                for (int i = 1; i <= n; i++) {
                    long val = prev[i][c];
                    if (val == 0) continue;
                    int rr = R[i][c];
                    if (rr < 0) continue;
                    diff[0] = (diff[0] + val) % MOD;
                    diff[rr + 1] = (diff[rr + 1] - val + MOD) % MOD;
                }
                long acc = 0;
                for (int r = 0; r <= n; r++) {
                    acc = (acc + diff[r]) % MOD;
                    cur[r][c] = (cur[r][c] + acc) % MOD;
                }
            }

            // Vertical-cut contribution: for each r, difference array over c
            for (int r = 0; r <= n; r++) {
                long[] diff = new long[m + 2];
                for (int i = 1; i <= m; i++) {
                    long val = prev[r][i];
                    if (val == 0) continue;
                    int cc = C[i][r];
                    if (cc < 0) continue;
                    diff[0] = (diff[0] + val) % MOD;
                    diff[cc + 1] = (diff[cc + 1] - val + MOD) % MOD;
                }
                long acc = 0;
                for (int c = 0; c <= m; c++) {
                    acc = (acc + diff[c]) % MOD;
                    cur[r][c] = (cur[r][c] + acc) % MOD;
                }
            }

            long[][] tmp = prev;
            prev = cur;
            cur = tmp;
        }

        return (int) (prev[0][0] % MOD);
    }
}