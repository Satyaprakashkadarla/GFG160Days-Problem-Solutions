class Solution {
    public int maxLen(int[] arr) {
        Map<Integer, Integer> mp = new HashMap();
        mp.put(0, -1);
        int ans =0, sum = 0;
        for(int i=0;i<arr.length;i++) {
            sum +=arr[i]==1 ? 1 : -1;
            if(mp.containsKey(sum)) {
                ans=Math.max(ans,i-mp.get(sum));
            }
            else {
                mp.put(sum, i);
            }
        }
        return ans;
    }
}
s