import java.util.*;

class Solution {
    public int maxProduct(int[] arr, int k) {
        long[][] mx = new long[k + 1][k + 1];
        long[][] mn = new long[k + 1][k + 1];

        for (int i = 0; i <= k; i++) {
            Arrays.fill(mx[i], Long.MIN_VALUE);
            Arrays.fill(mn[i], Long.MAX_VALUE);
        }

        mx[0][0] = mn[0][0] = 1;

        for (int x : arr) {
            for (int c = k; c >= 1; c--) {
                if (x < 0) {
                    for (int neg = c; neg >= 1; neg--) {
                        if (mx[c - 1][neg - 1] == Long.MIN_VALUE) continue;

                        mx[c][neg] = Math.max(mx[c][neg],
                                mn[c - 1][neg - 1] * x);
                        mn[c][neg] = Math.min(mn[c][neg],
                                mx[c - 1][neg - 1] * x);
                    }
                } else {
                    for (int neg = 0; neg <= c - 1; neg++) {
                        if (mx[c - 1][neg] == Long.MIN_VALUE) continue;

                        mx[c][neg] = Math.max(mx[c][neg],
                                mx[c - 1][neg] * x);
                        mn[c][neg] = Math.min(mn[c][neg],
                                mn[c - 1][neg] * x);
                    }
                }
            }
        }

        long ans = Long.MIN_VALUE;
        for (int neg = 0; neg <= k; neg++)
            ans = Math.max(ans, mx[k][neg]);

        return (int) ans;
    }
}
