import java.util.*;

class Solution {
    public ArrayList<Integer> freqInRange(int[] arr, int[][] queries) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.putIfAbsent(arr[i], new ArrayList<>());
            map.get(arr[i]).add(i);
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        for (int[] q : queries) {
            int l = q[0], r = q[1], x = q[2];
            List<Integer> indices = map.get(x);
            if (indices == null) {
                result.add(0);
                continue;
            }
            int left = Collections.binarySearch(indices, l);
            if (left < 0) left = -left - 1;
            int right = Collections.binarySearch(indices, r);
            if (right < 0) right = -right - 2;
            if (left <= right) {
                result.add(right - left + 1);
            } else {
                result.add(0);
            }
        }
        return result;
    }
}