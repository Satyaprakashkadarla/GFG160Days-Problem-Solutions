class Solution {
    // Function to remove a loop in the linked list.
    public static void removeLoop(Node head) {
        Node slow = head;
        Node fast = head;
        Node temp = head;
        while(fast!=null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                while(slow != temp) {
                    slow = slow.next;
                    temp = temp.next;
                }
                while(fast.next!=slow) {
                    fast = fast.next;
                }
                fast.next=null;
            }
        }
    }
}