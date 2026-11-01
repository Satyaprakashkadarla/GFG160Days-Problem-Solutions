
class Solution {
    public int maximumSubarray(int[] arr) {
        int noSquare = arr[0];
        int oneSquare = arr[0] * arr[0];
        int ans = Math.max(noSquare, oneSquare);

        for (int i = 1; i < arr.length; i++) {
            int x = arr[i];

            oneSquare = Math.max(
                oneSquare + x,
                Math.max(noSquare + x * x, x * x)
            );

            noSquare = Math.max(noSquare + x, x);

            ans = Math.max(ans, Math.max(noSquare, oneSquare));
        }

        return ans;
    }
}
