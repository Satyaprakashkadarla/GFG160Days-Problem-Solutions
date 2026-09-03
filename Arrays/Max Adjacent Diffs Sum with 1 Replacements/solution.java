class Solution {
    public int maxDiffSum(int[] arr) {
        int n = arr.length;

        long keep = 0; // arr[0] kept
        long one = 0;  // arr[0] replaced by 1

        for (int i = 1; i < n; i++) {
            long newKeep = Math.max(
                keep + Math.abs((long) arr[i] - arr[i - 1]),
                one + Math.abs((long) arr[i] - 1)
            );

            long newOne = Math.max(
                keep + Math.abs((long) 1 - arr[i - 1]),
                one
            );

            keep = newKeep;
            one = newOne;
        }

        return (int) Math.max(keep, one);
    }
}
