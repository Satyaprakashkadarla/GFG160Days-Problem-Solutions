import java.util.*;

class Solution {
    public int minDeletions(int[] arr) {
        List<Integer> lis = new ArrayList<>();
        for (int num : arr) {
            int pos = Collections.binarySearch(lis, num);
            if (pos < 0) pos = -pos - 1;
            if (pos == lis.size()) {
                lis.add(num);
            } else {
                lis.set(pos, num);
            }
        }
        return arr.length - lis.size();
    }
}