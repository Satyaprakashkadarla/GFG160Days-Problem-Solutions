class Solution {
    findIndex(s) {
        let n = s.length;
        let open = new Array(n + 1).fill(0);
        let close = new Array(n + 1).fill(0);
        
        for (let i = 1; i <= n; i++) {
            open[i] = open[i - 1] + (s[i - 1] === '(' ? 1 : 0);
        }
        
        for (let i = n - 1; i >= 0; i--) {
            close[i] = close[i + 1] + (s[i] === ')' ? 1 : 0);
        }
        
        for (let k = 0; k <= n; k++) {
            if (open[k] === close[k]) return k;
        }
        return -1;
    }
}