class Solution {
    public int largestSumCycle(int[] edge) {
        int n = edge.length;
        int[] visited = new int[n];

        int maxSum = -1;
        int time = 1;

        for (int i = 0; i < n; i++) {

            if (visited[i] != 0) {
                continue;
            }

            int curr = i;
            int startTime = time;

            // Traverse the path
            while (curr != -1 && visited[curr] == 0) {
                visited[curr] = time++;
                curr = edge[curr];
            }

            // Check if a cycle exists in the current path
            if (curr != -1 && visited[curr] >= startTime) {

                int sum = 0;
                int node = curr;

                while (true) {
                    sum += node;
                    node = edge[node];

                    if (node == curr) {
                        break;
                    }
                }

                maxSum = Math.max(maxSum, sum);
            }
        }

        return maxSum;
    }
}