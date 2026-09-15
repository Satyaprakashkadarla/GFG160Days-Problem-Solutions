/* Binary Tree Node Structure
class Node {
    int data;
    Node left, right;

    public Node(int data){
        this.data = data;
    }
}
*/
class Solution {
    public int getCount(Node root, int k) {
        if (root == null || k <= 0) return 0;

        // Maximum possible useful depth is k,
        // because any leaf deeper than k cannot be visited.
        int[] freq = new int[k + 1];

        // BFS: store node and its level
        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        int level = 1;

        while (!q.isEmpty() && level <= k) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                Node node = q.poll();

                // Leaf node
                if (node.left == null && node.right == null) {
                    freq[level]++;
                } else {
                    if (node.left != null) q.offer(node.left);
                    if (node.right != null) q.offer(node.right);
                }
            }

            level++;
        }

        // Pick leaves from smallest depth to largest
        int count = 0;

        for (int depth = 1; depth <= k; depth++) {
            if (freq[depth] == 0) continue;

            int canTake = Math.min(freq[depth], k / depth);
            count += canTake;
            k -= canTake * depth;

            if (k == 0) break;
        }

        return count;
    }
}
