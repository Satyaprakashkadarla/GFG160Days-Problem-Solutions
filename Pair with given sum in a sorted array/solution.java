class Solution {
    int countPairs(int arr[], int target) {
        int l=0, n=arr.length, r=n-1, ans=0;
        while(l<r){
            int sum = arr[l]+arr[r];
            if(sum==target){
                int start=l+1;
                int end=r-1;
                ans++;
                while(start<r && arr[start]==arr[start-1]){
                    ans++;
                    start++;
                }
                while(l<end && arr[end]==arr[end+1]){
                    end--;
                    ans++;
                }
                l++;
                r--;
            }else if(sum<target){
                l++;
            }else{
                r--;
            }
        }
        return ans;
    }