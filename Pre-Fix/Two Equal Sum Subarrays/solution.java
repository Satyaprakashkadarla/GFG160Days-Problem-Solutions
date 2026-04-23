class Solution {
    public boolean canSplit(int arr[]) {
        int total = 0;
        for (int num : arr) total += num;
        
        if (total % 2 != 0) return false;
        
        int target = total / 2;
        int sum = 0;
        for (int num : arr) {
            sum += num;
            if (sum == target) return true;
        }
        return false;
    }
}