class Solution {
    public ArrayList<ArrayList<Integer>> formCoils(int n) {
        int m = 4 * n;
        int total = m * m;
        int half = total / 2;

        ArrayList<Integer> c1 = new ArrayList<>(half);
        ArrayList<Integer> c2 = new ArrayList<>(half);

        // directions: down, right, up, left
        int[] dr = {1, 0, -1, 0};
        int[] dc = {0, 1, 0, -1};

        int r = 0, c = 0;
        c1.add(1);
        c2.add(total);

        int dir = 0;
        int len = m - 1;      // first segment length
        boolean first = true;
        int segsAtLen = 0;

        while (c1.size() < half) {
            for (int i = 0; i < len && c1.size() < half; i++) {
                r += dr[dir];
                c += dc[dir];
                int v = r * m + c + 1;
                c1.add(v);
                c2.add(total + 1 - v);
            }
            dir = (dir + 1) % 4;

            if (first) {          // after first segment, length becomes m-2
                len = m - 2;
                first = false;
                segsAtLen = 0;
            } else {
                segsAtLen++;
                if (segsAtLen == 2) { // each length is used twice
                    len -= 2;
                    segsAtLen = 0;
                }
            }
        }

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        res.add(c1);
        res.add(c2);
        return res;
    }
}