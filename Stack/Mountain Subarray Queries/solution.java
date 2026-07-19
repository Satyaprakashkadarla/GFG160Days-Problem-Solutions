class Solution {
    public ArrayList<Boolean> processQueries(int[] arr, int[][] queries) {
        int n = arr.length;
        int[] inc = new int[n];
        int[] dec = new int[n];
        inc[0] = 1;
        for (int i = 1; i < n; i++) {
            inc[i] = (arr[i] >= arr[i - 1]) ? inc[i - 1] + 1 : 1;
        }
        dec[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            dec[i] = (arr[i] >= arr[i + 1]) ? dec[i + 1] + 1 : 1;
        }
        
        ArrayList<Boolean> ans = new ArrayList<>();
        for (int[] q : queries) {
            int l = q[0], r = q[1];
            boolean ok = false;
            // check if entire subarray is non-decreasing or non-increasing
            if (inc[r] >= r - l + 1 || dec[l] >= r - l + 1) {
                ans.add(true);
                continue;
            }
            // For mountain with peak somewhere
            // We'll try peak at the point where inc and dec meet
            int peak = l;
            for (int k = l + 1; k <= r; k++) {
                if (arr[k] < arr[k - 1]) {
                    peak = k - 1;
                    break;
                }
            }
            // Now check if [l, peak] non-decreasing and [peak, r] non-increasing
            if (inc[peak] >= peak - l + 1 && dec[peak] >= r - peak + 1) {
                ok = true;
            }
            ans.add(ok);
        }
        return ans;
    }
}