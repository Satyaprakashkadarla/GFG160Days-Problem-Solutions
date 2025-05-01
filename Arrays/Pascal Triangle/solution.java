import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> nthRowOfPascalTriangle(int n) {
        n--;
        int prev = 1;
        List<Integer> res = new ArrayList<>();
        res.add(prev);
        for (int i = 1; i <= n; i++) {
            int curr = prev * (n - i + 1) / i;
            res.add(curr);
            prev = curr;
        }
        return res;
    }
}
