Minimum Time to Finish Project
class Solution {
    public int minTime(int[] duration, int[][] dependencies) {
        int n = duration.length;

        // Adjacency list using arrays for better memory efficiency
        int m = dependencies.length;
        int[] head = new int[n];
        int[] next = new int[m];
        int[] to = new int[m];
        int[] indegree = new int[n];

        java.util.Arrays.fill(head, -1);

        for (int i = 0; i < m; i++) {
            int u = dependencies[i][0];
            int v = dependencies[i][1];

            to[i] = v;
            next[i] = head[u];
            head[u] = i;
            indegree[v]++;
        }

        // Earliest completion time for each module
        long[] finish = new long[n];

        // Queue for topological sorting
        int[] queue = new int[n];
        int front = 0, rear = 0;

        // Modules with no dependencies can start immediately
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                finish[i] = duration[i];
                queue[rear++] = i;
            }
        }

        int processed = 0;
        long answer = 0;

        while (front < rear) {
            int u = queue[front++];
            processed++;

            answer = Math.max(answer, finish[u]);

            for (int e = head[u]; e != -1; e = next[e]) {
                int v = to[e];

                finish[v] = Math.max(
                    finish[v],
                    finish[u] + duration[v]
                );

                if (--indegree[v] == 0) {
                    queue[rear++] = v;
                }
            }
        }

        // Not all modules processed => cycle exists
        return processed == n ? (int) answer : -1;
    }
}
