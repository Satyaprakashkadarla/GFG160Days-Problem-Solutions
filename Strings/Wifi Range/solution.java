class Solution {
    public boolean wifiRange(String s, int x) {
        int n = s.length();
        int[] diff = new int[n + 1];
        
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                int left = Math.max(0, i - x);
                int right = Math.min(n - 1, i + x);
                diff[left]++;
                diff[right + 1]--;
            }
        }
        
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += diff[i];
            if (sum == 0) return false;
        }
        return true;
    }
}