class Solution {
    static Node reverseLL(Node head) {
        if(head == null || head.next == null) {
            return head;
        }
        Node curr = head;
        Node prev = null;
        Node forward = null;
        while(curr!=null) {
            forward=curr.next;
            curr.next=prev;
            prev=curr;
            curr=forward;
        }
        return prev;
    }
    static Node addTwoLists(Node num1, Node num2) {
        num1 = reverseLL(num1);
        num2 = reverseLL(num2);
        Node finalHead = new Node(-1);
        Node finalTail = finalHead;
        int carry = 0;
        while(num1!=null || num2!=null || carry !=0) {
            int v1=(num1 == null) ? 0 : num1.data;
            int v2=(num2 == null) ? 0 : num2.data;
            int sum = carry +v1+v2;
            carry = sum/10;
            int digit = sum %10;
            finalTail.next=new Node(digit);
            finalTail=finalTail.next;
            if(num1!=null) num1 = num1.next;
            if(num2!=null) num2 = num2.next;
        }
        finalHead = reverseLL(finalHead.next);
        while(finalHead !=null && finalHead.data == 0) {
            finalHead = finalHead.next;
        }
        return finalHead;
    }
}