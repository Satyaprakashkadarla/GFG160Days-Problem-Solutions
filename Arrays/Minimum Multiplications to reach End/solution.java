import java.util.*;

class Solution {
    public int minSteps(int[] arr, int start, int end) {
        if (start == end) return 0;
        
        boolean[] visited = new boolean[1000];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{start, 0});
        visited[start] = true;
        
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int val = curr[0];
            int steps = curr[1];
            
            for (int num : arr) {
                int next = (val * num) % 1000;
                if (next == end) return steps + 1;
                if (!visited[next]) {
                    visited[next] = true;
                    q.add(new int[]{next, steps + 1});
                }
            }
        }
        return -1;
    }
}