class Solution {
    // Function to count the number of possible triangles.
    // code for c++ and java is same so I am providing only java code.
    static int countTriangles(int arr[]) {
        // code here
        Arrays.sort(arr);
        int ans=0;for
        for(int i=arr.length-1;i>=0;i--){
            int st=0, end=i-1;
            while(st<end){
                if(arr[st]+arr[end]>arr[i]){
                    ans+=end-st;
                    end--;
                }
                else {
                    st++;
                }
            }
        }
        return ans;
    }
}