class Solution {
    public int getSingle(int[] arr) {
        int res = 0;
        for(int i=0;i<32;++i) {
            int count = 0;
            int x = 1 << i;
            for(int j=0;j<arr.length;++j) {
                if((arr[j] & x) !=0) {
                    count++;
                }
            }
            if(count % 3!=0) {
                res |= x;
            }
        }
        return res;
    }
}