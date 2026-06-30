import java.util.*;

class Solution {
    public int minInsAndDel(int[] a, int[] b) {
        int n = a.length, m = b.length;
        Map<Integer, Integer> pos = new HashMap<>();
        for (int i = 0; i < m; i++) {
            pos.put(b[i], i);
        }
        
        List<Integer> list = new ArrayList<>();
        for (int num : a) {
            if (pos.containsKey(num)) {
                list.add(pos.get(num));
            }
        }
        
        int lis = lengthOfLIS(list);
        return (n - lis) + (m - lis);
    }
    
    private int lengthOfLIS(List<Integer> list) {
        List<Integer> tail = new ArrayList<>();
        for (int num : list) {
            int idx = Collections.binarySearch(tail, num);
            if (idx < 0) idx = -idx - 1;
            if (idx == tail.size()) tail.add(num);
            else tail.set(idx, num);
        }
        return tail.size();
    }
}