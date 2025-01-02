class Solution {
    public int countSubarrays(int arr[], int k) {
        int sum=0,ans=0;
        HashMap<Integer,Integer> MM = new HashMap<>();
        for(int x:arr) {
            sum+=x;
            if(sum==k)ans++;
            ans+=MM.getOrDefault(sum-k,0);
            MM.put(sum,MM.getOrDefault(sum,0)+1);
        }
        return ans;
    }
}