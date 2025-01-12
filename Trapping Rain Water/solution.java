class Solution {
    public int maxWater(int arr[]) {
        int ans =0, LeftMax=0, RightMax=0, i=0, j=arr.length-1;
        
        //while check condition of Array
        while(i < j) {
            if(arr[i]<=arr[j]) {
                if(LeftMax < arr[i]) {
                    LeftMax=arr[i];
                }
                else {
                    ans +=LeftMax-arr[i];
                }
                i++;
            }
            else {
                if(RightMax<arr[j]) {
                    RightMax=arr[j];
                }
                else {
                    ans +=RightMax-arr[j];
                }
                j--;
            }
        }
        return ans;
        
    }
}
