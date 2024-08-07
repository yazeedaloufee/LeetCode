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
    HashMap<Node, Node> copyOf = new HashMap<>();

    public Node cloneGraph(Node node) {
        if(node == null) return null;
        if(copyOf.containsKey(node)) {
            return copyOf.get(node);
        }

        ArrayList<Node> children = new ArrayList<>();
        Node head = new Node(node.val);
        copyOf.put(node, head);

        for (Node child: node.neighbors) {
            children.add(cloneGraph(child));
        }
        head.neighbors = children;
        return head;
    }
}