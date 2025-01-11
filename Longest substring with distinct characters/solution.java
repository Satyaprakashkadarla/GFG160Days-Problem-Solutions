class Solution {
    public int longestUniqueSubstr(String s) {
        if(s==null || s.length()==0) {
            return -1;
        }
        int maxlength=0;
        int start=0;
        int end=0;
        HashMap<Character, Integer> map = new HashMap<>();
        while(end<s.length()) {
            char currchar=s.charAt(end);
            if(map.containsKey(currchar)) {
                start=Math.max(start, map.get(currchar)+1);
            }
            map.put(currchar, end);
            maxlength=Math.max(end-start+1,maxlength);
            end++;
        }
        return maxlength;
    }
}