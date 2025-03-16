class Solution {
    static int minJumps(int[] arr) {
        int n = arr.length;
        if(n == 1) return 0;
        if(arr[0] == 0) return -1;
        int jumps = 0 , currentend = 0 , farther = 0;
        for(int i = 0; i < n - 1; i++) {
            farther = Math.max(farther , i + arr[i]);
            if(i == currentend) {
                jumps++;
                currentend = farther;
                if(currentend >= n - 1) return jumps;
            }
        }
        return -1;
    }
}