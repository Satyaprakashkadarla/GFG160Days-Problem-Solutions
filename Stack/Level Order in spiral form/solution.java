class Solution {
    public ArrayList<Integer> findSpiral(Node root) {
        ArrayList<Integer> result = new ArrayList<>(); // To store final spiral order

        if (root == null) {
            return result; // Edge case: empty tree
        }

        Queue<Node> que = new LinkedList<>(); // Queue for level order
        que.add(root);

        boolean direction = false; // false => right to left, true => left to right

        while (!que.isEmpty()) {
            int n = que.size();             // Number of nodes at current level
            Integer[] row = new Integer[n]; // Temporary array for current level

            for (int i = 0; i < n; i++) {
                Node node = que.poll(); // Dequeue the front node
                int idx = direction ? i : (n - 1 - i);
                row[idx] = node.data; // Place data at correct index

                if (node.left != null) {
                    que.add(node.left); // Enqueue left child
                }

                if (node.right != null) {
                    que.add(node.right); // Enqueue right child
                }
            }
            for (int val : row) {
                result.add(val);
            }

            direction = !direction; // Toggle direction
        }

        return result;
    }
}