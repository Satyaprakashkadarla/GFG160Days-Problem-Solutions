/* BST Node Structure
class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}
*/

class Solution {
    public int pairsViolatingBST(Node root) {
        java.util.ArrayList<Integer> list = new java.util.ArrayList<>();
        inorder(root, list);

        int n = list.size();
        int[] arr = new int[n];
        int[] temp = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = list.get(i);
        }

        return mergeSort(arr, temp, 0, n - 1);
    }

    private void inorder(Node root, java.util.ArrayList<Integer> list) {
        if (root == null) return;

        inorder(root.left, list);
        list.add(root.data);
        inorder(root.right, list);
    }

    private int mergeSort(int[] arr, int[] temp, int left, int right) {
        if (left >= right) return 0;

        int mid = left + (right - left) / 2;

        int count = mergeSort(arr, temp, left, mid);
        count += mergeSort(arr, temp, mid + 1, right);

        int i = left, j = mid + 1, k = left;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
                count += mid - i + 1;
            }
        }

        while (i <= mid) temp[k++] = arr[i++];
        while (j <= right) temp[k++] = arr[j++];

        for (i = left; i <= right; i++) {
            arr[i] = temp[i];
        }

        return count;
    }
}