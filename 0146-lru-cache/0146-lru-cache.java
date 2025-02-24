class Node{
    Node prev,next;
    int key,value;
    Node(int key,int value){
        this.key = key;
        this.value = value;
    }
}
class LRUCache {

    Node head = new Node(0,0) , tail = new Node(0,0);
    Map<Integer,Node> map = new HashMap<>();
    int capacity;
    public LRUCache(int capacity) {
       this.capacity = capacity; 
       head.next = tail;
       tail.prev = head; 
    }
    
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        Node node = map.get(key);
        remove(node);
        insertAfterHead(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.value = value;
            remove(node);
            insertAfterHead(node);
        }else{
            if(map.size()==capacity){
                Node node = tail.prev;
                map.remove(node.key);
                remove(node);
            }
            Node node = new Node(key,value);
            map.put(key,node);
            insertAfterHead(node);
        }
    }

    public void insertAfterHead(Node node){
        Node currNode = head.next;
        head.next =  node;
        node.prev = head;
        node.next = currNode;
        currNode.prev = node;
    }

    public void remove(Node node){
        Node prevNode = node.prev;
        Node afterNode = node.next;
        prevNode.next = afterNode;
        afterNode.prev = prevNode;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */