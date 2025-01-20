class Solution {
    Node sortedMerge(Node head1, Node head2) {
        Node newHead = null, temp = null;
        while(head1!=null || head2!= null) {
            if(head1!=null && (head2==null||(head1.data<head2.data))) {
                if(newHead == null) {
                    newHead = head1;
                    temp = head1;
                }
                else {
                    temp.next = head1;
                    temp=head1;
                }
                head1 = head1.next;
            }
            else {
                if(newHead == null) {
                    newHead = head2;
                    temp=head2;
                }
                else {
                    temp.next = head2;
                    temp = head2;
                }
                head2=head2.next;
            }
        }
        temp.next=null;
        return newHead;
    }
}