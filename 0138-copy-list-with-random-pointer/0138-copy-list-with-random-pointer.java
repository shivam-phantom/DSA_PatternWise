/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
/**
    *create a map of old vs new nodes
    *check if node is present ? yes then return node
    *if not then create, add to the map and call the method for the next pointer
    * then call the method again for random pointer
    * then return the node
 */

class Solution {
    //old->new map
    Map<Node,Node> map = new HashMap<>();
    public Node copyRandomList(Node head) {
        if(head == null)
            return null;
        if(map.containsKey(head))
            return map.get(head);
        Node newNode = new Node(head.val);
        map.put(head,newNode);
        newNode.next = copyRandomList(head.next);
        newNode.random = copyRandomList(head.random);
        
        return newNode;
    }
}