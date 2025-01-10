class Solution {
    ArrayList<Integer> countDistinct(int arr[], int k) {
        Map<Integer,Integer> map = new HashMap<>();
        ArrayList<Integer> ans = new ArrayList<>();
        int n=arr.length;
        for(int i=0;i<n;i++){
            map.merge(arr[i],1,Integer::sum);
            if(i>=k){
                map.merge(arr[i-k],-1,Integer::sum);
                if(map.get(arr[i-k])==0)    map.remove(arr[i-k]);
            }
            if(i+1>=k)  ans.add(map.size());
        }
        return ans;
    }
}