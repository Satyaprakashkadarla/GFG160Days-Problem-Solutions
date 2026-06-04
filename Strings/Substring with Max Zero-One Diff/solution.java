Thought Process
Let’s define for each character:

'0' → +1

'1' → -1

Then for any substring, (count0 - count1) = sum of these values over that substring.

So the problem becomes:
Given an array of +1 and -1, find the maximum subarray sum.

If the array is all -1 (all 1s), the maximum sum is -1.

We can solve this using Kadane’s algorithm:

Keep running sum of current subarray.

If current sum becomes negative, restart from next element.

Track maximum sum seen.

------------------------------------------------------------------
Example
s = "11000010001"

Transform:
1 → -1, 1 → -1, 0 → +1, 0 → +1, 0 → +1, 0 → +1, 1 → -1, 0 → +1, 0 → +1, 0 → +1, 1 → -1
Array: [-1, -1, 1, 1, 1, 1, -1, 1, 1, 1, -1]

Kadane:
i=0: curr = max(-1, -1) = -1, maxSum = -1
i=1: curr = max(-1, -1 + -1) = -1, maxSum = -1
i=2: curr = max(1, -1 + 1) = 1, maxSum = 1
i=3: curr = max(1, 1 + 1) = 2, maxSum = 2
i=4: curr = max(1, 2 + 1) = 3, maxSum = 3
i=5: curr = max(1, 3 + 1) = 4, maxSum = 4
i=6: curr = max(-1, 4 + -1) = 3, maxSum = 4
i=7: curr = max(1, 3 + 1) = 4, maxSum = 4
i=8: curr = max(1, 4 + 1) = 5, maxSum = 5
i=9: curr = max(1, 5 + 1) = 6, maxSum = 6
i=10: curr = max(-1, 6 + -1) = 5, maxSum = 6

Output = 6 

--------------------------------------------------------------------

Algorithm
maxSubstring(s):
    curr = 0
    maxSum = -1
    for each char in s:
        val = 1 if char == '0' else -1
        curr = max(val, curr + val)
        maxSum = max(maxSum, curr)
    return maxSum

--------------------------------------------------------------------

Complexity
Time: O(n) — single pass through string.

Space: O(1) — only two variables.

-----------------------------------------------------------------

Code:
class Solution {
    int maxSubstring(String s) {
        int curr = 0, maxSum = -1;
        for (char ch : s.toCharArray()) {
            int val = (ch == '0') ? 1 : -1;
            curr = Math.max(val, curr + val);
            maxSum = Math.max(maxSum, curr);
        }
        return maxSum;
    }
}
