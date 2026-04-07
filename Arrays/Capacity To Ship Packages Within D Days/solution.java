class Solution {
    static int leastWeightCapacity(int[] arr, int n, int d) {
        int low = 0, high = 0;
        for (int w : arr) {
            low = Math.max(low, w);
            high += w;
        }
        
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (canShip(arr, mid, d)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
    
    private static boolean canShip(int[] arr, int cap, int d) {
        int days = 1;
        int current = 0;
        for (int w : arr) {
            if (current + w > cap) {
                days++;
                current = w;
                if (days > d) return false;
            } else {
                current += w;
            }
        }
        return true;
    }
}