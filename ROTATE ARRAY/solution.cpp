class Solution {
  public:
    void rotateArr(vector<int>& arr, int d) {
        int n=arr.size();
        d%=n;
        
        reverse(arr.begin()+d, arr.end());
        reverse(arr.begin(), arr.begin()+d);
        
        reverse(arr.begin(), arr.end());
        
        return;
        
    }
};