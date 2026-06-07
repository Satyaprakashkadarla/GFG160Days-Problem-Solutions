Intuition:
- Root (Level 1, Position 1) is always an Engineer.
- Left child keeps the same profession as its parent.
- Right child changes (flips) the profession.
- The path from the root to position 'pos' can be represented by the binary form of (pos - 1):
    0 → Left move (no flip)
    1 → Right move (flip)
- Therefore, the number of set bits in (pos - 1) equals the number of profession flips.
- Even flips → Engineer
- Odd flips → Doctor

Pseudocode:

profession(level, pos):

    flips = countSetBits(pos - 1)

    if flips % 2 == 0:
        return "Engineer"
    else:
        return "Doctor"

-------------------------------------------------------------------------------

Java Code:

class Solution {
    public String profession(int level, int pos) {

        int flips = Integer.bitCount(pos - 1);

        if (flips % 2 == 0) {
            return "Engineer";
        }

        return "Doctor";
    }
}

Dry Run:

Input:
level = 4, pos = 2

pos - 1 = 1
binary(1) = 1

set bits = 1
flips = 1 (odd)

Engineer → Right Child → Doctor

Output: Doctor

----------------------------------------------------------------------

Time Complexity:
O(log(pos))

Space Complexity:
O(1)