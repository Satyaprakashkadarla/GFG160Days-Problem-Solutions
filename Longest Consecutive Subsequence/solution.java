class Solution {
    public int longestConsecutive(int[] arr) {
        Set<Integer> hst = new HashSet();
        for(int i: arr) {
            hst.add(i);
        }
        int ans =0;
        for(int i: arr){
            int curr = 0 , temp =i , temp2= i-1;
            if(hst.contains(i)){
                while(hst.contains(temp)){
                curr++;
                hst.remove(temp);
                temp++;
            }
            while(hst.contains(temp2)) {
                curr++;
                hst.remove(temp2);
                temp2--;
            }
            ans = Math.max(ans , curr);
        }
    }
        return ans;
    }
}