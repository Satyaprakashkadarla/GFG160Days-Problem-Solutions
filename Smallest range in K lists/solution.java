class Solution {
    static class Node {
        int val, row, col;
        Node(int val, int row, int col) {
            this.val = val;
            this.row = row;
            this.col = col;
        }
    }

    public ArrayList<Integer> findSmallestRange(int[][] arr) {
        int n = arr.length;    // rows
        int m = arr[0].length; // columns

        PriorityQueue<Node> minHeap = new PriorityQueue<>((a, b)->a.val - b.val);

        int maxVal   = Integer.MIN_VALUE;
        int maxEl    = -1;
        int minEl    = -1;
        int minRange = Integer.MAX_VALUE;

        // Initialize minHeap with first element from each list and set maxVal
        for (int i = 0; i < n; i++) {
            minHeap.add(new Node(arr[i][0], i, 0));
            maxVal = Math.max(maxVal, arr[i][0]);
        }

        while (true) {
            Node top    = minHeap.poll(); // Get the minimum element
            int  minVal = top.val;
            int  row    = top.row;
            int  col    = top.col;

            // Update smallest range if current range is smaller
            if (maxVal - minVal < minRange) {
                minRange = maxVal - minVal;
                minEl    = minVal;
                maxEl    = maxVal;
            }

            // If the current list is exhausted, stop the process
            if (col + 1 == m) {
                break;
            }

            // Push the next element from the same list
            int nextVal = arr[row][col + 1];
            minHeap.add(new Node(nextVal, row, col + 1));

            // Update maxVal if necessary
            maxVal = Math.max(maxVal, nextVal);
        }

        ArrayList<Integer> result = new ArrayList<>();
        result.add(minEl);
        result.add(maxEl);
        return result;
    }
}
