import java.util.*;

class Solution {
    public ArrayList<ArrayList<Integer>> kSmallestPair(int[] arr1, int[] arr2, int k) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        
        if (arr1 == null || arr2 == null || arr1.length == 0 || arr2.length == 0 || k <= 0) {
            return result;
        }
        
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        
        for (int i = 0; i < Math.min(arr1.length, k); i++) {
            minHeap.offer(new int[]{arr1[i] + arr2[0], i, 0});
        }
        
        while (k-- > 0 && !minHeap.isEmpty()) {
            int[] current = minHeap.poll();
            int i = current[1];
            int j = current[2];
            
            ArrayList<Integer> pair = new ArrayList<>();
            pair.add(arr1[i]);
            pair.add(arr2[j]);
            result.add(pair);
            
            if (j + 1 < arr2.length) {
                minHeap.offer(new int[]{arr1[i] + arr2[j + 1], i, j + 1});
            }
        }
        
        return result;
    }
}