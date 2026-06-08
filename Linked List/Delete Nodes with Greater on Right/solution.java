/* Structure of linked list node
class Node{
    constructor(data){
        this.data = data;
        this.next = null;
    }
}
*/

class Solution {
    compute(head) {
        if (!head || !head.next) return head;
        
        // Reverse list
        head = this.reverse(head);
        
        let curr = head;
        let prev = null;
        let maxSoFar = -Infinity;
        
        while (curr) {
            if (curr.data < maxSoFar) {
                prev.next = curr.next;
            } else {
                maxSoFar = curr.data;
                prev = curr;
            }
            curr = curr.next;
        }
        
        // Reverse back
        head = this.reverse(head);
        return head;
    }
    
    reverse(head) {
        let prev = null;
        let curr = head;
        while (curr) {
            let next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}