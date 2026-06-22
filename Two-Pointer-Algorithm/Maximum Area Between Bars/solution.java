import java.util.*;

class Solution {
    public int maxArea(List<Integer> height) {
        int n = height.size();
        int left = 0, right = n - 1;
        int maxArea = 0;
        
        while (left < right) {
            int h = Math.min(height.get(left), height.get(right));
            int width = right - left - 1;
            maxArea = Math.max(maxArea, h * width);
            
            if (height.get(left) < height.get(right)) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
}