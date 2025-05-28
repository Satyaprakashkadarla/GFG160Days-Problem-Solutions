class Solution {
    public boolean ValidCorner(int[][] mat) {
        int r = mat.length;                    // number of rows
        int c = mat[0].length;                 // number of columns

        HashSet<String> set = new HashSet<>(); // to store seen column pairs

        for (int i = 0; i < r; i++) {
            List<Integer> cols = new ArrayList<>();  // store column indices with 1s in current row

            for (int j = 0; j < c; j++) {
                if (mat[i][j] == 1) {
                    cols.add(j);
                }
            }

            // check all pairs of 1s in the row
            for (int x = 0; x < cols.size(); x++) {
                for (int y = x + 1; y < cols.size(); y++) {
                    String pair = cols.get(x) + "_" + cols.get(y);

                    if (set.contains(pair)) {
                        return true;  // rectangle found
                    }

                    set.add(pair);
                }
            }
        }

        return false;  // no rectangle found
    }
}