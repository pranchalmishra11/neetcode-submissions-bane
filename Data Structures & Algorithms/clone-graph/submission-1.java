/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    private Map<Node,Node> oldToNew = new HashMap<>();
    public Node cloneGraph(Node node) {
        if(node==null){
            return null;
        }

        return dfs(node);// recursive creation of nodes of the graph
        
    }

    private Node dfs(Node node){
        if(oldToNew.containsKey(node)){// map to get copied nodes for neighbor attachments
            return oldToNew.get(node);
        }

        Node copied = new Node(node.val);// create copy node with value and empty neighbor list
        oldToNew.put(node,copied);// map old to new for future reference as it is undirected graph
        for(Node nei:node.neighbors){// iterate all children/neighbors of current node and create copies of them
            copied.neighbors.add(dfs(nei));
        }

        return copied;

    }
}