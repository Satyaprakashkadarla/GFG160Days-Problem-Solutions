class Solution {
    public int maxFrequency(int[] arr, int k) {
        Arrays.sort(arr);

        long sum = 0;
        int left = 0;
        int maxFreq = 1;

        for (int right = 0; right < arr.length; right++) {
            sum += arr[right];

            // Cost to make every element in the window arr[right]
            while ((long) arr[right] * (right - left + 1) - sum > k) {
                sum -= arr[left++];
            }

            maxFreq = Math.max(maxFreq, right - left + 1);
        }

        return maxFreq;
    }
}