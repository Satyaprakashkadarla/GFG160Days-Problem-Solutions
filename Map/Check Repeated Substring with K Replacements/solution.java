
class Solution {
    kSubstr(s, k) {
        let n = s.length;
        if (n % k !== 0) return false;
        let m = n / k;
        let blocks = [];
        for (let i = 0; i < n; i += k) {
            blocks.push(s.slice(i, i + k));
        }
        
        // Check if all same
        let first = blocks[0];
        let diffCount = 0;
        for (let i = 1; i < m; i++) {
            if (blocks[i] !== first) diffCount++;
        }
        if (diffCount === 0) return true;
        if (diffCount === 1) return true;
        
        // Try other block as pattern
        for (let i = 1; i < m; i++) {
            if (blocks[i] !== first) {
                let pattern = blocks[i];
                let diff = 0;
                for (let j = 0; j < m; j++) {
                    if (blocks[j] !== pattern) diff++;
                }
                if (diff === 1) return true;
                break;
            }
        }
        return false;
    }
}