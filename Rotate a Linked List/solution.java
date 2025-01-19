class Solution {
    public Node rotate(Node head, int k) {
        if( k == 0 || head == null)
        return head;
        int len = 1;
        Node curr = head;
        
        while(curr.next != null) {
            curr = curr.next;
            len +=1;
        }
        k %= len;
        if(k == 0)
        return head;
        
        curr.next = head;
        curr =  head;
        for(int i=1;i<k;i++) {
            curr = curr.next;
        }
        head = curr.next;
        curr.next = null;
        return head;
    }
}