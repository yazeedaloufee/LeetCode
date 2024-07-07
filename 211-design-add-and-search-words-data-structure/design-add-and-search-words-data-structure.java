class WordDictionary {
    class Node {
        Node[] children;
        boolean isWord;
        Node() {
            children = new Node[26];
            isWord = false;
        }
    }
    Node root;

    public WordDictionary() {
        root = new Node();
    }
    
    public void addWord(String word) {
        Node curr = root;
        for(char c : word.toCharArray()){
            if(curr.children[c-'a'] == null){
                curr.children[c - 'a'] = new Node();
            }
            curr = curr.children[c - 'a'];
        }
        curr.isWord = true;
    }
    
    public boolean search(String word) {
        return search(word, 0, root);
    }

    public boolean search(String word, int index,Node root) {
        Node curr = root;
        for(int i = index; i < word.length(); i++) {
            if(word.charAt(i) == '.'){
                for(Node n : curr.children) {
                    if(n != null && search(word, i +1, n)) {
                       return true;
                    }
                }
                return false;
                
            }else if(curr.children[word.charAt(i) - 'a'] == null ) {
                return false;
            }
                curr=curr.children[word.charAt(i) - 'a'];    
            
            
        }
        return curr.isWord;

    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */