class Solution {
    public int longestSubstr(String s, int k) {
        int[] freq = new int[26];
        int left = 0, maxLen = 0;
        
        for (int right = 0; right < s.length(); right++) {
            freq[s.charAt(right) - 'A']++;
            
            int maxFreq = 0;
            for (int f : freq) maxFreq = Math.max(maxFreq, f);
            
            while ((right - left + 1) - maxFreq > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
                // update maxFreq if needed (but we recalc next iteration)
            }
            
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}