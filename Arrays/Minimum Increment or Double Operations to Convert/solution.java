class Solution {
    public int countMinOperations(int arr[]) {
        int steps = 0;
        int n = arr.length;
        while (true) {
            boolean allZero = true;
            boolean allEven = true;
            for (int i = 0; i < n; i++) {
                if (arr[i] > 0) allZero = false;
                if (arr[i] % 2 != 0) allEven = false;
            }
            if (allZero) break;
            
            if (allEven) {
                for (int i = 0; i < n; i++) arr[i] /= 2;
                steps++;
            } else {
                for (int i = 0; i < n; i++) {
                    if (arr[i] % 2 == 1) {
                        arr[i]--;
                        steps++;
                    }
                }
            }
        }
        return steps;
    }
}