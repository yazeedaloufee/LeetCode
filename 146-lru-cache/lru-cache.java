class LRUCache {
    int capacity;
    int currentSize;
    Map < Integer, Node > hm = new HashMap < > ();
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        head = new Node();
        tail = new Node();
        tail.next = null;
        head.prev = null;
        tail.prev = head;
        head.next = tail;
        this.capacity = capacity;
        currentSize = 0;
    }

    public int get(int key) {
        if (hm.containsKey(key)) {
            Node current = hm.get(key);
            removeNode(current);
            moveToHead(current);
            return current.value;
        }
        return -1;

    }

    public void put(int key, int value) {

        Node newNode = new Node(key, value);
        if (hm.containsKey(key)) {
            Node removed = hm.get(key);

            removeNode(removed);
            currentSize--;
        }

        hm.put(key, newNode);
        moveToHead(newNode);
        currentSize++;

        if (currentSize > capacity) {
            Node removed = removeTail();
            hm.remove(removed.key);
            currentSize--;
        }


    }

    public void removeNode(Node node) {
        Node next = node.next;
        Node prev = node.prev;

        next.prev = prev;
        prev.next = next;
    }

    public void moveToHead(Node node) {
        Node currHead = head.next;
        head.next = node;
        currHead.prev = node;
        node.prev = head;
        node.next = currHead;
    }

    public Node removeTail() {
        Node removed = tail.prev;
        removeNode(removed);
        return removed;
    }

    class Node {
        int key;
        int value;
        Node prev;
        Node next;
        public Node() {

        }

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
        public String toString() {
            return "key : " + key + " , value : " + value;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */