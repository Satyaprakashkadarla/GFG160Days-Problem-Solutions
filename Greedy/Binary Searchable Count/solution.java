class Solution {
    binarySearchable(arr) {
        let count = 0;
        for (let i = 0; i < arr.length; i++) {
            if (this.binarySearch(arr, arr[i])) count++;
        }
        return count;
    }
    
    binarySearch(arr, target) {
        let l = 0, r = arr.length - 1;
        while (l <= r) {
            let mid = Math.floor((l + r) / 2);
            if (arr[mid] === target) return true;
            if (arr[mid] < target) l = mid + 1;
            else r = mid - 1;
        }
        return false;
    }
}
