/*
// Definition for a Node.
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
    public Node dfs(Node node,Map<Node,Node> map){
        if(node ==null) return null;
        Node newNode = new Node(node.val,new ArrayList<Node>());
        map.put(node,newNode);
        for(Node it:node.neighbors){
            if(!map.containsKey(it)){

                dfs(it,map);
            }
            newNode.neighbors.add(map.get(it));
        }
        return newNode;
    }

    public Node cloneGraph(Node node) {
        Map<Node, Node> map = new HashMap<>();
        return dfs(node, map);
    }
}