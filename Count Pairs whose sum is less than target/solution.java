// Function to count pairs whose sum is less than the target

    public int countPairs(int[] arr, int target) {
        // Step 1: Sort the array in ascending order
        // Sorting helps in applying the two-pointer technique efficiently
        Arrays.sort(arr);

        // Step 2: Initialize pointers and the count variable
        int left = 0;                 // Points to the beginning of the array
        int right = arr.length - 1;   // Points to the end of the array
        int count = 0;                // Tracks the number of valid pairs

        // Step 3: Iterate until the left pointer is less than the right pointer
        while (left < right) {
            // Calculate the sum of the elements at the two pointers
            int sum = arr[left] + arr[right];

            // Step 4: Check if the sum is less than the target
            if (sum < target) {
                // All pairs between the current `left` and `right` will have sums < target
                // Valid pairs include (arr[left], arr[right]), (arr[left], arr[right-1]), ..., (arr[left], arr[left+1])
                count += (right - left);

                // Move the left pointer to the right to check the next potential pair
                left++;
            } else {
                // If the sum is greater than or equal to the target, move the right pointer to the left
                // This decreases the sum and may result in valid pairs
                right--;
            }
        }

        // Step 5: Return the total count of valid pairs
        return count;
    }