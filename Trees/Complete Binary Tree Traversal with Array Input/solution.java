import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public ArrayList<ArrayList<Integer>> levelSort(int[] arr) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (arr == null || arr.length == 0) return result;
        
        int index = 0;
        int level = 0;
        int count = 1; // number of nodes at current level
        
        while (index < arr.length) {
            ArrayList<Integer> levelList = new ArrayList<>();
            int end = Math.min(index + count, arr.length);
            
            // Collect all nodes at current level
            for (int i = index; i < end; i++) {
                levelList.add(arr[i]);
            }
            
            // Sort the current level
            Collections.sort(levelList);
            result.add(levelList);
            
            // Move to next level
            index = end;
            count *= 2; // next level has twice as many nodes
            level++;
        }
        
        return result;
    }
}