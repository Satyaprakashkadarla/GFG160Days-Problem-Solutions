class Solution {
public:
    int search(vector<int>& nums, int target) {
        int leftIdx = 0;
        int rightIdx = nums.size() - 1;
        
        while (leftIdx <= rightIdx) {
            int midIdx = (leftIdx + rightIdx) / 2;
            if (nums[midIdx] == target) {
                return midIdx;
            }
            if (nums[leftIdx] <= nums[midIdx]) { // left is sorted
                if (target >= nums[leftIdx] && target < nums[midIdx]) {
                    rightIdx = midIdx - 1;
                } else {
                    leftIdx = midIdx + 1;
                }
            } else { // right is sorted
                if (target > nums[midIdx] && target <= nums[rightIdx]) {
                    leftIdx = midIdx + 1;
                } else {
                    rightIdx = midIdx - 1;
                }
            }
        }
        return -1;
    }
};