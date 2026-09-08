class Solution {
    public ArrayList<ArrayList<Integer>> searchWord(char[][] mat, String word) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        int n = mat.length;
        int m = mat[0].length;
        int len = word.length();

        // 8 directions
        int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dc = {-1,  0,  1, -1, 1, -1, 0, 1};

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {

                if (mat[r][c] != word.charAt(0))
                    continue;

                boolean found = false;

                for (int d = 0; d < 8 && !found; d++) {
                    int nr = r;
                    int nc = c;
                    int k;

                    for (k = 1; k < len; k++) {
                        nr += dr[d];
                        nc += dc[d];

                        if (nr < 0 || nr >= n || nc < 0 || nc >= m ||
                            mat[nr][nc] != word.charAt(k)) {
                            break;
                        }
                    }

                    if (k == len)
                        found = true;
                }

                if (found) {
                    ArrayList<Integer> pos = new ArrayList<>();
                    pos.add(r);
                    pos.add(c);
                    ans.add(pos);
                }
            }
        }

        // Row-major traversal already gives lexicographically sorted coordinates.
        return ans;
    }
}
