class Trie {
    class Node {
        Node[] children;
        boolean isWord;
        Node() {
            children = new Node[26];
            isWord = false;
        }
    }
    Node root;

    public Trie() {
        root = new Node();
        
    }
    
    public void insert(String word) {
        Node curr = root; 
        for(char c : word.toCharArray()) {
            int idx = c-'a';
            if(curr.children[idx] == null){
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }
        curr.isWord = true;
    }
    
    public boolean search(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            if(curr.children[word.charAt(i) - 'a'] == null) {
                return false;
            }
            if(i == word.length() - 1 && curr.children[word.charAt(i) - 'a'].isWord == false){
                return false;
            }


            curr= curr.children[word.charAt(i) - 'a'];
        }
        return true;
        
    }
    
    public boolean startsWith(String prefix) {
         Node curr = root;
        for (int i = 0; i < prefix.length(); i++) {
            if(curr.children[prefix.charAt(i) - 'a'] == null) {
                return false;
            }
            curr= curr.children[prefix.charAt(i) - 'a'];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */