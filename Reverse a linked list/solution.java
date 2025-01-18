class Solution {
    Node reverseList(Node head) {
        Node TempHead = null;
        while(head!=null) {
            Node nex = head.next;
            if(TempHead == null) {
                TempHead = head;
                TempHead.next = null;
            }
            else {
                head.next = TempHead;
                TempHead = head;
            }
            head = nex;
        }
        return TempHead;
    }
}