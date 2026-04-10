import java.util.*;

class Solution {
    public ArrayList<Integer> find3Numbers(int[] arr) {
        int n = arr.length;
        if (n < 3) return new ArrayList<>();
        
        int[] leftMin = new int[n];
        int[] rightMax = new int[n];
        
        leftMin[0] = arr[0];
        for (int i = 1; i < n; i++) {
            leftMin[i] = Math.min(leftMin[i - 1], arr[i]);
        }
        
        rightMax[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], arr[i]);
        }
        
        for (int j = 1; j < n - 1; j++) {
            if (leftMin[j - 1] < arr[j] && arr[j] < rightMax[j + 1]) {
                ArrayList<Integer> res = new ArrayList<>();
                res.add(leftMin[j - 1]);
                res.add(arr[j]);
                res.add(rightMax[j + 1]);
                return res;
            }
        }
        return new ArrayList<>();
    }
}