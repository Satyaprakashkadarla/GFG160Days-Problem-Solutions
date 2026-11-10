
class Solution {
    public int firstElementKTime(int[] arr, int k) {
        int[] freq = new int[1000001];

        for (int num : arr) {
            freq[num]++;

            if (freq[num] == k) {
                return num;
            }
        }

        return -1;
    }
}
