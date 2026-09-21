class Solution {
    public boolean areAnagrams(Node root1, Node root2) {
        if (root1 == null || root2 == null)
            return root1 == root2;

        Queue<Node> q1 = new ArrayDeque<>();
        Queue<Node> q2 = new ArrayDeque<>();

        q1.offer(root1);
        q2.offer(root2);

        while (!q1.isEmpty() && !q2.isEmpty()) {
            int n1 = q1.size();
            int n2 = q2.size();

            // Different number of nodes at this level
            if (n1 != n2)
                return false;

            HashMap<Integer, Integer> freq = new HashMap<>();

            // Count values in level of tree 1
            for (int i = 0; i < n1; i++) {
                Node node = q1.poll();
                freq.put(node.data, freq.getOrDefault(node.data, 0) + 1);

                if (node.left != null) q1.offer(node.left);
                if (node.right != null) q1.offer(node.right);
            }

            // Subtract values from level of tree 2
            for (int i = 0; i < n2; i++) {
                Node node = q2.poll();

                int count = freq.getOrDefault(node.data, 0);
                if (count == 0)
                    return false;

                if (count == 1)
                    freq.remove(node.data);
                else
                    freq.put(node.data, count - 1);

                if (node.left != null) q2.offer(node.left);
                if (node.right != null) q2.offer(node.right);
            }

            // All frequencies must have matched
            if (!freq.isEmpty())
                return false;
        }

        // Both trees must have the same number of levels
        return q1.isEmpty() && q2.isEmpty();
    }
}
