class Solution {
    public int countSubarray(int[] arr, int l, int r) {
        return countLessEqual(arr, r) - countLessEqual(arr, l - 1);
    }
    
    private int countLessEqual(int[] arr, int limit) {
        int left = 0, sum = 0, count = 0;
        for (int right = 0; right < arr.length; right++) {
            sum += arr[right];
            while (sum > limit && left <= right) {
                sum -= arr[left];
                left++;
            }
            count += (right - left + 1);
        }
        return count;
    }
}