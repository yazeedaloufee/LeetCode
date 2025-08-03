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
    HashMap<Node, Node> copied;
    public Node cloneGraph(Node node) {
    if (node == null) return null;
       copied = new HashMap<>();
       return copy(node);
    }
    public Node copy(Node node) {
        if(copied.containsKey(node)) return copied.get(node);

        Node copy = new Node(node.val);
        copied.put(node,copy);

        for (Node n : node.neighbors){
            copy.neighbors.add(copy(n));
        }

        return copy;
    }
}