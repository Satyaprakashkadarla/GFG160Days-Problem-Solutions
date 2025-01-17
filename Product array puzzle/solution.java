class Solution {
    public static int[] productExceptSelf(int arr[]) {
        int[] prefix = new int[arr.length];
        int[] suffix = new int[arr.length];
        prefix[0]=1;
        for(int i=1;i<arr.length;i++) {
            prefix[i]=prefix[i-1]*arr[i-1];
        }
        suffix[suffix.length-1]=1;
        for(int i=arr.length-2;i>=0;i--) {
            suffix[i]=suffix[i+1]*arr[i+1];
        }
        int[] ans = new int[arr.length];
        for(int i=0;i<ans.length;i++) {
            ans[i]=prefix[i]*suffix[i];
        }
        return ans;
    }
}