class Solution {
    // Function to clone a linked list with next and random pointer.
    Node cloneLinkedList(Node head) {
        Map<Node,Node> map = new HashMap<>();
        return cloneHelper(head,map);
    }
    public static Node cloneHelper(Node node, Map<Node, Node> map){
        if(node == null) {
            return null;
        }
        if(map.containsKey(node)) {
            return map.get(node);
        }
        Node newNode = new Node(node.data);
        map.put(node, newNode);
        newNode.next = cloneHelper(node.next, map);
        newNode.random = cloneHelper(node.random,map);
        return newNode;
    }
    
}