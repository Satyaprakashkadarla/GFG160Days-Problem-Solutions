import java.util.*;

class Solution {
    public ArrayList<Integer> constructList(int[][] queries) {
        int lazy = 0;
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
        
        for (int[] q : queries) {
            if (q[0] == 0) {
                list.add(q[1] ^ lazy);
            } else {
                lazy ^= q[1];
            }
        }
        
        for (int i = 0; i < list.size(); i++) {
            list.set(i, list.get(i) ^ lazy);
        }
        
        Collections.sort(list);
        return list;
    }
}