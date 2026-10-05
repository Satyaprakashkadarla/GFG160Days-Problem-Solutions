class Solution {
    public ArrayList<ArrayList<Integer>> socialNetwork(int[] arr) {
        int n = arr.length + 1;
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        int[] parent = new int[n + 1];

        for (int i = 2; i <= n; i++) {
            parent[i] = arr[i - 2];
        }

        for (int i = 2; i <= n; i++) {
            int[] dist = new int[n + 1];

            int curr = i;
            int d = 0;

            // Find distance from i to every reachable user
            while (curr != 1) {
                curr = parent[curr];
                d++;
                dist[curr] = d;
            }

            // Required order: j = 1 to i-1
            for (int j = 1; j < i; j++) {
                if (dist[j] != 0) {
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    temp.add(dist[j]);
                    ans.add(temp);
                }
            }
        }

        return ans;
    }
}
