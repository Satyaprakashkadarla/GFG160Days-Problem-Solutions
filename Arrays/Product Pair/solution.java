import java.util.HashSet;

class Solution {
    public boolean isProduct(int[] arr, long target) {
        HashSet<Long> set = new HashSet<>();

        for (int num : arr) {

            // Special case when target is 0
            if (target == 0) {
                if (num == 0) {
                    // If current is 0 and there is any previous element
                    if (!set.isEmpty()) return true;
                } else if (set.contains(0L)) {
                    return true;
                }
            } 
            else {
                // Check divisibility
                if (num != 0 && target % num == 0) {
                    long needed = target / num;

                    if (set.contains(needed)) {
                        return true;
                    }
                }
            }

            set.add((long) num);
        }

        return false;
    }
}