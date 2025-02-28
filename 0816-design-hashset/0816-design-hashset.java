class MyHashSet {

    private Map<Integer,Integer> map;
    public MyHashSet() {
         map = new HashMap<>();
    }
    
    public void add(int key) {
        map.put(key,0);
    }
    
    public void remove(int key) {
        map.remove(key);
    }
    
    public boolean contains(int key) {
        return map.containsKey(key)?true:false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */