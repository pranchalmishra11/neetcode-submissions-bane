class LRUCache {
    private Map<Integer,Node> cache;
    private int cap;
    private Node left;
    private Node right;
    public LRUCache(int capacity) {
        this.cap = capacity;
        cache = new HashMap<>();
        this.left = new Node(0,0);
        this.right = new Node(0,0);
        this.left.next = this.right;
        this.right.prev = this.left;
        
    }
    
    public int get(int key) {
        if(!cache.containsKey(key)){
            return -1;
        }

        Node found = cache.get(key);
        deleteNode(found);
        insertAfterHead(found);
        return found.val;
        
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)){
            Node curr = cache.get(key);
            curr.val = value;
            deleteNode(curr);
            insertAfterHead(curr);
        }
        else{
            Node newNode = new Node(key,value);
            if(cache.size()==cap){
                Node del = right.prev;
                cache.remove(del.key);
                deleteNode(del);
                cache.put(key,newNode);
                insertAfterHead(newNode);
            }
            else{
                cache.put(key,newNode);
                insertAfterHead(newNode);
            }
        }
        
    }

    private void deleteNode(Node node){
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    private void insertAfterHead(Node node){
        Node next = left.next;
        left.next = node;
        node.prev = left;
        node.next = next;
        next.prev = node;
    }
}

class Node{
    int key;
    int val;
    Node next;
    Node prev;

    public Node(int key, int val){
        this.key=key;
        this.val=val;
        this.prev=null;
        this.next=null;
    }
}
