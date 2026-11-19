
import java.util.Arrays;

class Solution {
    public void sortIt(int[] arr) {
        Integer[] nums = new Integer[arr.length];

        for (int i = 0; i < arr.length; i++) {
            nums[i] = arr[i];
        }

        Arrays.sort(nums, (a, b) -> {
            if (a % 2 != b % 2) {
                return (a % 2 == 1) ? -1 : 1;
            }

            if (a % 2 == 1) {
                return Integer.compare(b, a);
            }

            return Integer.compare(a, b);
        });

        for (int i = 0; i < arr.length; i++) {
            arr[i] = nums[i];
        }
    }
}
