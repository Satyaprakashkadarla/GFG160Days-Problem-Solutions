import java.util.HashMap;

class Solution {
    public int majorityElement(int[] arr) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        
        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
            if (freq.get(num) > arr.length / 2) {
                return num;
            }
        }
        return -1;
    }
}
