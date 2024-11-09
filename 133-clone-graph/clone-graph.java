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
    Map<Node, Node> hm;
    public Node cloneGraph(Node node) {
        hm = new HashMap<>();
        return copy(node);

    }
    public Node copy (Node node) {
        if(node == null) return null;
        if (hm.containsKey(node)){
            return hm.get(node);
        }
        Node newNode = new Node(node.val);
        hm.put(node, newNode);

        for(Node n : node.neighbors){
            newNode.neighbors.add(copy(n));
        }

        return newNode;
    }
}