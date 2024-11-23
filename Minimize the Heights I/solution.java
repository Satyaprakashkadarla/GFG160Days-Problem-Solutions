class Solution {
    public int getMinDiff(int k, int[] arr) {
        // code here
        int n =arr.length;
        Arrays.sort(arr);
        int ans = arr[n - 1] - arr[0];
        int ma = 0;
        int mi = 0;
        int largest = arr[n - 1 ]-k;
        int smallest = arr[0] + k;
        for(int i = 0; i < n - 1; ++i){
            mi = Math.min(smallest, arr[i + 1]-k);
            ma = Math.max(largest, arr[i] +k);
            ans = Math.min(ans, ma - mi);
        }
        return ans;
    }
}