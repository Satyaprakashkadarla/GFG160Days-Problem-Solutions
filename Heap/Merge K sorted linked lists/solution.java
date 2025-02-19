class Solution {
    // Function to merge K sorted linked list.
    Node mergeKLists(List<Node> arr) {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(node-> node.data));
        for(Node head : arr) {
            if(head!=null) {
                pq.add(head);
            }
        }
        Node dummy = new Node(0);
        Node tail = dummy;
        while(!pq.isEmpty()) {
            Node current = pq.poll();
            tail.next=current;
            tail=current;
            if(current.next!=null) {
                pq.add(current.next);
            }
        }
        return dummy.next;
    }
}