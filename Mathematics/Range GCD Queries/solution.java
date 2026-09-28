class Solution {

    int[] tree;

    public ArrayList<Integer> processQueries(int[] arr, int[][] queries) {
        int n = arr.length;
        tree = new int[4 * n];

        build(arr, 1, 0, n - 1);

        ArrayList<Integer> ans = new ArrayList<>();

        for (int[] q : queries) {
            if (q[0] == 0) {
                // Range GCD query
                ans.add(query(1, 0, n - 1, q[1], q[2]));
            } else {
                // Point update
                update(1, 0, n - 1, q[1], q[2]);
            }
        }

        return ans;
    }

    private void build(int[] arr, int node, int l, int r) {
        if (l == r) {
            tree[node] = arr[l];
            return;
        }

        int mid = l + (r - l) / 2;

        build(arr, node * 2, l, mid);
        build(arr, node * 2 + 1, mid + 1, r);

        tree[node] = gcd(tree[node * 2], tree[node * 2 + 1]);
    }

    private int query(int node, int l, int r, int ql, int qr) {
        if (qr < l || r < ql)
            return 0;

        if (ql <= l && r <= qr)
            return tree[node];

        int mid = l + (r - l) / 2;

        return gcd(
            query(node * 2, l, mid, ql, qr),
            query(node * 2 + 1, mid + 1, r, ql, qr)
        );
    }

    private void update(int node, int l, int r, int index, int value) {
        if (l == r) {
            tree[node] = value;
            return;
        }

        int mid = l + (r - l) / 2;

        if (index <= mid)
            update(node * 2, l, mid, index, value);
        else
            update(node * 2 + 1, mid + 1, r, index, value);

        tree[node] = gcd(tree[node * 2], tree[node * 2 + 1]);
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}
