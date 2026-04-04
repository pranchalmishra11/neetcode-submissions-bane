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

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node,Node> copyMap = new HashMap<>();
        Node curr = head;
        while(curr!=null){// first pass to create copies of nodes and store them against their originals
            Node n = new Node(curr.val);
            copyMap.put(curr,n);
            curr = curr.next;
        }

        curr=head;
        while(curr!=null){
            Node cnode = copyMap.get(curr);
            cnode.next = copyMap.get(curr.next);
            cnode.random = copyMap.get(curr.random);
            curr = curr.next;
        }

        return copyMap.get(head);




        
    }
}
