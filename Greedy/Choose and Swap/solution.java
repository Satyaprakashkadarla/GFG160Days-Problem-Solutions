class Solution {
    public String chooseSwap(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        int[] first = new int[26];
        int[] last = new int[26];
        for (int i = 0; i < 26; i++) {
            first[i] = -1;
            last[i] = -1;
        }
        for (int i = 0; i < n; i++) {
            int idx = arr[i] - 'a';
            if (first[idx] == -1) first[idx] = i;
            last[idx] = i;
        }
        
        for (int i = 0; i < n; i++) {
            char cur = arr[i];
            for (char c = 'a'; c < cur; c++) {
                int cIdx = c - 'a';
                if (last[cIdx] > i && first[cIdx] > i) {
                    // c appears only after i
                    // swap all occurrences
                    for (int j = 0; j < n; j++) {
                        if (arr[j] == cur) arr[j] = c;
                        else if (arr[j] == c) arr[j] = cur;
                    }
                    return new String(arr);
                }
            }
        }
        return s;
    }
}