import java.util.*;

class Solution {
    public int longestPath(String s, int[][] edges) {
        int n = s.length();
        List<Integer>[] g = new ArrayList[n];
        for (int i = 0; i < n; i++) g[i] = new ArrayList<>();

        for (int[] e : edges) {
            int u = e[0] - 1, v = e[1] - 1;
            g[u].add(v);
            g[v].add(u);
        }

        int[] par = new int[n], order = new int[n];
        Arrays.fill(par, -1);

        // Root tree at 0
        int[] st = new int[n];
        int top = 0, cnt = 0;
        st[0] = 0;
        par[0] = n;

        while (top >= 0) {
            int u = st[top--];
            order[cnt++] = u;
            for (int v : g[u]) {
                if (v != par[u]) {
                    par[v] = u;
                    st[++top] = v;
                }
            }
        }

        int[] down = new int[n];
        int[] up = new int[n];

        // Longest same-color path going down
        for (int i = n - 1; i >= 0; i--) {
            int u = order[i];
            down[u] = 1;

            for (int v : g[u]) {
                if (par[v] == u && s.charAt(v) == s.charAt(u))
                    down[u] = Math.max(down[u], 1 + down[v]);
            }
        }

        // Reroot: longest same-color path through parent side
        for (int u : order) {
            int best1 = 0, best2 = 0, who = -1;

            for (int v : g[u]) {
                if (par[v] == u && s.charAt(v) == s.charAt(u)) {
                    if (down[v] > best1) {
                        best2 = best1;
                        best1 = down[v];
                        who = v;
                    } else {
                        best2 = Math.max(best2, down[v]);
                    }
                }
            }

            for (int v : g[u]) {
                if (par[v] != u) continue;

                if (s.charAt(v) == s.charAt(u)) {
                    int sibling = (v == who) ? best2 : best1;
                    up[v] = 1 + Math.max(up[u], sibling);
                }
            }
        }

        int[] arm = new int[n];
        int ans = 1;

        for (int u = 0; u < n; u++) {
            arm[u] = Math.max(down[u], 1 + up[u]);
            ans = Math.max(ans, arm[u]);
        }

        // A valid path can change only once: R -> B
        for (int[] e : edges) {
            int u = e[0] - 1, v = e[1] - 1;

            if (s.charAt(u) != s.charAt(v))
                ans = Math.max(ans, arm[u] + arm[v]);
        }

        return ans;
    }
}
