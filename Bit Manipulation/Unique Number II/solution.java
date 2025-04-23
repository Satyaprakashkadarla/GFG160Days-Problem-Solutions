import java.util.*;

class Solution {
    public int[] singleNum(int[] arr) {
        int xorAll = 0;
        for (int num : arr) {
            xorAll ^= num;
        }

        // Find the rightmost set bit
        int setBit = xorAll & -xorAll;

        int G1 = 0, G0 = 0;
        for (int num : arr) {
            if ((num & setBit) != 0) {
                G1 ^= num;
            } else {
                G0 ^= num;
            }
        }

        // Ensure correct ordering before returning
        int[] result = (G1 < G0) ? new int[]{G1, G0} : new int[]{G0, G1};
        return result;
    }