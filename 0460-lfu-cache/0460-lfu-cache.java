class Node{
    Node next,prev;
    int key,value,freq;
    Node(int key,int value){
        this.key = key;
        this.value = value;
        this.freq = 1;
    }
}

class DoublyLinkedList{
    Node head,tail;
    int size ;
    DoublyLinkedList(){
        head = new Node(-1,-1);
        tail = new Node(-1,-1);
        head.next = tail;
        tail.prev = head;
        size=0;
    }
    void addNode(Node node){
        Node currNode = head.next;
        head.next = node;
        node.prev = head;
        node.next = currNode;
        currNode.prev = node;
        size++;
    }

    void remove(Node node){
        node.next.prev = node.prev;
        node.prev.next = node.next;
        size--;
    }

    Node removeLast(){
        if(size==0) return null;
        Node last = tail.prev;
        remove(last);
        return last;
    }
}

class LFUCache {

    private int minFreq , capacity;
    private Map<Integer,DoublyLinkedList> freqList;
    private Map<Integer,Node> keyNode;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFreq = 0;
        this.freqList = new HashMap<>();
        this.keyNode = new HashMap<>();
    }
    
    public int get(int key) {
        if(!keyNode.containsKey(key)) return -1;
        Node node = keyNode.get(key);
        updateFreq(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if(capacity == 0) return;

        if(keyNode.containsKey(key)){
            Node node = keyNode.get(key);
            node.value = value;
            updateFreq(node);
        }else{
            if(keyNode.size() == capacity){
                DoublyLinkedList minFreqList = freqList.get(minFreq);
                Node removeNode = minFreqList.removeLast();
                keyNode.remove(removeNode.key);
            }

            Node newNode = new Node(key,value);
            keyNode.put(key,newNode);
            minFreq = 1;
            freqList.putIfAbsent(1,new DoublyLinkedList());
            freqList.get(1).addNode(newNode);
        }
    }
    public void updateFreq(Node node){
        int freq = node.freq;
        freqList.get(freq).remove(node);

        if(freqList.get(freq).size == 0 && minFreq == freq){
            minFreq++;
        }
        node.freq++;
        freqList.putIfAbsent(node.freq,new DoublyLinkedList());
        freqList.get(node.freq).addNode(node);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */